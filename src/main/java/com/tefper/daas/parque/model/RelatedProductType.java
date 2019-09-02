package com.tefper.daas.parque.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * RelatedProductType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class RelatedProductType   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("product")
  private ProductRefInfoType product = null;

  public RelatedProductType type(String type) {
    this.type = type;
    return this;
  }

  /**
   * A categorization of the relationship defined between the product referenced and the original entity (e.g.: subproduct, bundled, dependent,…)
   * @return type
  **/
  @ApiModelProperty(value = "A categorization of the relationship defined between the product referenced and the original entity (e.g.: subproduct, bundled, dependent,…)")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public RelatedProductType product(ProductRefInfoType product) {
    this.product = product;
    return this;
  }

  /**
   * Definition of the related product (e.g.: the bundled subproduct)
   * @return product
  **/
  @ApiModelProperty(required = true, value = "Definition of the related product (e.g.: the bundled subproduct)")
  @NotNull

  @Valid

  public ProductRefInfoType getProduct() {
    return product;
  }

  public void setProduct(ProductRefInfoType product) {
    this.product = product;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedProductType relatedProductType = (RelatedProductType) o;
    return Objects.equals(this.type, relatedProductType.type) &&
        Objects.equals(this.product, relatedProductType.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedProductType {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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

