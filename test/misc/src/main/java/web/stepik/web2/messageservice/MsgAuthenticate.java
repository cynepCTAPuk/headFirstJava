package web.stepik.web2.messageservice;

public class MsgAuthenticate extends MsgToDB {
    private String name;
    private String password;
    private String sessionID;

    public MsgAuthenticate(Address from, Address to, String name, String password, String sessionID) {
        super(from, to);
        this.name = name;
        this.password = password;
        this.sessionID = sessionID;
    }

    @Override
    void exec(DBService dbService) {
        Account result = dbService.auth(name, password);
        Msg back = new MsgIdAuthenticated(getFrom(), getTo(), sessionID, result);
        dbService.getMessageSystem().sendMessage(back);
    }
}
