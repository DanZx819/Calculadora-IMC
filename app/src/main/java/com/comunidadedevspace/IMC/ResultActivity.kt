package com.comunidadedevspace.IMC

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)


        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificaçao = findViewById<TextView>(R.id.tv_classificaçao)

        tvResult.text = result.toString()

        //Classificação do IMC

        var classificacao: String?

        if (result < 18.5f) {
            classificacao = "ABAIXO DO PESO"
            tvClassificaçao.setTextColor(Color.RED)
        } else if (result > 18.5f && result <= 24.9f) {
            classificacao = "PESO NORMAL"
            tvClassificaçao.setTextColor(Color.GREEN)
        } else if (result > 24.9f && result <= 29.9f) {
            classificacao = "SOBRE PESO"
            tvClassificaçao.setTextColor(Color.YELLOW)
        } else if (result > 30f && result <= 39.9f) {
            classificacao = "OBESIDADE"
            tvClassificaçao.setTextColor(Color.RED)
        } else {
            classificacao = "OBESIDADE GRAVE"
            tvClassificaçao.setTextColor(Color.RED)
        }

        tvClassificaçao.text = classificacao
        }
    }
