package id.co.blogbasbas.wisatasemarang.map;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import id.co.blogbasbas.wisatasemarang.R;
import id.co.blogbasbas.wisatasemarang.model.ListWisataModel;
import id.co.blogbasbas.wisatasemarang.model.WisataModel;
import id.co.blogbasbas.wisatasemarang.network.ApiServices;
import id.co.blogbasbas.wisatasemarang.network.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<WisataModel> listData;
    Double lat;
    Double lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        final Object mf = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mf instanceof SupportMapFragment) {
            final SupportMapFragment smf = (SupportMapFragment) mf;
            smf.getMapAsync(this);
            // ...
        } else {
            finish();
            Toast.makeText(this, "Tidak Support", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ambilData();

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-7.0118258, 110.4111184);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Semarang Hotel").snippet(" ini Snippet").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12f));
        //intent ke map app
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(MapsActivity.this, "title", Toast.LENGTH_SHORT).show();
            // Displays an image of the Swiss Alps
                // Searches for 'Main Street' near San Francisco
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+lng+","+lat+"");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);


            }
        });
    }

    private void ambilData() {
        /*final ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Mohon Bersabar");
        progress.show();
*/
        ApiServices api = RetrofitConfig.getApiServices();
        Call<ListWisataModel> call = api.ambilDataWisata();
        call.enqueue(new Callback<ListWisataModel>() {
            @Override
            public void onResponse(Call<ListWisataModel> call, Response<ListWisataModel> response) {
           //     progress.hide();
                if (response.isSuccessful()){
                    if(response.body().getSuccess().toString().equals("true")){
                        listData = response.body().getWisata();

                        for (int i = 0; i < listData.size(); i++) {

                             lng = Double.valueOf(listData.get(i).getLongitudeWisata());
                             lat = Double.valueOf(listData.get(i).getLatitudeWisata());
                            try {
                                LatLng sydney = new LatLng(lat, lng);
                                mMap.addMarker(new MarkerOptions().position(sydney).title(listData.get(i).getNamaWisata())
                                        .snippet(listData.get(i).getAlamatWisata()));
                            } catch (Exception e){

                            }
                        }
                    } else {
                        //Toast.makeText(this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //Toast.makeText(getActivity(), "Respones is Not Succesfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListWisataModel> call, Throwable t) {
                //Toast.makeText(getActivity(), "Response Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
