package com.world.demo.countries;

import com.world.demo.continents.Continent;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;


@RedisHash( "countries" )
public class Country
    implements Serializable
{
    @Id
    private String id;
    
    @Indexed
    private String name;
    
    @Indexed
    private Continent continent;


    public Country()
    {
    }


    public Country( String name, Continent continent )
    {
        this.name = name;
        this.continent = continent;
    }


    public String getId()
    {
        return id;
    }


    public void setId( String id )
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    public Continent getContinent()
    {
        return continent;
    }


    public void setContinent( Continent continent )
    {
        this.continent = continent;
    }


    @Override
    public String toString()
    {
        return "Country{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", continent='" + continent + '\'' +
            '}';
    }
}
