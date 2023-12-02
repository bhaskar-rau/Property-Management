package com.mycompany.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_TABLE")
@Getter
@Setter
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "your_table_seq")

    @SequenceGenerator(name = "your_table_seq", sequenceName = "your_table_seq", allocationSize = 1, initialValue = 1)

    private Long id;
    private String ownerName;
    @Column(name = "EMAIL", nullable = false)
    private String ownerEmail;
    private String phone;
    private String password;
}
