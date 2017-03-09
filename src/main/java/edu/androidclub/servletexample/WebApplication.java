package edu.androidclub.servletexample;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebApplication implements Runnable {

    private static final int SERVER_PORT = 8080;
    private static final String SERVLET_PATH = "/";

    private static Runnable app;

    private final Server jetty;

    public WebApplication() {
        this.jetty = new Server(SERVER_PORT);
        initServlets();
        run();
    }

    public static void main(String[] args) {
        app = new WebApplication();
        app.run();
    }

    private void initServlets() {
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath(SERVLET_PATH);

        contextHandler.addServlet(
                new ServletHolder(new TestGetParamServlet()),
                TestGetParamServlet.PATH
        );

        jetty.setHandler(contextHandler);
    }

    @Override
    public void run() {
        if (jetty != null && !jetty.isStarted()) {
            try {
                jetty.start();
                System.out.println("Jetty server started at port " + SERVER_PORT);
                jetty.join();
            } catch (Exception ex) {
                System.err.println("Failed to start server at port " + SERVER_PORT);
            }
        }
    }
}
