package org.projekt_java_hibernateAssociationsOneToMany.entity;

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

    public Property(String city, Integer roomNumber) {
        this.city = city;
        this.roomNumber = roomNumber;
    }
}
