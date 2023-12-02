package com.mycompany.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    , generator = "your_table_seq"
//    @SequenceGenerator(name = "your_table_seq", sequenceName = "your_table_seq", allocationSize = 1, initialValue = 1)

    private Long id;
    @Column(name = "PROPERTY_TITLE",nullable = false)
    private String title;
    private String description;
    private Double price;
    private String address;
}
