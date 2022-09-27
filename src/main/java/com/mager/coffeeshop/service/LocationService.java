package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();
    Location getLocation(Long id);
    String getJSPoint();
}
