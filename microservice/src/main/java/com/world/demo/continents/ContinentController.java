package com.world.demo.continents;

import com.world.demo.continents.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContinentController
{
    private ContinentService service;


    @Autowired
    public ContinentController( ContinentService service )
    {
        this.service = service;
    }


    @RequestMapping(
        value = "/continents",
        method = RequestMethod.POST,
        consumes = { "application/json" }
    )
    public Continent add( @RequestBody final Continent continent )
    {
        return service.add( continent );
    }


    @RequestMapping(
        value = "/continents",
        method = RequestMethod.DELETE
    )
    public void delete( @RequestBody final Continent continent )
    {
        service.delete( continent );
    }


    @RequestMapping(
        value = "/continents",
        method = RequestMethod.GET,
        produces = { "application/json" }
    )
    public @ResponseBody
    List<Continent> list()
    {
        return service.continents();
    }
}
