package com.world.demo.countries.service;

import com.world.demo.countries.Country;

import java.util.List;


public interface CountryService
{
    Country add( Country country );

    List<Country> countries();

    void delete( Country country );

    List<Country> find( String continentName );
}
