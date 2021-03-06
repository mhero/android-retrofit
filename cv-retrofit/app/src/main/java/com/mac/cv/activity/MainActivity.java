package com.mac.cv.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mac.cv.adapter.CustomAdapter;
import com.mac.cv.model.AccountCredentials;
import com.mac.cv.model.Event;
import com.mac.cv.network.GetDataService;
import com.mac.cv.network.RetrofitClientInstance;
import com.mac.cv.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        final GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        Call<Void> tokenCall = service.geToken(new AccountCredentials("admin", "password"));
        tokenCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                progressDialog.dismiss();
                token = response.headers().get("Authorization");

                Call<List<Event>> eventCall = service.getAllEvents(token);
                eventCall.enqueue(new Callback<List<Event>>() {

                    @Override
                    public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                        progressDialog.dismiss();
                        generateDataList(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Event>> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });




    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<Event> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
