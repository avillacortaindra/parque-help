package com.tefper.daas.parque.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ProductInstanceStatusRequestType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class ProductInstanceStatusRequestType   {
  /**
   * Tracks the lifecycle status of the product in the internal state machine of the processing system
   */
  public enum StatusEnum {
    NEW("new"),
    
    CREATED("created"),
    
    ACTIVE("active"),
    
    PENDING("pending"),
    
    ABORTED("aborted"),
    
    SUSPENDED("suspended"),
    
    CANCELLED("cancelled"),
    
    CANCELLING("cancelling"),
    
    TERMINATED("terminated"),
    
    TERMINATING("terminating"),
    
    INFORMATION("information"),
    
    TRIAL("trial"),
    
    KEEP("keep");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("subStatus")
  private String subStatus = null;

  @JsonProperty("changeReason")
  private String changeReason = null;

  public ProductInstanceStatusRequestType status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Tracks the lifecycle status of the product in the internal state machine of the processing system
   * @return status
  **/
  @ApiModelProperty(required = true, value = "Tracks the lifecycle status of the product in the internal state machine of the processing system")
  @NotNull


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ProductInstanceStatusRequestType subStatus(String subStatus) {
    this.subStatus = subStatus;
    return this;
  }

  /**
   * Substatus in order to define a second status level
   * @return subStatus
  **/
  @ApiModelProperty(value = "Substatus in order to define a second status level")


  public String getSubStatus() {
    return subStatus;
  }

  public void setSubStatus(String subStatus) {
    this.subStatus = subStatus;
  }

  public ProductInstanceStatusRequestType changeReason(String changeReason) {
    this.changeReason = changeReason;
    return this;
  }

  /**
   * Reasoning for the change of status or substatus
   * @return changeReason
  **/
  @ApiModelProperty(value = "Reasoning for the change of status or substatus")


  public String getChangeReason() {
    return changeReason;
  }

  public void setChangeReason(String changeReason) {
    this.changeReason = changeReason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductInstanceStatusRequestType productInstanceStatusRequestType = (ProductInstanceStatusRequestType) o;
    return Objects.equals(this.status, productInstanceStatusRequestType.status) &&
        Objects.equals(this.subStatus, productInstanceStatusRequestType.subStatus) &&
        Objects.equals(this.changeReason, productInstanceStatusRequestType.changeReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, subStatus, changeReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductInstanceStatusRequestType {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    subStatus: ").append(toIndentedString(subStatus)).append("\n");
    sb.append("    changeReason: ").append(toIndentedString(changeReason)).append("\n");
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

