package org.projekt_java_hibernateFetchTypes.entity;

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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Property> properties;

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
}
