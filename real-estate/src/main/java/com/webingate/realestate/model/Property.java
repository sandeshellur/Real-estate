package com.webingate.realestate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int price;
    private String unit;
    private String description;
    private int avgRating;
    private int locationId;
    private String listFor;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Property() {
        super();
    }

    public Property(int id, String name, int price, String unit, String description, int avgRating,
                    int locationId, String listFor, Address address, Category category) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.description = description;
        this.avgRating = avgRating;
        this.locationId = locationId;
        this.listFor = listFor;
        this.address = address;
        this.category = category;
    }
}
