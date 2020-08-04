package com.example.boot.essentials.roomactuator;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="PRESIDENT")
public class President {
    @Id
    @GeneratedValue
    @Column(name="PRESIDENT_ID")
    private long id;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;
}
