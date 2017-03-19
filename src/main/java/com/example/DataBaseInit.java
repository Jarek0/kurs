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
        //Many to many
        Hero Geralt=new Hero("Geralt","Wiedzmin",50,5,new Date(new java.util.Date().getTime()), Morality.Dobry);
        Hero Conan=new Hero("Conan","Barbarzynca",100,15,new Date(new java.util.Date().getTime()), Morality.Neutralny);

        Mission mission1=new Mission("zabij smoka","zabij smoka");
        Mission mission2=new Mission("umyj naczynia","umyj naczynia");
        Mission mission3=new Mission("uratuj krolewne","uratuj krolewne");
        Mission mission4=new Mission("uratuj galaktyke","uratuj galaktyke");

        Geralt.setMissions(new HashSet<Mission>(Arrays.asList(mission2, mission3,mission4)));
        Conan.setMissions(new HashSet<Mission>(Arrays.asList(mission1, mission2,mission3)));

        heroRepository.save(Geralt);
        heroRepository.save(Conan);
        System.out.println(heroRepository.findByName("Geralt").toString());
        System.out.println(heroRepository.findByName("Conan").toString());
    }
}
