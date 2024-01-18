package org.projekt_java_hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Adam Seweryn
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="id_employee")
    private Integer idEmployee;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="salary")
    private Integer salary;

    public static void main(String[] args) {


    }
}