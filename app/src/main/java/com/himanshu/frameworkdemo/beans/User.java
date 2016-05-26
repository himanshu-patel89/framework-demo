package com.himanshu.frameworkdemo.beans;

/**
 * @author HimanshuP
 */
public class User {

    private String id;

    private String fullName;

    private String person;

    private String route;

    private String city;

    public User() {
    }

    public User(String id, String fullName, String person, String route, String city) {
        this.id = id;
        this.fullName = fullName;
        this.person = person;
        this.route = route;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", person='" + person + '\'' +
                ", route='" + route + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
