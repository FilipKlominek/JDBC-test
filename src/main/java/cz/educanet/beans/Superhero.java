package cz.educanet.beans;

public class Superhero {
    private final String pseudonym;
    private final String fullName;
    private final String gender;
    private final String race;
    private final String alignment;

    public Superhero(String pseudonym, String fullName, String gender, String race, String alignment) {
        this.pseudonym = pseudonym;
        this.fullName = fullName;
        this.gender = gender;
        this.race = race;
        this.alignment = alignment;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getAlignment() {
        return alignment;
    }
}
