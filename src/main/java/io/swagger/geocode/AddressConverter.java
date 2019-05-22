package io.swagger.geocode;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import io.swagger.model.Garage;
import io.swagger.repository.GarageDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


public class AddressConverter {

    @Autowired
    private GarageDao garageDao;

    private JOpenCageGeocoder jOpenCageGeocoder;

    public AddressConverter(String apiKey) {
        jOpenCageGeocoder = new JOpenCageGeocoder(apiKey);
    }

    private static float distFrom(float lat1, float lng1, float lat2, float lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (float) (earthRadius * c);
    }

    private List<String> convertAddress(String address) {
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);
        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng = response.getFirstPosition();
        List<String> coordinates = new ArrayList<>();
        coordinates.add(0, firstResultLatLng.getLat().toString());
        coordinates.add(1, firstResultLatLng.getLng().toString());
        return coordinates;
    }

    public Garage convertGarageAddress(Garage garage) {
        String address = garage.getAddress().getAddress() + ", " + garage.getAddress().getCity() + ", " + garage.getAddress().getCountry();
        List<String> coordinates = convertAddress(address);
        garage.setCoordinates(coordinates);
        return garage;
    }


    public List<Garage> findNearby(String address) {
        List<String> coordinates = convertAddress(address);
        List<Garage> allGarage = garageDao.findAll();
        List<Garage> nearby = new ArrayList<>();
        for (Garage garage : allGarage) {
            float distance = distFrom(Float.valueOf(coordinates.get(0)), Float.valueOf(coordinates.get(1)), Float.valueOf(garage.getCoordinates().get(0)), Float.valueOf(garage.getCoordinates().get(1)));
            if (distance < 40000) {
                nearby.add(garage);
            }
        }
        return nearby;
    }


}
