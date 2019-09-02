package com.tefper.daas.parque.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * ProductStatusChangeType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T19:59:22.607Z")

public class ProductStatusChangeType   {
  @JsonProperty("changeDate")
  private OffsetDateTime changeDate = null;

  /**
   * Entity status before the change
   */
  public enum OldStatusEnum {
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

    OldStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OldStatusEnum fromValue(String text) {
      for (OldStatusEnum b : OldStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("oldStatus")
  private OldStatusEnum oldStatus = null;

  @JsonProperty("oldSubStatus")
  private String oldSubStatus = null;

  /**
   * Entity status after the change
   */
  public enum NewStatusEnum {
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

    NewStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NewStatusEnum fromValue(String text) {
      for (NewStatusEnum b : NewStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("newStatus")
  private NewStatusEnum newStatus = null;

  @JsonProperty("newSubStatus")
  private String newSubStatus = null;

  @JsonProperty("changeReason")
  private String changeReason = null;

  public ProductStatusChangeType changeDate(OffsetDateTime changeDate) {
    this.changeDate = changeDate;
    return this;
  }

  /**
   * Date registered for the reported change of status or substatus
   * @return changeDate
  **/
  @ApiModelProperty(required = true, value = "Date registered for the reported change of status or substatus")
  @NotNull

  @Valid

  public OffsetDateTime getChangeDate() {
    return changeDate;
  }

  public void setChangeDate(OffsetDateTime changeDate) {
    this.changeDate = changeDate;
  }

  public ProductStatusChangeType oldStatus(OldStatusEnum oldStatus) {
    this.oldStatus = oldStatus;
    return this;
  }

  /**
   * Entity status before the change
   * @return oldStatus
  **/
  @ApiModelProperty(required = true, value = "Entity status before the change")
  @NotNull


  public OldStatusEnum getOldStatus() {
    return oldStatus;
  }

  public void setOldStatus(OldStatusEnum oldStatus) {
    this.oldStatus = oldStatus;
  }

  public ProductStatusChangeType oldSubStatus(String oldSubStatus) {
    this.oldSubStatus = oldSubStatus;
    return this;
  }

  /**
   * Substatus before the change
   * @return oldSubStatus
  **/
  @ApiModelProperty(value = "Substatus before the change")


  public String getOldSubStatus() {
    return oldSubStatus;
  }

  public void setOldSubStatus(String oldSubStatus) {
    this.oldSubStatus = oldSubStatus;
  }

  public ProductStatusChangeType newStatus(NewStatusEnum newStatus) {
    this.newStatus = newStatus;
    return this;
  }

  /**
   * Entity status after the change
   * @return newStatus
  **/
  @ApiModelProperty(required = true, value = "Entity status after the change")
  @NotNull


  public NewStatusEnum getNewStatus() {
    return newStatus;
  }

  public void setNewStatus(NewStatusEnum newStatus) {
    this.newStatus = newStatus;
  }

  public ProductStatusChangeType newSubStatus(String newSubStatus) {
    this.newSubStatus = newSubStatus;
    return this;
  }

  /**
   * Substatus after the change
   * @return newSubStatus
  **/
  @ApiModelProperty(value = "Substatus after the change")


  public String getNewSubStatus() {
    return newSubStatus;
  }

  public void setNewSubStatus(String newSubStatus) {
    this.newSubStatus = newSubStatus;
  }

  public ProductStatusChangeType changeReason(String changeReason) {
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
    ProductStatusChangeType productStatusChangeType = (ProductStatusChangeType) o;
    return Objects.equals(this.changeDate, productStatusChangeType.changeDate) &&
        Objects.equals(this.oldStatus, productStatusChangeType.oldStatus) &&
        Objects.equals(this.oldSubStatus, productStatusChangeType.oldSubStatus) &&
        Objects.equals(this.newStatus, productStatusChangeType.newStatus) &&
        Objects.equals(this.newSubStatus, productStatusChangeType.newSubStatus) &&
        Objects.equals(this.changeReason, productStatusChangeType.changeReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(changeDate, oldStatus, oldSubStatus, newStatus, newSubStatus, changeReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductStatusChangeType {\n");
    
    sb.append("    changeDate: ").append(toIndentedString(changeDate)).append("\n");
    sb.append("    oldStatus: ").append(toIndentedString(oldStatus)).append("\n");
    sb.append("    oldSubStatus: ").append(toIndentedString(oldSubStatus)).append("\n");
    sb.append("    newStatus: ").append(toIndentedString(newStatus)).append("\n");
    sb.append("    newSubStatus: ").append(toIndentedString(newSubStatus)).append("\n");
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

