package servlets;

import resources.ResourceServer;
import resources.ResourceServerMBean;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourceServlet extends HttpServlet {
    public static final String PAGE_URL = "/";
//    private final TestResource testResource;
    private ResourceServerMBean resourceServer;

    public ResourceServlet(ResourceServerMBean resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getParameter("path");
        System.out.println(path);

        TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(path);
        if (testResource != null) {
            resourceServer.setName(testResource.getName());
            resourceServer.setAge(testResource.getAge());
            System.out.println(resourceServer);

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(resourceServer);
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        } else
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
}
