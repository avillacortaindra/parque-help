package com.tefper.daas.parque.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.tefper.daas.parque.business.ProductBusiness;
import com.tefper.daas.parque.entity.BillingOffer;
import com.tefper.daas.parque.entity.Customer;
import com.tefper.daas.parque.entity.PrincipalComponent;
import com.tefper.daas.parque.entity.Suscriber;
import com.tefper.daas.parque.model.ProductInstanceType;
import com.tefper.daas.parque.repository.CaracteristicaRepository;
import com.tefper.daas.parque.repository.CustomerRepository;
import com.tefper.daas.parque.repository.PlaceRepository;
import com.tefper.daas.parque.repository.PrincipalComponentRepository;
import com.tefper.daas.parque.repository.SuscriberRepository;
import com.tefper.daas.parque.util.Constant;
import com.tefper.daas.parque.util.ProductType;

public class ProductBusinessImpl extends BusinessMain implements ProductBusiness {

	@Resource
	private PrincipalComponentRepository	pComponentRepository;

	@Resource
	private SuscriberRepository				suscriberRepository;

	@Resource
	private CustomerRepository				customerRepository;

	@Resource
	private PlaceRepository					placeRepository;

	@Resource
	private CaracteristicaRepository		caracteristicaRepository;

	@Autowired
	private Set<String>						subscriberStateActive;

	@Override
	public List<ProductInstanceType> getProductById(String productId) {
		final PrincipalComponent principalComponent = pComponentRepository.findById(productId);
		super.throwBussinessException(principalComponent);
		return this.builProductInstanceType(principalComponent, null);
	}

	private List<ProductInstanceType> builProductInstanceType(final PrincipalComponent pc, Suscriber suscriber) {

		List<ProductInstanceType> lproductInstanceType = new ArrayList<>();
		ProductInstanceType pit = new ProductInstanceType();
		pit.setId(pc.getId());
		pit.setHref(Constant.HREF_PRODUCT_INSTANCE_TYPE.concat(pc.getId()));
		if (suscriber == null) {
			suscriber = this.suscriberRepository.findBySuscriberid(pc.getSuscriberId());
		}
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
		Customer customer = this.customerRepository.findById(suscriber.getId());
		pit.addRelatedPartyItem(this.buildPartyRefType(customer));
		this.buildPlace(pit, suscriber);
		this.buildCharacteristic(this.caracteristicaRepository.findById(pc.getId()), pit);
		this.buildCycleBillingCharacteristic(pit, customer);

		lproductInstanceType.add(pit);

		return lproductInstanceType;
	}

	@Override
	public List<ProductInstanceType> getProductByPublicIdAndProductType(String publicId, String productType) {
		final Suscriber suscriber = suscriberRepository.findByMsisdnAndEstado(publicId, this.subscriberStateActive);
		super.throwBussinessException(suscriber);
		final PrincipalComponent principalComponent;
		if (productType.toUpperCase().equalsIgnoreCase(ProductType.MOBILE.toString())) {
			principalComponent = this.pComponentRepository.findBySuscriberIdAndProducType(suscriber.getSuscriberid(),
					ProductType.MOBILE.toString().toLowerCase());
		} else {
			principalComponent = this.pComponentRepository.findBySuscriberIdLandLine(suscriber.getSuscriberid(), ProductType.MOBILE.toString().toLowerCase());
		}
		super.throwBussinessException(principalComponent);
		return this.builProductInstanceType(principalComponent, suscriber);
	}

}
