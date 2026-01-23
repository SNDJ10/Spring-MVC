package com.xworkz.election.dto;




public class ElectionDto {
    private String partiName;
    private int age;
    private String email;
    private Long phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPartiName() {
        return partiName;
    }

    public void setPartiName(String partiName) {
        this.partiName = partiName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
