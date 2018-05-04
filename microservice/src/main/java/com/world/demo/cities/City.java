package com.world.demo.cities;

import com.world.demo.countries.Country;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;


@RedisHash( "cities" )
public class City
    implements Serializable
{
    @Id
    private String id;

    @Indexed
    private String name;

    @Indexed
    private Country country;


    public City()
    {
    }


    City( String name, Country country )
    {
        this.name = name;
        this.country = country;
    }


    @Override
    public String toString()
    {
        return "City{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", country=" + country +
            '}';
    }


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    public Country getCountry()
    {
        return country;
    }


    public void setCountry( Country country )
    {
        this.country = country;
    }


    public String getId()
    {
        return id;
    }


    public void setId( String id )
    {
        this.id = id;
    }
}
