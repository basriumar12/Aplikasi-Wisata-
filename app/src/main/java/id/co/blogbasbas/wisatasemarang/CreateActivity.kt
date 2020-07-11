package id.co.blogbasbas.wisatasemarang

import android.Manifest
import android.annotation.TargetApi
import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentUris
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.location.places.ui.PlacePicker
import com.google.android.material.textfield.TextInputLayout
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import id.co.blogbasbas.wisatasemarang.kumpulanhelper.MyFunction
import id.co.blogbasbas.wisatasemarang.network.RetrofitConfig
import kotlinx.android.synthetic.main.activity_create.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONException
import pl.aprilapps.easyphotopicker.EasyImage
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.IOException

class CreateActivity : MyFunction(), PermissionCallbacks, View.OnClickListener {
    var imageView: ImageView? = null
    var edtDeskripsi: EditText? = null
    var inputLayoutDeskripsi: TextInputLayout? = null
    var edtNama: EditText? = null
    var inputLayoutNama: TextInputLayout? = null
    var edtAlamat: EditText? = null
    var inputLayoutAlamat: TextInputLayout? = null
    var edtEvent: EditText? = null
    var inputLayoutEvent: TextInputLayout? = null
    var btnMaps: Button? = null
    var statusMaps: TextView? = null
    var btnSubmit: Button? = null
    var loading: ProgressDialog? = null
    var easyImage: EasyImage? = null
    var fileFoto = 0


    var path: File? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        imageView = findViewById(R.id.imageView)
        edtDeskripsi = findViewById(R.id.edt_deskripsi)
        edtAlamat = findViewById(R.id.edt_alamat)
        edtNama = findViewById(R.id.edt_nama)
        edtEvent = findViewById(R.id.edt_event)
        statusMaps = findViewById(R.id.status_maps)
        btnMaps = findViewById(R.id.btn_maps)
        btnSubmit = findViewById(R.id.btn_submit)

        Dexter.withActivity(this).withPermissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                .withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                        report?.let {

                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(
                            permissions: MutableList<PermissionRequest>?,
                            token: PermissionToken?
                    ) {
                        token?.continuePermissionRequest()
                    }
                }).check()
        btn_submit.setOnClickListener {
            submitData()
        }
        btn_maps.setOnClickListener {
            val builder = PlacePicker.IntentBuilder()
            try {
                startActivityForResult(builder.build(this@CreateActivity), RC_MAPS)
            } catch (e: GooglePlayServicesNotAvailableException) {
                e.printStackTrace()
            } catch (e: GooglePlayServicesRepairableException) {
                e.printStackTrace()
            }
        }

        edt_empat?.setOnClickListener {
           initPermission()
            openGallery()
            fileFoto = 4


        }

        edt_satu.setOnClickListener {
            initPermission()
            openGallery()
            fileFoto = 1
        }
        edt_dua.setOnClickListener {
            openGallery()
            fileFoto = 2
        }
        edt_tiga.setOnClickListener {
            openGallery()
            fileFoto = 3
        }

    }

    fun uploadFoto() {
        val file = File(path?.toURI())
        //ngasih nama gambar
        val namaGambar = file.name
        val sFile = RequestBody.create(MediaType.parse("image/*"), file)
        val fileToUpload = MultipartBody.Part.createFormData("file", namaGambar, sFile)
        val sgambar = RequestBody.create(MediaType.parse("text/plain"), namaGambar)

        //tampilkan loading

        progress_circular.visibility = View.VISIBLE
        //persiapan service
        val api = RetrofitConfig.apiServices
        api.CREATE_FOTO(
                fileToUpload,
                sgambar

        ).enqueue(object : Callback<id.co.blogbasbas.wisatasemarang.model.ResponseBody> {
            override fun onResponse(call: Call<id.co.blogbasbas.wisatasemarang.model.ResponseBody>, response: Response<id.co.blogbasbas.wisatasemarang.model.ResponseBody>) {
                if (response.isSuccessful) {
                    progress_circular.visibility = View.GONE

                    try {

                        if (response.body()?.success?.equals(true)!!) {
                            Log.e(TAG, "onResponse: ")
                            val builder = AlertDialog.Builder(this@CreateActivity)
                            builder.setTitle("Sukses Upload gambar")
                            builder.setMessage("Gambar $fileFoto Sukses  di upload")
                            builder.setPositiveButton("OK") { dialog, id ->
                                dialog.dismiss()

                            }
                            builder.create().show()
                        } else {
                            MyToast("gambar sudah tersedia")
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        MyToast("gagal 1 $e")
                        Log.e(TAG, "gagal upload : $e")
                    } catch (e: IOException) {
                        MyToast("gagal 2 $e")
                        e.printStackTrace()
                    }
                } else {
                    MyToast("Not Succesfull$response")
                }
            }

            override fun onFailure(call: Call<id.co.blogbasbas.wisatasemarang.model.ResponseBody>, t: Throwable) {
                MyToast("Gagal Failure$t")
                Log.e("TAG", "error ${t.message}")
                progress_circular.visibility = View.GONE

            }
        })
    }


    private fun initPermission() {

        Dexter.withActivity(this).withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
                .withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                        report?.let {

                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(
                            permissions: MutableList<PermissionRequest>?,
                            token: PermissionToken?
                    ) {
                        token?.continuePermissionRequest()
                    }
                }).check()
    }

    fun submitData() {
        //ambil data
        val nama: String
        val deskripsi: String
        val alamat: String
        val event: String

        nama = edtNama!!.text.toString()
        alamat = edtAlamat!!.text.toString()
        deskripsi = edtDeskripsi!!.text.toString()
        event = edtEvent!!.text.toString()
        val namaGambar1 = edt_satu.text.toString()
        val namaGambar2 = edt_dua.text.toString()
        val namaGambar3 = edt_tiga.text.toString()
        val namaGambar4 = edt_empat.text.toString()
        //cek jika kosong
        if (
                TextUtils.isEmpty(nama) ||
                TextUtils.isEmpty(alamat) ||
                TextUtils.isEmpty(deskripsi) ||
                TextUtils.isEmpty(event) ||
                TextUtils.isEmpty(lat) ||
                TextUtils.isEmpty(lng) ||
                TextUtils.isEmpty(namaGambar1) ||
                TextUtils.isEmpty(namaGambar2) ||
                TextUtils.isEmpty(namaGambar3) ||
                TextUtils.isEmpty(namaGambar4)
        //uri == null

        ) {
            MyToast("belum diisi")
        } else { //dapetin path gambar yg dipilih

            val file = File(path?.toURI())
            //ngasih nama gambar
            val namaGambar = file.name

            val sFile = RequestBody.create(MediaType.parse("image/*"), file)
            val fileToUpload = MultipartBody.Part.createFormData("file", namaGambar, sFile)
            val sNama = RequestBody.create(MediaType.parse("text/plain"), nama)
            val sdeskripsi = RequestBody.create(MediaType.parse("text/plain"), deskripsi)
            val sevent = RequestBody.create(MediaType.parse("text/plain"), event)
            val salamat = RequestBody.create(MediaType.parse("text/plain"), alamat)
            val sgambar1 = RequestBody.create(MediaType.parse("text/plain"), namaGambar1)
            val sgambar2 = RequestBody.create(MediaType.parse("text/plain"), namaGambar2)
            val sgambar3 = RequestBody.create(MediaType.parse("text/plain"), namaGambar3)
            val sgambar4 = RequestBody.create(MediaType.parse("text/plain"), namaGambar4)
            val slat = RequestBody.create(MediaType.parse("text/plain"), lng)
            val slng = RequestBody.create(MediaType.parse("text/plain"), lat)
            //tampilkan loading
            progress_circular.visibility = View.VISIBLE
            //persiapan service
            val api = RetrofitConfig.apiServices
            api.CREATE_WISATA(
                    //fileToUpload,
                    sNama,
                    sgambar1,
                    sdeskripsi,
                    sevent,
                    slat,
                    slng,
                    salamat,
                    sgambar2,
                    sgambar3,
                    sgambar4
            ).enqueue(object : Callback<id.co.blogbasbas.wisatasemarang.model.ResponseBody> {
                override fun onResponse(call: Call<id.co.blogbasbas.wisatasemarang.model.ResponseBody>, response: Response<id.co.blogbasbas.wisatasemarang.model.ResponseBody>) {
                    if (response.isSuccessful) {
                        progress_circular.visibility = View.GONE

                        try {

                            if (response.body()?.success?.equals(true)!!) {
                                Log.d(TAG, "onResponse: ")
                                val builder = AlertDialog.Builder(this@CreateActivity)
                                builder.setTitle("Complete")
                                builder.setMessage(response.body()?.message)
                                builder.setPositiveButton("OK") { dialog, id ->
                                    dialog.dismiss()
                                    val a = Intent(this@CreateActivity, MainActivity::class.java)
                                    a.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                                    startActivity(a)
                                    finish()
                                }
                                builder.create().show()
                            } else {
                                MyToast("Gagal ${response.body()?.message}")
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            MyToast("gagal 1 $e")
                            Log.d(TAG, "gagal upload : $e")
                        } catch (e: IOException) {
                            MyToast("gagal 2 $e")
                            e.printStackTrace()
                        }
                    } else {
                        MyToast("Not Succesfull$response")
                    }
                }

                override fun onFailure(call: Call<id.co.blogbasbas.wisatasemarang.model.ResponseBody>, t: Throwable) {
                    MyToast("Gagal Failure$t")
                    Log.e("TAG", "error ${t.message}")
                    progress_circular.visibility = View.GONE

                }
            })
        }
    }

    private val OPERATION_CHOOSE_PHOTO = 2
    private fun openGallery() {


        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(intent, OPERATION_CHOOSE_PHOTO)


    }

    var uri: Uri? = null
    var lat: String? = null
    var lng: String? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == OPERATION_CHOOSE_PHOTO && resultCode == Activity.RESULT_OK && data != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                handleImageOnKitkat(data)
                uri = data.getData();
            }
        } else if (requestCode == RC_MAPS && resultCode == Activity.RESULT_OK) {
            val place = PlacePicker.getPlace(this@CreateActivity, data)
            val alamat = String.format("%s", place.name)
            lat = place.latLng.latitude.toString()
            lng = place.latLng.longitude.toString()
            statusMaps!!.text = alamat
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        if (requestCode == 100) {
            openGallery()
        }
    }

    private fun getImagePath(uri: Uri?, selection: String?): String {
        var path: String? = null
        val cursor = uri?.let { contentResolver.query(it, null, selection, null, null) }
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            }
            cursor.close()
        }
        return path!!
    }

    @TargetApi(19)
    private fun handleImageOnKitkat(data: Intent?) {
        var imagePath: String? = null
        val uri = data!!.data
        //DocumentsContract defines the contract between a documents provider and the platform.
        if (DocumentsContract.isDocumentUri(this, uri)) {
            val docId = DocumentsContract.getDocumentId(uri)
            if (uri != null) {
                if ("com.android.providers.media.documents" == uri.authority) {
                    val id = docId.split(":")[1]
                    val selsetion = MediaStore.Images.Media._ID + "=" + id
                    imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            selsetion)
                } else if ("com.android.providers.downloads.documents" == uri.authority) {
                    val contentUri = ContentUris.withAppendedId(Uri.parse(
                            "content://downloads/public_downloads"), java.lang.Long.valueOf(docId))
                    imagePath = getImagePath(contentUri, null)
                }
            }
        } else if (uri != null) {
            if ("content".equals(uri.scheme, ignoreCase = true)) {
                imagePath = getImagePath(uri, null)
            } else if (uri != null) {
                if ("file".equals(uri.scheme, ignoreCase = true)) {
                    imagePath = uri.path
                }
            }
        }

        var file = File(imagePath.toString())
        val compressedImage = id.zelory.compressor.Compressor(this)
                .setMaxWidth(640)
                .setMaxHeight(480)
                .setQuality(75)
                .setCompressFormat(Bitmap.CompressFormat.PNG)
                .setDestinationDirectoryPath(
                        Environment.getExternalStoragePublicDirectory(
                                Environment.DIRECTORY_PICTURES
                        ).absolutePath
                )
                .compressToFile(file)
        path = compressedImage
        imageView?.let { Glide.with(this).load(compressedImage).into(it) }
        val files = File(path?.toURI())
        val namaGambar = files.name

        when (fileFoto) {
            1 -> {
                edt_satu.setText(namaGambar)
                uploadFoto()
            }
            2 -> {
                edt_dua.setText(namaGambar)
                uploadFoto()
            }
            3 -> {
                edt_tiga.setText(namaGambar)
                uploadFoto()
            }
            4 -> {
                edt_empat.setText(namaGambar)
                uploadFoto()
            }

        }

    }

    private fun chooseFile(file: File) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {}
    override fun onClick(view: View) {

    }

    companion object {
        private const val TAG = "CreateActivity"
        private const val RC_GALLERY = 3
        private const val RC_MAPS = 4
    }
}