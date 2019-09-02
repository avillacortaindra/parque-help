package com.tefper.daas.parque.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * QuantityType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class QuantityType   {
  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("maximum")
  private BigDecimal maximum = null;

  @JsonProperty("minimum")
  private BigDecimal minimum = null;

  @JsonProperty("units")
  private String units = null;

  public QuantityType amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Current number of units set for the quantity
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Current number of units set for the quantity")
  @NotNull

  @Valid

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public QuantityType maximum(BigDecimal maximum) {
    this.maximum = maximum;
    return this;
  }

  /**
   * Maximum number of units allowed for the quantity
   * @return maximum
  **/
  @ApiModelProperty(value = "Maximum number of units allowed for the quantity")

  @Valid

  public BigDecimal getMaximum() {
    return maximum;
  }

  public void setMaximum(BigDecimal maximum) {
    this.maximum = maximum;
  }

  public QuantityType minimum(BigDecimal minimum) {
    this.minimum = minimum;
    return this;
  }

  /**
   * Minimum number of units allowed for the quantity
   * @return minimum
  **/
  @ApiModelProperty(value = "Minimum number of units allowed for the quantity")

  @Valid

  public BigDecimal getMinimum() {
    return minimum;
  }

  public void setMinimum(BigDecimal minimum) {
    this.minimum = minimum;
  }

  public QuantityType units(String units) {
    this.units = units;
    return this;
  }

  /**
   * Definition of the units used for the quantity (number of licenses, minutes, Megabytes, …). Implementation specific
   * @return units
  **/
  @ApiModelProperty(required = true, value = "Definition of the units used for the quantity (number of licenses, minutes, Megabytes, …). Implementation specific")
  @NotNull


  public String getUnits() {
    return units;
  }

  public void setUnits(String units) {
    this.units = units;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuantityType quantityType = (QuantityType) o;
    return Objects.equals(this.amount, quantityType.amount) &&
        Objects.equals(this.maximum, quantityType.maximum) &&
        Objects.equals(this.minimum, quantityType.minimum) &&
        Objects.equals(this.units, quantityType.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, maximum, minimum, units);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuantityType {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    maximum: ").append(toIndentedString(maximum)).append("\n");
    sb.append("    minimum: ").append(toIndentedString(minimum)).append("\n");
    sb.append("    units: ").append(toIndentedString(units)).append("\n");
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

