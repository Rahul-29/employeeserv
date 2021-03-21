package com.paypal.bfs.test.employeeserv.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Address")
public class AddressEntity {

    @Id
    @SequenceGenerator(initialValue=1, name="address_seq", sequenceName="address_sequence")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "address_line1")
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zip_code;
}
