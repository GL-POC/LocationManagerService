package com.gl.service;

public class LocationException extends RuntimeException {

	public LocationException(String locationId) {
		super("Error while processing your request at id" + locationId);
	}
}
