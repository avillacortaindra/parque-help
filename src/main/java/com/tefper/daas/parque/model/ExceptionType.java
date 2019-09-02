package com.tefper.daas.parque.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ExceptionType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class ExceptionType   {
  @JsonProperty("exceptionId")
  private String exceptionId = null;

  @JsonProperty("exceptionText")
  private String exceptionText = null;

  @JsonProperty("moreInfo")
  private String moreInfo = null;

  @JsonProperty("userMessage")
  private String userMessage = null;

  public ExceptionType exceptionId(String exceptionId) {
    this.exceptionId = exceptionId;
    return this;
  }

  /**
   * Identifier of the exception
   * @return exceptionId
  **/
  @ApiModelProperty(required = true, value = "Identifier of the exception")
  @NotNull


  public String getExceptionId() {
    return exceptionId;
  }

  public void setExceptionId(String exceptionId) {
    this.exceptionId = exceptionId;
  }

  public ExceptionType exceptionText(String exceptionText) {
    this.exceptionText = exceptionText;
    return this;
  }

  /**
   * text describing the exception
   * @return exceptionText
  **/
  @ApiModelProperty(required = true, value = "text describing the exception")
  @NotNull


  public String getExceptionText() {
    return exceptionText;
  }

  public void setExceptionText(String exceptionText) {
    this.exceptionText = exceptionText;
  }

  public ExceptionType moreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
    return this;
  }

  /**
   * additional information on the exception
   * @return moreInfo
  **/
  @ApiModelProperty(value = "additional information on the exception")


  public String getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(String moreInfo) {
    this.moreInfo = moreInfo;
  }

  public ExceptionType userMessage(String userMessage) {
    this.userMessage = userMessage;
    return this;
  }

  /**
   * information valuable for the consumer
   * @return userMessage
  **/
  @ApiModelProperty(value = "information valuable for the consumer")


  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExceptionType exceptionType = (ExceptionType) o;
    return Objects.equals(this.exceptionId, exceptionType.exceptionId) &&
        Objects.equals(this.exceptionText, exceptionType.exceptionText) &&
        Objects.equals(this.moreInfo, exceptionType.moreInfo) &&
        Objects.equals(this.userMessage, exceptionType.userMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exceptionId, exceptionText, moreInfo, userMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExceptionType {\n");
    
    sb.append("    exceptionId: ").append(toIndentedString(exceptionId)).append("\n");
    sb.append("    exceptionText: ").append(toIndentedString(exceptionText)).append("\n");
    sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
    sb.append("    userMessage: ").append(toIndentedString(userMessage)).append("\n");
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

