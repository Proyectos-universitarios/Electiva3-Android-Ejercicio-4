package com.example.electivatarea4.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.electivatarea4.R;
import android.webkit.WebView;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    WebView miVisorWeb;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        final WebView web = (WebView) root.findViewById(R.id.visorweb);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://github.com/rperdomo24");
        return root;
    }
}