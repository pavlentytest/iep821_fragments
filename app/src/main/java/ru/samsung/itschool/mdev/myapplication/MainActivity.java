package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import ru.samsung.itschool.mdev.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnFragment2DataListener{

    private ActivityMainBinding binding;
    public static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // присоединение
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment1());
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment2());
            }
        });
    }

    public void loadFragment(Fragment fr) {
        // Менеджер переключения фрагментов
        FragmentManager fm = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putString(KEY,"Передаем из Активности во фрагмент!");
        fr.setArguments(bundle);

        // Переключение
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.body,fr);
        ft.addToBackStack(null);
        ft.commit();


    }

    @Override
    public void getData(String str) {
        Snackbar.make(findViewById(R.id.mainRoot),str,Snackbar.LENGTH_LONG).show();
    }
}