package com.world.demo.continents;

import com.world.demo.continents.service.ContinentService;
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

import static org.junit.Assert.*;


@RunWith( SpringRunner.class )
@SpringBootTest
@ContextConfiguration
@TestPropertySource( locations = "classpath:test.properties" )
public class ContinentRepoImplTest
{
    @Autowired
    ContinentService cut;

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
    public void testAddingAndRemovingContinent()
    {
        Continent continent = cut.add( new Continent( "Continent" ) );

        assertNotNull( continent );
        assertFalse( cut.continents().isEmpty() );

        cut.delete( continent );
        assertTrue( cut.continents().isEmpty() );
    }
}
