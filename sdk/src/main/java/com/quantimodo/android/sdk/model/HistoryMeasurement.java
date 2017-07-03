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
    final String unitAbbreviatedName;

    final String note;

    final int id;

    public HistoryMeasurement(int id, String source, String variable, Date timestamp, double value, String unit){
        this(id, source, variable, timestamp, value, unit, null);
    }

    public HistoryMeasurement(int id, String source, String variable, Date timestamp, double value, String unitAbbreviatedName,String note) {
        this.source = source;
        this.variable = variable;
        this.timestamp = timestamp;
        this.value = value;
        this.unitAbbreviatedName = unitAbbreviatedName;
        this.note = note;
        this.id = id;
    }

    public String getSource() {
        if(source == null){Log.e("getSource", "source is null!");}
        return source;
    }

    public String getVariable() {
        if(variable == null){Log.e("getVariable", "variable is null!");}
        return variable;
    }

    public Date getTimestamp() {
        if(timestamp == null){Log.e("getTimestamp", "timestamp is null!");}
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    public String getUnitAbbreviatedName() {
        if(variable == null){Log.e("getUnitAbbreviatedName", "unitAbbreviatedName is null!");}
        return unitAbbreviatedName;
    }

    public String getNote() {
        return note;
    }

    public int getId() {
        return id;
    }
}
