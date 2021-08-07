package com.example.pst_ta5_grupo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    private Button btnCategorias, btnMenu, btnPerfil;
    private String usuario;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        usuario = getIntent().getStringExtra("usuario");
        btnCategorias = findViewById(R.id.btnCategorias);
        btnMenu = findViewById(R.id.btnMenu);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnCategorias.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCategorias:
                intent = new Intent(getApplicationContext(), Categorias.class);
                startActivity(intent);
                break;
            case R.id.btnMenu:
                Toast.makeText(Menu.this, "Ya se encuentra en el menu principal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPerfil:
                intent = new Intent(getApplicationContext(), Perfil.class);
                intent.putExtra("usuario",usuario);
                startActivity(intent);
                break;
        }
    }
}