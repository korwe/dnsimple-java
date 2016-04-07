/**
 * Copyright 2012 Nimble Servers Limited. http://nimbleservers.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nimbleservers.dnsimple.domain;

import java.util.Date;

/**
 * Data for a domain.
 * <p>
 * @author Chris Strand
 */
public class Domain {
  
  private String id;
  private String name;
  private String nameServerStatus;
  private String registrationStatus;
  private Date createdAt;
  private Date updatedAt;
  // DNSimple has the expiration date in two formats, this one is the same
  // format as the other dates in the JSON response
  private Date parsedExpirationDate;
  private String registrantId;
  private String userId;
  private Boolean autoRenew;
  private Boolean privateWhois;
  
  public Domain() {
    this(null);
  }
  
  public Domain(String name) {
    this.id = null;
    this.name = name;
    this.nameServerStatus = null;
    this.registrationStatus = null;
    this.createdAt = null;
    this.updatedAt = null;
    this.parsedExpirationDate = null;
    this.registrantId = null;
    this.userId = null;
    this.autoRenew = null;
    this.privateWhois = null;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNameServerStatus() {
    return nameServerStatus;
  }

  public void setNameServerStatus(String nameServerStatus) {
    this.nameServerStatus = nameServerStatus;
  }

  public String getRegistrationStatus() {
    return registrationStatus;
  }

  public void setRegistrationStatus(String registrationStatus) {
    this.registrationStatus = registrationStatus;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Date getParsedExpirationDate() {
    return parsedExpirationDate;
  }

  public void setParsedExpirationDate(Date parsedExpirationDate) {
    this.parsedExpirationDate = parsedExpirationDate;
  }

  public String getRegistrantId() {
    return registrantId;
  }

  public void setRegistrantId(String registrantId) {
    this.registrantId = registrantId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Boolean getAutoRenew() {
    return autoRenew;
  }

  public void setAutoRenew(Boolean autoRenew) {
    this.autoRenew = autoRenew;
  }

  public Boolean getPrivateWhois() {
    return privateWhois;
  }

  public void setPrivateWhois(Boolean privateWhois) {
    this.privateWhois = privateWhois;
  }

  @Override
  public String toString() {
    return "Domain [id=" + id + ", name=" + name + ", nameServerStatus="
        + nameServerStatus + ", registrationStatus=" + registrationStatus
        + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
        + ", parsedExpirationDate=" + parsedExpirationDate + ", registrantId="
        + registrantId + ", userId=" + userId + ", autoRenew=" + autoRenew
        + ", privateWhois=" + privateWhois + "]";
  }
  
}
