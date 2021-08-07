package com.example.pst_ta5_grupo1;

import androidx.appcompat.app.AppCompatActivity;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private Button btnRegistro;
    private EditText edtTxTNombres, edtTxTApellidos, edtTxTCorreo, edtTxTCelular, edtTxTCategoria, edtTxtUsuario, edtTxtPassword, edtTxtConfirmacion;
    private AdminSQLiteOpenHelper admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        admin = new AdminSQLiteOpenHelper(this);

        btnRegistro = findViewById(R.id.btnRegistro);
        edtTxTNombres = findViewById(R.id.edtTxTNombres);
        edtTxTApellidos = findViewById(R.id.edtTxTApellidos);
        edtTxTCorreo = findViewById(R.id.edtTxTCorreo);
        edtTxTCelular = findViewById(R.id.edtTxTCelular);
        edtTxTCategoria = findViewById(R.id.edtTxTCategoria);
        edtTxtUsuario = findViewById(R.id.edtTxtUsuario);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtConfirmacion = findViewById(R.id.edtTxtConfirmacion);



        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombresTxt = edtTxTNombres.getText().toString();
                String apellidosTxt = edtTxTApellidos.getText().toString();
                String correoTxt = edtTxTCorreo.getText().toString();
                String celularTxt = edtTxTCelular.getText().toString();
                String categoriaTxt = edtTxTCategoria.getText().toString();
                String usuarioTxt = edtTxtUsuario.getText().toString();
                String passwordTxt = edtTxtPassword.getText().toString();
                String passwordConfirmTxt = edtTxtConfirmacion.getText().toString();

                if (!nombresTxt.isEmpty() && !apellidosTxt.isEmpty() && !correoTxt.isEmpty() && !celularTxt.isEmpty() && !categoriaTxt.isEmpty() && !usuarioTxt.isEmpty() && !passwordTxt.isEmpty() && !passwordConfirmTxt.isEmpty()) {
                    if (!passwordTxt.contentEquals(passwordConfirmTxt)) {
                        edtTxtPassword.setText("");
                        edtTxtConfirmacion.setText("");
                        Toast.makeText(Registro.this, "Las contraseñas no son iguales, intente de nuevo", Toast.LENGTH_SHORT).show();
                    } else {
                        Boolean checkUsuario = admin.checkUsuario(usuarioTxt);
                        if (!checkUsuario) {
                            Boolean insertData = admin.insertData(usuarioTxt, passwordTxt, nombresTxt, apellidosTxt, correoTxt, celularTxt, categoriaTxt);
                            if (insertData) {
                                Toast.makeText(Registro.this, "El registro fue exitoso", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                edtTxtUsuario.setText("");
                                Toast.makeText(Registro.this, "Este usuario ya existe, intente con otro", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                } else {
                    Toast.makeText(Registro.this, "Llenar los campos faltantes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


