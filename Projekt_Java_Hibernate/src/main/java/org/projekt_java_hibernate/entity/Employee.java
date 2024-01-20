package org.projekt_java_hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created by Adam Seweryn
 */
@Data
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "salary")
    private Integer salary;
}