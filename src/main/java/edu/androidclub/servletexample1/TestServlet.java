package edu.androidclub.servletexample1;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    public static final String PATH = "/test";
    private static final String VAL_NAME = "val";

    public TestServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String val = req.getParameter(VAL_NAME);
        PrintWriter responseWriter = resp.getWriter();
        responseWriter.append("Input val parameter value = " + val);
        responseWriter.append("Stopping method");
        responseWriter.flush();
    }
}
