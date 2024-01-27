package org.projekt_java_hibernateFetchTypes.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @ToString.Exclude
    @OneToOne(mappedBy = "companyDetail", cascade = CascadeType.ALL)
    private Company company;

    public CompanyDetail(String residence, Integer employeeNumber) {
        this.residence = residence;
        this.employeeNumber = employeeNumber;
    }
}
