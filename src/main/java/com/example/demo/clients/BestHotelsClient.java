package com.example.demo.clients;


import com.example.demo.request.AvailableHotelRequestForm;
import com.example.demo.response.BestHotelDto;
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
 * Inject Best Hotel Provider
 */
@FeignClient(url = "http://localhost:8060/hotel/best", name = "BestHotelClient")
public interface BestHotelsClient {

    @GetMapping("/search")
    public List<BestHotelDto> getBestHotel(@RequestParam String city, @RequestParam("fromDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate  , @RequestParam("toDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date  toDate, @RequestParam int numberOfAdults);

}
