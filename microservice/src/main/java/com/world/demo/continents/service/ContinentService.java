package com.world.demo.continents.service;

import com.world.demo.continents.Continent;

import java.util.List;


public interface ContinentService
{
    Continent add( Continent continent );

    void delete( Continent continent );

    List<Continent> continents();
}
