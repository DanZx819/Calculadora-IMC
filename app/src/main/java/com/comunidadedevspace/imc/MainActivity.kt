package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar os componentes EditText
        // Criar uma variavel e associar (=)o componente de UI <Edit Text>

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)

        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        // Recuperar o Botão da tela

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        //Colocar ação no botão
        btnCalcular.setOnClickListener {

            //Recuperar o texto digitado no edtPeso

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if(pesoStr == "" || alturaStr == ""){
                // Mostrar mensagem para o usuario
                Snackbar
                    .make(
                        edtPeso,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    ).show()
            }else{
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()
                val resultado = peso / (altura * altura)
                println(resultado)
            }

            //Fazer o calculo do IMC



        }
    }
}