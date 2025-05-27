package com.jprestes.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue
    private Long id;

    private Long studentId;
    private Long courseId;
    private String registrationDate;
    private String status; // e.g., "active", "completed", "cancelled"
}
