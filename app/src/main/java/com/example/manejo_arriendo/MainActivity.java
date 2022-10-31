package com.example.manejo_arriendo;

/*
Hacer una aplicación para manejar el arriendo de las viviendas (pueden ser casa (tienen un valor de
400000), apartamentos (valor de 300000) o finca (valor de 600000)), se cobra un valor adicional por
 cantidad de habitaciones (menos de tres (100000 pesos adicionales,3 o 4 (200000 pesos adicionales
 y  más de 4 (300000 pesos adicionales), si quiere parqueadero el valor adicional es de 100000 pesos),
   calcular el total del arrendamiento
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText jetcanthabitacion;
    RadioButton jrdcasa, jrdapartamento, jrdfinca;
    CheckBox jcbparqueadero;
    TextView jtvvalarriendobruto, jtvparqueadero, jtvtotalarriendo, jtvvalhabitacion;
    Button jbtncalcular, jbtnlimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        jetcanthabitacion=findViewById(R.id.etcanthabitacion);
        jrdcasa=findViewById(R.id.rdcasa);
        jrdapartamento=findViewById(R.id.rdapartamento);
        jrdfinca=findViewById(R.id.rdfinca);
        jcbparqueadero=findViewById(R.id.cbparqueadero);
        jtvvalarriendobruto=findViewById(R.id.tvvalarriendobruto);
        jtvtotalarriendo=findViewById(R.id.tvtotalarriendo);
        jtvparqueadero=findViewById(R.id.tvparqueadero);
        jbtncalcular=findViewById(R.id.btncalcular);
        jbtnlimpiar=findViewById(R.id.btnlimpiar);
        jtvvalhabitacion=findViewById(R.id.tvvalhabitacion);
    }

    public void Calcular_arriendo(View view){
        String verificarhabitaciones;
        verificarhabitaciones=jetcanthabitacion.getText().toString();

        if (verificarhabitaciones.isEmpty()){
            Toast.makeText(this, "Ingrese la cantidad de habitaciones", Toast.LENGTH_SHORT).show();
            jetcanthabitacion.requestFocus();
        }
        else {
            int cantidadHabitaciones;
            cantidadHabitaciones=Integer.parseInt(verificarhabitaciones);
            float valHabitacion, valTotal, valParqueadero, valArriendo;
            if (cantidadHabitaciones < 0){
                Toast.makeText(this, "Ingrese un numero de habitaciones balido", Toast.LENGTH_SHORT).show();
                jetcanthabitacion.requestFocus();
            }
            else {
                if (cantidadHabitaciones < 3){
                    valHabitacion=100000;
                    jtvvalhabitacion.setText("100000");
                }
                else{
                    if (cantidadHabitaciones >= 3 && cantidadHabitaciones <= 4){
                        valHabitacion=200000;
                        jtvvalhabitacion.setText("200000");
                    }
                    else {
                        valHabitacion=300000;
                        jtvvalhabitacion.setText("300000");
                    }
                }
                if (jrdcasa.isChecked()){
                    jtvvalarriendobruto.setText("400000");
                    valArriendo=400000;
                }
                else {
                    if (jrdapartamento.isChecked()){
                        jtvvalarriendobruto.setText("300000");
                        valArriendo=300000;
                    }
                    else {
                        jtvvalarriendobruto.setText("600000");
                        valArriendo=600000;
                    }

                    if (jcbparqueadero.isChecked()){
                        jtvparqueadero.setText("+100000");
                        valParqueadero=100000;
                    }
                    else {
                        jtvparqueadero.setText("0");
                        valParqueadero=0;
                    }


                }
            }
        }

    }
}