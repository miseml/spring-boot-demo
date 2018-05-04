package com.world.demo.countries.service;

import com.world.demo.countries.Country;
import com.world.demo.countries.CountryRepository;
import com.world.demo.util.IterableToStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Validated
public class CountryServiceImpl
    implements CountryService
{
    @Autowired
    CountryRepository repository;


    public Country add( Country country )
    {
        return repository.save( country );
    }


    @Override
    public List<Country> countries()
    {
        return IterableToStream.convert( repository.findAll() )
            .collect( Collectors.toList() );
    }


    @Override
    public void delete( Country country )
    {
        repository.delete( country );
    }


    @Override
    public List<Country> find( String continentName )
    {
        return repository.findByContinentName( continentName );
    }
}
