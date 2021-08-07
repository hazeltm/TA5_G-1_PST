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
    private TextView txtNombres, txtApellidos, txtCorreo, txtCelular, txtFavorito;
    private String usuario;
    private Intent intent;
    private AdminSQLiteOpenHelper admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        admin = new AdminSQLiteOpenHelper(this);

        btnCategorias = findViewById(R.id.btnCategorias);
        btnMenu = findViewById(R.id.btnMenu);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnCategorias.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtCelular = findViewById(R.id.txtCelular);
        txtFavorito = findViewById(R.id.txtFavorito);

        usuario = getIntent().getStringExtra("usuario").trim();
        System.out.println(usuario);
        SQLiteDatabase db = admin.getWritableDatabase();
        try {
            if (!usuario.isEmpty()) {
                System.out.println("sera?");
                Cursor info = db.rawQuery("select nombres,apellidos,correo,celular,favorito from clientes where usuario=" + usuario, null);
                System.out.println("aqui funciona?");
                if (info.moveToFirst()) {
                    System.out.println("dentro del if");
                    txtNombres.setText(info.getString(0));
                    txtApellidos.append(info.getString(1));
                    txtCorreo.append(info.getString(3));
                    txtCelular.append(info.getString(4));
                    txtFavorito.append(info.getString(5));

                }
            }
            db.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCategorias:
                intent = new Intent(getApplicationContext(), Categorias.class);
                startActivity(intent);
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