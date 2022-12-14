package com.IHF014.airhub.Actvities.FlightAcitivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.IHF014.airhub.Adapters.FlightStopsAdapter;
import com.IHF014.airhub.Models.FSModel;
import com.IHF014.airhub.databinding.ActivityFlightSearchDetailsBinding;

import java.util.ArrayList;

public class FlightSearchDetails extends AppCompatActivity {

    ActivityFlightSearchDetailsBinding binding;
    private String JsonResponseLink = "";
    private String jsonStart = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/flight/status/";
    private String jsonEnd = "?appId=bb42e12a&appKey=c4c20e505e572662f461bc4f2bdada53&utc=false";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlightSearchDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FSModel itemModel = getIntent().getParcelableExtra("curModel");
        ArrayList<FSModel.FlightSpots> itemModelList = getIntent().getParcelableArrayListExtra("curModelList");

        FSModel.FlightSpots spots1 = itemModelList.get(0);
        FSModel.FlightSpots spots2 = itemModelList.get(itemModelList.size()-1);

        String dateArrival = spots1.getDepartureTime();
        String dateAr = dateArrival.substring(0,10);
        String timeAr = dateArrival.substring(11,16);

        String dateDeparture = spots2.getArrivalTime();
        //  String dateDep = dateDeparture.substring(0,10);
        String timeDep = dateDeparture.substring(11,16);

        binding.dateSS.setText(dateAr);
        binding.time1SS.setText(timeAr);
        binding.time2SS.setText(timeDep);

        binding.airportCode1SS.setText(spots1.getDepartureAirport());
        binding.airportCode2SS.setText(spots2.getArrivalAirport());

        binding.flightNumberSS.setText(spots1.getAirlines()+spots1.getAirlineNumber());

        binding.flightDurationSS.setText(itemModel.getTotalJourneyDuration());
        binding.numOfStops.setText((itemModelList.size()-1)+"");

        FlightStopsAdapter flightAdapter = new FlightStopsAdapter(itemModelList,binding.recyclerView,getApplicationContext());
        binding.recyclerView.setAdapter(flightAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        flightAdapter.notifyDataSetChanged();

    }
}