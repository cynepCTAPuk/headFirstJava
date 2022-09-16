package web.stepik.web2.messageservice;

public abstract class MsgToDB extends Msg {
    protected MsgToDB(Address from, Address to) {
        super(from, to);
    }

    @Override
    public void exec(Abonent abonent) {
        if (abonent instanceof DBService) {
            exec((DBService) abonent);
        } else {
            // ...
        }
    }

    abstract void exec(DBService accountService);
}
