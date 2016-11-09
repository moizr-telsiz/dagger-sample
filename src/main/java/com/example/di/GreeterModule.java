package com.example.di;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class GreeterModule {
    private final String visitor;

    public GreeterModule(String visitor) { this.visitor = visitor; }

    @Provides @RequestScope
    public String provideFoo(){ return "toast"; }

    @Provides @RequestScope @Named("visitor")
    public String provideVisitor() { return visitor; }
}
