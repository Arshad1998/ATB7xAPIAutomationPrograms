package com.thetestingacademy.ex_22092024.PayloadHandling.GSONSerializationDeserialization.POJOClass;

public class Booking {

    //    {
//                "firstname" : "Jim",
//                        "lastname" : "Brown",
//                    "totalprice" : 111,
//                    "depositpaid" : true,
//                    "bookingdates" : {
//                "checkin" : "2018-01-01",
//                        "checkout" : "2019-01-01"
//            },
//                "additionalneeds" : "Breakfast"
//            }

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    //    Inner Object in JSON will be converted to Separate Class ana declared inside main class
    private BookingDates bookingdates;
    private String additionalneeds;

    public String getAdditionalNeeds() {
        return additionalneeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        additionalneeds = additionalNeeds;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        lastname = lastName;
    }

    public Integer getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(Integer totalPrice) {
        totalprice = totalPrice;
    }

    public Boolean getDepositPaid() {
        return depositpaid;
    }

    public void setDepositPaid(Boolean depositPaid) {
        depositpaid = depositPaid;
    }

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }


}
