package com.example.sosbackend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sosbackend.dto.CreateEmergencyServiceRequest;
import com.example.sosbackend.dto.EmergencyServiceResponseDTO;
import com.example.sosbackend.model.EmergencyServicesModel;
import com.example.sosbackend.response.ApiResponse;
import com.example.sosbackend.service.EmergencyService;
import com.example.sosbackend.util.ResponseUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class EmergencyServiceController {
  private final EmergencyService emergencyService;

  public EmergencyServiceController(EmergencyService emergencyService) {
    this.emergencyService = emergencyService;
  }

  @PostMapping("/emergencyService")
  public ResponseEntity<ApiResponse<List<EmergencyServiceResponseDTO>>> createEmergencyService(
      @Valid @RequestBody List<@Valid CreateEmergencyServiceRequest> requests, HttpServletRequest request) {
    List<EmergencyServicesModel> emergencyServices = this.emergencyService.createEmergencyServices(requests);

    return ResponseEntity.ok(
        ResponseUtil.response(EmergencyServiceResponseDTO.from(emergencyServices),
            "Emergency services created successfully", request.getRequestURI()));
  }

}
