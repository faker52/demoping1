package com.example.demoping1;

public class Doctor {

    public String name;
    public String message;
    public int imageId;

    public Doctor(String name, int imageId,String message) {
        this.name = name;
        this.imageId = imageId;
        this.message = message;
    }

    public String getName() {
        return name;
    }
    public String getMessage() {
        return message;
    }
    public int getImageId() {
        return imageId;
    }
}

