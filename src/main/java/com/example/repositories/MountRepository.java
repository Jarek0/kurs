package com.example.repositories;

import com.example.entities.Mount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 2017-03-19.
 */
@Repository
public interface MountRepository extends JpaRepository<Mount,Long>
{
}
