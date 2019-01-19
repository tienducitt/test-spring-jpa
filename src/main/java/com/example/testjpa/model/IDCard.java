package com.example.testjpa.model;

import javax.persistence.*;

@Entity
public class IDCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private IDCardType type;

    public IDCard() {
    }

    public IDCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public IDCardType getType() {
        return type;
    }

    public void setType(IDCardType type) {
        this.type = type;
    }
}
