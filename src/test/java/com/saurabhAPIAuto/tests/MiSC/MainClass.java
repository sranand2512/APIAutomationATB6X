package com.saurabhAPIAuto.tests.MiSC;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class MainClass {

    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id + getClass().getSimpleName());

    }

    @Test
    public void testMethods1() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One. Thread id is: " + id + getClass().getSimpleName());
        System.out.println("\n");
    }

    @Test
    public void testMethods2() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two. Thread id is: " + id + getClass().getSimpleName());
        System.out.println("\n");
    }

    @Test
    public void testMethods3() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Three. Thread id is: " + id + getClass().getSimpleName());
        System.out.println("\n");
    }

    @Test
    public void testMethods4() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Four. Thread id is: " + id + getClass().getSimpleName());
        System.out.println("\n");
    }

    @Test
    public void testMethods5() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Five. Thread id is: " + id + getClass().getSimpleName());
        System.out.println("\n");
    }

    @Test
    public void testMethods6() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Six. Thread id is: " + id + getClass().getSimpleName());
        System.out.println("\n");
    }

    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id + getClass().getSimpleName());

    }
}