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
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.blogbasbas.wisatasemarang.db.DatabaseHelper;
import id.co.blogbasbas.wisatasemarang.model.WisataModel;

public class DetailActivity extends AppCompatActivity {

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
    Boolean isFavorit;
    SharedPreferences pref;
    String latWisata;
    String longWisata;

    String idWisata;
    String namaWisata;
    String gambarWisata;
    String deskripsiWisata;
    String alamatWisata;

    String gambar1;
    String gambar2;
    String gambar3;
    String gambar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initView();

        //tangkap data
        Bundle data = getIntent().getExtras();

        if (data != null){
            idWisata = data.getString(Konstanta.DATA_ID);
            namaWisata = data.getString(Konstanta.DATA_NAMA);
            gambarWisata = data.getString(Konstanta.DATA_GAMBAR);
            deskripsiWisata = data.getString(Konstanta.DATA_DESKRIPSI);
            alamatWisata = data.getString(Konstanta.DATA_ALAMAT);
            longWisata = data.getString(Konstanta.DATA_LAT);
            latWisata = data.getString(Konstanta.DATA_LNG);
            gambar1 = data.getString(Konstanta.DATA_GBR1);
            gambar2 = data.getString(Konstanta.DATA_GBR2);
            gambar3 = data.getString(Konstanta.DATA_GBR3);
            gambar4 = data.getString(Konstanta.DATA_GBR4);
        }

        Log.d(TAG, " Hasil Dari Log " + Konstanta.DATA_ALAMAT);
        //set data ke widget
        getSupportActionBar().setTitle(namaWisata);

        tvDetailDeskripsi.setText(deskripsiWisata);
        tvDetailAlamat.setText(alamatWisata);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambarWisata)
                .apply(new RequestOptions().placeholder(R.drawable.olele).error(R.drawable.olele))
                .into(ivDetailGambar);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambar2)
                .apply(new RequestOptions().placeholder(R.drawable.olele).error(R.drawable.olele))
                .into(img2);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambar3)
                .apply(new RequestOptions().placeholder(R.drawable.olele).error(R.drawable.olele))
                .into(img3);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambar4)
                .apply(new RequestOptions().placeholder(R.drawable.olele).error(R.drawable.olele))
                .into(img4);
        Glide.with(this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/" + gambar1)
                .apply(new RequestOptions().placeholder(R.drawable.olele).error(R.drawable.olele))
                .into(img1);

        //preferences
        pref = getSharedPreferences(Konstanta.SETTING, MODE_PRIVATE);
        isFavorit = pref.getBoolean(Konstanta.TAF_PRE + idWisata, false);
        //namabah favorit tempat
        fab = (FloatingActionButton) findViewById(R.id.fab);
        cekFavorit(isFavorit);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //simpan favorit ke pref
                if (isFavorit) {
                    // isFavorit = false;
                    long del = DatabaseHelper.delete(namaWisata);

                    Log.d(TAG, "id kembali: " + del);
                    if (del <= 0) {
                        Snackbar.make(view, "Favorit gagal di Hapus", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    } else {
                        Snackbar.make(view, "Favorit  di Hapus", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                        //true
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean(Konstanta.TAF_PRE + idWisata, false);
                        editor.apply();

                        isFavorit = false;
                    }
                } else {
                /*
                    Snackbar.make(view, "Favorit di tambahkan", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/

                    //simpan ke sqllite

                    long id = DatabaseHelper.insertData(namaWisata, gambarWisata, alamatWisata, deskripsiWisata, latWisata, longWisata);

                    Log.d(TAG, "id kembali: " + id);
                    if (id <= 0) {
                        Snackbar.make(view, "Favorit gagal di tambahkan", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();

                    } else {
                        Snackbar.make(view, "Favorit  di tambahkan", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        //true
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean(Konstanta.TAF_PRE + idWisata, true);
                        editor.apply();

                        isFavorit = true;
                    }
                }
                cekFavorit(isFavorit);
            }
        });
    }

    private void cekFavorit(Boolean isFavorit) {

        if (isFavorit) {
            fab.setImageResource(R.drawable.ic_action_isfavorit);

        } else {
            fab.setImageResource(R.drawable.ic_action_nofav);
        }
    }

    private void initView() {
        ivDetailGambar = findViewById(R.id.iv_detail_gambar);
        tvDetailDeskripsi = findViewById(R.id.tv_detail_deskripsi);
        tvDetailAlamat = findViewById(R.id.tv_detail_alamat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_nav) {
            Uri gmmIntentUri = Uri.parse("google.navigation:q=" + longWisata + "," + latWisata + "");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);

        }

        return super.onOptionsItemSelected(item);
    }
}