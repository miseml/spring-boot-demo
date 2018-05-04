package com.world.demo.countries;

import com.world.demo.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CountryController
{
    private CountryService service;


    @Autowired
    public CountryController( CountryService service )
    {
        this.service = service;
    }


    @RequestMapping(
        value = "/countries",
        method = RequestMethod.POST,
        consumes = { "application/json" }
    )
    public Country add( @RequestBody final Country country )
    {
        return service.add( country );
    }


    @RequestMapping(
        value = "/countries",
        method = RequestMethod.DELETE
    )
    public void delete( @RequestBody final Country country )
    {
        service.delete( country );
    }


    @RequestMapping(
        value = "/countries",
        method = RequestMethod.GET,
        produces = { "application/json" }
    )
    public @ResponseBody
    List<Country> countries()
    {
        return service.countries();
    }


    @RequestMapping(
        value = "/countries/find",
        method = RequestMethod.GET,
        produces = { "application/json" }
    )
    public @ResponseBody
    List<Country> find(
        @RequestParam( value = "continent" ) String continent )
    {
        return service.find( continent );
    }
}
