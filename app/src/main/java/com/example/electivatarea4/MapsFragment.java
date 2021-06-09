package com.example.electivatarea4;

import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.electivatarea4.ui.gallery.GalleryFragment;
import com.example.electivatarea4.ui.slideshow.SlideshowFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {


    double coordenada1 = -34, coordenada2 = 151;
    String[] coordenadas;
    String[] Edificios;
    String id, Edificio = "Marker in Sydney";
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(coordenada1, coordenada2);

            Toast.makeText(getActivity(), String.valueOf(coordenada1) + "  " + String.valueOf(coordenada2), Toast.LENGTH_SHORT).show();

            googleMap.addMarker(new MarkerOptions().position(sydney).title(Edificio))
            .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,20));

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_maps, container, false);
        Edificios = getResources().getStringArray(R.array.edificios);
        coordenadas = getResources().getStringArray(R.array.edificioscoordenadas);

        Bundle bundle = this.getArguments();
        if(bundle != null){
            id = bundle.getString("key");
            if (id !="")
            {
                String[] shortcoordenadas = coordenadas[Integer.parseInt(id)].split(",");

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                }

                coordenada1 = Double.parseDouble(shortcoordenadas[0]);
                coordenada2 = Double.parseDouble(shortcoordenadas[1]);
            }
        }

        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                SlideshowFragment newFragment = new SlideshowFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, newFragment, newFragment.getTag())
                        .commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}