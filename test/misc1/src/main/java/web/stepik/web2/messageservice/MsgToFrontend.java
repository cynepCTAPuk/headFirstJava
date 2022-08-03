package web.stepik.web2.messageservice;

public abstract class MsgToFrontend extends Msg {
    protected MsgToFrontend(Address from, Address to) {
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
