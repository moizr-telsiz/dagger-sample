package com.example.di;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/greet"}, loadOnStartup = 1)
public class GreeterServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ApplicationComponent appcomponent = (ApplicationComponent) request.getServletContext().getAttribute("appcomponent");
        RequestComponent requestComponent = appcomponent
                .requestComponent(new GreeterModule(request.getQueryString()));
        String greeting = requestComponent.greeter().greet();

        response.getOutputStream().write(greeting.getBytes());
        response.getOutputStream().flush();
    }
}
