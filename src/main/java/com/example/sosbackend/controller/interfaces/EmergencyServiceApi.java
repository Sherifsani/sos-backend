package com.example.sosbackend.controller.interfaces;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.sosbackend.dto.CreateEmergencyServiceRequest;
import com.example.sosbackend.dto.EmergencyServiceResponseDTO;
import com.example.sosbackend.exceptions.ResourceNotFoundException;
import com.example.sosbackend.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "Emergency Services", description = "Apis for emergency services routes")
public interface EmergencyServiceApi {

  @Operation(summary = "Create new emergency services", description = "create new emergency services with their details")
  public ResponseEntity<ApiResponse<List<EmergencyServiceResponseDTO>>> createEmergencyService(
      List<CreateEmergencyServiceRequest> requests, HttpServletRequest request);

  @Operation(summary = "Get emergency services within a coordinate", description = "Fetch emergency services with a coordinate within a radius")
  public ResponseEntity<ApiResponse<List<EmergencyServiceResponseDTO>>> findNearbyEmergencyServices(
      double longitude,
      double latitude,
      double radius,
      HttpServletRequest request) throws ResourceNotFoundException;
}
