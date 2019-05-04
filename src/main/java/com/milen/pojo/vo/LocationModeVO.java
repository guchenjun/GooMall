package com.milen.pojo.vo;

public class LocationModeVO {

    private String location;

    private String mode;

    public LocationModeVO() {
    }

    public LocationModeVO(String location, String mode) {
        this.location = location;
        this.mode = mode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "LocationModeVO{" +
                "location='" + location + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}
