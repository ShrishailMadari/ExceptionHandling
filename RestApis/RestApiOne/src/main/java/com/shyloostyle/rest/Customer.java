package com.shyloostyle.rest;

public class Customer {
    private Integer cId;
    private String name;
    private Long phoneNo;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId=" + cId +
                ", name='" + name + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }


}
