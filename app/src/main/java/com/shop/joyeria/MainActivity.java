package com.shop.joyeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rbg_material, rbg_dijen , rbg_tipo ;
    private RadioButton rbt_material, rbt_dijen, rbt_tipo;
    private EditText cantidad;
    private Spinner tipo_moneda;
    private String[] list_monedas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rbg_material = findViewById(R.id.rbgMaterial);
        rbg_dijen = findViewById(R.id.rbgDijen);
        rbg_tipo = findViewById(R.id.rbgTipo);
        cantidad = findViewById(R.id.txtCantidad);
        tipo_moneda = findViewById(R.id.txtTipoMoneda);
        list_monedas = getResources().getStringArray(R.array.tipo_moneda_array);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list_monedas);
        tipo_moneda.setAdapter(adapter);
    }
}