package com.quantimodo.tools.models;


import com.quantimodo.tools.models.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import com.quantimodo.android.sdk.model.HistoryMeasurement;
// KEEP INCLUDES END
/**
 * Entity mapped to table "MEASUREMENT".
 */
public class Measurement {

    private Long id;
    /** Not-null value. */
    private java.util.Date timestamp;
    private Long variableId;
    private Long unitId;
    private double value;
    private String source;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient MeasurementDao myDao;

    private Variable variable;
    private Long variable__resolvedKey;

    private Unit unit;
    private Long unit__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Measurement() {
    }

    public Measurement(Long id) {
        this.id = id;
    }

    public Measurement(Long id, java.util.Date timestamp, Long variableId, Long unitId, double value, String source) {
        this.id = id;
        this.timestamp = timestamp;
        this.variableId = variableId;
        this.unitId = unitId;
        this.value = value;
        this.source = source;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMeasurementDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public java.util.Date getTimestamp() {
        return timestamp;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTimestamp(java.util.Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getVariableId() {
        return variableId;
    }

    public void setVariableId(Long variableId) {
        this.variableId = variableId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /** To-one relationship, resolved on first access. */
    public Variable getVariable() {
        Long __key = this.variableId;
        if (variable__resolvedKey == null || !variable__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            VariableDao targetDao = daoSession.getVariableDao();
            Variable variableNew = targetDao.load(__key);
            synchronized (this) {
                variable = variableNew;
            	variable__resolvedKey = __key;
            }
        }
        return variable;
    }

    public void setVariable(Variable variable) {
        synchronized (this) {
            this.variable = variable;
            variableId = variable == null ? null : variable.getId();
            variable__resolvedKey = variableId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Unit getUnit() {
        Long __key = this.unitId;
        if (unit__resolvedKey == null || !unit__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UnitDao targetDao = daoSession.getUnitDao();
            Unit unitNew = targetDao.load(__key);
            synchronized (this) {
                unit = unitNew;
            	unit__resolvedKey = __key;
            }
        }
        return unit;
    }

    public void setUnit(Unit unit) {
        synchronized (this) {
            this.unit = unit;
            unitId = unit == null ? null : unit.getId();
            unit__resolvedKey = unitId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    public static Measurement fromHistoryMeasurement(HistoryMeasurement measurement){
        Measurement m = new Measurement();
        m.setSource(measurement.getSource());
        m.setTimestamp(measurement.getTimestamp());
        m.setValue(measurement.getValue());
        //Unit ?
        //Variable ?

        return m;
    }

    public HistoryMeasurement toHistoryMeasurement(){
        return new HistoryMeasurement(
                getSource(),
                getVariable().getName(),
                getTimestamp(),
                getValue(),
                getUnit().getName()
        );
    }
    // KEEP METHODS END

}
