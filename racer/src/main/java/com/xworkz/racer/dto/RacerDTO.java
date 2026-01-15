package com.xworkz.racer.dto;

public class RacerDTO {
    private int id;
    private String racerName;
    private String bikeName;

    public RacerDTO(int id, String racerName, String bikeName) {
        this.id = id;
        this.racerName = racerName;
        this.bikeName = bikeName;
    }

    public RacerDTO() {
        System.out.println("this is dto");
    }

}
