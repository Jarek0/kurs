package com.example.entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by Dell on 2017-03-19.
 */
@Entity//adnotacja sprawia, że klasa jest mapowana na tabele
@Table(name="mounts")
public class Mount {

    @Id//wybranie klucza głównego
    @GeneratedValue(strategy= GenerationType.AUTO)//autoinkrementacja klucza głównego
    private long id;

    @NotNull
    @Size(min=5,max=45)
    String name;

    @Max(100)
    @Min(1)
    int speed;

    public Mount(String name, int speed) {
        this.name = name;
        this.speed = speed;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Mount={\n"+
                "id:"+this.id+"\n"+
                "name:"+this.name+"\n"+
                "speed:"+this.speed+"\n"+
                "}";
    }
}
