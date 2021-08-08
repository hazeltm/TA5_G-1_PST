package com.example.pst_ta5_grupo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Perfil extends AppCompatActivity implements View.OnClickListener {

    private Button btnCategorias, btnMenu, btnPerfil;
    private TextView txtInformacion, txtUsuario;
    private String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        btnCategorias = findViewById(R.id.btnCategorias);
        btnMenu = findViewById(R.id.btnMenu);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnCategorias.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
        txtInformacion = findViewById(R.id.txtInformacion);
        txtUsuario = findViewById(R.id.txtUsuario);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase db = admin.getReadableDatabase();
        usuario = getIntent().getStringExtra("usuario");
        txtUsuario.setText(usuario);

        Cursor info = db.rawQuery("SELECT * FROM clientes WHERE usuario='" + usuario + "'", null);
        StringBuffer buffer = new StringBuffer();
        while (info.moveToNext()) {
            buffer.append("Nombre: " + info.getString(2) + "\n");
            buffer.append("Apellido: " + info.getString(3) + "\n");
            buffer.append("Correo: " + info.getString(4) + "\n");
            buffer.append("Celular: " + info.getString(5) + "\n");
            buffer.append("Favorito: " + info.getString(6) + "\n\n");
        }
        txtInformacion.setText(buffer.toString());
        db.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCategorias:
                Toast.makeText(Perfil.this, "No hay categorias", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnMenu:
                finish();
                break;
            case R.id.btnPerfil:
                Toast.makeText(Perfil.this, "Ya se encuentra en su perfil", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}