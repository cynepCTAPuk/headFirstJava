package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveLoadObject1 {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String file = "c:/000/ivanov.txt";
            File your_file_name = File.createTempFile("c:/000/ivanov.txt", null);
            InputStream inputStream = new FileInputStream(your_file_name);
            OutputStream outputStream = new FileOutputStream(your_file_name);

            Person ivanov = new Person("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2_999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Person somePerson = new Person();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }
}

class Person {
    public String name;
    public List<Asset> assets = new ArrayList<>();

    public Person() {
    }

    public Person(String name, Asset... assets) {
        this.name = name;
        if (assets != null) {
            this.assets.addAll(Arrays.asList(assets));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person human = (Person) o;

        if (name != null ? !name.equals(name) : name != null) return false;
        return assets != null ? assets.equals(assets) : assets == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (assets != null ? assets.hashCode() : 0);
        return result;
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(name);
        for (Asset a : assets) {
            writer.println(a.getName());
            writer.println(a.getPrice());
        }
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        name = reader.readLine();
        while (reader.ready()) {
            assets.add(new Asset(reader.readLine(), Double.parseDouble(reader.readLine())));
        }
        reader.close();
    }
}

class Asset {
    public Asset(String name, double price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (Double.compare(asset.price, price) != 0) return false;
        return name != null ? name.equals(asset.name) : asset.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
