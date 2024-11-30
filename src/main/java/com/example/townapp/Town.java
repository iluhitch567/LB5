package com.example.townapp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long townId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long residents;

    @Column(length = 1000)
    private String background;

    @Column(nullable = false)
    private String location;

    @Column(nullable = true)
    private String region;
}
