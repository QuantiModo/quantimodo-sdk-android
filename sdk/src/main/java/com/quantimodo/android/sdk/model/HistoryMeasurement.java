package com.quantimodo.android.sdk.model;

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

    public HistoryMeasurement(String source, String variable, Date timestamp, double value, String unit) {
        this.source = source;
        this.variable = variable;
        this.timestamp = timestamp;
        this.value = value;
        this.unit = unit;
    }

    public String getSource() {
        return source;
    }

    public String getVariable() {
        return variable;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
}
