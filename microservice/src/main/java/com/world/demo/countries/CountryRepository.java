package com.world.demo.countries;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CountryRepository
    extends CrudRepository<Country, String>
{
    Country findByName( String name );

    List<Country> findByContinentName( String name );
}
