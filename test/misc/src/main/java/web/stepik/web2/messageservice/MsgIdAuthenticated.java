package web.stepik.web2.messageservice;

public class MsgIdAuthenticated extends MsgToFrontend {
    private String sessionID;
    private Account result;

    public MsgIdAuthenticated(Address from, Address to, String sessionID, Account result) {
        super(from, to);
        this.sessionID = sessionID;
        this.result = result;
    }

    @Override
    void exec(DBService dbService) {
    }
}
