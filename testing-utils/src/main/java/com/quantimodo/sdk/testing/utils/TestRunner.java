package com.quantimodo.sdk.testing.utils;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner extends android.support.test.runner.AndroidJUnitRunner {

    @Override
    public void onCreate(Bundle arguments) {
        try {
            Class multi = Class.forName("android.support.multidex.MultiDex");
            Method method = multi.getMethod("install", Context.class);
            method.invoke(null,getTargetContext());
            Log.e("MultiDex","success");
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            Log.e("MultiDex","Failed", e);
        }
        //Problem with amazon sdk , force set test package
        if (!arguments.containsKey("class")) {
            arguments.putString("package", "com.quantimodo.tools");
        }
        super.onCreate(arguments);
    }
}
