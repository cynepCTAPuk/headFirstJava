package ru.otus.base;

public class UsersDataSet {
    private final long id;
    private final String name;

    public UsersDataSet(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {return id;}
    public String getName() {return name;}

    @Override
    public String toString() {
        return "UsersDataSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
