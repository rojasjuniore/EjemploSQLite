package rojasjuniore.com.ejemplosqlite.Activities;

/**
 * Created by usuario on 19/08/2017.
 */

public class SQLConstants {

    //Database
    public static final String DB = "bdusuarios.db";

    //Tabla
    public static final String tableUsuarios = "usuarios";

    // Columnas
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_EDAD = "edad";
    public static final String COLUMN_CORREO = "correo";

    public static final String SQL_CREATE_TABLE_USUARIOS
            = "CREATE TABLE " + tableUsuarios
            + "("
            + COLUMN_ID + " INT PRIMARY KEY,"
            + COLUMN_NOMBRE + " TEXT,"
            + COLUMN_EDAD + " INT,"
            + COLUMN_CORREO + " TEXT"
            + ");";


    public static final String SQL_DELETE = "DROP TABLE " + tableUsuarios;

    public static final String SEARCH_BY_ID = "id=?";
    public static final String WHERE_ID_CLAUSE = "id=?";

    public static final String[] ALL_COLUMNS = {COLUMN_ID, COLUMN_NOMBRE, COLUMN_EDAD, COLUMN_CORREO};


}
