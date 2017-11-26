package id.co.blogbasbas.wisatasemarang.kumpulanhelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyFunction extends AppCompatActivity {
    Animation animation;
    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c=MyFunction.this;
    }

    public void MyToast(String isipesan){
        Toast.makeText(this, isipesan, Toast.LENGTH_LONG).show();
    }
    public void aksesclass(Class kelastujuan){
        startActivity(new Intent(c,kelastujuan));
    }

    public String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }





}
