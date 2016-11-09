package com.example.di;

import javax.inject.Inject;

@ApplicationScope
public class GreetingProvider {
    @Inject
    public GreetingProvider(){
        int x = 10;
    }

    public String get() {
        return "Hello";
    }
}
