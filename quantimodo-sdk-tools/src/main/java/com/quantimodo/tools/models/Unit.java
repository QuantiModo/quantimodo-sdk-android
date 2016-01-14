package com.quantimodo.tools.models;

import com.quantimodo.tools.models.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
import com.quantimodo.android.sdk.model.ConversionStep;

import java.util.ArrayList;
// KEEP INCLUDES END
/**
 * Entity mapped to table "UNIT".
 */
public class Unit implements java.io.Serializable {

    private Long id;
    /** Not-null value. */
    private String name;
    private Double min;
    private Double max;
    private String category;
    /** Not-null value. */
    private String abbr;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient UnitDao myDao;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Unit() {
    }

    public Unit(Long id) {
        this.id = id;
    }

    public Unit(Long id, String name, Double min, Double max, String category, String abbr) {
        this.id = id;
        this.name = name;
        this.min = min;
        this.max = max;
        this.category = category;
        this.abbr = abbr;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUnitDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /** Not-null value. */
    public String getAbbr() {
        return abbr;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setAbbr(String abbr) {
        this.abbr = abbr;
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
    public static Unit fromWsUnit(com.quantimodo.android.sdk.model.Unit unit){
        Unit u = new Unit();
        u.setName(unit.getName());
        u.setMin(Double.valueOf(unit.getMinimum()));
        u.setMax(Double.valueOf(unit.getMaximum()));
        u.setCategory(unit.getCategory());
        u.setAbbr(unit.getAbbreviatedName());
        return u;
    }

    public com.quantimodo.android.sdk.model.Unit toUnit(){
        return new com.quantimodo.android.sdk.model.Unit(
                getName(),
                getName(),
                getCategory(),
                String.format("%.2f",getMin()),
                String.format("%.2f", getMax()),
                new ArrayList<ConversionStep>()
        );
    }
    // KEEP METHODS END

}
