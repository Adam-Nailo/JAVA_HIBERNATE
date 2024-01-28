package org.projekt_java_hibernateAssociationsOneToManyUnidirectional.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Adam Seweryn
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Integer idCompany;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Integer value;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company_detail")
    private CompanyDetail companyDetail;

    @ToString.Exclude
    @OneToMany(mappedBy = "company",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Property> properties;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private Set<Department> departments;

    public Company(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
    public void addProperty (Property property){
        if (properties == null){
            properties = new ArrayList<>();
        }
        properties.add(property);
        property.setCompany(this);
    }

    public void addDepartment (Department department){
        if (departments == null){
            departments = new HashSet<>();
        }
        departments.add(department);
    }
}
