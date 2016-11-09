package com.example.di;

public class App {
    public static void main(String[] args) {
        ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
        Controller controller = applicationComponent.controller();
        System.out.println(controller.handleRequest("Madam President"));
        System.out.println(controller.handleRequest("Hillary Clinton"));
    }
}
