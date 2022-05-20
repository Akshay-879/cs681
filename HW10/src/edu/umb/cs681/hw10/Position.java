package edu.umb.cs681.hw10;

public final class Position {

    private final double latitude, longitude, altitude;

    public Position(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public String toString(){

        return latitude + "," + longitude + ",";

    }

    public boolean equals(Position position2){

        if(this.toString().equals(position2.toString())){
            return true;
        }else{
            return false;
        }
    }

//    ArrayList<Double> getCordinate(){
//
//    }

    Position changeLat(double newLat){
        return new Position(newLat, this.longitude, this.altitude);
    }

    Position changeLon(double newLon){
        return new Position(this.latitude, newLon, this.altitude);
    }

    Position changeAlt(double newAlti){
        return new Position(this.latitude, this.longitude, newAlti);
    }

}
