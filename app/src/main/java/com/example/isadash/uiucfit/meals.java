package com.example.isadash.uiucfit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
//import android.widget.SearchView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.isadash.uiucfit.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Main screen for our API testing app.
 */
public final class meals extends AppCompatActivity {
    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "Lab12:Main";

    /** Request queue for our network requests. */
    private static RequestQueue requestQueue;

    /**
     * textview.
     */
    private TextView result;
    private EditText name;

    private ArrayList<String> foodList = new ArrayList<>();

    /**
     * Run when our activity comes into view.
     *
     * @param savedInstanceState state that was saved by the activity last time it was paused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up a queue for our Volley requests
        requestQueue = Volley.newRequestQueue(this);

        // Load the main layout for our activity
        setContentView(R.layout.activity_meals);

        result = (TextView) findViewById(R.id.jsonResult);

        // Attach the handler to our UI button
        final Button startAPICall = findViewById(R.id.startAPICall);
        startAPICall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Start API button clicked");
                startAPICall();
            }
        });

        // Make sure that our progress bar isn't spinning and style it a bit
        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        name = (EditText) findViewById(R.id.editName);
    }

    /**
     * Make an API call.
     */
    void startAPICall() {
        try {
            final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://api.nutritionix.com/v1_1/search/" + name.getText().toString() + "?fields="
                            + "item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat&appId"
                            + "=6f9c1ffc&appKey=1613243ba6a63128f123070d59f18b5a",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            //Log.d(TAG, response.toString());

                            try {
                                JSONArray array = response.getJSONArray("hits");
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject object = array.getJSONObject(i);
                                    JSONObject details = object.getJSONObject("fields");

                                    String foodName = details.getString("item_name") + "\n" + " CALORIES: " + details.getString("nf_calories");
                                    foodList.add(foodName);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            String list = "";
                            for (String food: foodList) {
                                list = list + "\n" + food;
                            }

                            result.setText(list);
                            foodList.clear();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.w(TAG, error.toString());
                }
            });

            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

