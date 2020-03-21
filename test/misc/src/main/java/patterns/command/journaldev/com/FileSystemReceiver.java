package patterns.command.journaldev.com;

public interface FileSystemReceiver {
    void openFile();
    void writeFile();
    void closeFile();
}
