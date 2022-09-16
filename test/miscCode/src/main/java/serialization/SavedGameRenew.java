package serialization;

import java.io.*;

public class SavedGameRenew implements Serializable {
    private TerritoriesInfo territoriesInfo;
    private ResourcesInfo resourcesInfo;
    private transient DiplomacyInfo diplomacyInfo;

    public SavedGameRenew(TerritoriesInfo territoriesInfo, ResourcesInfo resourcesInfo, DiplomacyInfo diplomacyInfo) {
        this.territoriesInfo = territoriesInfo;
        this.resourcesInfo = resourcesInfo;
        this.diplomacyInfo = diplomacyInfo;
    }

    public TerritoriesInfo getTerritoriesInfo() {
        return territoriesInfo;
    }

    public void setTerritoriesInfo(TerritoriesInfo territoriesInfo) {
        this.territoriesInfo = territoriesInfo;
    }

    public ResourcesInfo getResourcesInfo() {
        return resourcesInfo;
    }

    public void setResourcesInfo(ResourcesInfo resourcesInfo) {
        this.resourcesInfo = resourcesInfo;
    }

    public DiplomacyInfo getDiplomacyInfo() {
        return diplomacyInfo;
    }

    public void setDiplomacyInfo(DiplomacyInfo diplomacyInfo) {
        this.diplomacyInfo = diplomacyInfo;
    }

    @Override
    public String toString() {
        return "SavedGame{" +
                "\n\tterritoriesInfo=" + territoriesInfo +
                "\n\tresourcesInfo=" + resourcesInfo +
                "\n\tdiplomacyInfo=" + diplomacyInfo +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("c:/000/game.ser");
        //создаем наш объект
        TerritoriesInfo territoriesInfo = new TerritoriesInfo("У Испании 6 провинций, у России 10 провинций, у Франции 8 провинций");
        ResourcesInfo resourcesInfo = new ResourcesInfo("У Испании 100 золота, у России 80 золота, у Франции 90 золота");
        DiplomacyInfo diplomacyInfo = new DiplomacyInfo("Франция воюет с Россией, Испания заняла позицию нейтралитета");
        SavedGameRenew savedGame = new SavedGameRenew(territoriesInfo, resourcesInfo, diplomacyInfo);
        System.out.println(savedGame);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(savedGame);
        objectOutputStream.close();

        InputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        savedGame = (SavedGameRenew) objectInputStream.readObject();
        System.out.println(savedGame);

    }
}

class TerritoriesInfo implements Serializable {
    private String info;

    public TerritoriesInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "TerritoriesInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}

class ResourcesInfo implements Serializable {
    private String info;

    public ResourcesInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResourcesInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}

class DiplomacyInfo implements Serializable {
    private String info;

    public DiplomacyInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "DiplomacyInfo{" +
                "info='" + info + '\'' +
                '}';
    }
}