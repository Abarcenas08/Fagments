package com.abarcenas.fagments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentinicio,fragmentRojo,fragmentVerde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentinicio= new InitializiFragment();
        fragmentRojo= new FragmentRed();
        fragmentRojo= new FragmentGreen();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments,fragmentinicio).commit();
    }

    public void onClick(View view){
        transaction=getSupportFragmentManager().beginTransaction();

        switch (view.getId())
        {
            case R.id.btn_rojo: transaction.replace(R.id.contenedor_fragments,fragmentRojo);
            transaction.addToBackStack(null);
                break;
            case  R.id.btn_verde: transaction.replace(R.id.contenedor_fragments,fragmentVerde);
                transaction.addToBackStack(null);
                break;
        }
        transaction.commit();
    }
}