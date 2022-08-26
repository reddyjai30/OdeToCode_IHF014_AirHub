package com.IHF014.airhub.Fragments.Transit;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.IHF014.airhub.Actvities.Transit_Parking;
import com.IHF014.airhub.databinding.FragmentTransportationBinding;


public class TransportationFragment extends Fragment {


    public TransportationFragment() {
        // Required empty public constructor

    }

    FragmentTransportationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTransportationBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        binding.travelBus.setOnClickListener(new View.OnClickListener() {
                                           public final void onClick(View it) {
                                             Intent i = new Intent(getActivity(),Transit_Bus.class);
                                             startActivity(i);

                                           }
                                       });
        binding.travelCab.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getActivity(),Transit_Cab.class);
                startActivity(i);
            }
        });
        binding.traveTrains.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                Intent i = new Intent(getActivity(),Transit_Train.class);
                startActivity(i);
            }
        });
       /* binding.navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),SmartTravel.class);
                startActivity(i);
            }
        });*/


        binding.travelParking.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View it) {
                binding.progressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(getActivity(), Transit_Parking.class);
                startActivity(i);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onStop() {
        super.onStop();
        binding.progressBar.setVisibility(View.INVISIBLE);
    }
}