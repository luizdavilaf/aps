package com.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, NoSuchFieldException {
        System.out.println("Hello World!");

       /*  Object arquivoFromReflection = null;
            arquivoFromReflection = Class.forName("com.example.Date").getDeclaredConstructor().newInstance();
            arquivoFromReflection.getClass().getDeclaredFields();
            arquivoFromReflection.getClass().getDeclaredConstructor().newInstance();
            Field dayField = arquivoFromReflection.getClass().getDeclaredField("day");
            byte day = 26;
            dayField.setByte(arquivoFromReflection, day); */
    }
}
