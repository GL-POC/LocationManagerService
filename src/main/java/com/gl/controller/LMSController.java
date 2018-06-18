package com.gl.controller;

import com.gl.entity.Location;
import com.gl.request.LocationRequest;
import com.gl.response.LocationResponse;
import com.gl.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chethana.nk on 29/3/18.
 */


@RestController
@RequestMapping
public class LMSController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "v1/locations/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LocationResponse getLocationById(@PathVariable String locationId){
        return locationService.getLocationById(locationId);
    }

    @PostMapping(value = "v1/location", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public LocationResponse createLocation(@RequestBody LocationRequest locationRequest){
        return locationService.save(locationRequest);
    }

    @DeleteMapping(value = "v1/locations/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteLocation(@PathVariable String locationId){
        locationService.deleteLocation(locationId);
    }

    @PutMapping(value = "v1/locations/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LocationResponse updateLocation(@PathVariable String locationId, @RequestBody LocationRequest locationRequest){
        return locationService.updateLocationById(locationId, locationRequest);
    }
}