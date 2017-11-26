package id.co.blogbasbas.wisatasemarang;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.co.blogbasbas.wisatasemarang.kumpulanhelper.MyFunction;
import id.co.blogbasbas.wisatasemarang.kumpulanhelper.RealPathUtils;
import id.co.blogbasbas.wisatasemarang.network.ApiServices;
import id.co.blogbasbas.wisatasemarang.network.RetrofitConfig;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends MyFunction implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.edt_deskripsi)
    EditText edtDeskripsi;
    @BindView(R.id.input_layout_deskripsi)
    TextInputLayout inputLayoutDeskripsi;
    @BindView(R.id.edt_nama)
    EditText edtNama;
    @BindView(R.id.input_layout_nama)
    TextInputLayout inputLayoutNama;
    @BindView(R.id.edt_alamat)
    EditText edtAlamat;
    @BindView(R.id.input_layout_alamat)
    TextInputLayout inputLayoutAlamat;
    @BindView(R.id.edt_event)
    EditText edtEvent;
    @BindView(R.id.input_layout_event)
    TextInputLayout inputLayoutEvent;
    @BindView(R.id.btn_maps)
    Button btnMaps;
    @BindView(R.id.status_maps)
    TextView statusMaps;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    ProgressDialog loading;
    private static final String TAG = "CreateActivity";
    private static final int RC_GALLERY = 3;
    private static final int RC_MAPS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.imageView, R.id.btn_maps, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView:
                //dapet foto dari hp
                openGallery();
                break;
            case R.id.btn_maps:
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(CreateActivity.this), RC_MAPS);
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_submit:
                //ambil data
                String nama, deskripsi, alamat, event;
                nama = edtNama.getText().toString();
                alamat = edtAlamat.getText().toString();
                deskripsi = edtDeskripsi.getText().toString();
                event = edtEvent.getText().toString();

                //cek jika kosong
                if (TextUtils.isEmpty(nama) ||
                        TextUtils.isEmpty(alamat)||
                        TextUtils.isEmpty(deskripsi)||
                        TextUtils.isEmpty(event)||
                        TextUtils.isEmpty(lat)||
                        TextUtils.isEmpty(lng)||
                        uri == null
                        ){
                    MyToast("belum diisi");
                } else {

                    //dapetin path gambar yg dipilih
                    String path = null;
                    if (Build.VERSION.SDK_INT < 11) {
                        path = RealPathUtils.getRealPathFromURI_BelowAPI11(CreateActivity.this, uri);

                        // SDK >= 11 && SDK < 19
                    } else if (Build.VERSION.SDK_INT < 19) {
                        path = RealPathUtils.getRealPathFromURI_API11to18(CreateActivity.this, uri);

                        // SDK > 19 (Android 4.4)
                    } else if (Build.VERSION.SDK_INT > 22) {
                        path = RealPathUtils.getRealPathFromURI_API23(CreateActivity.this, uri);

                    } else {
                        path = RealPathUtils.getRealPathFromURI_API19(CreateActivity.this, uri);
                    }

                    File file = new File(path);

                    //ngasih nama gambar
                    String namaGambar = currentDate() + file.getName();

                    RequestBody sFile = RequestBody.create(MediaType.parse("image/*"), file);
                    MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", namaGambar, sFile);
                    RequestBody sNama = RequestBody.create(MediaType.parse("text/plain"), nama);
                    RequestBody sdeskripsi = RequestBody.create(MediaType.parse("text/plain"), deskripsi);
                    RequestBody sevent = RequestBody.create(MediaType.parse("text/plain"), event);
                    RequestBody salamat = RequestBody.create(MediaType.parse("text/plain"), alamat);
                    RequestBody sgambar = RequestBody.create(MediaType.parse("text/plain"), namaGambar);
                    RequestBody slat = RequestBody.create(MediaType.parse("text/plain"), lng);
                    RequestBody slng = RequestBody.create(MediaType.parse("text/plain"), lat);

                    //tampilkan loading
                    loading = ProgressDialog.show(CreateActivity.this, "Loading", "Mohon bersabara", true, false);
                    loading.show();

                    //persiapan service
                    ApiServices api = RetrofitConfig.getApiServices();
                    api.CREATE_WISATA(
                            fileToUpload,
                            sNama,
                            sgambar,
                            sdeskripsi,
                            sevent,
                            slat,
                            slng,
                            salamat
                    ).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
                                loading.dismiss();
                                try {
                                    JSONObject object = new JSONObject(response.body().string());
                                    if (object.getString("success").equals("true")) {

                                        Log.d(TAG, "onResponse: ");
                                        AlertDialog.Builder builder = new AlertDialog.Builder(CreateActivity.this);
                                        builder.setTitle("Complete");
                                        builder.setMessage(object.getString("message"));
                                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.dismiss();
                                                Intent a = new Intent(CreateActivity.this, MainActivity.class);
                                                a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                startActivity(a);
                                                finish();
                                            }
                                        });
                                        builder.create().show();

                                    } else {
                                        MyToast("Gagal ");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    MyToast("gagal 1 " +e);
                                    Log.d(TAG, "gagal upload : " +e);
                                } catch (IOException e) {
                                    MyToast("gagal 2 " +e);
                                    e.printStackTrace();
                                }
                            } else {
                                MyToast("Not Succesfull" +response);
                            }
                        }


                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            MyToast("Gagal Failure" +t );
                        }
                    });
                }

                    break;

        }
    }

    private void openGallery() {

        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE};
        if (!EasyPermissions.hasPermissions(getApplicationContext(), perms)) {
            EasyPermissions.requestPermissions(CreateActivity.this, "Butuh kamu", 100, perms);
        }

        Intent gallery = new Intent();
        gallery.setType("image/*");
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(gallery, RC_GALLERY);
    }

    public Uri uri = null;
    String lat, lng;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_GALLERY && resultCode == RESULT_OK && data != null) {
            uri = data.getData();
            Log.d(TAG, "onActivityResult: " + uri.toString());
            try {
                Bitmap hasil = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imageView.setImageBitmap(hasil);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (requestCode == RC_MAPS && resultCode  == RESULT_OK){
            Place place = PlacePicker.getPlace(CreateActivity.this, data);
            String alamat = String.format("%s", place.getName());
            lat = String.valueOf(place.getLatLng().latitude);
            lng = String.valueOf(place.getLatLng().longitude);
            statusMaps.setText(alamat);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (requestCode == 100) {
            openGallery();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}