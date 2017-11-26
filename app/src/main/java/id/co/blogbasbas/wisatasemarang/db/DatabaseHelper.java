package id.co.blogbasbas.wisatasemarang.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import id.co.blogbasbas.wisatasemarang.model.WisataModel;

/**
 * Created by Server on 31/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "dbwisata";
    private final static String DATABASE_TABLE = "table_wisata";
    private final static String WISATA_ID = "_id";
    private final static String NAMA_WISATA = "nama_wisata";
    private final static String GAMBAR_WISATA = "gambar_wisata";
    private final static String ALAMAT_WISATA = "alamat_wisata";
    private final static String DESKRIPSI_WISATA = "deskripsi_wisata";
    private final static String LATITUDE_WISATA = "latitude_wisata";
    private final static String LONGITUDE_WISATA = "longitude_wisata";

    private final static int DATABASE_VERSION = 1;
    private static DatabaseHelper instance;

    //create query table
    private final static String CREATE_TABLE = "CREATE TABLE " + DATABASE_TABLE
            + " (" + WISATA_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + NAMA_WISATA + " VARCHAR(200), "
            + GAMBAR_WISATA + " VARCHAR(200), "
            + ALAMAT_WISATA + " TEXT, "
            + DESKRIPSI_WISATA + " TEXT, "
            + LATITUDE_WISATA + " VARCHAR(20), "
            + LONGITUDE_WISATA + " VARCHAR(20));";

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper initDatabaseHelper(Context context) {
        if (instance != null) {
            return instance;
        }

        return new DatabaseHelper(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //membuat tabel
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);

    }

    public static long insertData(String namaWisata,
                                  String gambarWisata,
                                  String alamatWisata,
                                  String deskripsiWisata,
                                  String latWisata,
                                  String longWisata) {
        //
        SQLiteDatabase db = instance.getWritableDatabase();
        //untuk memasukan /colom
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMA_WISATA, namaWisata);
        contentValues.put(GAMBAR_WISATA, gambarWisata);
        contentValues.put(ALAMAT_WISATA, alamatWisata);
        contentValues.put(DESKRIPSI_WISATA, deskripsiWisata);
        contentValues.put(LATITUDE_WISATA, latWisata);
        contentValues.put(LONGITUDE_WISATA, longWisata);
        //insert data
        long id = db.insert(DATABASE_TABLE, null, contentValues);
        db.close();
        return id;
    }

    //menghapus data favorit di sqlite
    public static int delete(String namaWisata) {
        SQLiteDatabase db = instance.getWritableDatabase();
        String namaKolomnya = NAMA_WISATA + " = ?";
        String[] nilaiFieldnya = {namaWisata};

        return db.delete(DATABASE_TABLE, namaKolomnya, nilaiFieldnya);
    }

    public static  ArrayList<WisataModel> getDataFavorite() {
        ArrayList<WisataModel> listWisataFavorite = new ArrayList<>();
        SQLiteDatabase db = instance.getWritableDatabase();
        String[] columnName = {WISATA_ID, NAMA_WISATA, GAMBAR_WISATA, ALAMAT_WISATA, DESKRIPSI_WISATA, LATITUDE_WISATA, LONGITUDE_WISATA};

        Cursor kursor = null;

        try {
            kursor = db.query(
                    DATABASE_TABLE,
                    columnName,
                    null, null, null, null, null);
            if (kursor != null) {
                while (kursor.moveToNext()) {
                    int idWisata = kursor.getInt(kursor.getColumnIndex(WISATA_ID));
                    String namaWisata = kursor.getString(kursor.getColumnIndex(NAMA_WISATA));
                    String gambarWisata = kursor.getString(kursor.getColumnIndex(GAMBAR_WISATA));
                    String alamatWisata = kursor.getString(kursor.getColumnIndex(ALAMAT_WISATA));
                    String deskripsiWisata = kursor.getString(kursor.getColumnIndex(DESKRIPSI_WISATA));
                    String latWisata = kursor.getString(kursor.getColumnIndex(LATITUDE_WISATA));
                    String longWisata = kursor.getString(kursor.getColumnIndex(LONGITUDE_WISATA));

                    WisataModel wisataFavorite = new WisataModel();
                    wisataFavorite.setIdWisata(String.valueOf(idWisata));
                    wisataFavorite.setNamaWisata(namaWisata);
                    wisataFavorite.setGambarWisata(gambarWisata);
                    wisataFavorite.setAlamatWisata(alamatWisata);
                    wisataFavorite.setDeksripsiWisata(deskripsiWisata);
                    wisataFavorite.setLatitudeWisata(latWisata);
                    wisataFavorite.setLongitudeWisata(longWisata);

                    listWisataFavorite.add(wisataFavorite);
                }
            }
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            if (kursor != null) {
                kursor.close();
                db.close();
            }
        }
        return listWisataFavorite;
    }


}
