package com.comunidadedevspace.imc

import android.content.Intent
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
                // Mostrar SnackBar para o usuario
                Snackbar
                    .make(
                        edtPeso,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    ).show()
            }else{
                //Fazer o calculo do IMC
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()
                val resultado = peso / (altura * altura)
                println(resultado)
                //Navegar para a proxima tela
                //Criar o layout da proxima tela
                //Passar dados para a proxima tela

                //Intent -  Classe do proprio android
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, resultado)
                startActivity(intent)
            }

        }

    }
}