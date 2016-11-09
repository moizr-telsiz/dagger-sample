package com.example.di;

import dagger.Lazy;

import javax.inject.Inject;

@ApplicationScope
public class Controller {
    private final Lazy<ApplicationComponent> applicationComponent;

    @Inject
    public Controller(Lazy<ApplicationComponent> applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public String handleRequest(String name) {
        RequestComponent requestComponent = applicationComponent.get()
                .requestComponent(new GreeterModule(name));
        return requestComponent.greeter().greet();
    }
}
