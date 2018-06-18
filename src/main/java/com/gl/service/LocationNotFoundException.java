package com.gl.service;

public class LocationNotFoundException extends RuntimeException {

	public LocationNotFoundException(String locationId) {
		super("Location Not Found for id " + locationId);
	}

}
