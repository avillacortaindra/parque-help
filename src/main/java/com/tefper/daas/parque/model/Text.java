package com.tefper.daas.parque.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Text
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class Text extends ProductCharacteristicType  {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("value")
  private String value = null;

  public Text name(String name) {
    this.name = name;
    return this;
  }

  /**
   * First part of the textual descriptive characteristic
   * @return name
  **/
  @ApiModelProperty(required = true, value = "First part of the textual descriptive characteristic")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Text value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Second part of the textual descriptive characteristic
   * @return value
  **/
  @ApiModelProperty(required = true, value = "Second part of the textual descriptive characteristic")
  @NotNull


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Text text = (Text) o;
    return Objects.equals(this.name, text.name) &&
        Objects.equals(this.value, text.value) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Text {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

