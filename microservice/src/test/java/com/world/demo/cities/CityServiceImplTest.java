package com.world.demo.cities;

import com.world.demo.cities.service.CityService;
import com.world.demo.continents.Continent;
import com.world.demo.continents.service.ContinentService;
import com.world.demo.countries.Country;
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
public class CityServiceImplTest
{
    @Autowired
    CityService cut;

    @Autowired
    ContinentService continentService;

    @Autowired
    CountryService countryService;

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
    public void testAddingAndRemovingCity()
    {
        Continent continent = continentService.add( new Continent( "Continent" ) );
        Country country = countryService.add( new Country( "Country", continent ) );

        City city = cut.add( new City( "city", country ) );

        assertNotNull( city );
        assertFalse( cut.cities().isEmpty() );

        cut.delete( city );
        assertTrue( cut.cities().isEmpty() );
    }



    @Test
    public void noResultsShouldBeFound_forUnexistingCity()
    {
        Continent continent = continentService.add( new Continent( "Continent" ) );
        countryService.add( new Country( "Country", continent ) );

        Continent continent2 = continentService.add( new Continent( "Continent2" ) );
        Country country2 = countryService.add( new Country( "Country2", continent2 ) );

        cut.add( new City( "city", country2 ) );

        assertTrue( cut.findByCountryAndContinent( "Country", "Continent" ).isEmpty() );
    }


    @Test
    public void cityShouldBeFoundByContinent()
    {
        Continent continent = continentService.add( new Continent( "Continent" ) );
        Country country = countryService.add( new Country( "Country", continent ) );

        cut.add( new City( "city", country ) );

        List<City> actual = cut.findByCountryAndContinent( null, "Continent" );

        assertFalse( actual.isEmpty() );
    }


    @Test
    public void cityShouldBeFoundByCountry()
    {
        Continent continent = continentService.add( new Continent( "Continent" ) );
        Country country = countryService.add( new Country( "Country", continent ) );

        cut.add( new City( "city", country ) );

        List<City> actual = cut.findByCountryAndContinent( "Country", null );

        assertFalse( actual.isEmpty() );
    }
}
