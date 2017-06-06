package com.example.sandeep.myapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sandeep.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Find_Us extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find__us);
        initMap();
    }

    private void initMap() {

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map)
    {

        LatLng latLng = new LatLng(13.05241, 80.25082);
        map.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,12.0f));
        map.addMarker(new MarkerOptions().position(latLng).title("Delicioso"));
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }
}
