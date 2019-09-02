package com.tefper.daas.parque.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.tefper.daas.parque.business.CustomerBusiness;
import com.tefper.daas.parque.entity.BillingOffer;
import com.tefper.daas.parque.entity.Customer;
import com.tefper.daas.parque.entity.PrincipalComponent;
import com.tefper.daas.parque.entity.Suscriber;
import com.tefper.daas.parque.model.ProductInstanceType;
import com.tefper.daas.parque.repository.BillingOfferRepository;
import com.tefper.daas.parque.repository.CaracteristicaRepository;
import com.tefper.daas.parque.repository.ComponentRepository;
import com.tefper.daas.parque.repository.CustomerRepository;
import com.tefper.daas.parque.repository.PrincipalComponentRepository;
import com.tefper.daas.parque.repository.SuscriberRepository;
import com.tefper.daas.parque.util.Constant;

public class CustomerBusinessImpl extends BusinessMain implements CustomerBusiness {

	@Resource
	private BillingOfferRepository			billingOfferRepository;

	@Resource
	private ComponentRepository				componentRepository;

	@Resource
	private CustomerRepository				customerRepository;

	@Resource
	private SuscriberRepository				suscriberRepository;

	@Resource
	private PrincipalComponentRepository	pComponentRepository;

	@Resource
	private CaracteristicaRepository		caracteristicaRepository;

	@Override
	public List<ProductInstanceType> getCustomerProductById(String customerId) {
		final Customer customer = customerRepository.findById(customerId);
		super.throwBussinessException(customer);
		List<ProductInstanceType> pit = new ArrayList<>();
		this.builProductInstanceType(customer, pit);
		return pit;
	}

	private void builProductInstanceType(final Customer customer, List<ProductInstanceType> lproductInstanceType) {

		List<Suscriber> suscriberList = this.suscriberRepository.findById(customer.getId());
		super.throwBussinessException(suscriberList);
		suscriberList.stream().forEach(suscriber -> {
			List<PrincipalComponent> pComponentList = pComponentRepository.findBySuscriberId(suscriber.getSuscriberid());
			pComponentList.stream().forEach(pc -> {

				ProductInstanceType pit = new ProductInstanceType();
				pit.setId(pc.getId());
				pit.setHref(Constant.HREF_PRODUCT_INSTANCE_TYPE.concat(pc.getId()));
				pit.setPublicId(suscriber.getMsisdn());
				pit.setDescription(pc.getDescription());
				pit.setName(pc.getName());
				pit.setProductType(this.validateProductType(pc.getProducType().toUpperCase()));
				pit.setIsBundle(Boolean.valueOf(pc.getIsbundle()));
				pit.setOrderDate(this.getDateTimeZone(this.buildOrderDate(pc)));
				pit.setStartDate(this.getDateTimeZone(pc.getStartdate()));
				pit.setStatus(this.buildStatus(pc.getStatus()));
				this.buildAccountRefType(suscriber, pit);

				this.buildProductRelationShip(pc, pit);

				List<BillingOffer> billingOffer = this.buildBillingOffer(pc);
				this.buildComponentProdPriceType(billingOffer, pit);
				billingOffer.forEach(bo -> {
					this.buildMTIndicator(pit, bo);
					this.buildSharingData(pit, bo);
					this.buildQuotaData(pit, bo);
					this.buildAppIlimitada(bo.getIdbillingoffer(), pit, pc.getStartdate());
				});

				pit.setProductOffering(this.buildProductOffering(pc));
				pit.addRelatedPartyItem(this.buildPartyRefType(customer));
				this.buildPlace(pit, suscriber);
				this.buildCharacteristic(this.caracteristicaRepository.findById(pc.getId()), pit);
				this.buildCycleBillingCharacteristic(pit, customer);

				lproductInstanceType.add(pit);
			});
		});
	}

	@Override
	public List<ProductInstanceType> getCustomerProductByTypeAndDocument(String documentType, String documentNumber) {
		final List<Customer> customer = customerRepository.findByTipodocumentoAndNumerodocumento(documentType, documentNumber);
		super.throwBussinessException(customer);
		List<ProductInstanceType> pit = new ArrayList<>();
		customer.stream().forEach(c -> {
			this.builProductInstanceType(c, pit);
		});
		return pit;
	}

}
