package com.example.jogodavelha
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity() : AppCompatActivity() {
    //em cada player, vai guardando no array, aonde o jogador está marcando
    val jogadorOne = arrayListOf<Int>()
    val jogadorTwo = arrayListOf<Int>()

    //carrega aqui, a vez do jogador..se pode ou não pode
    var jogadorCorrente = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }//override fun onCreate(savedInstanceState: Bundle?) {

    fun jogando(position: Int, btnSelecionado: Button){
        if (jogadorCorrente == 1){
            btnSelecionado.text = "X"
            btnSelecionado.setBackgroundColor(android.R.attr.colorAccent)

            //adiciona a posiçãodo jogador
            jogadorOne.add(position)

            //aqui passa a vez para jogador_02
            jogadorCorrente = 2
        }//if (jogadorCorrente == 1){

        else{
            btnSelecionado.text = "O"
            btnSelecionado.setBackgroundColor(android.R.attr.colorSecondary)

            //adiciona a posiçãodo jogador
            jogadorTwo.add(position)

            //aqui passa a vez para jogador_02
            jogadorCorrente = 1
        }//else{

        btnSelecionado.isClickable = false
        checkResult()
    }//fun jogando(position: Int){

    fun btnPosicao (viewzinha: View) = when(viewzinha.id){
        R.id.btn_01 -> jogando(1, viewzinha as Button)
        R.id.btn_02 -> jogando(2, viewzinha as Button)
        R.id.btn_03 -> jogando(3, viewzinha as Button)
        R.id.btn_04 -> jogando(4, viewzinha as Button)
        R.id.btn_05 -> jogando(5, viewzinha as Button)
        R.id.btn_06 -> jogando(6, viewzinha as Button)
        R.id.btn_07 -> jogando(7, viewzinha as Button)
        R.id.btn_08 -> jogando(8, viewzinha as Button)
        R.id.btn_09 -> jogando(9, viewzinha as Button)
        else -> jogando(0, viewzinha as Button)
    }

    fun checkResult(){
        val linha_01 = listOf(1,2,3)
        val linha_02 = listOf(4,5,6)
        val linha_03 = listOf(7,8,9)

        val coluna_01 = listOf(1,4,7)
        val coluna_02 = listOf(2,5,8)
        val coluna_03 = listOf(3,6,9)

        val diagonal_01 = listOf(1,5,9)
        val diagonal_02 = listOf(3,5,7)

        var ganhador = -1

        if (jogadorOne.containsAll(linha_01) || jogadorOne.containsAll(linha_02) || jogadorOne.containsAll(linha_03) ||
                jogadorOne.containsAll(coluna_01) || jogadorOne.containsAll(coluna_02) || jogadorOne.containsAll(coluna_03) ||
                jogadorOne.containsAll(diagonal_01) || jogadorOne.containsAll(diagonal_02)) {ganhador = 1}

        if (jogadorTwo.containsAll(linha_01) || jogadorTwo.containsAll(linha_02) || jogadorTwo.containsAll(linha_03) ||
                jogadorTwo.containsAll(coluna_01) || jogadorTwo.containsAll(coluna_02) || jogadorTwo.containsAll(coluna_03) ||
                jogadorTwo.containsAll(diagonal_01) || jogadorTwo.containsAll(diagonal_02)) {ganhador = 1}

        when (ganhador){
            1 -> Toast.makeText(this, "Parabéns, jogador_01 foi ganhador", Toast.LENGTH_LONG).show()
            2 -> Toast.makeText(this, "Parabéns, jogador_02 foi ganhador", Toast.LENGTH_LONG).show()
        }//when (ganhador){
    }//fun checkResult(){

    fun restart (viewzinha: View) {
        jogadorOne.clear()
        jogadorTwo.clear()
        setContentView(R.layout.activity_main)
    }//fun restart (viewzinha: View) {
}//class MainActivity : AppCompatActivity() {