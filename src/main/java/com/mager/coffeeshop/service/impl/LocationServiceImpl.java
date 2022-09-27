package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.Location;
import com.mager.coffeeshop.repository.LocationRepository;
import com.mager.coffeeshop.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocation(Long id) {
        return locationRepository.getReferenceById(id);
    }

    @Override
    public String getJSPoint() {
        StringBuilder JSPoints = new StringBuilder();
        JSPoints.append("myMap.geoObjects");
        List<Location> all = locationRepository.findAll();
        for (Location location : all) {
            JSPoints.append(".add(new ymaps.Placemark([" + location.getCoordinates() + "], {\n" +
                    "            balloonContent: '" + location.getName() + "'\n" +
                    "        }, {\n" +
                    "            preset: 'islands#nightDotIcon',\n" +
                    "            iconColor: 'red'\n" +
                    "        }))");
        }
        JSPoints.append(";");
        return JSPoints.toString();
    }
}
