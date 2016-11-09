package com.example.di;

import dagger.Component;
import dagger.MembersInjector;

@ApplicationScope
@Component
public interface ApplicationComponent {
    Controller controller();
    RequestComponent requestComponent(GreeterModule greeterModule);
}
