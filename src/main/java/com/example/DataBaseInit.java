package com.example;

import com.example.entities.Hero;
import com.example.entities.Item;
import com.example.entities.Mission;
import com.example.entities.Mount;
import com.example.entities.enums.Morality;
import com.example.repositories.HeroRepository;
import com.example.repositories.MissionRepository;
import com.example.repositories.MountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    MissionRepository missionRepository;

    @Transactional//transakcja
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //własne żądania i stronicowanie
        for(int i=0;i<10;i++){
            heroRepository.save(new Hero("Wojownik"+i,"Wojownik",50+i,
                    10,new Date(new java.util.Date().getTime()), Morality.Dobry,new Mount("kon"+i,50)));
        }
        for(int i=0;i<10;i++){
            heroRepository.save(new Hero("Mag"+i,"Mag",30+i,
                    10,new Date(new java.util.Date().getTime()), Morality.Zly,new Mount("smok"+i,100)));
        }

        System.out.println("Bohater z wierzchowcem 'kon1'");
        System.out.println(heroRepository.findByMountName("kon1"));

        System.out.println("Bohater z wierzchowcem 'smok3'");
        System.out.println(heroRepository.findByMountName("smok3"));

        System.out.println("Bohaterowie z klasa 'Wojownik' i morlanością 'Dobry'");
        for(Hero hero:heroRepository.findByMoralityAndCharacterClass(Morality.Dobry,"Wojownik")){
            System.out.println(hero);
        }

        System.out.println("Pierwsza strona bohaterow o rozmiarze 4 posortowana według pola 'heartpoints'");
        for(Hero hero:heroRepository.findAll(new PageRequest(1, 4, Sort.Direction.DESC,"heartpoints"))){
            System.out.println(hero);
        }
    }
}
