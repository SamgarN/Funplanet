package com.example.samgar.funplanet.fragment;

/**
 * Created by samgar on 12/5/16.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.samgar.funplanet.AppControler.AppController;
import com.example.samgar.funplanet.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TabFragment1 extends Fragment {
TextView  textView;
    ProgressDialog dialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        RequestQueue rq = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url= "http://api.androidhive.info/contacts/";
textView=(TextView)inflater.inflate(R.layout.tab_fragment_1, container, false).findViewById(R.id.textView);


        dialog = new ProgressDialog(getActivity()) ;
        dialog.setMessage("Күту тұрыңыз...");
        dialog.setCancelable(false);
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                         // Do something with the response

                        try{


                            JSONObject o = new JSONObject(response);

                            JSONArray values=o.getJSONArray("contacts");



                            for ( int i=0; i< values.length(); i++) {


                                JSONObject sonuc = values.getJSONObject(i);


                                textView.append("Flight: " + sonuc.getString("id") + "\n");
                                textView.setText("samgar");
                                textView.append("name: " + sonuc.getString("name") + "\n\n");

                                Toast.makeText(getActivity().getApplicationContext(),sonuc.getString("name").toString(),Toast.LENGTH_SHORT).show();
                                Log.e("-------",sonuc.getString("name").toString());
                            }




                        }  catch (JSONException ex){

                            Log.e("jan--------2","hate");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(),"hate boldi",Toast.LENGTH_LONG).show();
                        Log.e("jan--------3","hate");
                    }
                });

rq.add(stringRequest);


rq.add(stringRequest);
        hideDialog();

        return inflater.inflate(R.layout.tab_fragment_1, container, false);   }


    public void showDialog(){
        if(!dialog.isShowing())
            dialog.show();
    }

    public void hideDialog(){
        if(dialog.isShowing())
            dialog.hide();

    }

}