package com.example.demo.entity;




public class RentRecordDetail  {
    String saler_phone;
    String buyer_phone;
    Object postedbook;

    public String getSaler_phone() {
        return saler_phone;
    }

    public void setSaler_phone(String saler_phone) {
        this.saler_phone = saler_phone;
    }

    public String getBuyer_phone() {
        return buyer_phone;
    }

    public void setBuyer_phone(String buyer_phone) {
        this.buyer_phone = buyer_phone;
    }

    public Object getPostedbook() {
        return postedbook;
    }

    public void setPostedbook(Object postedbook) {
        this.postedbook = postedbook;
    }

    public Object getRentrecord() {
        return rentrecord;
    }

    public void setRentrecord(Object rentrecord) {
        this.rentrecord = rentrecord;
    }

    Object rentrecord;


}
