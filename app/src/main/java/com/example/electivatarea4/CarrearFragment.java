package com.example.electivatarea4;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.electivatarea4.ui.gallery.GalleryFragment;


public class CarrearFragment extends Fragment {
String id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_carrear, container, false);

        Bundle bundle = this.getArguments();
        if(bundle != null){
            id = bundle.getString("urlId");

            String URL = getResources().getString(R.string.enlace_carreras);
            final WebView web = (WebView) root.findViewById(R.id.visorweb);
            web.setWebViewClient(new WebViewClient());
            web.loadUrl(URL+id);
        }
            // This callback will only be called when MyFragment is at least Started.
            OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
                @Override
                public void handleOnBackPressed() {
                    GalleryFragment newFragment = new GalleryFragment();
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
}