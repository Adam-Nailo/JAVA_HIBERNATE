package org.projekt_java_hibernateAssociations.entity;

import lombok.*;

import javax.persistence.*;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company_detail")
    private CompanyDetail companyDetail;

    public Company(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
