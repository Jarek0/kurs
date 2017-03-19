package com.example;

import com.example.entities.Hero;
import com.example.entities.enums.Morality;
import com.example.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Dell on 2017-03-19.
 */
@Component
public class DataBaseInit implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired//opisac DI
    HeroRepository heroRepository;

    @Transactional//transakcja
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //Hero Geralt=new Hero("Geralt","Wiedzmin",50,5,new Date(new java.util.Date().getTime()), Morality.Dobry);
        //heroRepository.save(Geralt);
        //Hero hero=heroRepository.findOne((long)1);
        //Hero hero=heroRepository.findByName("Geralt");
        //heroRepository.delete((long)1);
        //System.out.println(hero.toString());

        //ArrayList<Hero> heroes=new ArrayList<>();
        /*for(int i=0;i<10;i++){
            heroes.add(new Hero("Hero"+i,"Class"+i,10,5,new Date(new java.util.Date().getTime()), Morality.Neutralny));
        }
        heroRepository.save(heroes);*/

        /*for(Hero hero:heroRepository.findAll())
        System.out.println(hero.toString());*/

        /*for(Hero hero:heroRepository.findByMorality(Morality.Neutralny))
            System.out.println(hero.toString());*/

        //heroRepository.deleteAll();
    }
}
