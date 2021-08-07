package com.example.pst_ta5_grupo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegistro, btnIngreso;
    private EditText edtTxtUsuario, edtTxtPassword;
    private String usuario, password;
    private AdminSQLiteOpenHelper admin;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        admin = new AdminSQLiteOpenHelper(this);

        btnRegistro = findViewById(R.id.btnRegistro);
        btnIngreso = findViewById(R.id.btnIngreso);
        edtTxtUsuario = findViewById(R.id.edtTxtUsuario);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);

        btnRegistro.setOnClickListener(this);
        btnIngreso.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIngreso:
                usuario = edtTxtUsuario.getText().toString();
                password = edtTxtPassword.getText().toString();
                if (!usuario.isEmpty() && !password.isEmpty()) {
                    Boolean checkUsuarioPassword = admin.checkUsuarioPassword(usuario, password);
                    if (checkUsuarioPassword) {
                        intent = new Intent(getApplicationContext(), Menu.class);
                        intent.putExtra("usuario", usuario);
                        startActivity(intent);
                    } else {
                        edtTxtPassword.setText("");
                        Toast.makeText(MainActivity.this, "Contraseña incorrecta, intente de nuevo", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Llenar los campos faltantes", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnRegistro:
                intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}