/*
 * https://ru.stackoverflow.com/questions/715661/Сериализация-сложного-java-объекта-в-json
 */
package chap02_IO.serializationJson;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;

class Record {
    private String name;
    private String status;
    private int executionCount;

    public Record() {
    }

    public Record(String name, String status, int executionCount) {
        setName(name);
        setStatus(status);
        setExecutionCount(executionCount);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setExecutionCount(int executionCount) {
        this.executionCount = executionCount;
    }

    public int getExecutionCount() {
        return executionCount;
    }
}

class SomeFile {
    private String path;
    private List<Record> records;
    private boolean putInEnd;

    public SomeFile() {
        records = new ArrayList<>();
    }

    public SomeFile(String path, boolean putInEnd) {
        this();
        setPath(path);
        setPutInEnd(putInEnd);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPutInEnd(boolean putInEnd) {
        this.putInEnd = putInEnd;
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }
}

class SomeFiles {
    private String name;
    private Map<String, SomeFile> pool;

    public SomeFiles() {
        pool = new HashMap<>();
    }

    public SomeFiles(String name) {
        this();
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void putSomeFile(String name, SomeFile someFile) {
        pool.put(name, someFile);
    }

    public Map<String, SomeFile> getPool() {
        return pool;
    }
}

public class App {
    public static void main(String[] args) {
        SomeFile someFile = new SomeFile("c:/000/secret.txt", false);
        someFile.addRecord(new Record("Some Record", "Some status", 42));
        someFile.addRecord(new Record("Another Record", "Same status", 0));

        SomeFiles someFiles = new SomeFiles("Some Files");
        someFiles.putSomeFile("Some File", someFile);

        ObjectMapper mapper = new ObjectMapper();
        // Для вывода с отступами
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Здесь происходит самая главная магия
            mapper.writeValue(new File("c:/000/some_files.json"), someFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}