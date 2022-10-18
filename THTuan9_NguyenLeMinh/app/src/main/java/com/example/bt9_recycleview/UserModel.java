package com.example.bt9_recycleview;

public class UserModel {
    private char firstChar;
    private String name;

    public UserModel (){}

    public UserModel(String name) {
        this.firstChar = name.charAt(0);
        this.name = name;
    }

    public char getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(char firstChar) {
        this.firstChar = firstChar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
