package com.IHF014.airhub;

import android.os.AsyncTask;

import com.IHF014.airhub.Database.ParkingChargesDatabase;
import java.io.IOException;

public class StorageAsyncTask extends AsyncTask<String,Void,Void> {


    @Override
    protected Void doInBackground(String... strings) {
        try {
            ParkingChargesDatabase.insertEntity(strings[0],strings[1],strings[2],strings[3]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


