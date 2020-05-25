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
public class DatabaseHelper extends SQLiteOpenHelper{

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
    //query create table
    private final static String CREATE_TABLE = "CREATE TABLE "+DATABASE_TABLE
            +" ("+WISATA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +NAMA_WISATA+" VARCHAR(200), "
            +GAMBAR_WISATA+" VARCHAR(200), "
            +ALAMAT_WISATA+" TEXT, "
            +DESKRIPSI_WISATA+" TEXT, "
            +LATITUDE_WISATA+ " VARCHAR(20), "
            +LONGITUDE_WISATA+ " VARCHAR(20));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(db);
    }

    //DML
    //CRUD

    //insert data
    public long insertData(String namaWisata, String gambarWisata, String alamatWisata, String deskripsiWisata, String latWisata, String longWisata){
        //kalau gagal <= 0
        // kalau berhasil > 0
        //saat insert kita dapat id
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAMA_WISATA, namaWisata);
        cv.put(GAMBAR_WISATA, gambarWisata);
        cv.put(ALAMAT_WISATA, alamatWisata);
        cv.put(DESKRIPSI_WISATA, deskripsiWisata);
        cv.put(LATITUDE_WISATA, latWisata);
        cv.put(LONGITUDE_WISATA, longWisata);
        long id = db.insert(DATABASE_TABLE, null, cv);
        db.close();
        return id;
    }

    //menghapus data favorite di SQLite
    public long delete(String namaWisata){
        SQLiteDatabase db = this.getWritableDatabase();
        String namaKolom = NAMA_WISATA + " = ?";
        String [] isikolom = {namaWisata};

        int count = db.delete(DATABASE_TABLE,namaKolom,isikolom);
        db.close();
        return count;
    }


    public ArrayList<WisataModel> getDataFavorite() {
        ArrayList<WisataModel> listWisataFavorite = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columnName = {WISATA_ID, NAMA_WISATA, GAMBAR_WISATA, ALAMAT_WISATA, DESKRIPSI_WISATA, LATITUDE_WISATA, LONGITUDE_WISATA};
        Cursor kursor = db.query(
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

        db.close();
        return listWisataFavorite;
    }



//    public long delete0(int idWisata){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String namaKolom = WISATA_ID + " = ?";
//        String [] isikolom = {String.valueOf(idWisata)};
//
//        int count = db.delete(DATABASE_TABLE,namaKolom,isikolom);
//        db.close();
//        return count;
//    }

}
