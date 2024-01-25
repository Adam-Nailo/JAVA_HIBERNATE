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
@Table(name = "company_detail")
public class CompanyDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company_detail")
    private Integer idCompanyDetail;
    @Column(name = "residence")
    private String residence;
    @Column(name = "employee_number")
    private Integer employeeNumber;

    public CompanyDetail(String residence, Integer employeeNumber) {
        this.residence = residence;
        this.employeeNumber = employeeNumber;
    }
}
