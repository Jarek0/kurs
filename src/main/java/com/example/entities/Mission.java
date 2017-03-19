package com.example.entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Dell on 2017-03-19.
 */
@Entity//adnotacja sprawia, że klasa jest mapowana na tabele
@Table(name="missions")
public class Mission {

    @Id//wybranie klucza głównego
    @GeneratedValue(strategy= GenerationType.AUTO)//autoinkrementacja klucza głównego
    private long id;

    @NotNull
    @Size(min=5,max=45)
    private String title;

    @NotNull
    @Size(min=5,max=101)
    private String description;

    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE}, mappedBy="missions")
    private Set<Hero> heroes;

    public Mission(){

    }

    public Mission(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String discription) {
        this.description = discription;
    }

    public Set<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(Set<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public String toString() {
        return "Mission={\n"+
                "id:"+this.id+"\n"+
                "title:"+this.title+"\n"+
                "description:"+this.description+"\n"+
                "}";
    }
}
