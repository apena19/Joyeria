package com.shop.joyeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rbg_material, rbg_dijen , rbg_tipo ;
    private RadioButton rbt_material, rbt_dijen, rbt_tipo;
    private EditText cantidad;
    private Spinner tipo_moneda;
    private String[] list_monedas;
    private TextView resultado;


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
        resultado = findViewById(R.id.lblResultado);
    }
    // calcula el total a pagar verificando los campos seleccionados y cantidad
    public void calcular(View v){
        //guadamos los datos para el calculo
        int materialId, dijeId, tipoId, total=0;
        materialId = rbg_material.getCheckedRadioButtonId();
        rbt_material = findViewById(materialId);
        dijeId  = rbg_dijen.getCheckedRadioButtonId();
        rbt_dijen = findViewById(dijeId);
        tipoId  = rbg_tipo.getCheckedRadioButtonId();
        rbt_tipo = findViewById(tipoId);
        int pos_tipo_moneda = tipo_moneda.getSelectedItemPosition();
        //validamos que los datos de los campos sean correctos
        if (validate()){
            if(rbt_material.getText().equals( getString(R.string.lbl_cuerda) )){
                if(rbt_dijen.getText().equals( getString(R.string.lbl_martillo) )){
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_oro)) || rbt_tipo.getText().equals( getString(R.string.lbl_oro_rosado)) ){
                        total = 90;
                    }
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_Plata))  ){
                        total = 70;
                    }
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_niquel))  ){
                        total = 50;
                    }
                }
                if(rbt_dijen.getText().equals( getString(R.string.lbl_ancla) )){
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_oro)) || rbt_tipo.getText().equals( getString(R.string.lbl_oro_rosado)) ){
                        total = 110;
                    }
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_Plata))  ){
                        total = 90;
                    }
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_niquel))  ){
                        total = 80;
                    }
                }
            }
            if(rbt_material.getText().equals( getString(R.string.lbl_cuero) )){
                if(rbt_dijen.getText().equals( getString(R.string.lbl_martillo) )){
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_oro)) || rbt_tipo.getText().equals( getString(R.string.lbl_oro_rosado)) ){
                        total = 100;
                    }
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_Plata))  ){
                        total = 80;
                    }
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_niquel))  ){
                        total = 70;
                    }
                }
                if(rbt_dijen.getText().equals( getString(R.string.lbl_ancla) )){
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_oro)) || rbt_tipo.getText().equals( getString(R.string.lbl_oro_rosado)) ){
                        total = 120;
                    }
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_Plata))  ){
                        total = 100;
                    }
                    if( rbt_tipo.getText().equals( getString(R.string.lbl_niquel))  ){
                        total = 90;
                    }
                }
            }
            if(pos_tipo_moneda == 1){
                //convertimos el total parcial a pesos colombianos
                total = (total * 3200) * Integer.parseInt( cantidad.getText().toString()) ;
            }else{
                //multiplicamos por el total solamente en usd
                total = total * Integer.parseInt( cantidad.getText().toString() );
            }
            resultado.setText( getString(R.string.lbl_resultado) + total );
        }
    }
    //valida los campos enviados y retorna true o false
    public boolean validate(){
        if (rbg_material.getCheckedRadioButtonId() == -1 || rbg_dijen.getCheckedRadioButtonId() == -1 || rbg_tipo.getCheckedRadioButtonId() == -1  ){
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
            return  false;
        }
        if( tipo_moneda.getSelectedItemPosition() == 0){
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_LONG).show();
            return false;
        }
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(getString(R.string.error));
            cantidad.requestFocus();
            return  false;
        }
        return true;
    }
}