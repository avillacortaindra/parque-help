package com.tefper.daas.parque.business.impl;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.tefper.daas.parque.entity.AppsIlimitada;
import com.tefper.daas.parque.entity.BillingOffer;
import com.tefper.daas.parque.entity.BillingOfferAttribute;
import com.tefper.daas.parque.entity.BillingOfferPropertieList;
import com.tefper.daas.parque.entity.Caracteristica;
import com.tefper.daas.parque.entity.Component;
import com.tefper.daas.parque.entity.Customer;
import com.tefper.daas.parque.entity.Place;
import com.tefper.daas.parque.entity.PrincipalComponent;
import com.tefper.daas.parque.entity.Quota;
import com.tefper.daas.parque.entity.Suscriber;
import com.tefper.daas.parque.exception.BusinessException;
import com.tefper.daas.parque.model.AccountRefType;
import com.tefper.daas.parque.model.AccountRefType.BillingMethodEnum;
import com.tefper.daas.parque.model.ComponentProdPriceType;
import com.tefper.daas.parque.model.EntityRefType;
import com.tefper.daas.parque.model.KeyValueType;
import com.tefper.daas.parque.model.MobileQuota;
import com.tefper.daas.parque.model.MobileQuotaCharacteristicType;
import com.tefper.daas.parque.model.MobileQuotaCharacteristicTypeDataQuota;
import com.tefper.daas.parque.model.MobileQuotaCharacteristicTypeSmsQuota;
import com.tefper.daas.parque.model.MobileQuotaCharacteristicTypeVoiceQuota;
import com.tefper.daas.parque.model.MoneyType;
import com.tefper.daas.parque.model.ProductInstanceType;
import com.tefper.daas.parque.model.ProductInstanceType.ProductTypeEnum;
import com.tefper.daas.parque.model.ProductInstanceType.StatusEnum;
import com.tefper.daas.parque.model.ProductRefInfoType;
import com.tefper.daas.parque.model.RelatedPartyRefType;
import com.tefper.daas.parque.model.RelatedProductType;
import com.tefper.daas.parque.model.StringType;
import com.tefper.daas.parque.model.Text;
import com.tefper.daas.parque.repository.AppsIlimitadaRepository;
import com.tefper.daas.parque.repository.BillingOfferAttributeRepository;
import com.tefper.daas.parque.repository.BillingOfferPropertieListRepository;
import com.tefper.daas.parque.repository.BillingOfferRepository;
import com.tefper.daas.parque.repository.CaracteristicaRepository;
import com.tefper.daas.parque.repository.ComponentRepository;
import com.tefper.daas.parque.repository.PlaceRepository;
import com.tefper.daas.parque.repository.QuotaRepository;
import com.tefper.daas.parque.util.Constant;
import com.tefper.daas.parque.util.JsonUtil;
import com.tefper.daas.parque.util.ProductType;

public abstract class BusinessMain {

	@Resource
	private BillingOfferRepository				billingOfferRepository;

	@Resource
	private BillingOfferAttributeRepository		boAttributeRepository;

	@Resource
	private PlaceRepository						placeRepository;

	@Resource
	private CaracteristicaRepository			caracteristicaRepository;

	@Resource
	private QuotaRepository						quotaRepository;

	@Resource
	private BillingOfferPropertieListRepository	billingOfferPropertieListRepository;

	@Resource
	private AppsIlimitadaRepository				appsIlimitadaRepository;

	@Resource
	private ComponentRepository					componentRepository;

	@Autowired
	private Set<String>							dataSharing;

	protected RelatedPartyRefType buildPartyRefType(final Customer customer) {
		RelatedPartyRefType partyRefType = new RelatedPartyRefType();
		partyRefType.setId(customer.getId());
		partyRefType.setName(customer.getName());
		partyRefType.setRole(Constant.ROLE);
		return partyRefType;
	}

	protected EntityRefType buildProductOffering(final PrincipalComponent pc) {
		EntityRefType entityRefType = new EntityRefType();
		entityRefType.setDescription(pc.getDescriptionproductoffering());
		entityRefType.setName(pc.getName());
		entityRefType.setId(pc.getId());
		entityRefType.setHref(Constant.HREF_PRODUCT_OFFERING + (entityRefType.getId() != null ? entityRefType.getId() : ""));

		return entityRefType;
	}

	protected void buildPlace(ProductInstanceType pit, final Suscriber suscriber) {

		if (suscriber.getBillingArrangement() != null && !suscriber.getBillingArrangement().equalsIgnoreCase("")) {
			List<Place> places = this.placeRepository.findByBillingArrangement(suscriber.getBillingArrangement());
			places.forEach(place -> {
				EntityRefType entityRefType = new EntityRefType();
				entityRefType.setDescription(place.getDescription());
				entityRefType.setName(place.getName());
				entityRefType.setId(place.getId());
				pit.addPlaceItem(entityRefType);
			});
		}
	}

	protected void buildAccountRefType(final Suscriber subscriber, ProductInstanceType pit) {
		if (subscriber.getIdbillingaccount() != null && !subscriber.getIdbillingaccount().equalsIgnoreCase("")) {
			AccountRefType accountRefType = new AccountRefType();
			accountRefType.setBillingMethod(this.buildBuildMethod(subscriber.getCategory()));
			accountRefType.setId(subscriber.getIdbillingaccount());
			accountRefType.setHref(Constant.HREF_BILLING_ACCOUNT + (accountRefType.getId() != null ? accountRefType.getId() : ""));
			accountRefType.setName(subscriber.getNameaccount());
			pit.addBillingAccountItem(accountRefType);
		}
	}

	protected void buildProductRelationShip(final PrincipalComponent pc, ProductInstanceType productInstance) {
		List<Component> components;
		if (pc.getProducType().toUpperCase().equalsIgnoreCase(ProductType.MOBILE.toString())) {
			components = this.componentRepository.findByMaincomponentkey(pc.getMaincomponentkey());
		} else {
			components = this.componentRepository.findByParentassignproductid(pc.getId());
		}
		Map<String, RelatedProductType> hashMapPrit = new HashMap<>();
		components.stream().forEach(c -> {
			hashMapPrit.put(c.getId(), this.buildComponents(c, productInstance.getPublicId()));
		});

		this.buildTreeRelationShip(hashMapPrit, productInstance);
	}

	protected void buildAppIlimitada(String billingOfferId, ProductInstanceType productInstance, Date startdate) {
		List<AppsIlimitada> appsIlimitadas = this.appsIlimitadaRepository.findById(billingOfferId);
		appsIlimitadas.forEach(appsIlimitada -> {
			Component component = new Component();
			component.setId(Constant.APPSILIMITADA_ID);
			component.setName(appsIlimitada.getName().trim());
			component.setDescription(appsIlimitada.getName().trim());
			component.setParentassignproductid(productInstance.getId());
			component.setProducttype(Constant.APPSILIMITADA_PRODUCTTYPE_SVA);
			component.setStartdate(startdate);
			productInstance.addProductRelationshipItem(this.buildComponents(component, productInstance.getPublicId()));
		});
	}

	private RelatedProductType buildComponents(Component component, String publicId) {
		RelatedProductType relatedProductType = new RelatedProductType();
		ProductRefInfoType prit = new ProductRefInfoType();
		List<BillingOffer> bo = this.billingOfferRepository.findByAssignedProductId(component.getId());
		if (!bo.isEmpty()) {
			this.buildComponentProdPriceType(bo, prit);
		}

		prit.setId(component.getId());
		prit.setPublicId(publicId);
		prit.setDescription(component.getDescription());
		prit.setName(component.getName());
		prit.setProductType(ProductRefInfoType.ProductTypeEnum.fromValue(component.getProducttype().toLowerCase()));
		prit.setStartDate(this.getDateTimeZone(component.getStartdate()));
		prit.setHref(component.getParentassignproductid());
		this.buildCharacteristicComponent(this.caracteristicaRepository.findById(component.getId()), prit);

		relatedProductType.setProduct(prit);
		relatedProductType.setType(Constant.SUBPRODUCT);
		return relatedProductType;
	}

	private void buildTreeRelationShip(Map<String, RelatedProductType> hashMapPrit, ProductInstanceType productInstance) {
		hashMapPrit.forEach((k, v) -> {
			String parentAssignProductId = v.getProduct().getHref();
			if (!parentAssignProductId.equalsIgnoreCase(productInstance.getId())) {
				if (hashMapPrit.get(parentAssignProductId) != null)
					hashMapPrit.get(parentAssignProductId).getProduct().addProductRelationshipItem(v);
			}
		});

		hashMapPrit.forEach((k, v) -> {
			String parentAssignProductId = v.getProduct().getHref();
			if (parentAssignProductId.equalsIgnoreCase(productInstance.getId())) {
				productInstance.addProductRelationshipItem(v);
			}
		});

		hashMapPrit.forEach((k, v) -> {
			v.getProduct().setHref(Constant.HREF_PRODUCT_INSTANCE_TYPE + (v.getProduct().getId()));
		});
	}

	private void buildCharacteristicComponent(final List<Caracteristica> characteristic, ProductRefInfoType productRefInfoType) {
		characteristic.stream().filter(
				c -> c.getNombre() != null && !c.getNombre().equalsIgnoreCase("") && c.getValor() != null && !c.getValor().equalsIgnoreCase("")).forEach(c -> {
					productRefInfoType.addCharacteristicItem(this.buildTextTypeCharacteristic(c.getNombre(), c.getValor()));
				});
	}

	protected void buildCharacteristic(final List<Caracteristica> characteristic, ProductInstanceType productInstanceType) {
		characteristic.stream().filter(
				c -> c.getNombre() != null && !c.getNombre().equalsIgnoreCase("") && c.getValor() != null && !c.getValor().equalsIgnoreCase("")).forEach(c -> {
					productInstanceType.addCharacteristicItem(this.buildTextTypeCharacteristic(c.getNombre(), c.getValor()));
				});
	}

	protected Text buildTextTypeCharacteristic(String key, String value) {
		Text textType = new Text();
		textType.setValueType(StringType.ValueTypeEnum.STRING);
		textType.setName(key);
		textType.setValue(value);
		return textType;
	}

	protected MobileQuota buildMobileQuotaCharacteristic(final List<Quota> quotaList) {
		MobileQuota mobileQuota = new MobileQuota();
		mobileQuota.setValueType(MobileQuota.ValueTypeEnum.OBJECT);
		mobileQuota.setValue(this.buildMobileQuotaCharacteristicType(quotaList));

		return mobileQuota;
	}

	protected List<Quota> findQuotas(String assignedProductId) {
		return quotaRepository.findByAssignedproductid(assignedProductId);
	}

	private MobileQuotaCharacteristicType buildMobileQuotaCharacteristicType(final List<Quota> quotaList) {
		MobileQuotaCharacteristicType characteristicType = new MobileQuotaCharacteristicType();
		characteristicType.addDataQuotaItem(this.buildDataQuota(quotaList));
		characteristicType.addSmsQuotaItem(this.buildSmsQuota(quotaList));
		characteristicType.addVoiceQuotaItem(this.buildVoiceQuota(quotaList));
		return characteristicType;
	}

	private MobileQuotaCharacteristicTypeVoiceQuota buildVoiceQuota(final List<Quota> quotaList) {
		MobileQuotaCharacteristicTypeVoiceQuota voice = new MobileQuotaCharacteristicTypeVoiceQuota();
		quotaList.stream().filter(quota -> quota.getTipoquota().equalsIgnoreCase(Constant.MOBILE_QUOTA_VOICE)).forEach(quota -> {
			voice.setVoiceAllowance(quota.getCantidad().intValue());
			voice.setUnit(MobileQuotaCharacteristicTypeVoiceQuota.UnitEnum.fromValue(quota.getUnidad()));
			voice.addTimeBandsItem(MobileQuotaCharacteristicTypeVoiceQuota.TimeBandsEnum.fromValue(quota.getBanda()));
			voice.addOriginsItem(MobileQuotaCharacteristicTypeVoiceQuota.OriginsEnum.fromValue(quota.getOrigen()));
			voice.addDestinationsItem(MobileQuotaCharacteristicTypeVoiceQuota.DestinationsEnum.fromValue(quota.getDestino()));
		});
		return voice;
	}

	private MobileQuotaCharacteristicTypeSmsQuota buildSmsQuota(final List<Quota> quotaList) {
		MobileQuotaCharacteristicTypeSmsQuota sms = new MobileQuotaCharacteristicTypeSmsQuota();
		quotaList.stream().filter(quota -> quota.getTipoquota().equalsIgnoreCase(Constant.MOBILE_QUOTA_SMS)).forEach(quota -> {
			sms.setSmsAllowance(quota.getCantidad().intValue());
			sms.addTimeBandsItem(MobileQuotaCharacteristicTypeSmsQuota.TimeBandsEnum.fromValue(quota.getBanda()));
			sms.addOriginsItem(MobileQuotaCharacteristicTypeSmsQuota.OriginsEnum.fromValue(quota.getOrigen()));
			sms.addDestinationsItem(MobileQuotaCharacteristicTypeSmsQuota.DestinationsEnum.fromValue(quota.getDestino()));
		});
		return sms;
	}

	private MobileQuotaCharacteristicTypeDataQuota buildDataQuota(final List<Quota> quotaList) {
		MobileQuotaCharacteristicTypeDataQuota data = new MobileQuotaCharacteristicTypeDataQuota();
		quotaList.stream().filter(quota -> quota.getTipoquota().equalsIgnoreCase(Constant.MOBILE_QUOTA_DATA)).forEach(quota -> {
			data.setDataAllowance(quota.getCantidad().longValue());
			data.setUnit(MobileQuotaCharacteristicTypeDataQuota.UnitEnum.fromValue(quota.getUnidad()));
			data.addTimeBandsItem(MobileQuotaCharacteristicTypeDataQuota.TimeBandsEnum.fromValue(quota.getBanda()));
			data.addOriginsItem(MobileQuotaCharacteristicTypeDataQuota.OriginsEnum.fromValue(quota.getOrigen()));
			data.addDestinationsItem(MobileQuotaCharacteristicTypeDataQuota.DestinationsEnum.fromValue(quota.getDestino()));
		});
		return data;
	}

	protected void buildComponentProdPriceType(final List<BillingOffer> billingOffer, Object prit) {
		ComponentProdPriceType componentProdPriceType = new ComponentProdPriceType();
		billingOffer.stream().filter(boffer -> (boffer.getPriceType() != null && !boffer.getPriceType().equalsIgnoreCase("")
				&& ComponentProdPriceType.PriceTypeEnum.fromValue(boffer.getPriceType().toLowerCase()) != null) && boffer.getAmount() != null
				&& boffer.getUnit() != null && !boffer.getUnit().equalsIgnoreCase("")).forEach(boffer -> {
					componentProdPriceType.setId(boffer.getId());
					componentProdPriceType.setName(boffer.getName());
					componentProdPriceType.setPriceType(ComponentProdPriceType.PriceTypeEnum.fromValue(boffer.getPriceType().toLowerCase()));
					componentProdPriceType.setRecurringChargePeriod(
							ComponentProdPriceType.RecurringChargePeriodEnum.fromValue(boffer.getRecurringChargePeriod().toLowerCase()));

					final MoneyType moneyType = new MoneyType();
					moneyType.setAmount(BigDecimal.valueOf(boffer.getAmount()));
					moneyType.setUnits(boffer.getUnit());
					componentProdPriceType.setPrice(moneyType);

					if (boffer.getIdbillingoffer() != null || !boffer.getIdbillingoffer().equalsIgnoreCase("")) {
						List<BillingOfferAttribute> boAttributeList = this.boAttributeRepository.findByBillingOfferID(boffer.getIdbillingoffer());
						this.buildAdditionalData(boAttributeList, componentProdPriceType);
					}
					if (prit instanceof ProductRefInfoType)
						((ProductRefInfoType) prit).addProductPriceItem(componentProdPriceType);
					if (prit instanceof ProductInstanceType)
						((ProductInstanceType) prit).addProductPriceItem(componentProdPriceType);

				});
	}

	protected void buildAdditionalData(final List<BillingOfferAttribute> billingOfferAttribute, ComponentProdPriceType productPrice) {
		billingOfferAttribute.parallelStream().filter(
				oa -> oa.getAttributeDefaultValue() != null && !oa.getAttributeDefaultValue().equalsIgnoreCase("")).forEach(oa -> {
					KeyValueType keyValueType = new KeyValueType();
					keyValueType.setValue(oa.getAttributeDefaultValue());
					this.getKeyAdditionalData(oa.getNameListTypeNameLocal(), keyValueType);
					productPrice.addAdditionalDataItem(keyValueType);
				});
	}

	private void getKeyAdditionalData(String name, KeyValueType key) {
		List<Map<String, String>> tempList = JsonUtil.jsonMapper.readValue(name, List.class);
		tempList.parallelStream().forEach(tl -> {
			tl.forEach((k, v) -> {
				if (String.valueOf(k).equalsIgnoreCase(Constant.ATTRIBUTE_TO_CONSIDER)) {
					key.setKey(String.valueOf(v));
				}
			});
		});
	}

	protected <T> void throwBussinessException(T obj) {
		if (obj instanceof List<?>) {
			if (obj == null || ((List<T>) obj).size() == 0) {
				throw new BusinessException();
			}
		} else if (obj == null) {
			throw new BusinessException();
		}
	}

	private BillingMethodEnum buildBuildMethod(String billingMethod) {
		if (billingMethod.equalsIgnoreCase(Constant.BILLINGMETHOD_CONTROL)) {
			return AccountRefType.BillingMethodEnum.CONTROL;
		} else if (billingMethod.equalsIgnoreCase(Constant.BILLINGMETHOD_POSTPAID)) {
			return AccountRefType.BillingMethodEnum.POSTPAID;
		} else if (billingMethod.equalsIgnoreCase(Constant.BILLINGMETHOD_PREPAID)) {
			return AccountRefType.BillingMethodEnum.PREPAID;
		} else if (billingMethod.equalsIgnoreCase(Constant.BILLINGMETHOD_CARIBU)) {
			return AccountRefType.BillingMethodEnum.CONTROL;
		} else {
			return null;
		}
	}

	protected StatusEnum buildStatus(String state) {
		if (state.equalsIgnoreCase(Constant.STATEPRODUCT_ACTIVE)) {
			return ProductInstanceType.StatusEnum.ACTIVE;
		} else if (state.equalsIgnoreCase(Constant.STATEPRODUCT_SUSPENDED)) {
			return ProductInstanceType.StatusEnum.SUSPENDED;
		} else if (state.equalsIgnoreCase(Constant.STATEPRODUCT_TERMINATED)) {
			return ProductInstanceType.StatusEnum.TERMINATED;
		} else {
			return null;
		}
	}

	protected String getDateTimeZone(Date datetime) {
		if (datetime != null) {
			ZonedDateTime date = datetime.toInstant().atZone(ZoneId.systemDefault());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.FORMAT_DATETIME);
			return date.toLocalDateTime().format(formatter).toString() + date.getOffset().toString();
		}
		return null;
	}

	protected Date buildOrderDate(final PrincipalComponent pc) {
		if (!pc.getProducType().toUpperCase().equalsIgnoreCase(ProductType.MOBILE.toString())) {
			return pc.getStartdate();
		} else
			return null;
	}

	protected void buildCycleBillingCharacteristic(ProductInstanceType pit, final Customer customer) {
		if (customer.getCiclodefacturacion() != null && !customer.getCiclodefacturacion().equalsIgnoreCase("")) {
			pit.addCharacteristicItem(this.buildTextTypeCharacteristic(Constant.CICLE_BILLING, customer.getCiclodefacturacion()));
		}
	}

	protected void buildSharingData(ProductInstanceType pit, BillingOffer bo) {
		if (!bo.getIdbillingoffer().equalsIgnoreCase("")) {
			List<BillingOfferPropertieList> bopl = this.billingOfferPropertieListRepository.findByBillingOfferIdAndPropertiesName(bo.getIdbillingoffer(),
					this.dataSharing);
			bopl.forEach(b -> {
				if (b.getPropertiesName().equalsIgnoreCase(Constant.SHARINGDATACONSUMER_VALUE)) {
					pit.addCharacteristicItem(this.buildTextTypeCharacteristic(Constant.SHARINGDATACONSUMER_NAME, b.getPropertiesValue()));
				} else {
					pit.addCharacteristicItem(this.buildTextTypeCharacteristic(Constant.SHARINGDATAOWNER_NAME, b.getPropertiesValue()));
				}
			});
		}
	}

	protected void buildQuotaData(ProductInstanceType pit, BillingOffer bo) {
		if (!bo.getIdbillingoffer().equalsIgnoreCase("")) {
			List<Quota> quotaList = quotaRepository.findByAssignedproductid(bo.getIdbillingoffer());
			if (!quotaList.isEmpty()) {
				pit.addCharacteristicItem(this.buildMobileQuotaCharacteristic(quotaList));
			}
		}
	}

	protected void buildMTIndicator(ProductInstanceType pit, BillingOffer bo) {
		if (!bo.getIndicadorMovistarTotal().equalsIgnoreCase("")) {
			pit.addCharacteristicItem(this.buildTextTypeCharacteristic(Constant.INDICATOR_MT, bo.getIndicadorMovistarTotal()));
		}
	}

	protected List<BillingOffer> buildBillingOffer(final PrincipalComponent pc) {
		List<BillingOffer> billingOffer;
		if (pc.getProducType().toUpperCase().equalsIgnoreCase(ProductType.MOBILE.toString())) {
			billingOffer = this.billingOfferRepository.findByAssignedMainComponentAndIndicadorPlan(pc.getMaincomponentkey(), Constant.INDICADOR_PLAN);
		} else {
			billingOffer = this.billingOfferRepository.findByAssignedProductId(pc.getId());
		}
		return billingOffer;
	}

	protected ProductTypeEnum validateProductType(String pType) {
		if (ProductType.BALNEARIO.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.LANDLINE;
		} else if (ProductType.MOVISTAR_TV_TDP_HOGAR_DIGITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.INTERMEDIO_SATELITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.CONTROL_SATELITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.MOVISTAR_TV_BASICO_SAT_TDP.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.LINEA_TELEFONICA_VOIP.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.LANDLINE;
		} else if (ProductType.INTERMEDIO_SATELITAL_TDP.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.ESTANDAR_DIGITAL_FTTH.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.MOVISTAR_UNO_DUO.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BUNDLE;
		} else if (ProductType.MOVISTAR_TV_HOGAR_DIGITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.DUO_NAKED_TV_ESTANDAR_INTE.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BUNDLE;
		} else if (ProductType.SPEEDY_MONO_HFC.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BROADBAND;
		} else if (ProductType.ESTANDAR_TRIO_TDP.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BUNDLE;
		} else if (ProductType.ESTANDAR_FULL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.DUO_NAKED_SOLO_INTERNET.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BROADBAND;
		} else if (ProductType.MOVISTAR_UNO_TRIO.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BUNDLE;
		} else if (ProductType.ESTANDAR.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.INTERNET_NAKED_FTTH.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BROADBAND;
		} else if (ProductType.MOVISTAR_ESTANDAR_SATELITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.ESTANDAR_TDP_DIGITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.ESTELAR_DIGITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.ESTELAR_TRIO_TDP.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BUNDLE;
		} else if (ProductType.INTERMEDIO.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BUNDLE;
		} else if (ProductType.BALNEARIO_SATELITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.ESTELAR_DIGITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.ESTELAR_TDP_DIGITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.ESTELAR_SATELITAL_TDP.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.ESTELAR.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.STD_DIG_MOVISTAR_UNO_TRIO.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.BUNDLE;
		} else if (ProductType.ESTANDAR_SATELITAL.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.CABLETV;
		} else if (ProductType.OTROS.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.LANDLINE;
		} else if (ProductType.MOBILE.toString().equalsIgnoreCase(pType)) {
			return ProductTypeEnum.MOBILE;
		} else
			return null;
	}

}
