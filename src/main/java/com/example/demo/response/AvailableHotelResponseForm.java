package com.example.demo.response;

import lombok.Data;
import java.util.List;


/**
 * @author Hashem Rashed
 */
@Data
public class AvailableHotelResponseForm {

    private String provider;
    private String hotelName;
    private double hotelFare;
    private double rate;
    private List<String> roomAmenities;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * @return Total price rounded to 2 decimals
     */
    public double getHotelFare() {
        return hotelFare = (double) Math.round(hotelFare * 100) / 100;
    }

    public void setHotelFare(double hotelFare) {
        this.hotelFare = hotelFare;
    }

    public List<String> getRoomAmenities() {
        return roomAmenities;
    }

    public void setRoomAmenities(List<String> roomAmenities) {
        this.roomAmenities = roomAmenities;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "AvailableHotelResponseForm{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelFare=" + hotelFare +
                ", roomAmenities=" + roomAmenities +
                '}';
    }
}
