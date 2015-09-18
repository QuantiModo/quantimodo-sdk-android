package com.quantimodo.sdk.testing.utils;

import android.content.Context;
import android.os.Bundle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner extends android.support.test.runner.AndroidJUnitRunner {

    @Override
    public void onCreate(Bundle arguments) {
        try {
            Class multi = Class.forName("android.app.assist.MultiDex");
            Method method = multi.getMethod("install", Context.class);
            method.invoke(null,getTargetContext());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //Problem with amazon sdk , force set test package
        if (!arguments.containsKey("class")) {
            arguments.putString("package", "com.quantimodo.tools");
        }
        super.onCreate(arguments);
    }
}
