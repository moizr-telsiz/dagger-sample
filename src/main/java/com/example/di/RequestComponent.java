package com.example.di;

import dagger.Subcomponent;

@RequestScope
@Subcomponent(modules = GreeterModule.class)
public interface RequestComponent {
    Greeter greeter();
}
