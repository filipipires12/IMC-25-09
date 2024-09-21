package br.com.aula.text;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.google.android.material.textfield.TextInputEditText;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void calculaImc(View view) {
        TextInputEditText campoNome = findViewById(R.id.textinputNome);
        TextInputEditText campoPeso = findViewById(R.id.textInputPeso);
        TextInputEditText campoAltura = findViewById(R.id.textinputAltura);
        AppCompatRadioButton campoMasculino = findViewById(R.id.radioMasculino);
        AppCompatRadioButton campoFeminino = findViewById(R.id.radioFeminino);
        TextView textErro = findViewById(R.id.Resultado2);

        TextView resultado1 = findViewById(R.id.textResultado1);

        // Cria as variaveis e converte em string
        String nome = campoNome.getText().toString();
        String peso = campoPeso.getText().toString();
        String altura = campoAltura.getText().toString();


        if(campoMasculino.isChecked()) {
            if (nome.isEmpty() && peso.isEmpty() && altura.isEmpty()) {
                resultado1.setText("Por favor senhor digite seu Nome, Peso e Altura...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (nome.isEmpty() && altura.isEmpty()) {
                resultado1.setText("Por favor senhor digite seu Nome e Altura...");
                textErro.setText("EROO!!!");
                return;
            }
            if (peso.isEmpty() && altura.isEmpty()) {
                resultado1.setText("Por favor senhor digite seu Peso e Altura...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (nome.isEmpty() && peso.isEmpty()) {
                resultado1.setText("Por favor senhor digite seu Nome e Peso...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (nome.isEmpty()) {
                resultado1.setText("Por favor senhor digite seu nome...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (peso.isEmpty()) {
                resultado1.setText("Por favor senhor digite seu peso...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (altura.isEmpty()) {
                resultado1.setText("Por favor senhor digite sua altura...");
                textErro.setText("ERRO!!!");
                return;
            }
        }else if (campoFeminino.isChecked()){
            if (nome.isEmpty() && peso.isEmpty() && altura.isEmpty()) {
                resultado1.setText("Por favor senhora digite seu Nome, Peso e Altura...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (nome.isEmpty() && altura.isEmpty()) {
                resultado1.setText("Por favor senhora digite seu Nome e Altura...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (peso.isEmpty() && altura.isEmpty()) {
                resultado1.setText("Por favor senhora digite seu Peso e Altura...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (nome.isEmpty() && peso.isEmpty()) {
                resultado1.setText("Por favor senhora digite seu Nome e Peso...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (nome.isEmpty()) {
                resultado1.setText("Por favor senhora digite seu nome...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (peso.isEmpty()) {
                resultado1.setText("Por favor senhora digite seu peso...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (altura.isEmpty()) {
                resultado1.setText("Por favor senhora digite sua altura...");
                textErro.setText("ERRO!!!");
                return;
            }
        }
        else {
            if (nome.isEmpty() && peso.isEmpty() && altura.isEmpty()) {
                resultado1.setText("Por favor selecione seu Gênero e digite seu Nome, Peso e Altura...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (nome.isEmpty() && peso.isEmpty()){
                resultado1.setText("Por favor selecione seu Gênero e digite seu Nome e Peso...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (peso.isEmpty() && altura.isEmpty()){
                resultado1.setText("Por favor selecione seu Gênero e digite seu Peso e Altura...");
                textErro.setText("ERRO!!!");
                return;
            }
            if (nome.isEmpty() && altura.isEmpty()){
                resultado1.setText("Por favor selecione seu Gênero e digite seu Nome e Altura...");
                textErro.setText("EROO!!!");

                return;
            }
        }

        //Converter os dados Peso e altura em numerico e calcula imc
        Double numPeso = Double.parseDouble(peso);
        Double numAltura = Double.parseDouble(altura);
        Double numImc = numPeso / (numAltura * numAltura);

        // Formata o nosso imc em duas casas decimais
        DecimalFormat df = new DecimalFormat("##.##");
        String imcFormatado = df.format(numImc);

        String resultadoTexto = "";
            if (campoMasculino.isChecked()) {
                if (numImc >= 40) {
                    resultadoTexto = ("Seu imc é: " + imcFormatado + " - Obesidade Móbida");

                } else if (numImc >= 30 && numImc <= 39.9) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Obesidade Moderada");

                } else if (numImc >= 25 && numImc <= 29.9) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Obesidade Leve");

                } else if (numImc >= 20 && numImc <= 24.9) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Normal");

                } else if (numImc < 20) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Abaixo do Normal");
                }
            }else if (campoFeminino.isChecked()) {
                if (numImc >= 39) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Obesidade Móbida");

                } else if (numImc >= 29 && numImc <= 38.9) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Obesidade Moderada");

                } else if (numImc >= 24 && numImc <= 28.9) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Obesidade Leve");

                } else if (numImc >= 19 && numImc <= 23.9) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Normal");

                } else if (numImc < 20) {
                    resultadoTexto = ("Seu IMC é: " + imcFormatado + " - Abaixo do Normal");
            }
        }
        if(!resultadoTexto.isEmpty()){
            fecharTeclado();
        }
        resultado1.setText(resultadoTexto);


    }


    private void fecharTeclado() {
        // Verifica se há uma view atual com foco
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public void limpaDados(View view) {

        TextInputEditText nome = findViewById(R.id.textinputNome);
        TextInputEditText peso = findViewById(R.id.textInputPeso);
        TextInputEditText altura = findViewById(R.id.textinputAltura);
        TextView limpar = findViewById(R.id.textResultado1);
        AppCompatRadioButton buttonMasculino = findViewById(R.id.radioMasculino);
        AppCompatRadioButton buttonFeminino = findViewById(R.id.radioFeminino);

        nome.setText("");
        peso.setText("");
        altura.setText("");
        limpar.setText("");

        buttonMasculino.setChecked(false);
        buttonFeminino.setChecked(false);



    }
}
