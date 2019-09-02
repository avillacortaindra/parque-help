package com.tefper.daas.parque.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RelatedObjectType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class RelatedObjectType   {
  @JsonProperty("involvement")
  private String involvement = null;

  @JsonProperty("reference")
  private String reference = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("validFor")
  private TimePeriodType validFor = null;

  public RelatedObjectType involvement(String involvement) {
    this.involvement = involvement;
    return this;
  }

  /**
   * Indication of the relationship defined between the object and the product reported (e.g.: disputed invoice, adjusted invoice, related product, opportunity, framework agreeement,…). Supported values are implementation and application specific
   * @return involvement
  **/
  @ApiModelProperty(value = "Indication of the relationship defined between the object and the product reported (e.g.: disputed invoice, adjusted invoice, related product, opportunity, framework agreeement,…). Supported values are implementation and application specific")


  public String getInvolvement() {
    return involvement;
  }

  public void setInvolvement(String involvement) {
    this.involvement = involvement;
  }

  public RelatedObjectType reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * String providing identification of the related object reported (an id or a name)
   * @return reference
  **/
  @ApiModelProperty(value = "String providing identification of the related object reported (an id or a name)")


  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public RelatedObjectType href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A resource URI pointing to the resource in the OB that stores the related object detailed information
   * @return href
  **/
  @ApiModelProperty(required = true, value = "A resource URI pointing to the resource in the OB that stores the related object detailed information")
  @NotNull


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public RelatedObjectType validFor(TimePeriodType validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The validity for the relation with the related object. If not included, the current date is used as starting date and no ending date is defined
   * @return validFor
  **/
  @ApiModelProperty(value = "The validity for the relation with the related object. If not included, the current date is used as starting date and no ending date is defined")

  @Valid

  public TimePeriodType getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriodType validFor) {
    this.validFor = validFor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedObjectType relatedObjectType = (RelatedObjectType) o;
    return Objects.equals(this.involvement, relatedObjectType.involvement) &&
        Objects.equals(this.reference, relatedObjectType.reference) &&
        Objects.equals(this.href, relatedObjectType.href) &&
        Objects.equals(this.validFor, relatedObjectType.validFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(involvement, reference, href, validFor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedObjectType {\n");
    
    sb.append("    involvement: ").append(toIndentedString(involvement)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
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

