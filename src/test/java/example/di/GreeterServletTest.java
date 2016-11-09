package com.example.di;

import dagger.Lazy;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class GreeterServletTest {

    private class MockApplicationContext implements ApplicationComponent {

        @Override public Controller controller() {
            return new Controller(() -> MockApplicationContext.this);
        }

        @Override public RequestComponent requestComponent(GreeterModule greeterModule) {
            return new MockRequestComponent(greeterModule);
        }
    }


    private class MockRequestComponent implements RequestComponent {

        private GreeterModule greetingModule;

        MockRequestComponent(GreeterModule greetingModule){
            this.greetingModule = greetingModule;
        }

        @Override public Greeter greeter() {
            return new Greeter(() -> new GreetingProvider() {
                public String get(){
                    return "Jolly good";
                }
            }, greetingModule.provideVisitor());
        }
    }

    @Test
    public void testDoGet() throws IOException {
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        ServletContext servletContext = mock(ServletContext.class);
        ServletOutputStream outputStream = mock(ServletOutputStream.class);

        when(httpServletRequest.getServletContext()).thenReturn(servletContext);
        when(servletContext.getAttribute("appcomponent")).thenReturn(new MockApplicationContext());
        when(httpServletRequest.getQueryString()).thenReturn("fellow");


        when(httpServletResponse.getOutputStream()).thenReturn(outputStream);

        new GreeterServlet().doGet(httpServletRequest, httpServletResponse);

        verify(outputStream).write("Jolly good fellow".getBytes());
    }
}
