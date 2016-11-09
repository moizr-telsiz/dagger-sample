package com.example.di;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component
public interface SingletonComponent {
    MySingleton mySingleton();
}
