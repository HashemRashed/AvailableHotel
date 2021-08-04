package com.example.demo.response;

import lombok.Data;

/**
 * @author Hashem Rashed
 */
@Data
public class BookingHotelDto {


    private String hotelName;
    private double rate;
    private double hotelFare;
    private String roomAmenities;

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public void setRate(double rate) {
        if(rate <= 5){
            this.rate = rate;
        }
    }

    public void setHotelFare(double hotelFare) {
        this.hotelFare = hotelFare;
    }

    public void setRoomAmenities(String roomAmenities) {
        this.roomAmenities = roomAmenities;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getRate() {
        return rate;
    }
    /**
     * @return Total price rounded to 2 decimals
     */
    public double getHotelFare() {
        return hotelFare = (double) Math.round(hotelFare * 100) / 100;
    }

    public String getRoomAmenities() {
        return roomAmenities;
    }
}
