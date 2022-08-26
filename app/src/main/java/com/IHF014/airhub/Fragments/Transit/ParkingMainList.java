package com.IHF014.airhub.Fragments.Transit;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.IHF014.airhub.Adapters.TrackChargesListAdapter;
import com.IHF014.airhub.Database.ParkingChargesDatabase;
import com.IHF014.airhub.Models.ParkingDetails;
import com.IHF014.airhub.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ParkingMainList extends Fragment {

    List<ParkingDetails> parkingDetailsList=new ArrayList<>();
    RecyclerView rv;


    public ParkingMainList() {
        // Required empty public constructor
        super(R.layout.fragment_parking_main_list);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_parking_main_list, container, false);

        FloatingActionButton fab=view.findViewById(R.id.fab1);
        rv=view.findViewById(R.id.parking_main_list);
        TextView charges=view.findViewById(R.id.fare_price_text);



        new ParkingChargesDatabase(getContext());
        try {
            parkingDetailsList = ParkingChargesDatabase.getDetails();
            charges.setText(String.valueOf(ParkingChargesDatabase.getSum()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new TrackChargesListAdapter(getContext(),parkingDetailsList));




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),TrackCharges.class));
            }
        });
        return view;
    }
}