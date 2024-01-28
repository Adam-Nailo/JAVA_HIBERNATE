package org.projekt_java_hibernateAssociationsManyToMany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam Seweryn
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    private Integer idTraining;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "employee_training", joinColumns = @JoinColumn(name="id_training"), inverseJoinColumns = @JoinColumn(name = "id_employee"))
    private List<Employee> employees;

    public Training(String name) {
        this.name = name;
    }

    public void addEmployee (Employee employee){
        if (employees == null){
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }
}
