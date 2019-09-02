package com.tefper.daas.parque.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ApiTransactionStatusType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class ApiTransactionStatusType   {
  /**
   * Status of the transaction
   */
  public enum TransactionStatusEnum {
    RECEIVED("received"),
    
    PROCESSING("processing"),
    
    SUCCESS("success"),
    
    FAIL("fail");

    private String value;

    TransactionStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransactionStatusEnum fromValue(String text) {
      for (TransactionStatusEnum b : TransactionStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("transactionStatus")
  private TransactionStatusEnum transactionStatus = null;

  @JsonProperty("error")
  private ExceptionType error = null;

  public ApiTransactionStatusType transactionStatus(TransactionStatusEnum transactionStatus) {
    this.transactionStatus = transactionStatus;
    return this;
  }

  /**
   * Status of the transaction
   * @return transactionStatus
  **/
  @ApiModelProperty(required = true, value = "Status of the transaction")
  @NotNull


  public TransactionStatusEnum getTransactionStatus() {
    return transactionStatus;
  }

  public void setTransactionStatus(TransactionStatusEnum transactionStatus) {
    this.transactionStatus = transactionStatus;
  }

  public ApiTransactionStatusType error(ExceptionType error) {
    this.error = error;
    return this;
  }

  /**
   * If status is fail this element must be used. It has the format of a UNICA Exception and will contain the details of the failure
   * @return error
  **/
  @ApiModelProperty(value = "If status is fail this element must be used. It has the format of a UNICA Exception and will contain the details of the failure")

  @Valid

  public ExceptionType getError() {
    return error;
  }

  public void setError(ExceptionType error) {
    this.error = error;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiTransactionStatusType apiTransactionStatusType = (ApiTransactionStatusType) o;
    return Objects.equals(this.transactionStatus, apiTransactionStatusType.transactionStatus) &&
        Objects.equals(this.error, apiTransactionStatusType.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionStatus, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiTransactionStatusType {\n");
    
    sb.append("    transactionStatus: ").append(toIndentedString(transactionStatus)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

