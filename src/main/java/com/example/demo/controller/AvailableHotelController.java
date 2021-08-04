package com.example.demo.controller;


import com.example.demo.clients.BestHotelsClient;
import com.example.demo.clients.BookingHotelsClient;
import com.example.demo.constant.Providers;
import com.example.demo.response.BestHotelDto;
import com.example.demo.response.BookingHotelDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.request.AvailableHotelRequestForm;
import com.example.demo.response.AvailableHotelResponseForm;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hashem Rashed
 */
@RestController
public class AvailableHotelController {

    private static final String VALIDATION_IATA_REGEX = "^[A-Z]{3}$";
    Pattern pattern = Pattern.compile(VALIDATION_IATA_REGEX);

    @Autowired(required = false)
    BestHotelsClient bestHotelsClient;

    @Autowired(required = false)
    BookingHotelsClient bookingHotelsClient;

    /**
     *
     * @param
     * @return
     *
     * call search API for Available Hotel
     */
    @GetMapping(value = "/search")
    @ApiOperation(value = "Search Available Hotels", notes="Search Available Hotels and sorting by rate")
    public ResponseEntity<?> searchAvailableHotel(
            @ApiParam(name =  "city", type = "String", value = "City Name", example = "AUD", required = true) String city,
            @ApiParam(name =  "fromDate", type = "Date", value = "From Date", example = "2021-08-04", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate ,
            @ApiParam(name =  "toDate", type = "Date", value = "To Date", example = "2021-08-05", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date  toDate,
            @ApiParam(name =  "numberOfAdults", type = "Integer", value = "Number Of Adults", example = "4", required = true) int numberOfAdults)  {

        /**
         * check if City code belongs IATA codes
         */
        Matcher matcher = pattern.matcher(city.toUpperCase());
        if (!matcher.matches()){
            return new ResponseEntity<>("This City Code: " + city +" not belongs with IATA codes", HttpStatus.BAD_REQUEST);
        }

        List<AvailableHotelResponseForm> response = new ArrayList<>();

        /**
         * call Best Hotel provider
         */
        List<BestHotelDto> bestHotels =  bestHotelsClient.getBestHotel( city,  fromDate, toDate,  numberOfAdults);

        for (BestHotelDto bestHotel : bestHotels) {
            ArrayList<String> roomAmenities = new ArrayList<>(Arrays.asList(bestHotel.getRoomAmenities().split(", ")));

            AvailableHotelResponseForm availableHotel = new AvailableHotelResponseForm();
            availableHotel.setHotelFare(bestHotel.getHotelFare());
            availableHotel.setHotelName(bestHotel.getHotelName());
            availableHotel.setRate(bestHotel.getRate());
            availableHotel.setRoomAmenities(roomAmenities);
            availableHotel.setProvider(Providers.BEST_HOTEL.toString());
            response.add(availableHotel);
        }


        /**
         * call Booking Hotel provider
         */
        List<BookingHotelDto> bookHotels =  bookingHotelsClient.getBookingHotel( city,  fromDate, toDate,  numberOfAdults);

        for (BookingHotelDto bookHotel : bookHotels) {
            ArrayList<String> roomAmenities = new ArrayList<>(Arrays.asList(bookHotel.getRoomAmenities().split(", ")));
            AvailableHotelResponseForm availableHotel = new AvailableHotelResponseForm();
            availableHotel.setHotelFare(bookHotel.getHotelFare());
            availableHotel.setHotelName(bookHotel.getHotelName());
            availableHotel.setRate(bookHotel.getRate());
            availableHotel.setRoomAmenities(roomAmenities);
            availableHotel.setProvider(Providers.BOOKING_HOTEL.toString());
            response.add(availableHotel);
        }


        /**
         * sort list of available hotel desc By Rate
         */
        Collections.sort(response, new Comparator<AvailableHotelResponseForm>() {
            @Override
            public int compare(AvailableHotelResponseForm c1, AvailableHotelResponseForm c2) {
                return Double.compare(c1.getRate(), c2.getRate());
            }
        });
        Collections.reverse(response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
