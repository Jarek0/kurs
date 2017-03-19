package com.example.repositories;

import com.example.entities.Hero;
import com.example.entities.Mount;
import com.example.entities.enums.Morality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dell on 2017-03-19.
 */
@Repository//ta adnotacja jest ważna
public interface HeroRepository extends JpaRepository<Hero,Long>//dziedziczymy po odpowiedniej klasie i okreslany obiekt entity
{
Hero findByName(String name);
List<Hero> findByMorality(Morality morality);

    @Query("SELECT h FROM Hero h WHERE h.morality = ?1 and h.characterClass = ?2")
    List<Hero> findByMoralityAndCharacterClass(Morality morality,String characterClass);//własne żądanie

    @Query("SELECT h FROM Hero h JOIN h.mount WHERE  h.mount.name = ?1")
    Hero findByMountName(String mountName);//własne żądanie

    Page<Hero> findAll(Pageable page);//przykład stronicowania
}
