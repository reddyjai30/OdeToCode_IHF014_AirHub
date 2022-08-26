package com.IHF014.airhub.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.IHF014.airhub.Fragments.Flights.ExploreAirport_About;
import com.IHF014.airhub.Fragments.Flights.ExploreAirport_Photos;
import com.IHF014.airhub.Fragments.Flights.AllFlights;
import com.IHF014.airhub.Fragments.Flights.DirectFlights;
import com.IHF014.airhub.Fragments.Flights.FlightsArrival;
import com.IHF014.airhub.Fragments.Flights.FlightDeparture;
import com.IHF014.airhub.Fragments.Flights.FromToFlights;
import com.IHF014.airhub.Fragments.Flights.NumSearchFlights;
import com.IHF014.airhub.Fragments.Transit.Ac;
import com.IHF014.airhub.Fragments.Transit.AirportTaxi;
import com.IHF014.airhub.Fragments.Transit.AppBasedTaxi;
import com.IHF014.airhub.Fragments.Transit.CarRentals;
import com.IHF014.airhub.Fragments.Transit.ChargesFragment;
import com.IHF014.airhub.Fragments.Transit.NonAc;
import com.IHF014.airhub.Fragments.Transit.ParkingMainList;
import com.IHF014.airhub.Fragments.Transit.Transit_Cab_Ola;
import com.IHF014.airhub.Fragments.Transit.Transit_Cab_Uber;
import com.IHF014.airhub.Fragments.Transit.WomenTaxi;
import com.IHF014.airhub.Fragments.TransitBusFly;
import com.IHF014.airhub.Fragments.TransitBusVV;
import com.IHF014.airhub.Fragments.hotels.NearBlrHotels;
import com.IHF014.airhub.Fragments.hotels.SearchHotels;
import com.IHF014.airhub.Fragments.restaurants.PostSecurityRes;
import com.IHF014.airhub.Fragments.restaurants.PreSecurityRes;
import com.IHF014.airhub.Fragments.shopping.DomesticShops;
import com.IHF014.airhub.Fragments.shopping.InternationalShops;

public class FragmentAdapter extends FragmentPagerAdapter {

    int uniqueL;

    public FragmentAdapter(@NonNull FragmentManager fm, int uniqueL) {
        super(fm);
        this.uniqueL = uniqueL;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if(uniqueL == 1) {
            switch (position) {
                case 0:
                    return new FlightsArrival();
                case 1:
                    return new FlightDeparture();
                default:
                    return new FlightDeparture();
            }
        }
        else if(uniqueL == 2) {                       // uniqueL == 2
            switch (position) {
                case 0:
                    return new FromToFlights();
                case 1:
                    return new NumSearchFlights();
                default:
                    return new FromToFlights();
            }
        }
        else if(uniqueL == 4){
            switch (position){
                case 0: return new AppBasedTaxi();

                case 2: return new CarRentals();
                case 1: return new AirportTaxi();
                default: return new AppBasedTaxi();
            }
        }
        else if(uniqueL == 5){
            switch (position){
                case 0: return new ExploreAirport_About();
                case 1: return new ExploreAirport_Photos();
                default: return new ExploreAirport_About();
            }
        }
        else if(uniqueL == 6){
            switch (position){
                case 0: return new TransitBusVV();
                case 1: return new TransitBusFly();
                default: return new TransitBusVV();
            }
        } else if(uniqueL == 7){
            switch (position){
                case 0: return new PreSecurityRes();
                case 1: return new PostSecurityRes();
                default: return new PreSecurityRes();
            }
        } else if(uniqueL == 8){
            switch (position){
                case 0: return new DomesticShops();
                case 1: return new InternationalShops();
                default: return new DomesticShops();
            }
        } else if(uniqueL == 10){
            switch (position){
                case 0: return new ChargesFragment();
                case 1: return new ParkingMainList();
                default: return new ChargesFragment();
            }
        } else if(uniqueL == 11){
            switch (position){
                case 0: return new NearBlrHotels();
                case 1: return new SearchHotels();
                default: return new NearBlrHotels();
            }
        }
        else if(uniqueL == 15){
            switch (position){
                case 1: return new Transit_Cab_Ola();

                case 0: return new Transit_Cab_Uber();
                default: return new Transit_Cab_Uber();
            }
        }
        else if(uniqueL == 16){
            switch (position){
                case 0: return new NonAc();

                case 1: return new Ac();
                case 2: return new WomenTaxi();
                default: return new Ac();
            }
        }
        else{
            switch (position){
                case 0: return new AllFlights();
                case 1: return new DirectFlights();
                default: return new AllFlights();
            }
        }

    }

    @Override
    public int getCount() {
        if(uniqueL == 4||uniqueL == 16)
        {
            return 3;
        }
        else
        {
            return 2;
        }
              // for now both the Activity's and Fragment's have 2 child
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String title = null;
        if(uniqueL == 1) {
            if (position == 0) {
                title = "Arrivals";
            } else if (position == 1) {
                title = "Departures";
            }
        }
        else if(uniqueL == 2){
            if(position==0){
                title = "From / To";
            }
            else if(position==1){
                title = "Flight Number";
            }
        }
        else if(uniqueL == 4){
            if(position==0){
                title = "App Based";
            }
            else if(position==2){
                title = "Car Rentals";
            }
            else if(position==1){
                title = "Airport Taxi";
            }

        }   else if(uniqueL == 5){
            if(position==0){
                title = "About";
            }
            else if(position==1){
                title = "Photos";
            }
        }
        else if(uniqueL == 6){
            if(position==0){
                title = "Vayu Vajra";
            }
            else if(position==1){
                title = "Fly Bus";
            }
        } else if(uniqueL == 7){
            if(position==0){
                title = "Pre-Security";
            }
            else if(position==1){
                title = "Post-Security";
            }
        } else if(uniqueL == 8){
            if(position==0){
                title = "Domestic";
            }
            else if(position==1){
                title = "International";
            }
        } else if(uniqueL == 10){
            if(position==0){
                title = "Parking charges";
            }
            else if(position==1){
                title = "Track Charges";
            }
        } else if(uniqueL == 11){
            if(position==0){
                title = "Near Airport";
            }
            else if(position==1){
                title = "Search Hotels";
            }
        }
        else if(uniqueL == 15){
            if(position==0){
                title = "Uber";
            }
            else if(position==1){
                title = "Ola";
            }
        }
        else if(uniqueL == 16){
            if(position==0){
                title = "Non-Ac (KSTDC only)";
            }
            else if(position==1){
                title = "Ac";
            }
            else if(position==2){
                title = "Women Taxi(KSTDC only,AC sedan)";
            }
        }
        else{
            if(position==0){
                title = "All Flights";
            }
            else if(position==1){
                title = "Direct";
            }
        }

        return title;
    }

}
