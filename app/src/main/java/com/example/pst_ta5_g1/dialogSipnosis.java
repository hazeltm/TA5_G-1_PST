package com.example.pst_ta5_g1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class dialogSipnosis extends AppCompatActivity {

    TextView tvTitulo,tvSipnosis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_sipnosis);
        tvTitulo = (TextView)findViewById(R.id.tvTitulo);
        tvSipnosis = (TextView)findViewById(R.id.tvSipnosis);

        String titulo = getIntent().getStringExtra("titulo");
        String sipnosis = getIntent().getStringExtra("sipnosis");

        tvTitulo.setText(titulo);
        tvSipnosis.setText(sipnosis);
    }
}