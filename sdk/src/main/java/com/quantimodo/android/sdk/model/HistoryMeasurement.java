package com.quantimodo.android.sdk.model;

import android.util.Log;

import java.util.Date;

public class HistoryMeasurement {
    @Deprecated
    final String source;
    @Deprecated
    final String variable;
    @Deprecated
    final Date timestamp;
    @Deprecated
    final double value;
    @Deprecated
    final String unit;

    final String note;

    final int id;

    public HistoryMeasurement(int id, String source, String variable, Date timestamp, double value, String unit){
        this(id, source, variable, timestamp, value, unit,null);
    }

    public HistoryMeasurement(int id, String source, String variable, Date timestamp, double value, String unit,String note) {
        this.source = source;
        this.variable = variable;
        this.timestamp = timestamp;
        this.value = value;
        this.unit = unit;
        this.note = note;
        this.id = id;
    }

    public String getSource() {
        Log.d("getSource", "getSource is " + variable);
        return source;
    }

    public String getVariable() {
        Log.d("getVariable", "getVariable is " + variable);
        return variable;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        Log.d("getUnit", "getUnit is " + unit);
        return unit;
    }

    public String getNote() {
        return note;
    }

    public int getId() {
        return id;
    }
}
