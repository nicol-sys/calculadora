package com.example.calculadora;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private TextView tvresultado;
    public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    public Button btnsuma, btnresta, btnmul, btndiv, btnpo;
    public Button btnigual, limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvresultado = findViewById(R.id.tvresultado);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnsuma = findViewById(R.id.btnsuma);
        btnresta = findViewById(R.id.btnresta);
        btnmul = findViewById(R.id.btnmul);
        btndiv = findViewById(R.id.btndiv);
        btnpo = findViewById(R.id.btnpo);
        btnigual = findViewById(R.id.btnigual);
        limpiar = findViewById(R.id.limpiar);
    }

    public void calcular(View view) {

        int id = view.getId();
        String textoActual = tvresultado.getText().toString();

        switch (id) {

            case R.id.btn7:
                textoActual += "7";
                break;
            case R.id.btn8:
                textoActual += "8";
                break;
            case R.id.btn9:
                textoActual += "9";
                break;

            case R.id.btn4:
                textoActual += "4";
                break;
            case R.id.btn5:
                textoActual += "5";
                break;
            case R.id.btn6:
                textoActual += "6";
                break;
            case R.id.btn1:
                textoActual += "1";
                break;
            case R.id.btn2:
                textoActual += "2";
                break;
            case R.id.btn3:
                textoActual += "3";
                break;
            case R.id.btn0:
                textoActual += "0";
                break;

            case R.id.btnsuma:
                textoActual += "+";
                break;
            case R.id.btnresta:
                textoActual += "-";
                break;
            case R.id.btnmul:
                textoActual += "*";
                break;
            case R.id.btndiv:
                textoActual += "/";
                break;
            case R.id.btnpo:
                textoActual += "EXP";
                break;
            case R.id.btnigual:
                textoActual = "=";
                try {

                    String resultado = evaluarExpresion(textoActual);

                    tvresultado.setText(resultado);
                } catch (Exception e) {

                    tvresultado.setText("Error");
                }
                break;
            case R.id.limpiar:

                textoActual = "C";
                break;
        }
        tvresultado.setText(textoActual);
    }

    private String evaluarExpresion(String expresion) {
        try {
            String[] elementos = expresion.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
            if (elementos.length % 2 == 0) {
                return "Error";
            }

            double resultado = Double.parseDouble(elementos[0]);

            for (int i = 1; i < elementos.length; i += 2) {
                String operador = elementos[i];
                double operando = Double.parseDouble(elementos[i + 1]);

                switch (operador) {
                    case "+":
                        resultado += operando;
                        break;
                    case "-":
                        resultado -= operando;
                        break;
                    case "*":
                        resultado *= operando;
                        break;
                    case "/":
                        if (operando == 0) {
                            return "Error";
                        }
                        resultado /= operando;
                        break;
                    case "^":
                        resultado = Math.pow(resultado, operando);
                        break;
                    default:
                        return "Error";
                }
            }

            return String.valueOf(resultado);
        } catch (Exception e) {
            return "Error";
        }
    }
}