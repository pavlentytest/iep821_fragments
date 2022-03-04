package ru.samsung.itschool.mdev.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.samsung.itschool.mdev.myapplication.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {

    private String mParam1;
    private Fragment1Binding fragment1Binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(MainActivity.KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment1Binding = Fragment1Binding.inflate(inflater, container, false);
        fragment1Binding.textVIew1.setText(mParam1);
        return fragment1Binding.getRoot();
        // Navigation!!!
        
    }
}