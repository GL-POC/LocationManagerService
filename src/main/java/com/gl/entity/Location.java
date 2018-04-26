package com.gl.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by chethana.nk on 29/3/18.
 */

@Document(collection = "location")
public class Location {

    @Id
    private String id;
    private String locationName;
    private int capacity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Location{" +
            "id=" + id +
            ", locationName='" + locationName + '\'' +
            ", capacity=" + capacity +
            '}';
    }
}
