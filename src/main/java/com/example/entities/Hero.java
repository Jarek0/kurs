package com.example.entities;

import com.example.entities.enums.Morality;
import com.sun.istack.internal.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Created by Dell on 2017-03-19.
 */
@Entity//adnotacja sprawia, że klasa jest mapowana na tabele
@Table(name="heroes")
public class Hero {

    @Id//wybranie klucza głównego
    @GeneratedValue(strategy= GenerationType.AUTO)//autoinkrementacja klucza głównego
    private long id;

    //dodatkowe pola z warunkami integralności

    @NotNull
    @Column(unique = true)
    @Size(min=5,max=45)
    String name;//pole name nie może być pusty, musi mieć od 1 do 45 znaków i musi być unikalne

    @NotNull
    @Size(max=20)
    String characterClass;//pole nie może być puste i musi mieć mniej niż 20 znaków

    @Column(columnDefinition = "TINYINT")
    int heartpoints;//zmiana typu danych na tinyint

    @Column(columnDefinition = "TINYINT")
    int attack;//zmiana typu danych na tinyint

    @NotNull
    @Column(name= "date_of_birth")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    Date dateOfBirth;//data ma mieć określony format i nie być pusta

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "morality",columnDefinition = "ENUM('Dobry', 'Neutralny', 'Zly')")
    private Morality morality;

    //musimy mieć pusty konstruktor
    public Hero(){

    }

    //dodatkowy konstruktor
    public Hero(String name, String characterClass, int heartpoints, int attack, Date dateOfBirth, Morality morality) {
        this.name = name;
        this.characterClass = characterClass;
        this.heartpoints = heartpoints;
        this.attack = attack;
        this.dateOfBirth = dateOfBirth;
        this.morality = morality;
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

    public Morality getMorality() {
        return morality;
    }

    public void setMorality(Morality morality) {
        this.morality = morality;
    }

    @Override
    public String toString() {
        return "Hero={\n"+
                "id:"+this.id+"\n"+
                "name:"+this.name+"\n"+
                "heartpoints:"+this.heartpoints+"\n"+
                "attack:"+this.attack+"\n"+
                "dateOfBirth:"+this.dateOfBirth+"\n"+
                "morality:"+this.morality+"\n"+
                "}";
    }
}
