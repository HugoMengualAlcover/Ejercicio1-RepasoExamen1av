package com.example.ejercicio1_repasoexamen1av;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Toast;

import com.example.ejercicio1_repasoexamen1av.databinding.ActivityMainBinding;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private final int NUMINICIALCIGARROS = 20;
    private int numCigarros;
    private int dineroAhorrado;

    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        numCigarros = NUMINICIALCIGARROS;

        binding.contentMain.lblDineroAhorradoMain.setText("Cigarrillos restantes " + numCigarros);

        binding.contentMain.btnNoFumarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numCigarros -= 1;
                if(numCigarros<1){
                    numCigarros = NUMINICIALCIGARROS;
                    dineroAhorrado += 5;
                    Toast.makeText(MainActivity.this, "Te has acabado una caja, y te has ahorrado " + nf.format(5), Toast.LENGTH_SHORT).show();
                    binding.contentMain.lblDineroAhorradoMain.setText("Dinero ahorrado "+ nf.format(dineroAhorrado));
                }
                binding.contentMain.lblNumCigarrosMain.setText("Cigarrillos restantes " + numCigarros);
            }
        });
    }


}