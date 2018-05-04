package com.world.demo.continents.service;

import com.world.demo.continents.Continent;
import com.world.demo.continents.ContinentRepository;
import com.world.demo.util.IterableToStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Validated
public class ContinentServiceImpl
    implements ContinentService
{
    @Autowired
    ContinentRepository repository;


    public Continent add( Continent continent )
    {
        return repository.save( continent );
    }


    @Override
    public void delete( Continent continent )
    {
        repository.delete( continent );
    }


    @Override
    public List<Continent> continents()
    {
        return IterableToStream.convert( repository.findAll() )
            .collect( Collectors.toList() );
    }
}
