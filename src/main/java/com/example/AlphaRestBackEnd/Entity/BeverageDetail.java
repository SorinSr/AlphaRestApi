package com.example.AlphaRestBackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table (name = "beverage_detail")
public class BeverageDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "alcohol_percent")
    private String alcoholPercent;

    @Column(name = "type")
    private String type;

    @Column(name = "color")
    private String color;

    @Column(name = "volume")
    private String volume;

    @Column(name = "details")
    private String details;

    //BI-Directional relationship
    @OneToOne(mappedBy = "beverageDetail", cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JsonIgnoreProperties("beverageDetail")
    private Beverage beverage;

    public BeverageDetail() {
    }

    public BeverageDetail(String alcoholPercent, String type, String color, String volume, String details) {
        this.alcoholPercent = alcoholPercent;
        this.type = type;
        this.color = color;
        this.volume = volume;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlcoholPercent() {
        return alcoholPercent;
    }

    public void setAlcoholPercent(String alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String toString() {
        return "BeverageDetail{" +
                "id=" + id +
                ", alcoholPercent='" + alcoholPercent + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", volume='" + volume + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
