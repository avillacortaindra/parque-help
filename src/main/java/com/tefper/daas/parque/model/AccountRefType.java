package com.tefper.daas.parque.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Reference to an external account that can be queried with the Account Management API.
 */
@ApiModel(description = "Reference to an external account that can be queried with the Account Management API.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class AccountRefType   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  /**
   * How this account is billed
   */
  public enum BillingMethodEnum {
    PREPAID("prepaid"),
    
    POSTPAID("postpaid"),
    
    CONTROL("control");

    private String value;

    BillingMethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static BillingMethodEnum fromValue(String text) {
      for (BillingMethodEnum b : BillingMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("billingMethod")
  private BillingMethodEnum billingMethod = null;

  public AccountRefType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the account
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Unique identifier of the account")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AccountRefType href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A resource URI pointing to the account resource in the server
   * @return href
  **/
  @ApiModelProperty(required = true, value = "A resource URI pointing to the account resource in the server")
  @NotNull


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AccountRefType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Account name
   * @return name
  **/
  @ApiModelProperty(value = "Account name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AccountRefType referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * Type of referred account e.g.: financial account, billing account…
   * @return referredType
  **/
  @ApiModelProperty(value = "Type of referred account e.g.: financial account, billing account…")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }

  public AccountRefType billingMethod(BillingMethodEnum billingMethod) {
    this.billingMethod = billingMethod;
    return this;
  }

  /**
   * How this account is billed
   * @return billingMethod
  **/
  @ApiModelProperty(value = "How this account is billed")


  public BillingMethodEnum getBillingMethod() {
    return billingMethod;
  }

  public void setBillingMethod(BillingMethodEnum billingMethod) {
    this.billingMethod = billingMethod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountRefType accountRefType = (AccountRefType) o;
    return Objects.equals(this.id, accountRefType.id) &&
        Objects.equals(this.href, accountRefType.href) &&
        Objects.equals(this.name, accountRefType.name) &&
        Objects.equals(this.referredType, accountRefType.referredType) &&
        Objects.equals(this.billingMethod, accountRefType.billingMethod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, referredType, billingMethod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    billingMethod: ").append(toIndentedString(billingMethod)).append("\n");
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

