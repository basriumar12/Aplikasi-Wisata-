package id.co.blogbasbas.wisatasemarang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by idn on 10/30/2017.
 */

public class ListWisataModel {
    @SerializedName("wisata")
    @Expose
    private ArrayList<WisataModel> wisata = new ArrayList<>();
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public ArrayList<WisataModel> getWisata() {
        return wisata;
    }

    public void setWisata(ArrayList<WisataModel> wisata) {
        this.wisata = wisata;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
