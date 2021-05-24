package com.example.electivatarea4.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Desarrollador de software con tecnologías .Net, experiencia como líder técnico de productos corporativos y a la medida. Manejo de tecnologías de Microsoft y OpenSource entre algunas de ellas: .Net Core, .Net Framework, ORM Entity Framework y Core, MVC, experiencia con Git, Azure DevOps, además el uso de JavaScript en Dom, Bootstrap, Json, Xml, C#, MS SQL Server, MySQL, Apis de IA de Microsoft, Azure, IBM Bluemix.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}