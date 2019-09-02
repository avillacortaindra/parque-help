package com.tefper.daas.parque.model;

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
 * ProdPriceAlterationType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class ProdPriceAlterationType   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("priceCondition")
  private String priceCondition = null;

  @JsonProperty("priority")
  private String priority = null;

  @JsonProperty("priceType")
  private String priceType = null;

  /**
   * Identification for the recurring periodicity in the case of recurring alteration models (e.g.: “monthly”, “yearly”,…)
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
  private RecurringChargePeriodEnum recurringChargePeriod = null;

  @JsonProperty("applicationDuration")
  private Integer applicationDuration = null;

  /**
   * Identification for the type of discount to be applied
   */
  public enum DiscountTypeEnum {
    AMOUNT("amount"),
    
    PERCENTAGE("percentage");

    private String value;

    DiscountTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DiscountTypeEnum fromValue(String text) {
      for (DiscountTypeEnum b : DiscountTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("discountType")
  private DiscountTypeEnum discountType = null;

  @JsonProperty("unitOfMeasure")
  private QuantityType unitOfMeasure = null;

  @JsonProperty("price")
  private MoneyType price = null;

  @JsonProperty("additionalData")
  @Valid
  private List<KeyValueType> additionalData = null;

  public ProdPriceAlterationType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * A human readable charging discount model name
   * @return name
  **/
  @ApiModelProperty(value = "A human readable charging discount model name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProdPriceAlterationType description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A human readable discount short description
   * @return description
  **/
  @ApiModelProperty(value = "A human readable discount short description")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProdPriceAlterationType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The validity for the discount model If not included, the current date is used as starting date and no ending date is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the discount model If not included, the current date is used as starting date and no ending date is defined")

  @Valid

  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public ProdPriceAlterationType priceCondition(String priceCondition) {
    this.priceCondition = priceCondition;
    return this;
  }

  /**
   * Text describing the condition that triggers the alteration to be applied
   * @return priceCondition
  **/
  @ApiModelProperty(value = "Text describing the condition that triggers the alteration to be applied")


  public String getPriceCondition() {
    return priceCondition;
  }

  public void setPriceCondition(String priceCondition) {
    this.priceCondition = priceCondition;
  }

  public ProdPriceAlterationType priority(String priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Priority level for applying this alteration among all the defined alterations on the order item price
   * @return priority
  **/
  @ApiModelProperty(value = "Priority level for applying this alteration among all the defined alterations on the order item price")


  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public ProdPriceAlterationType priceType(String priceType) {
    this.priceType = priceType;
    return this;
  }

  /**
   * Identification for the type of individual alteration type (recurring discount, one time discount, recurring allowance, one time allowance)
   * @return priceType
  **/
  @ApiModelProperty(required = true, value = "Identification for the type of individual alteration type (recurring discount, one time discount, recurring allowance, one time allowance)")
  @NotNull


  public String getPriceType() {
    return priceType;
  }

  public void setPriceType(String priceType) {
    this.priceType = priceType;
  }

  public ProdPriceAlterationType recurringChargePeriod(RecurringChargePeriodEnum recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
    return this;
  }

  /**
   * Identification for the recurring periodicity in the case of recurring alteration models (e.g.: “monthly”, “yearly”,…)
   * @return recurringChargePeriod
  **/
  @ApiModelProperty(value = "Identification for the recurring periodicity in the case of recurring alteration models (e.g.: “monthly”, “yearly”,…)")


  public RecurringChargePeriodEnum getRecurringChargePeriod() {
    return recurringChargePeriod;
  }

  public void setRecurringChargePeriod(RecurringChargePeriodEnum recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
  }

  public ProdPriceAlterationType applicationDuration(Integer applicationDuration) {
    this.applicationDuration = applicationDuration;
    return this;
  }

  /**
   * Duration defined as a number of instances of the recurring period to apply the alteration (e.g.: 2 months for the recurring discount)
   * @return applicationDuration
  **/
  @ApiModelProperty(value = "Duration defined as a number of instances of the recurring period to apply the alteration (e.g.: 2 months for the recurring discount)")


  public Integer getApplicationDuration() {
    return applicationDuration;
  }

  public void setApplicationDuration(Integer applicationDuration) {
    this.applicationDuration = applicationDuration;
  }

  public ProdPriceAlterationType discountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
    return this;
  }

  /**
   * Identification for the type of discount to be applied
   * @return discountType
  **/
  @ApiModelProperty(value = "Identification for the type of discount to be applied")


  public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  public ProdPriceAlterationType unitOfMeasure(QuantityType unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * Unit of measure to apply the alteration (e.g.: “per 1 minute”, “per 1 second”, “per 1 GB”, “per 50 GB”, “per 1 license”, “subscription”,…)
   * @return unitOfMeasure
  **/
  @ApiModelProperty(value = "Unit of measure to apply the alteration (e.g.: “per 1 minute”, “per 1 second”, “per 1 GB”, “per 50 GB”, “per 1 license”, “subscription”,…)")

  @Valid

  public QuantityType getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(QuantityType unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public ProdPriceAlterationType price(MoneyType price) {
    this.price = price;
    return this;
  }

  /**
   * Value of the alteration for the case of discount. This will refer to a monetary value or a percentage
   * @return price
  **/
  @ApiModelProperty(value = "Value of the alteration for the case of discount. This will refer to a monetary value or a percentage")

  @Valid

  public MoneyType getPrice() {
    return price;
  }

  public void setPrice(MoneyType price) {
    this.price = price;
  }

  public ProdPriceAlterationType additionalData(List<KeyValueType> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ProdPriceAlterationType addAdditionalDataItem(KeyValueType additionalDataItem) {
    if (this.additionalData == null) {
      this.additionalData = new ArrayList<KeyValueType>();
    }
    this.additionalData.add(additionalDataItem);
    return this;
  }

  /**
   * Any additional metadata that the application may supply (implementation and application specific). It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs
   * @return additionalData
  **/
  @ApiModelProperty(value = "Any additional metadata that the application may supply (implementation and application specific). It is recommended not to use this parameter and request new information elements to be added in the structure definition. Next releases of the T-Open API will not include support for this additionalData parameter because it has been detected that the extensibility function is not helping the stability of the standard definition of APIs")

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
    ProdPriceAlterationType prodPriceAlterationType = (ProdPriceAlterationType) o;
    return Objects.equals(this.name, prodPriceAlterationType.name) &&
        Objects.equals(this.description, prodPriceAlterationType.description) &&
        Objects.equals(this.validFor, prodPriceAlterationType.validFor) &&
        Objects.equals(this.priceCondition, prodPriceAlterationType.priceCondition) &&
        Objects.equals(this.priority, prodPriceAlterationType.priority) &&
        Objects.equals(this.priceType, prodPriceAlterationType.priceType) &&
        Objects.equals(this.recurringChargePeriod, prodPriceAlterationType.recurringChargePeriod) &&
        Objects.equals(this.applicationDuration, prodPriceAlterationType.applicationDuration) &&
        Objects.equals(this.discountType, prodPriceAlterationType.discountType) &&
        Objects.equals(this.unitOfMeasure, prodPriceAlterationType.unitOfMeasure) &&
        Objects.equals(this.price, prodPriceAlterationType.price) &&
        Objects.equals(this.additionalData, prodPriceAlterationType.additionalData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, validFor, priceCondition, priority, priceType, recurringChargePeriod, applicationDuration, discountType, unitOfMeasure, price, additionalData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProdPriceAlterationType {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    priceCondition: ").append(toIndentedString(priceCondition)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
    sb.append("    applicationDuration: ").append(toIndentedString(applicationDuration)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

