package com.example.demo.clients;


import com.example.demo.request.AvailableHotelRequestForm;
import com.example.demo.response.BookingHotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
/**
 * @author Hashem Rashed
 *
 * @implNote
 * Inject Booking Hotel Provider
 */
@FeignClient(url = "http://localhost:8050/hotel/booking", name = "BookingHotelClient")
public interface BookingHotelsClient {

    @GetMapping("/search")
    public List<BookingHotelDto> getBookingHotel(@RequestParam String city, @RequestParam("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate  , @RequestParam("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date  toDate, @RequestParam int numberOfAdults);

}
