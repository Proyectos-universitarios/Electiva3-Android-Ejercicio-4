package com.example.electivatarea4.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.electivatarea4.CarrearFragment;
import com.example.electivatarea4.MainActivity;
import com.example.electivatarea4.MapsFragment;
import com.example.electivatarea4.R;
import android.webkit.WebView;

public class SlideshowFragment extends Fragment {

    ListView lv;
    String[] stringArray;

    private SlideshowViewModel slideshowViewModel;
    WebView miVisorWeb;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        Toast.makeText(getActivity(), "SELECCIONE EL EDIFICIO QUE DESEA VER EN EL MAPA", Toast.LENGTH_SHORT).show();

        lv = (ListView) root.findViewById(R.id.idedificios);
        stringArray = getResources().getStringArray(R.array.edificios);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,stringArray);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = new Bundle();
                bundle.putString("key",String.valueOf(position));
                MapsFragment newFragment = new MapsFragment();
                newFragment.setArguments(bundle);

                // consider using Java coding conventions (upper first char class names!!!)
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment, newFragment, newFragment.getTag())
                        .commit();
            }
        });

        return root;
    }
}