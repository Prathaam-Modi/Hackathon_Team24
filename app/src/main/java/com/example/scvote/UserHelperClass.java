package com.example.scvote;

public class UserHelperClass {

    String  canname,radioch;

    public UserHelperClass() {
    }

    public UserHelperClass(String canname, String radioch) {
        this.canname = canname;
        this.radioch = radioch;
    }

    public String getCanname() {
        return canname;
    }

    public void setCanname(String canname) {
        this.canname = canname;
    }

    public String getRadioch() {
        return radioch;
    }

    public void setRadioch(String radioch) {
        this.radioch = radioch;
    }
}
