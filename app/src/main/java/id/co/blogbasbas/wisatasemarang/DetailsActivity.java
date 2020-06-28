package id.co.blogbasbas.wisatasemarang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.co.blogbasbas.wisatasemarang.adapter.WisataAdapter;
import id.co.blogbasbas.wisatasemarang.adapter.WisataAdapterDetail;
import id.co.blogbasbas.wisatasemarang.db.DatabaseHelper;
import id.co.blogbasbas.wisatasemarang.model.ListWisataModel;
import id.co.blogbasbas.wisatasemarang.model.WisataModel;
import id.co.blogbasbas.wisatasemarang.network.ApiServices;
import id.co.blogbasbas.wisatasemarang.network.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class DetailsActivity extends AppCompatActivity {
    private static final String TAG = "DetailWisataActivity";
    private ImageView ivDetailGambar;
    private TextView tvDetailDeskripsi;
    private TextView tvDetailAlamat;
    FloatingActionButton fab;
    ImageView img1;
    ImageView img2;
    ImageView img3;
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
    DatabaseHelper database = new DatabaseHelper(this);

    RecyclerView recyclerView;
    ArrayList<WisataModel> listData;
    Context context;
    RecyclerView.LayoutManager layoutManager;
    ProgressBar pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initView();
        ambilData();

        //tangkap data
        Bundle data = getIntent().getExtras();

        if (data != null) {
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
                .load(Konstanta.BASEURL_IMAGE + gambarWisata)
                .apply(new RequestOptions().placeholder(R.drawable.olele).error(R.drawable.olele))
                .into(ivDetailGambar);


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
                    long del = database.delete(namaWisata);

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

                    long id = database.insertData(namaWisata, gambarWisata, alamatWisata, deskripsiWisata, latWisata, longWisata);

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
        fab = findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.rv_detail);

        pd = (ProgressBar) findViewById(R.id.pd);
        listData = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(DetailsActivity.this,
                LinearLayoutManager.HORIZONTAL, false));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);

    }

    private void ambilData() {
        pd.setVisibility(View.VISIBLE);

        ApiServices api = RetrofitConfig.getApiServices();
        Call<ListWisataModel> call = api.ambilDataWisata();
        call.enqueue(new Callback<ListWisataModel>() {
            @Override
            public void onResponse(Call<ListWisataModel> call, Response<ListWisataModel> response) {
                pd.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    if (response.body().getSuccess().toString().equals("true")) {
                        listData = response.body().getWisata();
                        WisataAdapterDetail adapter = new WisataAdapterDetail(listData, DetailsActivity.this);
                        recyclerView.setAdapter(adapter);

                        //ngetes data di log
                        for (int i = 0; i < listData.size(); i++) {
                            Log.d(TAG, "onResponse: " + listData.get(i).getGambarWisata());
                        }
                    } else {
                        Toast.makeText(DetailsActivity.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DetailsActivity.this, "Respones is Not Succesfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListWisataModel> call, Throwable t) {
                Toast.makeText(DetailsActivity.this, "Response Failure", Toast.LENGTH_SHORT).show();
            }
        });
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