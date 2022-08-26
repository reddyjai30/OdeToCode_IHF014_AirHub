package com.IHF014.airhub;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.IHF014.airhub.Database.ParkingChargesDatabase;

import java.io.IOException;

public class UpdateAsyncTask extends AsyncTask<Void,Void,Void> {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            ParkingChargesDatabase.updateElapsedTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
