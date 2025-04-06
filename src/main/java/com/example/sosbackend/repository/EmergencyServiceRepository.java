package com.example.sosbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sosbackend.model.EmergencyServicesModel;

public interface EmergencyServiceRepository extends JpaRepository<EmergencyServicesModel, Long> {

}
