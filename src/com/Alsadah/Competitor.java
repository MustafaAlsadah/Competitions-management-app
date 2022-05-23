package com.Alsadah;


import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Competitor implements Serializable {
    String ID;
    int indexInDataBase;
    String major;
    String name;
    String rank;


    public Competitor(String name, String ID, String major, int indexInDataBase, String rank){
        this.name = (name);
        this.ID = ID;
        this.major = major;
        this.indexInDataBase = indexInDataBase;
        this.rank = rank;
    }

    public void setID(String ID) {
        for (int i=0; i<ID.length(); i++){
            if (!Character.isDigit(ID.charAt(i)))
                throw new IllegalArgumentException("Entered ID has a non-digit value");
        }
        if (ID.length()>9 || ID.length()<9){
            throw new IllegalArgumentException("Entered ID has more or less than 9 digits");
        }else {
            this.ID = ID;
        }

    }
    public String getID() {
        return ID;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        String str = "Name: "+this.name
                +"\nID: "+this.ID
                +"\nMajor: "+this.major
                +"\nRank: "+this.rank;
        return str;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
