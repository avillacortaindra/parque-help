package com.tefper.daas.parque.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RelatedPartyRefType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class RelatedPartyRefType   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  @JsonProperty("@referredType")
  private String referredType = null;

  @JsonProperty("description")
  private String description = null;

  public RelatedPartyRefType id(String id) {
    this.id = id;
    return this;
  }

  /**
   * String providing identification of the related party reported
   * @return id
  **/
  @ApiModelProperty(required = true, value = "String providing identification of the related party reported")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RelatedPartyRefType href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A resource URI pointing to the resource in the OB that stores the related party detailed information
   * @return href
  **/
  @ApiModelProperty(value = "A resource URI pointing to the resource in the OB that stores the related party detailed information")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public RelatedPartyRefType name(String name) {
    this.name = name;
    return this;
  }

  /**
   * String providing the name of the related party reported
   * @return name
  **/
  @ApiModelProperty(value = "String providing the name of the related party reported")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RelatedPartyRefType role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Indication of the relationship defined between the related party and the order (e.g.: originator, customer, user, …). Supported values are implementation and application specific
   * @return role
  **/
  @ApiModelProperty(value = "Indication of the relationship defined between the related party and the order (e.g.: originator, customer, user, …). Supported values are implementation and application specific")


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public RelatedPartyRefType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The validity for the relation with the related party. If not included, the current date is used as starting date and no ending date is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the relation with the related party. If not included, the current date is used as starting date and no ending date is defined")

  @Valid

  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }

  public RelatedPartyRefType referredType(String referredType) {
    this.referredType = referredType;
    return this;
  }

  /**
   * Indicates the type of the resource referenced for extensibility/polimorphic purposes of the specific entity (individual/organization for customer, urban/rural for address, ...)
   * @return referredType
  **/
  @ApiModelProperty(value = "Indicates the type of the resource referenced for extensibility/polimorphic purposes of the specific entity (individual/organization for customer, urban/rural for address, ...)")


  public String getReferredType() {
    return referredType;
  }

  public void setReferredType(String referredType) {
    this.referredType = referredType;
  }

  public RelatedPartyRefType description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Text describing the referred related party
   * @return description
  **/
  @ApiModelProperty(value = "Text describing the referred related party")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedPartyRefType relatedPartyRefType = (RelatedPartyRefType) o;
    return Objects.equals(this.id, relatedPartyRefType.id) &&
        Objects.equals(this.href, relatedPartyRefType.href) &&
        Objects.equals(this.name, relatedPartyRefType.name) &&
        Objects.equals(this.role, relatedPartyRefType.role) &&
        Objects.equals(this.validFor, relatedPartyRefType.validFor) &&
        Objects.equals(this.referredType, relatedPartyRefType.referredType) &&
        Objects.equals(this.description, relatedPartyRefType.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, role, validFor, referredType, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedPartyRefType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    referredType: ").append(toIndentedString(referredType)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

