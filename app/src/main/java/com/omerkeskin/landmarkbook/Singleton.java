package com.omerkeskin.landmarkbook;

public class Singleton {

    private static Singleton instance;
    private Landmark landmark;

    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
         if(instance == null){
             instance = new Singleton();
         }
         return instance;
    }

    public Landmark getLandmark() {
        return landmark;
    }

    public void setLandmark(Landmark landmark) {
        this.landmark = landmark;
    }
}
