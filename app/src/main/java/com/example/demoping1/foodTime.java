package com.example.demoping1;

public class foodTime {
    private String time;

    private String food1;
    private String food2;
    private String food3;

    private int Image;



    public foodTime(String time,int Image,String food1,String food2,String food3){
        this.Image=Image;
        this.time=time;
        this.food1=food1;
        this.food2=food2;
        this.food3=food3;
    }

    public String getName(){
        return time;
    }
    public int getImage(){
        return Image;
    }

    public String getFood1(){
        return food1;
    }
    public String getFood2(){
        return food2;
    }
    public String getFood3(){
        return food3;
    }

}