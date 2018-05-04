package com.world.demo.cities.service;

import com.world.demo.cities.City;
import com.world.demo.cities.CityRepository;
import com.world.demo.util.IterableToStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CityServiceImpl
    implements CityService
{
    @Autowired
    CityRepository repository;


    public City add( City city )
    {
        return repository.save( city );
    }


    @Override
    public void delete( City city )
    {
        repository.delete( city );
    }


    @Override
    public List<City> cities()
    {
        return IterableToStream.convert( repository.findAll() )
            .collect( Collectors.toList() );
    }


    @Override
    public List<City> findByCountryAndContinent( String countryName, String continentName )
    {
        if( countryName != null && continentName != null )
        {
            return repository.findByCountryNameAndCountryContinentName( countryName, continentName );
        }
        if( countryName == null )
        {
            return repository.findByCountryContinentName( continentName );
        }
        return repository.findByCountryName( countryName );
    }
}
