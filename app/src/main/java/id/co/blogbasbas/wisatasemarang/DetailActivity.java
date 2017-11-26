package id.co.blogbasbas.wisatasemarang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.blogbasbas.wisatasemarang.db.DatabaseHelper;
import id.co.blogbasbas.wisatasemarang.model.WisataModel;

public class DetailActivity extends AppCompatActivity {
    ArrayList<WisataModel> listData = new ArrayList<>();
    private static final String TAG = "DetailWisataActivity";
    private ImageView ivDetailGambar;
    private TextView tvDetailDeskripsi;
    private TextView tvDetailAlamat;
    FloatingActionButton fab;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.img4)
    ImageView img4;

    DatabaseHelper db = new DatabaseHelper(this);
    Boolean isFavorit;
    SharedPreferences pref;
     String latWisata;
    String longWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        initView();


        //tangkap data
        Bundle data = getIntent().getExtras();
        final String idWisata = data.getString(Konstanta.DATA_ID);
        final String namaWisata = data.getString(Konstanta.DATA_NAMA);
        final String gambarWisata = data.getString(Konstanta.DATA_GAMBAR);
        final String deskripsiWisata = data.getString(Konstanta.DATA_DESKRIPSI);
        final String alamatWisata = data.getString(Konstanta.DATA_ALAMAT);
        longWisata = data.getString(Konstanta.DATA_LAT);
         latWisata = data.getString(Konstanta.DATA_LNG);
        final String gambar1 = data.getString(Konstanta.DATA_GBR1);
        final String gambar2 = data.getString(Konstanta.DATA_GBR2);
        final String gambar3 = data.getString(Konstanta.DATA_GBR3);
        final String gambar4 = data.getString(Konstanta.DATA_GBR4);



        Log.d(TAG, " Hasil Dari Log " +Konstanta.DATA_ALAMAT);
        //set data ke widget
        getSupportActionBar().setTitle(namaWisata);


        tvDetailDeskripsi.setText(deskripsiWisata);
        tvDetailAlamat.setText(alamatWisata);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambarWisata)
                .placeholder(R.drawable.olele)
                .error(R.drawable.olele)
                .into(ivDetailGambar);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambar2)
                .placeholder(R.drawable.olele)
                .error(R.drawable.olele)
                .into(img2);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambar3)
                .placeholder(R.drawable.olele)
                .error(R.drawable.olele)
                .into(img3);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambar4)
                .placeholder(R.drawable.olele)
                .error(R.drawable.olele)
                .into(img4);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambar1)
                .placeholder(R.drawable.olele)
                .error(R.drawable.olele)
                .into(img1);



        //preferences
        pref = getSharedPreferences(Konstanta.SETTING, MODE_PRIVATE);
        isFavorit = pref.getBoolean(Konstanta.TAF_PRE+idWisata, false);
       //namabah favorit tempat
        fab = (FloatingActionButton) findViewById(R.id.fab);
        cekFavorit(isFavorit);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //simpan favorit ke pref
                if (isFavorit){


                   // isFavorit = false;

                    long del = db.delete(namaWisata);


                    Log.d(TAG, "id kembali: "+del);
                    if (del<= 0){
                        Snackbar.make(view, "Favorit gagal di Hapus", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    } else {
                        Snackbar.make(view, "Favorit  di Hapus", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        //true
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean(Konstanta.TAF_PRE+idWisata, false);
                        editor.commit();

                        isFavorit = false;

                    }



                }
                  else {

                /*
                    Snackbar.make(view, "Favorit di tambahkan", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/


                    //simpan ke sqllite
                    long id = db.insertData(namaWisata,gambarWisata,alamatWisata,
                            deskripsiWisata,latWisata,longWisata);

                    Log.d(TAG, "id kembali: "+id);
                    if (id<= 0){
                        Snackbar.make(view, "Favorit gagal di tambahkan", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    } else {
                        Snackbar.make(view, "Favorit  di tambahkan", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        //true
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean(Konstanta.TAF_PRE+idWisata, true);
                        editor.commit();

                        isFavorit = true;

                    }
                }

                cekFavorit(isFavorit);




            }
        });
    }

    private void cekFavorit(Boolean isFavorit) {

        if (isFavorit == true){
            fab.setImageResource(R.drawable.ic_action_isfavorit);

        } else {
            fab.setImageResource(R.drawable.ic_action_nofav);
        }
    }

    private void initView() {
        ivDetailGambar = (ImageView) findViewById(R.id.iv_detail_gambar);
        tvDetailDeskripsi = (TextView) findViewById(R.id.tv_detail_deskripsi);
        tvDetailAlamat = (TextView) findViewById(R.id.tv_detail_alamat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_detail,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.action_nav){
            Uri gmmIntentUri = Uri.parse("google.navigation:q="+longWisata+","+latWisata+"");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }

        return super.onOptionsItemSelected(item);
    }
}