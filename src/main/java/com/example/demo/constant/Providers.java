package com.example.demo.constant;
/**
 * @author Hashem Rashed
 *
 * add providers
 */
public enum Providers {

   BEST_HOTEL("Best Hotel"),
   CRAZY_HOTEL("Crazy Hotel"),
   BOOKING_HOTEL("Booking Hotel") ;

    private String name;

    private Providers(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
