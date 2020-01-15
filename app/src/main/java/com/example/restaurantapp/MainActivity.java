package com.example.restaurantapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.restaurantapp.Adapters.RestaurantInfoAdapter;
import com.example.restaurantapp.Model.RestaurantInfo;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EditText mSearch;
    private String mCityName;
    private ImageView mSearchView;
    private RestaurantInfo mRestaurantInfo;
    private SharedPreferences mSharedPreferences;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearch = findViewById(R.id.searchRestaurant);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        mSearchView = findViewById(R.id.searchView);
        mRecyclerView = findViewById(R.id.recyclerView);
        mProgressBar = findViewById(R.id.progressbar);

        mSearch.setImeOptions(EditorInfo.IME_ACTION_DONE);

        mSharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        mSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent event) {
                hideKeyboard();
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
                hideKeyboard();
                if(mSearch.getText().toString().trim().length() > 0){
                    mCityName = mSearch.getText().toString().trim();
                    initRequest();
                }
            }
        });

        if(isCached()) {
            String cachedResponse = mSharedPreferences.getString("DATA","");
            mRestaurantInfo = new Gson().fromJson(cachedResponse,RestaurantInfo.class);
            bindData(mRestaurantInfo);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    private boolean isCached() {
        String isCached = mSharedPreferences.getString("DATA","");
        return !isCached.equals("");
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.toggleSoftInput(0, 0);
        }
    }

    private void initRequest() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, ApiUrls.BASE_URL.concat(mCityName), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mRestaurantInfo = new Gson().fromJson(response.toString(),RestaurantInfo.class);
                mSharedPreferences.edit().putString("DATA",response.toString()).apply();
                mProgressBar.setVisibility(View.GONE);
                bindData(mRestaurantInfo);
                Log.d("Response",""+mRestaurantInfo.getResultsFound());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressBar.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(),"Could not fetch the Data", Toast.LENGTH_LONG).show();
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

    private void bindData(RestaurantInfo mRestaurantInfo) {
        mRecyclerView.setVisibility(View.VISIBLE);
        RestaurantInfoAdapter mRestaurantInfoAdapter = new RestaurantInfoAdapter(mRestaurantInfo);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRestaurantInfoAdapter);
    }
}