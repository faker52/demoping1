package com.example.demoping1.ui.doctor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DoctorViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;


    public DoctorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is a doctor");//根据自己喜欢放界面的测试文字
    }

    public LiveData<String> getText() {
        return mText;
    }
}