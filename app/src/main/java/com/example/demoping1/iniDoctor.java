package com.example.demoping1;

public class iniDoctor {
    private String name;

    private int Imageright;

    private int Imageleft;

    public iniDoctor(String name,int Imageleft,int imageright){
        this.Imageleft=Imageleft;
        this.name=name;
        this.Imageright=imageright;
    }

    public String getName(){
        return name;
    }
    public int getImageleft(){
        return Imageleft;
    }
    public int getImageright(){return Imageright;}
}