package edu.androidclub.servletexample1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Application implements Runnable {

    private static final int JETTY_PORT = 8080;

    private static Application app;

    private final Server jetty;

    public Application() {
        this.jetty = new Server(JETTY_PORT);
    }

    public static void main(String[] args) {
        app = new Application();
        app.init();
        app.run();
    }

    private void init() {
        ServletContextHandler servletHandler = new ServletContextHandler(
                ServletContextHandler.SESSIONS
        );

        servletHandler.addServlet(
                new ServletHolder(
                        new TestServlet()
                ),
                TestServlet.PATH
        );

        jetty.setHandler(servletHandler);
    }

    @Override
    public void run() {
        if (jetty != null && !jetty.isStarted()) {
            try {
                jetty.start();
                System.out.println("Server is started on port " + JETTY_PORT);
                jetty.join();
            } catch (Exception ex) {
                System.err.println(ex);
                System.exit(0);
            }
        } else {
            throw new RuntimeException("Jetty not ready. Aborting.");
        }
    }
}
