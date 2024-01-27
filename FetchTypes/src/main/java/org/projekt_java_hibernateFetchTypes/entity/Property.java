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
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_property")
    private Integer idProperty;
    @Column(name = "city")
    private String city;
    @Column(name = "room_number")
    private Integer roomNumber;
    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_company")
    private Company company;

    public Property(String city, Integer roomNumber) {
        this.city = city;
        this.roomNumber = roomNumber;
    }
}
