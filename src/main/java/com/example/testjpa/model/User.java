package com.example.testjpa.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private City city;

    @OneToOne(cascade = CascadeType.ALL)
    private IDCard card;

    @OneToMany(mappedBy = "user")
    private List<Subject> subjects;

    public void setId(Integer id) {
        this.id = id;
    }

    public IDCard getCard() {
        return card;
    }

    public void setCard(IDCard card) {
        this.card = card;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
