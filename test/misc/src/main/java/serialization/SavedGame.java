package serialization;

import java.io.*;
import java.util.Arrays;

public class SavedGame implements Serializable {
//    private static final long serialVersionUID = 1L;
    private String[] territoriesInfo;
    private String[] resourcesInfo;
    private String[] diplomacyInfo;

    public SavedGame(String[] territoriesInfo, String[] resourcesInfo, String[] diplomacyInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
        this.diplomacyInfo = diplomacyInfo;
    }

    public String[] getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(String[] territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public String[] getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(String[] resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    public String[] getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(String[] diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "\n\tterritoriesInfo=" + Arrays.toString(territoriesInfo) +
                "\n\tresourcesInfo=" + Arrays.toString(resourcesInfo) +
                "\n\tdiplomacyInfo=" + Arrays.toString(diplomacyInfo) +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("c:/000/game.ser");
        //создаем наш объект
        String[] territoryInfo = {"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
        String[] resourcesInfo = {"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};
        SavedGame savedGame = new SavedGame(territoryInfo, resourcesInfo, diplomacyInfo);
        System.out.println(savedGame);

        //создаем 2 потока для сериализации объекта и сохранения его в файл
        OutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(savedGame);      // сохраняем игру в файл
        objectOutputStream.close();                     //закрываем поток и освобождаем ресурсы

        InputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        savedGame = (SavedGame) objectInputStream.readObject();
        System.out.println(savedGame);
    }
}