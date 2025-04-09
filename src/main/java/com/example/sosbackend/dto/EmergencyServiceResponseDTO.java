package com.example.sosbackend.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.sosbackend.model.EmergencyServicesModel;

import lombok.Data;

@Data
public class EmergencyServiceResponseDTO {
  private Long id;
  private String name;
  private String location;
  private String type;
  private String callcode;
  private double longitude;
  private double latitude;

  public static EmergencyServiceResponseDTO from(EmergencyServicesModel model) {
    EmergencyServiceResponseDTO dto = new EmergencyServiceResponseDTO();
    dto.setId(model.getId());
    dto.setName(model.getName());
    dto.setLocation(model.getLocation());
    dto.setType(model.getType());
    dto.setCallcode(model.getCallcode());
    if (model.getCoordinates() != null) {
      dto.setLongitude(model.getCoordinates().getPosition().getLon());
      dto.setLatitude(model.getCoordinates().getPosition().getLat());
    }
    return dto;
  }

  public static List<EmergencyServiceResponseDTO> from(List<EmergencyServicesModel> models) {
    return models.stream()
        .map(EmergencyServiceResponseDTO::from)
        .collect(Collectors.toList());
  }
}
