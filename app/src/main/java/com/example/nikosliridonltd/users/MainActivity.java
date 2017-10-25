package com.example.nikosliridonltd.users;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.nikosliridonltd.users.Adapters.Adapter;
import com.example.nikosliridonltd.users.Models.User;
import com.example.nikosliridonltd.users.Network.Network;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;
    private Network networkRequest;
    NetworkRequest network = new NetworkRequest();
    private ListView userListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        networkRequest = new Network();
        network.execute();
    }

    public void findViews(){
        userListView = (ListView)findViewById(R.id.userList);
    }

    private class NetworkRequest extends AsyncTask<Void,Void,String> {

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            populateList(User.createUsers(result));
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                return  networkRequest.run("https://randomuser.me/api/?results=10");
            } catch (IOException e) {
                return null;
            }
        }
    }

    private void populateList(List<User> list){
        adapter = new Adapter(this, list);
        userListView.setAdapter(adapter);
    }
}

