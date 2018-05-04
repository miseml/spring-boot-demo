package com.world.demo.cities.service;

import com.world.demo.cities.City;

import java.util.List;


public interface CityService
{
    City add( City city );

    List<City> cities();

    void delete( City city );

    List<City> findByCountryAndContinent( String countryName, String continentName );
}
