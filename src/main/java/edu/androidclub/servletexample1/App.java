package edu.androidclub.servletexample1;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class App extends Application {

    private Set<Class<?>> classes = new HashSet<>();
    private Set<Object> singletones = new HashSet<>();

    public App() {
        classes.add(JacksonJaxbJsonProvider.class);
        classes.add(TestResource.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletones;
    }
}
