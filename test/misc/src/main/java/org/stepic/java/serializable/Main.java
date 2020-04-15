package org.stepic.java.serializable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Paths.get("c:/000/client.bin");
        Client originalClient = new Client();
        originalClient.setId(1);
        originalClient.setName("Chuck Norris");
        originalClient.setBirthDate(LocalDate.of(1940, 3, 10));
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(originalClient);
        }
        Client client;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            client = (Client) ois.readObject();
        }
        System.out.println(client.getId() + "\n" + client.getName());
        System.out.println(client.getBirthDate() + "\n" + client.getAgeInYears());

        Animal[] animals = {new Animal("1"), new Animal("2")};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeInt(animals.length);
            for (Animal animal : animals) oos.writeObject(animal);
        }
        Animal[] copyAnimals = deserializeAnimalArray(baos.toByteArray());
        for (Animal animal : copyAnimals) System.out.print(animal.getName() + " ");
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] heap = new Animal[0];
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
            int size = ois.readInt();
            heap = new Animal[size];
            for (int i = 0; i < size; i++) heap[i] = (Animal) ois.readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return heap;
    }
}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) return Objects.equals(name, ((Animal) obj).name);
        return false;
    }

}

class Client implements Serializable {
    private long id;
    private String name;
    private LocalDate birthDate;
    private transient int ageInYears;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAgeInYears() {
        if (ageInYears == 0) ageInYears = birthDate.until(LocalDate.now()).getYears();
        return ageInYears;
    }

}