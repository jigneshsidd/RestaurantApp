package com.example.restaurantapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.restaurantapp.Model.RestaurantInfo;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    EditText mSearch;
    String mCityName;
    ImageView mSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch = findViewById(R.id.searchRestaurant);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mSearchView = findViewById(R.id.searchView);

        mSearch.setImeOptions(EditorInfo.IME_ACTION_DONE);

        mSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent event) {
                if(mSearch.getText().toString().trim().length() > 0){
                    mCityName = mSearch.getText().toString().trim();
                    initRequest();
                }
                return false;
            }
        });
        mSearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"hello world", Toast.LENGTH_LONG).show();
                hideKeyboard();
                if(mSearch.getText().toString().trim().length() > 0){
                    mCityName = mSearch.getText().toString().trim();
                    initRequest();
                }
            }
        });
        //mRecyclerView.setAdapter();
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.toggleSoftInput(0, 0);
        }
    }

    private void initRequest() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ApiUrls.BASE_URL.concat(mCityName), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RestaurantInfo mRestaurantInfo = new Gson().fromJson(response.toString(),RestaurantInfo.class);
                Log.d("Response",""+mRestaurantInfo.getResultsFound());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                return super.parseNetworkResponse(response);
            }

            @Override
            public HashMap<String, String> getHeaders() {
                HashMap headers = new HashMap();
                headers.put("user-key", "22bad0b91e35b1ef64352a166f27b769");
                return headers;
            }
        };
        requestQueue.add(request);
        Log.d("URL",""+request.getUrl());
    }
}