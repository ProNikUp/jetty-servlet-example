package edu.androidclub.servletexample;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by senik11 on 09.03.17.
 */
public class TestGetParamServlet extends HttpServlet {

    public static final String PATH = "/test";

    public TestGetParamServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        PrintWriter responseWriter = resp.getWriter();
        responseWriter.append("Got param = ").append(param);
        responseWriter.flush();
    }
}
