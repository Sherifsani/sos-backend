package com.example.sosbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
// @JsonIgnoreProperties(ignoreUnknown = false)
public class CreateEmergencyServiceRequest {

  @NotEmpty(message = "name is required")
  private String name;

  @NotEmpty(message = "type is required")
  @Pattern(regexp = "police station|fire station|hospital")
  private String type;

  @Size(min = 3, max = 12, message = "The length of callcode cannot be less than 3 and more than 12 digits")
  private String callcode;

  @NotNull(message = "Longitude is required")
  @DecimalMin(value = "-180.0", message = "Longitude must be greater than or equal to -180")
  @DecimalMax(value = "180.0", message = "Longitude must be less than or equal to 180")
  private Double longitude;

  @NotNull(message = "Latitude is required")
  @DecimalMin(value = "-90.0", message = "Latitude must be greater than or equal to -90")
  @DecimalMax(value = "90.0", message = "Latitude must be less than or equal to 90")
  private Double latitude;

  // public CreateEmergencyServiceRequest toEmergencyServices() {
  // return new CreateEmergencyServiceRequest()
  // .setName(name)
  // .setType(type)
  // .setCallcode(callcode)
  // .setLongitude(longitude)
  // .setLatitude(latitude);
  // }

  // public void setName(String name) {
  // this.name = name;
  // }
  //
  // public String getName() {
  // return this.name;
  // }
  //
  // public void setType(String type) {
  // this.type = type;
  // }
  //
  // public String getType() {
  // return this.type;
  // }
  //
  // public void setCallcode(int callcode) {
  // this.callcode = callcode;
  // }
  //
  // public int getCallcode() {
  // return this.callcode;
  // }
  //
  // public void setLatitude(double latitude) {
  // this.latitude = latitude;
  // }
  //
  // public double getLatitude() {
  // return this.latitude;
  // }
  //
  // public void setLongitude(double longitude) {
  // this.longitude = longitude;
  // }
  //
  // public double getLongitude() {
  // return this.longitude;
  // }

}
