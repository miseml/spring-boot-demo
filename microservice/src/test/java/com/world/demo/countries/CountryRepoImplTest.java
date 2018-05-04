package com.world.demo.countries;

import com.world.demo.continents.Continent;
import com.world.demo.continents.service.ContinentService;
import com.world.demo.countries.service.CountryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith( SpringRunner.class )
@SpringBootTest
@ContextConfiguration
@TestPropertySource( locations = "classpath:test.properties" )
public class CountryRepoImplTest
{
    @Autowired
    ContinentService continentService;

    @Autowired
    CountryService cut;

    @Autowired
    RedisTemplate<Object, Object> template;


    @Before
    public void setUp()
    {
        template.execute( ( RedisConnection connection ) -> {
            connection.flushAll();
            return "OK";
        } );
    }


    @Test
    public void testAddingAndRemovingCountry()
    {
        Continent continent = continentService.add( new Continent( "Continent" ) );
        Country country = cut.add( new Country( "Country", continent ) );

        assertNotNull( country );
        assertFalse( cut.countries().isEmpty() );

        cut.delete( country );
        assertTrue( cut.countries().isEmpty() );
    }


    @Test
    public void noResultsShouldBeFound_forUnexistingCountry()
    {
        Continent continent = continentService.add( new Continent( "Continent2" ) );
        cut.add( new Country( "Country2", continent ) );

        assertTrue( cut.find( "Continent" ).isEmpty() );
    }


    @Test
    public void countryShouldBeFoundByContinent()
    {
        Continent continent = continentService.add( new Continent( "Continent" ) );
        cut.add( new Country( "Country", continent ) );

        List<Country> actual = cut.find( "Continent" );

        assertFalse( actual.isEmpty() );
    }
}
