package com.example.challenge1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.Pair;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity  implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, GoogleMap.OnMarkerClickListener {

    private MapView gmap;
    private GoogleMap infoMap;
    private TextView infoTXT;
    private Button markerBTN;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    ArrayList<MarkerOptions> markers = new ArrayList<>();
    ArrayList<Marker> toDeleteMarkers = new ArrayList<>();
    private  String m_text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        gmap = (MapView) findViewById(R.id.mapView);
        gmap.onCreate(mapViewBundle);

        markerBTN = findViewById(R.id.markerBTN);

        infoTXT = findViewById(R.id.infoTXT);

        infoTXT.setOnClickListener(
                (v) ->{
                    getNearestMarker();
                }
        );

        markerBTN.setOnClickListener(
                (v)->{
                    //CODE ADAPTED FROM https://stackoverflow.com/questions/10903754/input-text-dialog-android
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Nombre Lugar");


                    final EditText input = new EditText(this);

                    builder.setView(input);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            m_text = input.getText().toString();
                            if(infoMap != null){
                                Location currLoc = infoMap.getMyLocation();

                                MarkerOptions mar =new MarkerOptions().position(new LatLng(currLoc.getLatitude(), currLoc.getLongitude())).title(m_text);
                                infoMap.addMarker(mar);
                                markers.add(mar);

                            }
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();

                }
        );

        gmap.getMapAsync(this);

    }

    protected void getNearestMarker(){
        if(markers.size()>0){
            LatLng currLoc = new LatLng(infoMap.getMyLocation().getLatitude(), infoMap.getMyLocation().getLongitude());
            TreeMap<Double, String> processed = new TreeMap<>();
            for(MarkerOptions m: markers){
                processed.put(CalculationByDistance(currLoc,m.getPosition()), m.getTitle());
            }
            double lowestDis = processed.firstKey();
            if(lowestDis <20){
                infoTXT.setText("You are in "+ processed.get(lowestDis));
            }else{
                infoTXT.setText("The nearest marker place is "+ processed.get(lowestDis));
            }

        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        gmap.onSaveInstanceState(mapViewBundle);
    }
    @Override
    protected void onResume() {
        super.onResume();
        gmap.onResume();
    }


    @Override
    protected void onStart() {
        super.onStart();
        gmap.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        gmap.onStop();
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        infoMap = map;

     //   map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        map.setMyLocationEnabled(true);
        map.setOnMyLocationButtonClickListener(this);
        map.setOnMyLocationClickListener(this);

        map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location arg0) {
                map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(arg0.getLatitude(),arg0.getLongitude())));
                //map.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(), arg0.getLongitude())).title("It's Me!"));
            }
        });
        map.setMinZoomPreference(3.0f);
        map.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) this);
        map.setOnMapClickListener(
                (latLng -> {
                    for(Marker m :toDeleteMarkers){
                        m.remove();
                    }
                })
        );
        map.setOnMapClickListener(
                (latLng -> {
                    for(Marker m :toDeleteMarkers){
                        m.remove();

                    }
                })
        );
    }

    @Override
    protected void onPause() {
        gmap.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        gmap.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        gmap.onLowMemory();
    }

    @Override
    public boolean onMyLocationButtonClick() {

        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

        Geocoder geocoder=new Geocoder(this, Locale.getDefault()) ;
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            geocoder = new Geocoder(this, Locale.getDefault());
            String address = addresses.get(0).getAddressLine(0);
            MarkerOptions m = new MarkerOptions().position(new LatLng(location.getLatitude(),location.getLongitude()));
            m.title("curr pos");
            m.snippet(address);
            Marker ma= infoMap.addMarker(m);
            ma.showInfoWindow();
            toDeleteMarkers.add(ma);



        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        // TODO Auto-generated method stub
        String oldTitle = marker.getTitle();
        marker.setSnippet("Usted se encuentra a "+ CalculationByDistance(marker.getPosition(), new LatLng(infoMap.getMyLocation().getLatitude(),infoMap.getMyLocation().getLongitude()))+ " metros de distancia a "+oldTitle);
        marker.showInfoWindow();

        return false;
    }

    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        return Radius * c*1000;
    }
}
