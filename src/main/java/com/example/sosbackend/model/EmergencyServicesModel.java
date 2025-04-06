package com.example.sosbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import org.hibernate.annotations.Check;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

@Entity
@Table(name = "emergency_services", indexes = {
    @Index(name = "idx_locations_coordinates", columnList = "coordinates")
})
@Check(constraints = "type IN ('police station', 'fire station', 'hospital')")
@Data
public class EmergencyServicesModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "call_code", nullable = true)
  private String callcode;

  @Column(columnDefinition = "geography(Point,4326)")
  private Point<G2D> coordinates;

}
