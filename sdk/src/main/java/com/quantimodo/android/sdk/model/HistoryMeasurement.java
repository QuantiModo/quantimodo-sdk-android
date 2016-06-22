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

    final String note;

    final int id;

    final Date updatedAt;

    public HistoryMeasurement(int id, String source, String variable, Date timestamp, double value, String unit, Date updatedAt){
        this(id, source, variable, timestamp, value, unit, null, updatedAt);
    }

    public HistoryMeasurement(
            int id, String source,
            String variable,
            Date timestamp,
            double value,
            String unit,
            String note,
            Date updatedAt
    ) {
        this.source = source;
        this.variable = variable;
        this.timestamp = timestamp;
        this.value = value;
        this.unit = unit;
        this.note = note;
        this.id = id;
        this.updatedAt = updatedAt;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public String getNote() {
        return note;
    }

    public int getId() {
        return id;
    }
}
