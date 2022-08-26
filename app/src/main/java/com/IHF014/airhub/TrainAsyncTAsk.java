package com.IHF014.airhub;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.IHF014.airhub.Models.TrainData;
import com.IHF014.airhub.Queries.TrainQueryUtils;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainAsyncTAsk extends AsyncTaskLoader {

    List<TrainData> trainList=new ArrayList<>();
        String trainName="";
        String trainNumber="";

    public TrainAsyncTAsk(Context context,String trainName,String trainNumber)
    {
        super(context);
        this.trainName= trainName;
        this.trainNumber=trainNumber;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<TrainData> loadInBackground() {
        try {
            String jsonResponse= TrainQueryUtils.makeHttpRequest(trainName,trainNumber);
            trainList=TrainQueryUtils.parseJsonResponse(jsonResponse);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return trainList;
    }
}
