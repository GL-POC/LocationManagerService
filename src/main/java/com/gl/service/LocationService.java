package com.gl.service;

import com.gl.entity.Location;
import com.gl.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chethana.nk on 29/3/18.
 */

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location getLocationById(String locationId) {
        return locationRepository.getLocationById(locationId);
    }

    public Location save(Location location){
        return locationRepository.save(location);
    }

    public void  deleteLocation(String locationId){
        locationRepository.delete(locationId);
    }

    public Location updateLocationById(String locationId, Location location){
        Location locationById = locationRepository.getLocationById(locationId);
        locationById.setLocationName(location.getLocationName());
        locationById.setCapacity(location.getCapacity());
        return locationRepository.save(locationById);
    }
}
