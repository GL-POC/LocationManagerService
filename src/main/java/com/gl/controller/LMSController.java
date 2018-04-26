package com.gl.controller;

import com.gl.entity.Location;
import com.gl.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chethana.nk on 29/3/18.
 */


@RestController
public class LMSController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/location/{locationId}")
    public Location getLocationById(@PathVariable String locationId){
        return locationService.getLocationById(locationId);
    }

    @PostMapping(value = "/save")
    public Location save(@RequestBody Location location){
        return locationService.save(location);
    }

    @DeleteMapping(value = "/delete/{locationId}")
    public void deleteLocation(@PathVariable String locationId){
        locationService.deleteLocation(locationId);
    }

    @PutMapping(value = "/update/{locationId}")
    public Location updateLocation(@PathVariable String locationId, @RequestBody Location location){
        return locationService.updateLocationById(locationId, location);
    }
}
