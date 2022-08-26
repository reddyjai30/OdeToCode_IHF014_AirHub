package com.IHF014.airhub.Fragments.restaurants;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.IHF014.airhub.Adapters.RestaurantShoppingAdapter;
import com.IHF014.airhub.Models.RestaurantShoppingModel;
import com.IHF014.airhub.Queries.RestaurantQuery;
import com.IHF014.airhub.databinding.FragmentPostSecurityResBinding;

import java.net.URL;
import java.util.ArrayList;

public class PostSecurityRes extends Fragment {

    public PostSecurityRes() {
        // Required empty public constructor
    }

    FragmentPostSecurityResBinding binding;
    private String JsonResponseLink = "https://springboot-restapi.azurewebsites.net/restaurants";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostSecurityResBinding.inflate(getLayoutInflater());

        RestaurantAsyncTask task = new RestaurantAsyncTask();
        task.execute();

        return binding.getRoot();
    }

    protected void updateUi(ArrayList<RestaurantShoppingModel> restaurantList){

        if (restaurantList.size() == 0){
            binding.emptyTextView.setVisibility(View.VISIBLE);
        }
        RestaurantShoppingAdapter adapter = new RestaurantShoppingAdapter(restaurantList, binding.recyclerView, getContext());
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();

    }

    private class RestaurantAsyncTask extends AsyncTask<URL, Void, ArrayList<RestaurantShoppingModel>> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected ArrayList<RestaurantShoppingModel> doInBackground(URL... urls) {
            ArrayList<RestaurantShoppingModel> event = RestaurantQuery.fetchRestaurantData(JsonResponseLink,2);            //also we can use  urls[0]
            return event;
        }

        @Override
        protected void onPostExecute(ArrayList<RestaurantShoppingModel> event) {

             binding.progressBar1.setVisibility(View.GONE);


            if (event == null) {
                // binding.emptyTextView.setVisibility(View.VISIBLE);
                return;
            }

            updateUi(event);

        }

    }

}