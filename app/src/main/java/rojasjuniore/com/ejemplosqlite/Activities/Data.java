package rojasjuniore.com.ejemplosqlite.Activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import rojasjuniore.com.ejemplosqlite.Activities.Helpers.DBHelper;
import rojasjuniore.com.ejemplosqlite.Activities.POJOS.Usuario;

/**
 * Created by usuario on 19/08/2017.
 */

public class Data {

    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context) {
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }


    public void insertUsuario(Usuario usuario) {
        ContentValues contentValues = usuario.toValues();
        sqLiteDatabase.insert(SQLConstants.tableUsuarios, null, contentValues);
        Log.e("tableUsuarios", SQLConstants.tableUsuarios);
    }

    public Usuario getUsuario(String id) {
        Usuario usuario = new Usuario();
        String[] whereArgs = new String[]{id};

        Cursor cursor = sqLiteDatabase.query(
                SQLConstants.tableUsuarios,
                SQLConstants.ALL_COLUMNS,
                SQLConstants.SEARCH_BY_ID,
                whereArgs,
                null,
                null,
                null);

        // while (cursor.moveToNext()) {
        if (cursor.getCount() == 1) {
            cursor.moveToNext();
            usuario.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            usuario.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            usuario.setEdad(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_EDAD)));
            usuario.setCorreo(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_CORREO)));
        }
        //}

        return usuario;

    }


    public void updateUser(String id, ContentValues contentValues) {

        String[] whereArgs = new String[]{String.valueOf(id)};
        sqLiteDatabase.update(SQLConstants.tableUsuarios,
                contentValues, SQLConstants.WHERE_ID_CLAUSE, whereArgs);

    }

    public void deleteUser(String id) {

        String[] whereArgs = new String[]{String.valueOf(id)};
        sqLiteDatabase.delete(SQLConstants.tableUsuarios, SQLConstants.WHERE_ID_CLAUSE, whereArgs);

    }

    public void open() {
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close() {
        sqLiteOpenHelper.close();
    }


}
