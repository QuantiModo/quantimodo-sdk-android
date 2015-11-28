package com.quantimodo.tools;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.quantimodo.sdk.testing.utils.Utils;
import com.quantimodo.tools.events.SyncFinished;
import com.quantimodo.tools.events.SyncStarted;
import com.quantimodo.tools.models.*;
import com.quantimodo.tools.sync.SyncService;
import com.quantimodo.tools.testhelpers.TestModule;
import com.quantimodo.tools.testhelpers.TestSyncService;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.List;

import static com.quantimodo.tools.sync.SyncService.SYNC_FROM_SCRATCH_KEY;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SyncServiceTest {

    private boolean syncInProgress = false;
    private boolean syncStarted = false;

    @Inject
    DaoSession session;

    @BeforeClass
    public static void main() throws Exception{
        TestModule.addToGraph();
    }

    @Before
    public void setup(){
        QTools.getInstance().inject(this);
        session.getMeasurementDao().deleteAll();
        session.getVariableDao().deleteAll();
        session.getUnitDao().deleteAll();
        session.getCategoryDao().deleteAll();

        SharedPreferences prefs = InstrumentationRegistry.getContext().getSharedPreferences(ToolsPrefs.QUANTIMODO_PREF_KEY, Context.MODE_PRIVATE);
        prefs.edit().remove(SyncService.LAST_META_SYNC).commit();

        QTools.getInstance().register(this);
    }

    @Test
    public void testSync() throws Exception {
        Intent intent = new Intent(InstrumentationRegistry.getContext(), TestSyncService.class);
        intent.putExtra(SYNC_FROM_SCRATCH_KEY,false);
        InstrumentationRegistry.getContext().startService(intent);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(InstrumentationRegistry.getContext());
        Log.i("SyncServiceTest", "Username " + prefs.getString("userDisplayName", null));
        Utils.waitForCondition(new Utils.Condition() {
            @Override
            public boolean check() {
                return !syncInProgress && syncStarted;
            }
        }, 60000 * 2);

        assertTrue(session.getCategoryDao().count() > 0);
        assertTrue(session.getUnitDao().count() > 0);
        assertTrue(session.getVariableDao().count() > 0);

        UnitDao unitDao = session.getUnitDao();
        List<Unit> unitList = unitDao.loadAll();

        VariableDao variableDao = session.getVariableDao();
        List<Variable> variables = variableDao.loadAll();
        Variable variable = variables.get(0);

        assertNotNull(variable.getCategory());
        assertNotNull(variable.getUnit());
    }

    public void onEvent(SyncStarted syncStarted){
        syncInProgress = true;
        this.syncStarted = true;
    }

    public void onEvent(SyncFinished syncFinished){
        syncInProgress = false;
    }

    @After
    public void down(){
        QTools.getInstance().unregister(this);
    }



}
