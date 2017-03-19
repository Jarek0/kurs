package com.example;

import com.example.entities.Hero;
import com.example.entities.Item;
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
import java.util.HashSet;
import java.util.Set;

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
        //One to many
        Hero Geralt=new Hero("Geralt","Wiedzmin",50,5,new Date(new java.util.Date().getTime()), Morality.Dobry);
        HashSet<Item> items=new HashSet<>();
        for(int i=0;i<10;i++)
            items.add(new Item("Item"+i,50+i));

        Geralt.setItems(items);
        heroRepository.save(Geralt);
        System.out.println(heroRepository.findByName("Geralt").toString());

    }
}
