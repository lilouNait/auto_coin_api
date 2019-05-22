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

    private final static double AVERAGE_RADIUS_OF_EARTH = 6371;

    private double distFrom(double userLat, double userLng, double venueLat, double venueLng) {

        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);

        double a = (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)) +
                (Math.cos(Math.toRadians(userLat))) *
                        (Math.cos(Math.toRadians(venueLat))) *
                        (Math.sin(lngDistance / 2)) *
                        (Math.sin(lngDistance / 2));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (double) (Math.round(AVERAGE_RADIUS_OF_EARTH * c));

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
            double distance = distFrom(Double.valueOf(coordinates.get(0)), Double.valueOf(coordinates.get(1)), Double.valueOf(garage.getCoordinates().get(0)), Double.valueOf(garage.getCoordinates().get(1)));
            if (distance < 50) {
                nearby.add(garage);
            }
        }
        return nearby;
    }


}
