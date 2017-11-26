package id.co.blogbasbas.wisatasemarang.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.co.blogbasbas.wisatasemarang.R;
import id.co.blogbasbas.wisatasemarang.adapter.WisataAdapter;
import id.co.blogbasbas.wisatasemarang.db.DatabaseHelper;
import id.co.blogbasbas.wisatasemarang.model.WisataModel;

/**
 * Created by Server on 31/10/2017.
 */
public class FavoritFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseHelper database;
    ArrayList<WisataModel> listWisataFavorite;

    public FavoritFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerWisata);


        listWisataFavorite = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //  database = new DatabaseHelper(getActivity());


        ambilData();







        return view;




    }

    private void ambilData() {

        database = new DatabaseHelper(getActivity());
        listWisataFavorite = database.getDataFavorite();

        WisataAdapter adapter = new WisataAdapter(listWisataFavorite, getActivity());
        recyclerView.setAdapter(adapter);

//        Log.d(" dapat data  ", " "+listWisataFavorite.get(0).getNamaWisata());
        //listWisataFavorite = new ArrayList<>();
    }
}



