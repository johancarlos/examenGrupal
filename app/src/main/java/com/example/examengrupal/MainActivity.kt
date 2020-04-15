package com.example.examengrupal

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View){
        val buSelected = view as Button
        var cellID = 0
        when(buSelected.id){
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9

        }

        playGame(cellID,buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cellID: Int, buSelected: Button) {
        if(activePlayer==1){
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(cellID)
            activePlayer = 2
            AutoPlay()
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.parseColor("#FF9300"))
            player2.add(cellID)
            activePlayer = 1
        }
        buSelected.isEnabled = false;
        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }
        // row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }

        // row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }

        // col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }

        // col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }


        // col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }
        //diagonales
        if((player1.contains(1) && player1.contains(5) && player1.contains(9)) || (player1.contains(3) && player1.contains(5) && player1.contains(7)) ){
            winner=1
        }
        if((player2.contains(1) && player2.contains(5) && player2.contains(9))|| (player2.contains(3) && player2.contains(5) && player2.contains(7))){
            winner=2
        }


        if( winner != -1){
            if (winner==1){
                Toast.makeText(this," Player 1  win the game", Toast.LENGTH_LONG).show()
                val alertDialog = AlertDialog.Builder(this)
                    .setTitle("Ganador!!!")
                    .setMessage("Gracias por participar Jugador1 {Name}!")
                    .setPositiveButton("Reiniciar", null)
                            .setCancelable(false)
                    .create()
                alertDialog.show()
            }

            }else
                 if(winner == 2){
                Toast.makeText(this," Player 2  win the game", Toast.LENGTH_LONG).show()
                    val alertDialog = AlertDialog.Builder(this)
                        .setTitle("Ganador!!!")
                        .setMessage("Gracias por participar Jugador2 {Name}!")
                        .setPositiveButton("Reiniciar",null)
                        .setCancelable(false)
                        .create()
                    alertDialog.show()
            }

        }

    private fun AutoPlay() {
        val emptyCells=ArrayList<Int>()
        for (cellID in 1..9){
            if(!(player1.contains(cellID) || player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells[randIndex]


        var buSelected:Button
        when(cellID){
            1->buSelected=btn1
            2-> buSelected=btn2
            3-> buSelected=btn3
            4-> buSelected=btn4
            5-> buSelected=btn5
            6-> buSelected=btn6
            7-> buSelected=btn7
            8-> buSelected=btn8
            9-> buSelected=btn9
            else -> buSelected = btn1

        }
        playGame(cellID,buSelected)
    }

}
