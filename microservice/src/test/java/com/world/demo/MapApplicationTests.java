package com.world.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class MapApplicationTests
{
    @Test
    public void contextLoads()
    {
    }
}
