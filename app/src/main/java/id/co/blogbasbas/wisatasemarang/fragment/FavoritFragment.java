package id.co.blogbasbas.wisatasemarang.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    ArrayList<WisataModel> listWisataFavorite;

    public FavoritFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerWisata);

        listWisataFavorite = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ambilData();

        return view;
    }

    private void ambilData() {
        DatabaseHelper database = new DatabaseHelper(getContext());
        listWisataFavorite = database.getDataFavorite();
        WisataAdapter adapter = new WisataAdapter(listWisataFavorite, getActivity());
        recyclerView.setAdapter(adapter);

//        Log.d(" dapat data  ", " "+listWisataFavorite.get(0).getNamaWisata());
        //listWisataFavorite = new ArrayList<>();
    }
}



