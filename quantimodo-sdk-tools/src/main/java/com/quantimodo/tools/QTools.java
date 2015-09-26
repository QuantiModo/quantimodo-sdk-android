package com.quantimodo.tools;

/**
 * Enter point of QuantimodoTools
 * Used to get instance of application, in order to use tools components
 * {@link QTools#init(QApplication)} should be called , with instance of QApplication
 */
public class QTools {

    private static QApplication mInstance;

    /**
     * @param instance Instance of QApplicaiton
     */
    public static void init(QApplication instance){
        mInstance = instance;
    }


    public static QApplication getInstance(){
        return mInstance;
    }
}
