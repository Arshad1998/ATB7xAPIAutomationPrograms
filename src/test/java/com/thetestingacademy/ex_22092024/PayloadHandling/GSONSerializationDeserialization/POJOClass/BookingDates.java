package com.thetestingacademy.ex_22092024.PayloadHandling.GSONSerializationDeserialization.POJOClass;

public class BookingDates {

//    "bookingdates" : {
//                "checkin" : "2018-01-01",
//                        "checkout" : "2019-01-01"
//            }


    private String checkin;
    private String checkout;


    public String getCheckOUT() {
        return checkout;
    }

    public void setCheckOUT(String checkOUT) {
        checkout = checkOUT;
    }

    public String getCheckIN() {
        return checkin;
    }

    public void setCheckIN(String checkIN) {
        checkin = checkIN;
    }



}
