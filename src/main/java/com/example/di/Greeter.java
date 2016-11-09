package com.example.di;

import dagger.Lazy;

import javax.inject.Inject;
import javax.inject.Named;

@RequestScope
public class Greeter {
    private final String visitor;
    private final Lazy<GreetingProvider> greetingProvider;

    @Inject
    public Greeter(Lazy<GreetingProvider> greetingProvider,
            @Named("visitor") String visitor) {
        this.visitor = visitor;
        this.greetingProvider = greetingProvider;
    }



    public String greet() {
        return greetingProvider.get().get() + " " + visitor;
    }
}
