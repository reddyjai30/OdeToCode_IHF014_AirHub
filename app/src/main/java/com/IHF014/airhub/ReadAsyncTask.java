package com.IHF014.airhub;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.IHF014.airhub.Database.ParkingChargesDatabase;
import com.IHF014.airhub.Models.ParkingDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadAsyncTask extends AsyncTask<Void,Void, List<ParkingDetails>> {

   List<ParkingDetails> list=new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override

    protected List<ParkingDetails> doInBackground(Void... voids) {
        try {
            list=ParkingChargesDatabase.getDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
