package com.example.di;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SingletonDemoTest {

    @Test
    public void testSingletonPerComponent(){
        SingletonComponent singletonComponent = DaggerSingletonComponent.create();

        MySingleton mySingleton = singletonComponent.mySingleton();
        MySingleton mySingleton1 = singletonComponent.mySingleton();

        assertTrue(mySingleton == mySingleton1);

        SingletonComponent singletonComponent1 = DaggerSingletonComponent.create();

        assertFalse(mySingleton == singletonComponent1.mySingleton());
    }
}
