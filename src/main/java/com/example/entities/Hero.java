package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Dell on 2017-03-19.
 */
@Entity//adnotacja sprawia, że klasa jest mapowana na tabele
public class Hero {

    @Id//wybranie klucza głównego
    @GeneratedValue(strategy= GenerationType.AUTO)//autoinkrementacja klucza głównego
    private long id;

    //dodatkowe pola
    String name;

    String characterClass;

    int heartpoints;

    int attack;

    Date dateOfBirth;

    //musimy mieć pusty konstruktor
    public Hero(){

    }

    //dodatkowy konstruktor
    public Hero(String name, String characterClass, int heartpoints, int attack, Date dateOfBirth) {
        this.name = name;
        this.characterClass = characterClass;
        this.heartpoints = heartpoints;
        this.attack = attack;
        this.dateOfBirth = dateOfBirth;
    }

    //musimy mieć getery i setery
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

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getHeartpoints() {
        return heartpoints;
    }

    public void setHeartpoints(int heartpoints) {
        this.heartpoints = heartpoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
