package com.world.demo.continents;

import org.springframework.data.repository.CrudRepository;


public interface ContinentRepository
    extends CrudRepository<Continent, String>
{
    Continent findByName( String name );
}
