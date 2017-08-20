package rojasjuniore.com.ejemplosqlite.Activities.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import rojasjuniore.com.ejemplosqlite.Activities.SQLConstants;

/**
 * Created by usuario on 19/08/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int SQL_DB_V = 1;

    public DBHelper(Context context) {
        super(context, SQLConstants.DB, null, SQL_DB_V);
        Log.e("DB", SQLConstants.DB);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLConstants.SQL_CREATE_TABLE_USUARIOS);
        Log.e("SQLCREATETABLEUSUARIOS", SQLConstants.SQL_CREATE_TABLE_USUARIOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLConstants.SQL_DELETE);
        Log.e("SQL_DELETE", SQLConstants.SQL_DELETE);
        onCreate(sqLiteDatabase);
    }
}
