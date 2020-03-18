package patterns.proxy.task3709.connectors;

import patterns.proxy.task3709.security.SecurityChecker;
import patterns.proxy.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    SimpleConnector simpleConnector;
    SecurityChecker securityChecker = new SecurityCheckerImpl();

    public SecurityProxyConnector(String s) {
        simpleConnector = new SimpleConnector(s);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck())
            simpleConnector.connect();
    }
}
