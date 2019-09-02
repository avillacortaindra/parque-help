package com.tefper.daas.parque.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ComponentProdPriceType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class ComponentProdPriceType {

	@JsonProperty("id")
	private String	id			= null;

	@JsonProperty("name")
	private String	name		= null;

	@JsonProperty("description")
	private String	description	= null;

	@JsonProperty("isMandatory")
	private Boolean	isMandatory	= null;

	/**
	 * Identification for the type of individual pricing component
	 */
	public enum PriceTypeEnum {
		RECURRING("recurring"),

		USAGE("usage"),

		ONE_TIME("one time");

		private String value;

		PriceTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static PriceTypeEnum fromValue(String text) {
			for (PriceTypeEnum b : PriceTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("priceType")
	private PriceTypeEnum priceType = null;

	/**
	 * Identification for the recurring charging periodicity in the case of
	 * recurring pricing models (e.g.: “monthly”, “yearly”,…)
	 */
	public enum RecurringChargePeriodEnum {
		DAILY("daily"),

		WEEKLY("weekly"),

		MONTHLY("monthly"),

		YEARLY("yearly");

		private String value;

		RecurringChargePeriodEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static RecurringChargePeriodEnum fromValue(String text) {
			for (RecurringChargePeriodEnum b : RecurringChargePeriodEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("recurringChargePeriod")
	private RecurringChargePeriodEnum		recurringChargePeriod	= null;

	@JsonProperty("unitOfMeasure")
	private QuantityType					unitOfMeasure			= null;

	@JsonProperty("price")
	private MoneyType						price					= null;

	@JsonProperty("taxIncluded")
	private Boolean							taxIncluded				= null;

	@JsonProperty("taxRate")
	private BigDecimal						taxRate					= null;

	@JsonProperty("taxType")
	private String							taxType					= null;

	@JsonProperty("prodPriceAlteration")
	@Valid
	private List<ProdPriceAlterationType>	prodPriceAlteration		= null;

	@JsonProperty("additionalData")
	@Valid
	private List<KeyValueType>				additionalData			= null;

	public ComponentProdPriceType id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * A unique identifier for the pricing model
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "A unique identifier for the pricing model")

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ComponentProdPriceType name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * A human readable pricing model name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "A human readable pricing model name")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ComponentProdPriceType description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A human readable pricing short description
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A human readable pricing short description")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ComponentProdPriceType isMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
		return this;
	}

	/**
	 * Indicates if the pricing model must be always included as part of the
	 * offering
	 * 
	 * @return isMandatory
	 **/
	@ApiModelProperty(value = "Indicates if the pricing model must be always included as part of the offering")

	public Boolean isIsMandatory() {
		return isMandatory;
	}

	public void setIsMandatory(Boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public ComponentProdPriceType priceType(PriceTypeEnum priceType) {
		this.priceType = priceType;
		return this;
	}

	/**
	 * Identification for the type of individual pricing component
	 * 
	 * @return priceType
	 **/
	@ApiModelProperty(required = true, value = "Identification for the type of individual pricing component")
	@NotNull

	public PriceTypeEnum getPriceType() {
		return priceType;
	}

	public void setPriceType(PriceTypeEnum priceType) {
		this.priceType = priceType;
	}

	public ComponentProdPriceType recurringChargePeriod(RecurringChargePeriodEnum recurringChargePeriod) {
		this.recurringChargePeriod = recurringChargePeriod;
		return this;
	}

	/**
	 * Identification for the recurring charging periodicity in the case of
	 * recurring pricing models (e.g.: “monthly”, “yearly”,…)
	 * 
	 * @return recurringChargePeriod
	 **/
	@ApiModelProperty(value = "Identification for the recurring charging periodicity in the case of recurring pricing models (e.g.: “monthly”, “yearly”,…)")

	public RecurringChargePeriodEnum getRecurringChargePeriod() {
		return recurringChargePeriod;
	}

	public void setRecurringChargePeriod(RecurringChargePeriodEnum recurringChargePeriod) {
		this.recurringChargePeriod = recurringChargePeriod;
	}

	public ComponentProdPriceType unitOfMeasure(QuantityType unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	/**
	 * Indication of the criteria to be used for the charging (e.g.: “per
	 * minute”, “per second”, “per GB”, “per 50GB”, “per license”, “per
	 * subscription to offering”…)
	 * 
	 * @return unitOfMeasure
	 **/
	@ApiModelProperty(value = "Indication of the criteria to be used for the charging (e.g.: “per minute”, “per second”, “per GB”, “per 50GB”, “per license”, “per subscription to offering”…)")

	@Valid

	public QuantityType getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(QuantityType unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public ComponentProdPriceType price(MoneyType price) {
		this.price = price;
		return this;
	}

	/**
	 * Base value applied to the price model offering (without taxes). This
	 * could refer to a charge, a discount or an allowance
	 * 
	 * @return price
	 **/
	@ApiModelProperty(required = true, value = "Base value applied to the price model offering (without taxes). This could refer to a charge, a discount or an allowance")
	@NotNull

	@Valid

	public MoneyType getPrice() {
		return price;
	}

	public void setPrice(MoneyType price) {
		this.price = price;
	}

	public ComponentProdPriceType taxIncluded(Boolean taxIncluded) {
		this.taxIncluded = taxIncluded;
		return this;
	}

	/**
	 * Indication if the price is with taxes (true) or without (false)
	 * 
	 * @return taxIncluded
	 **/
	@ApiModelProperty(value = "Indication if the price is with taxes (true) or without (false)")

	public Boolean isTaxIncluded() {
		return taxIncluded;
	}

	public void setTaxIncluded(Boolean taxIncluded) {
		this.taxIncluded = taxIncluded;
	}

	public ComponentProdPriceType taxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
		return this;
	}

	/**
	 * Taxes (in percentage) applied to the individual pricing component
	 * 
	 * @return taxRate
	 **/
	@ApiModelProperty(value = "Taxes (in percentage) applied to the individual pricing component")

	@Valid

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public ComponentProdPriceType taxType(String taxType) {
		this.taxType = taxType;
		return this;
	}

	/**
	 * Indication on the type of tax applied (e.g. “VAT”, “IVA”, …)
	 * 
	 * @return taxType
	 **/
	@ApiModelProperty(value = "Indication on the type of tax applied (e.g. “VAT”, “IVA”, …)")

	public String getTaxType() {
		return taxType;
	}

	public void setTaxType(String taxType) {
		this.taxType = taxType;
	}

	public ComponentProdPriceType prodPriceAlteration(List<ProdPriceAlterationType> prodPriceAlteration) {
		this.prodPriceAlteration = prodPriceAlteration;
		return this;
	}

	public ComponentProdPriceType addProdPriceAlterationItem(ProdPriceAlterationType prodPriceAlterationItem) {
		if (this.prodPriceAlteration == null) {
			this.prodPriceAlteration = new ArrayList<ProdPriceAlterationType>();
		}
		this.prodPriceAlteration.add(prodPriceAlterationItem);
		return this;
	}

	/**
	 * An amount, usually of money, that modifies a price charged for a Product
	 * 
	 * @return prodPriceAlteration
	 **/
	@ApiModelProperty(value = "An amount, usually of money, that modifies a price charged for a Product")

	@Valid

	public List<ProdPriceAlterationType> getProdPriceAlteration() {
		return prodPriceAlteration;
	}

	public void setProdPriceAlteration(List<ProdPriceAlterationType> prodPriceAlteration) {
		this.prodPriceAlteration = prodPriceAlteration;
	}

	public ComponentProdPriceType additionalData(List<KeyValueType> additionalData) {
		this.additionalData = additionalData;
		return this;
	}

	public ComponentProdPriceType addAdditionalDataItem(KeyValueType additionalDataItem) {
		if (this.additionalData == null) {
			this.additionalData = new ArrayList<KeyValueType>();
		}
		this.additionalData.add(additionalDataItem);
		return this;
	}

	/**
	 * Any additional metadata that the application may supply (implementation
	 * and application specific). The metadata are in the form of name-value
	 * pairs. It is recommended not to use this parameter and request new
	 * information elements to be added in the structure definition. Next
	 * releases of the T-Open API will not include support for this
	 * additionalData parameter because it has been detected that the
	 * extensibility function is not helping the stability of the standard
	 * definition of APIs
	 * 
	 * @return additionalData
	 **/
	@ApiModelProperty(value = "Any additional metadata that the application may supply (implementation and application specific). The metadata are in the form of name-value pairs. It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs")

	@Valid

	public List<KeyValueType> getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(List<KeyValueType> additionalData) {
		this.additionalData = additionalData;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ComponentProdPriceType componentProdPriceType = (ComponentProdPriceType) o;
		return Objects.equals(this.id, componentProdPriceType.id) && Objects.equals(this.name, componentProdPriceType.name)
				&& Objects.equals(this.description, componentProdPriceType.description) && Objects.equals(this.isMandatory, componentProdPriceType.isMandatory)
				&& Objects.equals(this.priceType, componentProdPriceType.priceType)
				&& Objects.equals(this.recurringChargePeriod, componentProdPriceType.recurringChargePeriod)
				&& Objects.equals(this.unitOfMeasure, componentProdPriceType.unitOfMeasure) && Objects.equals(this.price, componentProdPriceType.price)
				&& Objects.equals(this.taxIncluded, componentProdPriceType.taxIncluded) && Objects.equals(this.taxRate, componentProdPriceType.taxRate)
				&& Objects.equals(this.taxType, componentProdPriceType.taxType)
				&& Objects.equals(this.prodPriceAlteration, componentProdPriceType.prodPriceAlteration)
				&& Objects.equals(this.additionalData, componentProdPriceType.additionalData);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, isMandatory, priceType, recurringChargePeriod, unitOfMeasure, price, taxIncluded, taxRate, taxType,
				prodPriceAlteration, additionalData);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ComponentProdPriceType {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    isMandatory: ").append(toIndentedString(isMandatory)).append("\n");
		sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
		sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
		sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
		sb.append("    price: ").append(toIndentedString(price)).append("\n");
		sb.append("    taxIncluded: ").append(toIndentedString(taxIncluded)).append("\n");
		sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
		sb.append("    taxType: ").append(toIndentedString(taxType)).append("\n");
		sb.append("    prodPriceAlteration: ").append(toIndentedString(prodPriceAlteration)).append("\n");
		sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
