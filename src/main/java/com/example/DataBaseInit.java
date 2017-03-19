package com.example;

import com.example.entities.Hero;
import com.example.entities.Mount;
import com.example.entities.enums.Morality;
import com.example.repositories.HeroRepository;
import com.example.repositories.MountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Dell on 2017-03-19.
 */
@Component
public class DataBaseInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired//opisac DI
    HeroRepository heroRepository;

    @Autowired
    MountRepository mountRepository;

    @Transactional//transakcja
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //One to one
        //Mount Plotka=new Mount("Plotka",500);
        //Hero Geralt=new Hero("Geralt","Wiedzmin",50,5,new Date(new java.util.Date().getTime()), Morality.Dobry,Plotka);
        //heroRepository.save(Geralt);
        //System.out.println(heroRepository.findByName("Geralt").toString());

        
    }
}
