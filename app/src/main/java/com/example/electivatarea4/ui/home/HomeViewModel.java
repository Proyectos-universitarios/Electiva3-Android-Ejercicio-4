package com.example.electivatarea4.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("bienvenido a mi aplicación usando NavigationDrawer Activity");
    }

    public LiveData<String> getText() {
        return mText;
    }
}