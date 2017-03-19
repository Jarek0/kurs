package com.example.entities;

import com.example.entities.enums.Morality;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    private String name;//pole name nie może być pusty, musi mieć od 1 do 45 znaków i musi być unikalne

    @NotNull
    @Size(max=20)
    private String characterClass;//pole nie może być puste i musi mieć mniej niż 20 znaków

    @Max(100)
    private int heartpoints;//zmiana typu danych na tinyint

    @Min(1)
    @Max(10)
    private int attack;//zmiana typu danych na tinyint

    @NotNull
    @Column(name= "date_of_birth")
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date dateOfBirth;//data ma mieć określony format i nie być pusta

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "morality",columnDefinition = "ENUM('Dobry', 'Neutralny', 'Zly')")
    private Morality morality;

    @Nullable
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="mount_id")
    private Mount mount;
    /*tryby kaskadowości:
    ALL - wszystkie operacje przechodza na powiązany obiekt np. usuwanie
    PERSIST - powoduje, że gdy stworzymy encje to encja powiązanej tabeli również zostanie stworzona
    MERGE - kiedy dołączymy encje powiązane z nią encje rówież zostaną dołączone
    REMOVE - kiedy usuniemy encję encje z nią powiązane zostaną usunięte
     */


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
    public Hero(String name, String characterClass, int heartpoints, int attack, Date dateOfBirth, Morality morality,Mount mount) {
        this.name = name;
        this.characterClass = characterClass;
        this.heartpoints = heartpoints;
        this.attack = attack;
        this.dateOfBirth = dateOfBirth;
        this.morality = morality;
        this.mount=mount;
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

    public Mount getMount() {
        return mount;
    }

    public void setMount(Mount mount) {
        this.mount = mount;
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
                "mount:"+this.mount.toString()+
                "}";
    }
}
