package id.co.blogbasbas.wisatasemarang.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import id.co.blogbasbas.wisatasemarang.R;
import id.co.blogbasbas.wisatasemarang.adapter.WisataAdapter;
import id.co.blogbasbas.wisatasemarang.model.ListWisataModel;
import id.co.blogbasbas.wisatasemarang.model.WisataModel;
import id.co.blogbasbas.wisatasemarang.network.ApiServices;
import id.co.blogbasbas.wisatasemarang.network.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
        RecyclerView recyclerView;
    ArrayList<WisataModel> listData;
        Context context;
    RecyclerView.LayoutManager layoutManager;
    ProgressBar pd;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerWisata);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);



        pd = (ProgressBar) view.findViewById(R.id.pd);
                //Data
        listData = new ArrayList<>();
        ambilData();
        // layout manager
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), gridColumnCount));

        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        return view;



    }
    private void ambilData() {
        pd.setVisibility(View.VISIBLE);
//        final ProgressDialog progress = new ProgressDialog(getActivity());
/*
        progress.setTitle("Loading");
        progress.setMessage("Mohon Bersabar");
        progress.show();
*/

        ApiServices api = RetrofitConfig.getApiServices();
        Call<ListWisataModel> call = api.ambilDataWisata();
        call.enqueue(new Callback<ListWisataModel>() {
            @Override
            public void onResponse(Call<ListWisataModel> call, Response<ListWisataModel> response) {
                pd.setVisibility(View.GONE);
                if (response.isSuccessful()){
                    if(response.body().getSuccess().toString().equals("true")){
                        listData = response.body().getWisata();
                        WisataAdapter adapter = new WisataAdapter(listData, getActivity());
                        recyclerView.setAdapter(adapter);

                        //ngetes data di log
                        for (int i = 0; i < listData.size(); i++) {
                            Log.d(TAG, "onResponse: " + listData.get(i).getGambarWisata());
                        }
                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Respones is Not Succesfull", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListWisataModel> call, Throwable t) {
                Toast.makeText(getActivity(), "Response Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
