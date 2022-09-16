package patterns.command.EugeneSuleimanov;

public class Developer {
    Command insert;
    Command update;
    Command select;
    Command delete;

    public Developer(Command insert, Command update, Command select, Command delete) {
        this.insert = insert;
        this.update = update;
        this.select = select;
        this.delete = delete;
    }

    public void insertRecord() {
        insert.execute();
    }
    public void updateRecord() {
        update.execute();
    }
    public void selecttRecord() {
        select.execute();
    }
    public void deletetRecord() {
        delete.execute();
    }
}
