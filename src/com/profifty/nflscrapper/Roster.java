package com.profifty.nflscrapper;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Roster {
    private final SimpleIntegerProperty jersey;
    private final SimpleStringProperty name;
    private final SimpleStringProperty position;
    private final SimpleStringProperty height;
    private final SimpleIntegerProperty weight;
    private final SimpleIntegerProperty age;
    private final SimpleStringProperty experience;
    private final SimpleStringProperty college;

   
    Roster(Integer jersey, String name, String position, String height, Integer weight, Integer age, String experience, String college) {
        this.jersey = new SimpleIntegerProperty(jersey);
        this.name = new SimpleStringProperty(name);
        this.position = new SimpleStringProperty(position);
        this.height = new SimpleStringProperty(height);
        this.weight = new SimpleIntegerProperty(weight);
        this.age= new SimpleIntegerProperty(age);
        this.experience = new SimpleStringProperty(experience);
        this.college = new SimpleStringProperty(college);
        
    }
    public int getJersey() {
        return jersey.get();
    }

    public void setJersey(int jerseyNumber) {
        jersey.set(jerseyNumber);
    }
    public IntegerProperty jerseyProperty() {
        return jersey;
    }


    public String getName() {
        return name.get();
    }

    public void setName(String playerName) {
        name.set(playerName);
    }
    
    public StringProperty nameProperty() {
        return name;
    }

    public String getPosition() {
        return position.get();
    }

    public void setPosition(String playerPosition) {
        position.set(playerPosition);
    }
    public StringProperty positionProperty() {
        return position;
    }

    public String getHeight() {
        return height.get();
    }

    public void setHeight(String playerHeight) {
        height.set(playerHeight);
    }
    public StringProperty heightProperty() {
        return height;
    }
    public int getWeight() {
        return weight.get();
    }

    public void setWeight(int playerWeight) {
        weight.set(playerWeight);
    }
    public IntegerProperty weightProperty() {
        return weight;
    }
    public int getAge() {
        return age.get();
    }

    public void setAge(int playerAge) {
        age.set(playerAge);
    }
    public IntegerProperty ageProperty() {
    	return age;
    }
    public String getExperience() {
        return experience.get();
    }

    public void setExperience(String playerExperience) {
        experience.set(playerExperience);
    }
    public StringProperty experienceProperty() {
        return experience;
    }
    public String getCollege() {
        return college.get();
    }

    public void setCollege(String playerCollege) {
        college.set(playerCollege);
    }
    public StringProperty collegeProperty() {
        return college;
    }
}
