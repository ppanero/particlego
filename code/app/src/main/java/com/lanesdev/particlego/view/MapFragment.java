package com.lanesdev.particlego.view;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.gms.maps.model.Marker;
import com.lanesdev.particlego.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback {


    private ProgressBar progressBar;
    private GoogleMap mMap;
    private Marker mCurrentPoint;


    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        mMap = map;
        LatLng lhc = new LatLng(46.230374, 6.054298);
        mCurrentPoint = mMap.addMarker(new MarkerOptions().position(lhc));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lhc));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_tab_map, container, false);
        // Inflate the layout for this fragment
        progressBar = (ProgressBar)rootView.findViewById(R.id.progress_bar_map);
        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);

        return rootView;
    }

    public void updateMap(Location location) {
        mCurrentPoint.remove();
        LatLng lhc = new LatLng(location.getLatitude(), location.getLongitude());
        mCurrentPoint = mMap.addMarker(new MarkerOptions().position(lhc));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lhc));
    }
}