package com.example.repositories;

import com.example.entities.Hero;
import com.example.entities.enums.Morality;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
