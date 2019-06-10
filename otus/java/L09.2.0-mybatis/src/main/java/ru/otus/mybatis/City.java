package ru.otus.mybatis;

public class City {
    int id;
    String name;
    String state;
    String country;

    public int getId() {return id;}
    public String getName() {return name;}
    public String getState() {return state;}
    public String getCountry() {return country;}

    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setState(String state) {this.state = state;}
    public void setCountry(String country) {this.country = country;}

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
