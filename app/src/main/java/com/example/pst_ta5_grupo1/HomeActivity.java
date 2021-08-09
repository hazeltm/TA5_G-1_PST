package com.example.pst_ta5_grupo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    com.example.pst_ta5_grupo1.AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
    private EditText edt;
    private TableLayout tb;
    int[] numLibrosImg = new int[]{R.drawable.fuimoscanciones,R.drawable.fuimoscanciones, R.drawable.mundodragones, R.drawable.lasombra, R.drawable.elcuento, R.drawable.cielo,
            R.drawable.dragonalia, R.drawable.gato, R.drawable.cabal};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        edt = (EditText) findViewById(R.id.et1);
        tb=(TableLayout)findViewById(R.id.tablelayout);
        llenarTabla();
    }

    public void consultaporcodigo(View v) {
        SQLiteDatabase bd = admin.getWritableDatabase();
        String libro = edt.getText().toString();
        if(!libro.isEmpty()){
            tb.removeAllViews();//ELIMINA FILAS ANTERIORES
            String query = "SELECT * FROM libros WHERE titulo ='"+libro+"'";
            Cursor fila = bd.rawQuery(query, null);

            TableRow.LayoutParams tRowLayout = new TableRow.LayoutParams(); //diseño para todas las filas y encabezado
            tRowLayout.setMargins(5,5,5,5);
            tRowLayout.weight=1;

            //Creación de las demás filas
            if(fila.moveToFirst()){
                TableRow tr= new TableRow(this);
                String titulo="";
                String sipnosis="";
                String categoria = "";
                String editorial= "";
                String autor = "";
                String cad = "";
                int imagenPos= 0;

                //
                imagenPos = fila.getInt(0);
                titulo = fila.getString(1);
                autor = fila.getString(2);
                editorial = fila.getString(3);
                categoria = fila.getString(4);
                sipnosis = fila.getString(5);
                cad = "Titulo: "+titulo+"\n"+
                        "Autor: "+autor+"\n"+
                        "Editorial: "+editorial+"\n";
                //
                TextView tv= new TextView(this);
                tv.setGravity(Gravity.RIGHT);
                tv.setPadding(20,20,20,20);
                tv.setTextSize(18);
                tv.setBackgroundColor(Color.parseColor("#faf0e6"));
                tv.setTextColor(Color.BLACK);
                tv.setCompoundDrawablesWithIntrinsicBounds(numLibrosImg[imagenPos], 0, 0, 0);
                tv.setText(cad);
                tr.addView(tv,tRowLayout);
                String finalTitulo = titulo;
                String finalSipnosis = sipnosis;
                tr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogStarter(finalTitulo,finalSipnosis);
                    }
                });
                tb.addView(tr);
            }else{
                Toast.makeText(this,"El libro no se encuentra disponible",Toast.LENGTH_SHORT).show();
            }
            fila.close();

        }else{//VOLVER INICIO
            String query = "SELECT * FROM libros";
            Cursor fila = bd.rawQuery(query, null);

            TableRow.LayoutParams tRowLayout = new TableRow.LayoutParams(); //diseño para todas las filas y encabezado
            tRowLayout.setMargins(5,5,5,5);
            tRowLayout.weight=1;

            //Creación de las demás filas
            while (fila.moveToNext()) {
                TableRow tr= new TableRow(this);
                String titulo="";
                String sipnosis="";
                String editorial= "";
                String autor = "";
                String categoria = "";
                String cad = "";
                int imagenPos= 0;

                //
                imagenPos = fila.getInt(0);
                titulo = fila.getString(1);
                autor = fila.getString(2);
                editorial = fila.getString(3);
                categoria = fila.getString(4);
                sipnosis = fila.getString(5);
                cad = "Titulo: "+titulo+"\n"+
                        "Autor: "+autor+"\n"+
                        "Editorial: "+editorial+"\n";
                //
                TextView tv= new TextView(this);
                tv.setGravity(Gravity.RIGHT);
                tv.setPadding(20,20,20,20);
                tv.setTextSize(18);
                tv.setBackgroundColor(Color.parseColor("#faf0e6"));
                tv.setTextColor(Color.BLACK);
                tv.setCompoundDrawablesWithIntrinsicBounds(numLibrosImg[imagenPos], 0, 0, 0);
                tv.setText(cad);
                tr.addView(tv,tRowLayout);
                String finalTitulo = titulo;
                String finalSipnosis = sipnosis;
                tr.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogStarter(finalTitulo, finalSipnosis);
                    }
                });
                tb.addView(tr);
            }
            fila.close();
        }
        bd.close();
    }

    public void llenarTabla() {
        SQLiteDatabase bd = admin.getReadableDatabase();
        String query = "SELECT * FROM libros";
        Cursor fila = bd.rawQuery(query, null);

        TableRow.LayoutParams tRowLayout = new TableRow.LayoutParams(); //diseño para todas las filas y encabezado
        tRowLayout.setMargins(5,5,5,5);
        tRowLayout.weight=1;
        //Creación de las demás filas
        while (fila.moveToNext()) {
            TableRow tr= new TableRow(this);
            String titulo="";
            String sipnosis="";
            String editorial= "";
            String autor = "";
            String categoria = "";
            String cad = "";
            int imagenPos= 0;

            //
            imagenPos = fila.getInt(0);
            titulo = fila.getString(1);
            autor = fila.getString(2);
            editorial = fila.getString(3);
            categoria = fila.getString(4);
            sipnosis = fila.getString(5);
            cad = "Titulo: "+titulo+"\n"+
                    "Autor: "+autor+"\n"+
                    "Editorial: "+editorial+"\n";
            //

            TextView tv= new TextView(this);
            tv.setGravity(Gravity.RIGHT);
            tv.setPadding(20,20,20,20);
            tv.setTextSize(18);
            tv.setBackgroundColor(Color.parseColor("#faf0e6"));
            tv.setTextColor(Color.BLACK);
            tv.setCompoundDrawablesWithIntrinsicBounds(numLibrosImg[imagenPos], 0, 0, 0);
            tv.setText(cad);
            tr.addView(tv,tRowLayout);
            String finalTitulo = titulo;
            String finalSipnosis = sipnosis;
            tr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialogStarter(finalTitulo,finalSipnosis);
                }
            });
            tb.addView(tr);
        }
        fila.close();
        bd.close();

    }

    public void dialogStarter(String titulo, String sipnosis){
        Intent i = new Intent(this, dialogSipnosis.class);
        i.putExtra("titulo",titulo);
        i.putExtra("sipnosis",sipnosis);
        startActivity(i);
    }



}