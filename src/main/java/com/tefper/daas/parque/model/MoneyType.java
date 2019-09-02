package com.tefper.daas.parque.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * MoneyType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class MoneyType   {
  @JsonProperty("amount")
  private BigDecimal amount = null;

  @JsonProperty("units")
  private String units = null;

  public MoneyType amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Current value set for the money
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Current value set for the money")
  @NotNull

  @Valid

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public MoneyType units(String units) {
    this.units = units;
    return this;
  }

  /**
   * Definition of the currency used. It is implementation specific to define how currencies are defined, it could be defined using ISO 4217
   * @return units
  **/
  @ApiModelProperty(required = true, value = "Definition of the currency used. It is implementation specific to define how currencies are defined, it could be defined using ISO 4217")
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
    MoneyType moneyType = (MoneyType) o;
    return Objects.equals(this.amount, moneyType.amount) &&
        Objects.equals(this.units, moneyType.units);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, units);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MoneyType {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

