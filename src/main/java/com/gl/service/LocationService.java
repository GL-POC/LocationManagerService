package com.gl.service;

import com.gl.entity.Location;
import com.gl.repository.LocationRepository;
import com.gl.request.LocationRequest;
import com.gl.response.LocationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chethana.nk on 29/3/18.
 */

@Service
//@RefreshScope
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true, rollbackFor = LocationNotFoundException.class)
    public LocationResponse getLocationById(String locationId) {
        Location location = locationRepository.getLocationById(locationId);
        if(location != null){
            return new LocationResponse(location.getId(),location.getLocationName(),location.getCapacity());
        }
        throw new LocationNotFoundException(locationId);
    }

    public LocationResponse save(LocationRequest locationRequest){
        Location locationToSave = new Location();
        locationToSave.setCapacity(locationRequest.getCapacity());
        locationRequest.setLocationName(locationRequest.getLocationName());
        Location location = locationRepository.save(locationToSave);
        if(location == null) {
            throw new LocationException(locationRequest.getLocationName());
        } else {
            return  new LocationResponse(location.getId(),location.getLocationName(),location.getCapacity());
        }
    }

    public void  deleteLocation(String locationId){
        Location locationToDelete = locationRepository.getLocationById(locationId);
        if(locationToDelete != null) {
            locationRepository.deleteById(locationToDelete.getId());
        } else {
            throw new LocationNotFoundException(locationId);
        }

    }

    public LocationResponse updateLocationById(String locationId, LocationRequest locationRequest){
        Location locationById = locationRepository.getLocationById(locationId);
        if(locationById!= null) {
            locationById.setLocationName(locationRequest.getLocationName());
            locationById.setCapacity(locationRequest.getCapacity());
            Location response = locationRepository.save(locationById);
            return new LocationResponse(response.getId(), response.getLocationName(), response.getCapacity());
        }

        throw new LocationException(locationId);
    }
}
