package com.IHF014.airhub.Fragments.Flights;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.IHF014.airhub.databinding.FragmentExploreAirportAboutBinding;

public class ExploreAirport_About extends Fragment {

    public ExploreAirport_About() {
        // Required empty public constructor
    }

    FragmentExploreAirportAboutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentExploreAirportAboutBinding.inflate(getLayoutInflater());




        return binding.getRoot();
    }


}