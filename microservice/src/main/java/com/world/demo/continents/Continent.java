package com.world.demo.continents;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("continents")
public class Continent
    implements Serializable
{
    @Id
    private String id;
    
    @Indexed
    private String name;


    public Continent()
    {
    }


    public Continent( String name )
    {
        this.name = name;
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


    @Override
    public String toString()
    {
        return "Continent{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
