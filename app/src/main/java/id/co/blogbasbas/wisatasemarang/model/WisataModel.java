package id.co.blogbasbas.wisatasemarang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by idn on 10/30/2017.
 */

public class WisataModel {
    @SerializedName("id_wisata")
    @Expose
    private String idWisata;
    @SerializedName("nama_wisata")
    @Expose
    private String namaWisata;
    @SerializedName("gambar_wisata")
    @Expose
    private String gambarWisata;
    @SerializedName("deksripsi_wisata")
    @Expose
    private String deksripsiWisata;
    @SerializedName("alamat_wisata")
    @Expose
    private String alamatWisata;
    @SerializedName("event_wisata")
    @Expose
    private String eventWisata;
    @SerializedName("latitude_wisata")
    @Expose
    private String latitudeWisata;
    @SerializedName("longitude_wisata")
    @Expose
    private String longitudeWisata;
    private String gambar1;
    private String gambar2;

    public String getGambar1() {
        return gambar1;
    }

    public void setGambar1(String gambar1) {
        this.gambar1 = gambar1;
    }

    public String getGambar2() {
        return gambar2;
    }

    public void setGambar2(String gambar2) {
        this.gambar2 = gambar2;
    }

    public String getGambar3() {
        return gambar3;
    }

    public void setGambar3(String gambar3) {
        this.gambar3 = gambar3;
    }

    public String getGambar4() {
        return gambar4;
    }

    public void setGambar4(String gambar4) {
        this.gambar4 = gambar4;
    }

    private String gambar3;
    private String gambar4;



   /* public WisataModel(String id, String namaWisata,
                       String gambarWisata, String alamatWisata,
                       String deskripsiWisata, String latWisata,
                       String longWisata) {
    }
*/
    //buat 

    public String getIdWisata() {
        return idWisata;
    }

    public void setIdWisata(String idWisata) {
        this.idWisata = idWisata;
    }

    public String getNamaWisata() {
        return namaWisata;
    }

    public void setNamaWisata(String namaWisata) {
        this.namaWisata = namaWisata;
    }

    public String getGambarWisata() {
        return gambarWisata;
    }

    public void setGambarWisata(String gambarWisata) {
        this.gambarWisata = gambarWisata;
    }

    public String getDeksripsiWisata() {
        return deksripsiWisata;
    }

    public void setDeksripsiWisata(String deksripsiWisata) {
        this.deksripsiWisata = deksripsiWisata;
    }

    public String getAlamatWisata() {
        return alamatWisata;
    }

    public void setAlamatWisata(String alamatWisata) {
        this.alamatWisata = alamatWisata;
    }

    public String getEventWisata() {
        return eventWisata;
    }

    public void setEventWisata(String eventWisata) {
        this.eventWisata = eventWisata;
    }

    public String getLatitudeWisata() {
        return latitudeWisata;
    }

    public void setLatitudeWisata(String latitudeWisata) {
        this.latitudeWisata = latitudeWisata;
    }

    public String getLongitudeWisata() {
        return longitudeWisata;
    }

    public void setLongitudeWisata(String longitudeWisata) {
        this.longitudeWisata = longitudeWisata;
    }
}
