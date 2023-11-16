package br.edu.ifg.entities;
public class Item {
    private String gender;
    private String race;
    private String parentalLevelEducation;
    private String lunch;
    private String testPreparation;
    private double mathScore;
    private double readScore;
    private double writeScore;

    public Item(String gender, String race, String parentalLevelEducation, String lunch,
                String testPreparation, double mathScore, double readScore, double writeScore) {
        this.gender = gender;
        this.race = race;
        this.parentalLevelEducation = parentalLevelEducation;
        this.lunch = lunch;
        this.testPreparation = testPreparation;
        this.mathScore = mathScore;
        this.readScore = readScore;
        this.writeScore = writeScore;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getParentalLevelEducation() {
        return parentalLevelEducation;
    }

    public void setParentalLevelEducation(String parentalLevelEducation) {
        this.parentalLevelEducation = parentalLevelEducation;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getTestPreparation() {
        return testPreparation;
    }

    public void setTestPreparation(String testPreparation) {
        this.testPreparation = testPreparation;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getReadScore() {
        return readScore;
    }

    public void setReadScore(double readScore) {
        this.readScore = readScore;
    }

    public double getWriteScore() {
        return writeScore;
    }

    public void setWriteScore(double writeScore) {
        this.writeScore = writeScore;
    }

    @Override
    public String toString() {
        return gender + ", " +
                race + ", " +
                parentalLevelEducation + ", " +
                lunch + ", " +
                testPreparation + ", " +
                mathScore + ", " +
                readScore + ", " +
                writeScore;
    }
}

