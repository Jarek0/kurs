package com.example.entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

/**
 * Created by Dell on 2017-03-19.
 */
@Entity
@Table(name="items")
public class Item {
    @Id//wybranie klucza głównego
    @GeneratedValue(strategy= GenerationType.AUTO)//autoinkrementacja klucza głównego
    private long id;

    @NotNull
    @Column(unique = true)
    @Size(min=5,max=45)
    private String name;

    @Max(100)
    private int power;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "hero_id")
    private Hero hero;

    public Item(){

    }

    public Item(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public Item(String name, int power, Hero hero) {
        this.name = name;
        this.power = power;
        this.hero = hero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "Item={\n"+
                "id:"+this.id+"\n"+
                "name:"+this.name+"\n"+
                "power:"+this.power+"\n"+
                "}";
    }
}
