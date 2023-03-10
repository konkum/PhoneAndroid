package com.example.phone;

public class Phone {
    private int icon;
    private String phoneName;
    private String phoneCost;

    public Phone(int icon, String phoneName, String phoneCost) {
        this.icon = icon;
        this.phoneName = phoneName;
        this.phoneCost = phoneCost;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneCost() {
        return phoneCost;
    }

    public void setPhoneCost(String phoneCost) {
        this.phoneCost = phoneCost;
    }
}
