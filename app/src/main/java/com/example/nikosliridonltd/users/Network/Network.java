package com.example.nikosliridonltd.users.Network;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by niko's liridon.ltd on 28/09/2017.
 */

public class Network {

    public String run(String url) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonResponse;

        jsonResponse = response.body().string();
        Log.d("Response", jsonResponse);

        return jsonResponse;
    }


}
