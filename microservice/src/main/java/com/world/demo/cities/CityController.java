package com.world.demo.cities;

import com.world.demo.cities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CityController
{
    private CityService service;


    @Autowired
    public CityController( CityService service )
    {
        this.service = service;
    }


    @RequestMapping(
        value = "/cities",
        method = RequestMethod.POST,
        consumes = { "application/json" }
    )
    public City add( @RequestBody final City city )
    {
        return service.add( city );
    }


    @RequestMapping(
        value = "/cities",
        method = RequestMethod.DELETE
    )
    public void delete( @RequestBody final City city )
    {
        service.delete( city );
    }


    @RequestMapping(
        value = "/cities",
        method = RequestMethod.GET,
        produces = { "application/json" }
    )
    public @ResponseBody
    List<City> list()
    {
        return service.cities();
    }


    @RequestMapping(
        value = "/cities/find",
        method = RequestMethod.GET,
        produces = { "application/json" }
    )
    public @ResponseBody
    List<City> find(
        @RequestParam( value = "continent", required = false ) String continent,
        @RequestParam( value = "country", required = false ) String country )
    {
        return service.findByCountryAndContinent( country, continent );
    }
}
