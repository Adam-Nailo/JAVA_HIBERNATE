package org.projekt_java_hibernate.entity;


import lombok.*;

import javax.persistence.*;

/**
 * Created by Adam Seweryn
 */
@Getter
@Setter
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