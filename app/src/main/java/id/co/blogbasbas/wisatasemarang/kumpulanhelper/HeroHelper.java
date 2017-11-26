package id.co.blogbasbas.wisatasemarang.kumpulanhelper;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressLint("SimpleDateFormat")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HeroHelper {
    private static final int DEBUG = 1;
    public static final String APP = "ojekOnlineBatch2-app";
    //public static final String BASE_URL = "http://gojeg.manggaleh.net/api/";
    //public static final String BASE_URL_IMAGE = "http://gojeg.manggaleh.net/img/";

    //BASE_URL + daftar
    //BASE_URL + login
    public static void alert(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);


        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Showing Alert Message
        alertDialog.show();


    }



    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }


    public static void error(Exception e) {
        if (DEBUG == 1) {
            e.printStackTrace();
        }
    }

    public static void error(Exception e, String x) {
        if (DEBUG == 1) {
            log(x);
            e.printStackTrace();
        }

    }

    public static void showSettingGps(final Context context) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);

        alertBuilder.setTitle("GPS Setting");
        alertBuilder
                .setMessage("GPS is not enabled. Do you want to go to settings menu?");

        alertBuilder.setPositiveButton("Setting",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                    }
                });
        alertBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
        alertBuilder.show();
    }

    public static boolean isOnline(Context c) {
        ConnectivityManager cm = (ConnectivityManager) c
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    // peringatan jika internet tidak konek
    public static void alertMessageNoInternet(Context c) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setMessage(
                "Anda tidak terkoneksi dengan internet, Silahkan Aktifkan Internet Anda terlebih dahulu.")
                .setCancelable(false)
                .setTitle("Informasi Internet")
                .setNegativeButton("Tutup",
                        new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog,
                                                @SuppressWarnings("unused") final int id) {
                                dialog.cancel();
                            }
                        });
        final AlertDialog alert = builder.create();
        alert.show();
    }


    public static String tglJamSekarangFile() {
        DateFormat formatter1 = new SimpleDateFormat("yyyyMMdd_HHmmss");

        Date now = new Date();
        HeroHelper.pre("tgl simpan: " + formatter1.format(now));
        return formatter1.format(now);
    }

    public static File getFileScan(String fileName) {
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "simvasi");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdir()) {
                Log.d("error", "Failed to create directory");
            }
        }

        File file = new File(mediaStorageDir, fileName);

        return file;
    }

    public static File saveFile(Bitmap bmp, String nama) {

        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "panenid");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdir()) {
                Log.d("error", "Failed to create directory");
            }
        }

        File file = null;
        try {
            file = new File(mediaStorageDir, nama + ".png");
            FileOutputStream fOut = new FileOutputStream(file);

            bmp.compress(Bitmap.CompressFormat.PNG, 85, fOut);
            fOut.flush();
            fOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return file;
    }

    public static String timeConversion(int totalSeconds) {

        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;

        int seconds = totalSeconds % SECONDS_IN_A_MINUTE;
        int totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        int minutes = totalMinutes % MINUTES_IN_AN_HOUR;
        int hours = totalMinutes / MINUTES_IN_AN_HOUR;

        if (hours == 0) {
            return minutes + " minutes";
        } else {
            return hours + " hours " + minutes + " minutes ";
        }
        // return hours + " hours " + minutes + " minutes " + seconds +
        // " seconds";

    }

    public static String timeConversion2(int totalSeconds) {

        final int MINUTES_IN_AN_HOUR = 60;
        final int SECONDS_IN_A_MINUTE = 60;

        int seconds = totalSeconds % SECONDS_IN_A_MINUTE;
        int totalMinutes = totalSeconds / SECONDS_IN_A_MINUTE;
        int minutes = totalMinutes % MINUTES_IN_AN_HOUR;
        int hours = totalMinutes / MINUTES_IN_AN_HOUR;

        // return hours + " hours " + minutes + " minutes " + seconds +
        // " seconds";
        return String.format("%02d", hours) + ":"
                + String.format("%02d", minutes) + ":"
                + String.format("%02d", seconds);
    }

    public static void pesan(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }

    public static boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isCompare(EditText etText, EditText ex) {
        String a = etText.getText().toString();
        String b = ex.getText().toString();
        if (a.equals(b)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isBatasUsia(EditText etText, int batas) {
        String a = etText.getText().toString();
        Date usia = strTodate(a);
        Date sekarang = dateAddYear(strTodate(tglSekarang()), batas);
        if (usia.before(sekarang)) {
            return false;
        } else {
            return true;
        }
    }

    public static void pre(String pesan) {
        try {
            if (DEBUG == 1) {
                System.out.println(pesan);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static boolean isBatasTanggal(EditText etText, int batas) {
        String a = etText.getText().toString();
        Date usia = strTodate(a);
        Date sekarang = dateKurang(strTodate(tglSekarang()), batas);
        pre("tanggal pilih : " + usia.toString() + " --- tanggal batas : "
                + sekarang.toString());
        if (usia.after(sekarang)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * method is used for checking valid email id format.
     *
     * @param email
     * @return boolean true for valid false for invalid
     */
    public static boolean isEmailValid(EditText email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email.getText().toString();

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean minLength(EditText etText, int jmlh) {
        if (etText.getText().toString().trim().length() >= jmlh) {
            return false;
        } else {
            return true;
        }
    }

    // untuk check koneksi internet
    public static boolean isOnline(ConnectivityManager cm) {
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    // md5 encrypt function
    public static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String tglSekarang() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String tglSekarang(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String tglSekarangNyatu() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy_HHmm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String jamSekarang() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String jamSekarang2() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String tglJamSekarang() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String tglJamSekarang2() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String tglJamSql() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static Date strTodate(String data) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = null;
        String newDateString = "";
        try {
            startDate = df.parse(data);
            // newDateString = df.format(startDate);
            System.out.println(newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return startDate;
    }

    public static Date strTodate(String data, String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date startDate = null;
        String newDateString = "";
        try {
            startDate = df.parse(data);
            // newDateString = df.format(startDate);
            System.out.println(newDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return startDate;
    }

    public static String formatInt(int data) {
        DecimalFormat nft = new DecimalFormat("#00.###");
        return nft.format(data);
    }

    public static String dateToString(Date data) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String newDateString = "";
        newDateString = df.format(data);
        return newDateString;
    }

    public static Date dateAdd(Date in, int daysToAdd) {
        if (in == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(in);
        cal.add(Calendar.DAY_OF_MONTH, daysToAdd);
        return cal.getTime();

    }

    public static Date dateKurang(Date in, int daysToAdd) {
        if (in == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(in);
        cal.add(Calendar.DAY_OF_MONTH, -daysToAdd);
        return cal.getTime();

    }

    public static Date dateAddYear(Date in, int tahun) {
        if (in == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(in);
        cal.add(Calendar.YEAR, tahun);
        return cal.getTime();

    }

    public static String toRupiahFormat(String nominal) {

        DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("");
        dfs.setMonetaryDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        // String rupiah = df.format(Double.parseDouble(nominal)) + ",-";
        String rupiah = df.format(d(nominal));

        return rupiah;
    }

    public static String toRupiahFormat2(String nominal) {

        DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance();

        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setCurrencySymbol("");
        dfs.setMonetaryDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        // String rupiah = df.format(Double.parseDouble(nominal)) + ",-";
        //df.setDecimalSeparatorAlwaysShown(desimal);
        df.setMaximumFractionDigits(0);
        String rupiah = df.format(d(nominal));

        return rupiah;
    }

    public static String getDeviceId(Context context) {
        final String deviceId = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        if (deviceId != null) {
            return deviceId;
        } else {
            return Build.SERIAL;
        }
    }

    public static String getDeviceUUID(Context context) {
        final TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = ""
                + Secure.getString(context.getContentResolver(),
                Secure.ANDROID_ID);

        String deviceMobileNo = tm.getLine1Number();

        UUID deviceUuid = new UUID(androidId.hashCode(),
                ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString();

    }

    public static void alert(Context context, String title, String message,
                             Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        if (status != null)
            // Setting alert dialog icon
//            alertDialog.setIcon((status) ? R.drawable.successicon
//                    : R.drawable.erroricon);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });

        // Showing Alert Message
        alertDialog.show();
    }

    public static void log(String pesan) {
        if (DEBUG == 1) {
            Log.d(APP, pesan);
        }
    }

    public static OutputStream writeFile(String fileName) {
        OutputStream fileOut = null;
        try {
            File file = new File(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

            if (file.exists()) {
                fileOut = new FileOutputStream(file);
            } else {
                file.createNewFile();
                fileOut = new FileOutputStream(file);
            }

        } catch (IOException e) {
            log(e.toString());
            e.printStackTrace();

        }

        return fileOut;
    }

    public static File getFile(String fileName) {
        File file = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);

        return file;
    }

    public static Double d(String transPokok) {
        Double x = 0.0;
        try {
            x = Double.parseDouble(transPokok);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return x;
    }

    public static String s(Double jml) {
        // TODO Auto-generated method stub
        return String.valueOf(jml);
    }

    //hitung masa panen
    public static int posisiPanen(String tglTanam, String masapanen) {
        int hasil = 1;

        String x[] = tglTanam.split("-");
        tglTanam = x[2] + "-" + x[1] + "-" + x[0];
        //hitung selisih tanggal sekarang dengan tanggal tanam
        int selisih = getBedaHari(strTodate(tglSekarang()), strTodate(tglTanam));

        int range = (int) Integer.parseInt(masapanen) / 3;
        int range1 = range + range;
        int range2 = range + range1;


        if (selisih < range) {
            hasil = 1;
        } else if (selisih >= range && selisih <= range1) {
            hasil = 2;
        } else if (selisih > range1) {
            hasil = 3;
        }

        log("selesih : " + String.valueOf(selisih) + ", range :"
                + String.valueOf(range) + ", hasil :" + String.valueOf(hasil));


        return hasil;
    }

    public static int getBedaHari(Date dateOne, Date dateTwo) {
        long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
        int diff = (int) (timeDiff / (1000 * 60 * 60 * 24));
        return diff;
    }

    public static String tglToInd(String tgl) {
        String x[] = tgl.split("-");
        return x[2] + " " + getBulan(x[1]) + " " + x[0];
    }

    public static String tglToInd3(String tgl) {
        String x[] = tgl.split(" ")[0].split("-");
        return x[2] + " " + getBulan(x[1]) + " " + x[0];
    }

    public static String tglJamToInd(String tgl) {
        String x[] = tgl.split("-");
        String x1[] = x[2].split(" ");
        return x1[0] + " " + getBulan(x[1]) + " " + x[0] + " " + x1[1];
    }

    public static String tglToIndBlnThn(String tgl) {
        String x[] = tgl.split("-");
        return getBulan(x[1]) + " " + x[0];
    }

    public static String tglToInd2(String tgl) {
        String x[] = tgl.split("-");
        return x[2] + "/" + x[1] + "/" + x[0].substring(2);
    }

    public static String getBulan(String i) {
        String hasil = "";
        if (i.equalsIgnoreCase("01")) {
            hasil = "Januari";
        } else if (i.equalsIgnoreCase("02")) {
            hasil = "Februari";
        } else if (i.equalsIgnoreCase("03")) {
            hasil = "Maret";
        } else if (i.equalsIgnoreCase("04")) {
            hasil = "April";
        } else if (i.equalsIgnoreCase("05")) {
            hasil = "Mei";
        } else if (i.equalsIgnoreCase("06")) {
            hasil = "Juni";
        } else if (i.equalsIgnoreCase("07")) {
            hasil = "Juli";
        } else if (i.equalsIgnoreCase("08")) {
            hasil = "Agustus";
        } else if (i.equalsIgnoreCase("09")) {
            hasil = "September";
        } else if (i.equalsIgnoreCase("10")) {
            hasil = "Oktober";
        } else if (i.equalsIgnoreCase("11")) {
            hasil = "November";
        } else if (i.equalsIgnoreCase("12")) {
            hasil = "Desember";
        }

        return hasil;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double round(double value) {
        if (2 < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String round(String value) {
        try {
            double dx = d(value);
            if (2 < 0) throw new IllegalArgumentException();

            BigDecimal bd = new BigDecimal(dx);
            bd = bd.setScale(2, RoundingMode.HALF_UP);


            return s(bd.doubleValue());
        } catch (Exception e) {
            e.printStackTrace();

            return value;
        }
    }

    public static String statusTransaksi(String status) {
        String hasil = "proses";

        switch (Integer.parseInt(status)) {
            case 1:
                hasil = "Proses";
                break;
            case 2:
                hasil = "Belum Transfer";
                break;
            case 3:
                hasil = "Sudah Transfer";
                break;
            case 4:
                hasil = "Selesai";
                break;
            case 9:
                hasil = "hapus";
                break;

        }

        return hasil;
    }

    /*public static Bitmap getBitmap(String url,Context context)
    {
        FileCache fileCache=new FileCache(context);
        MemoryCache memoryCache=new MemoryCache();
        File f=fileCache.getFile(url);
        //from SD cache
        //CHECK : if trying to decode file which not exist in cache return null
        Bitmap b = decodeFile(f);
        if(b!=null)
            return b;
        // Download image file from web
        try {
            Bitmap bitmap=null;
            URL imageUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)imageUrl.openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(true);
            InputStream is=conn.getInputStream();
            // Constructs a new FileOutputStream that writes to file
            // if file not exist then it will create file
            OutputStream os = new FileOutputStream(f);
            // See Utils class CopyStream method
            // It will each pixel from input stream and
            // write pixels to output stream (file)
            CopyStream(is, os);
            os.close();
            conn.disconnect();
            //Now file created and going to resize file with defined height
            // Decodes image and scales it to reduce memory consumption
            b = decodeFile(f);
            return bitmap;

        } catch (Throwable ex){
            ex.printStackTrace();
            if(ex instanceof OutOfMemoryError)
                memoryCache.clear();
            return null;
        }
    }*/

    //Decodes image and scales it to reduce memory consumption
    private static Bitmap decodeFile(File f) {

        try {
            //Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            FileInputStream stream1 = new FileInputStream(f);
            BitmapFactory.decodeStream(stream1, null, o);
            stream1.close();
            //Find the correct scale value. It should be the power of 2.
            // Set width/height of recreated image
            final int REQUIRED_SIZE = 85;
            int width_tmp = o.outWidth, height_tmp = o.outHeight;
            int scale = 1;
            while (true) {
                if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE)
                    break;
                width_tmp /= 2;
                height_tmp /= 2;
                scale *= 2;
            }

            //decode with current scale values
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            FileInputStream stream2 = new FileInputStream(f);
            Bitmap bitmap = BitmapFactory.decodeStream(stream2, null, o2);
            stream2.close();
            return bitmap;

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void CopyStream(InputStream is, OutputStream os) {
        final int buffer_size = 1024;
        try {
            byte[] bytes = new byte[buffer_size];
            for (; ; ) {
                int count = is.read(bytes, 0, buffer_size);
                if (count == -1)
                    break;
                os.write(bytes, 0, count);
            }
        } catch (Exception ex) {
        }
    }

    public static String getShelter(String status) {
        String hasil = "Manggarai";

        switch (Integer.parseInt(status)) {
            case 1:
                hasil = "Manggarai";
                break;
            case 2:
                hasil = "Dukuh Atas";
                break;

        }

        return hasil;
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public static Bitmap base64ToBitmap(String b64) {
        byte[] imageAsBytes = Base64.decode(b64.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }

    public static String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    public static double distance(double lat1, double lng1, double lat2, double lng2, String unit){
        double earthRadius = 6371.0;
        if (unit.equalsIgnoreCase("M")){
            earthRadius = 6371 * 1000;
        }else if(unit.equalsIgnoreCase("N")){
            earthRadius=6371.75;
        }
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double sindLat =Math.sin(dLat / 2);
        double sindLng =Math.sin(dLng / 2);

        double a = Math.pow(sindLat,2)+Math.pow(sindLng,2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;
        return dist;

    }

}
