package com.example.electivatarea4.ui.gallery;

import android.widget.*;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.electivatarea4.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.electivatarea4.R;
import  com.example.electivatarea4.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    ListView lv;
    String[] stringArray,stringURL;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        lv = (ListView) root.findViewById(R.id.ListViewid);
        stringArray = getResources().getStringArray(R.array.carreras);
        stringURL = getResources().getStringArray(R.array.link_carreras);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,stringArray);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putString("urlId",stringURL[position]);
                CarrearFragment newFragment = new CarrearFragment();
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