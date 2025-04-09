package com.example.sosbackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sosbackend.controller.interfaces.EmergencyServiceApi;
import com.example.sosbackend.dto.CreateEmergencyServiceRequest;
import com.example.sosbackend.dto.EmergencyServiceResponseDTO;
import com.example.sosbackend.exceptions.ResourceNotFoundException;
import com.example.sosbackend.model.EmergencyServicesModel;
import com.example.sosbackend.response.ApiResponse;
import com.example.sosbackend.service.EmergencyService;
import com.example.sosbackend.util.ResponseUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/api")
@Validated
public class EmergencyServiceController implements EmergencyServiceApi {
  private final EmergencyService emergencyService;

  public EmergencyServiceController(EmergencyService emergencyService) {
    this.emergencyService = emergencyService;
  }

  @PostMapping("/emergencyServices")
  public ResponseEntity<ApiResponse<List<EmergencyServiceResponseDTO>>> createEmergencyService(
      @Valid @RequestBody List<@Valid CreateEmergencyServiceRequest> requests, HttpServletRequest request) {
    List<EmergencyServicesModel> emergencyServices = this.emergencyService.createEmergencyServices(requests);

    return ResponseEntity.ok(
        ResponseUtil.response(EmergencyServiceResponseDTO.from(emergencyServices),
            "Emergency services created successfully", request.getRequestURI()));
  }

  @GetMapping("/emergencyServices")
  public ResponseEntity<ApiResponse<List<EmergencyServiceResponseDTO>>> findNearbyEmergencyServices(
      @Valid @RequestParam(required = true) @DecimalMin(value = "-180.0", message = "longitude must be greater than or equal to -180.0") @DecimalMax(value = "180.0", message = "longitude must be less than or equal to 180.0") double longitude,

      @Valid @RequestParam(required = true) @DecimalMin(value = "-90.0", message = "latitude must be greater than or equal -90.0") @DecimalMax(value = "90.0", message = "latitude must be less than or equal to 90.0") double latitude,

      @Valid @RequestParam(required = true) @Positive(message = "radius must be positive") double radius,
      HttpServletRequest request) throws ResourceNotFoundException {

    List<EmergencyServicesModel> emergencyServices = this.emergencyService
        .findNearbyEmergencyServices(longitude, latitude, radius);

    if (emergencyServices.size() == 0) {
      throw new ResourceNotFoundException("No nearby emergency services found for this coordinate");
    }

    return ResponseEntity.ok(ResponseUtil.response(EmergencyServiceResponseDTO.from(emergencyServices),
        "Nearby Emergency services successfully fetched", request.getRequestURI()));
  }

}
