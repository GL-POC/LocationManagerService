package com.gl.repository;

import com.gl.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chethana.nk on 29/3/18.
 */


@Repository
public interface LocationRepository extends MongoRepository<Location, String> {

    Location getLocationById(String locationId);
}
