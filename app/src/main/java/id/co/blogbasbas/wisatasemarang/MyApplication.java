package id.co.blogbasbas.wisatasemarang;

import android.app.Application;

import id.co.blogbasbas.wisatasemarang.db.DatabaseHelper;

/**
 * Created by jonesrandom on 11/26/17.
 * <p>
 * AA
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseHelper.initDatabaseHelper(this);
    }
}
