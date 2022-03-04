package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.samsung.itschool.mdev.myapplication.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {

    private OnFragment2DataListener dataListener;
    private Fragment2Binding binding2;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragment2DataListener) {
            dataListener = (OnFragment2DataListener) context;
        } else {
            Log.e("RRRR","Error!");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding2 = Fragment2Binding.inflate(inflater,container,false);
        binding2.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataListener.getData("Ура!!!");
            }
        });
        return binding2.getRoot();
    }

    public interface OnFragment2DataListener {
        void getData(String str);
    }
}