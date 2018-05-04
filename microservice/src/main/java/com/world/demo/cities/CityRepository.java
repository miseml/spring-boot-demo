package com.world.demo.cities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CityRepository
    extends CrudRepository<City, String>
{
    List<City> findByCountryContinentName( String name );

    List<City> findByCountryName( String name );

    List<City> findByCountryNameAndCountryContinentName( String countryName, String continentName );
}

