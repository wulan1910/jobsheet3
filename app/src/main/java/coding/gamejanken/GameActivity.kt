package coding.gamejanken

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.selects.SelectInstance

class GameActivity : AppCompatActivity() {

    private lateinit var computerImageView: ImageView
    private lateinit var rockImageButton: ImageButton
    private lateinit var scissorsImageButton: ImageButton
    private lateinit var paperImageButton: ImageButton
    private lateinit var resultImageView: ImageView

    private fun initComponents() {
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }
    private fun initlisteners(){
        rockImageButton.setOnClickListener {startGame("ROCK")}
        scissorsImageButton.setOnClickListener { startGame("SCISSORS") }
        paperImageButton.setOnClickListener { startGame("PAPER") }
    }
    private fun startGame(option: String) {
        val computerImageView = Game.pickrandomOption()
        computerImageView.setImageResource(Game.pickDrawble(computeroption))

        when {
            Game.isDraw(option, computerOption) -> resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(option, computerOption) -> resultImageView.setImageResource(R.drawable.win)
            else -> resultImageView.setImageResource(R.drawable.lose)
        }
    }

    override fun onCreate(savedInstancestate: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initlisteners()
    }
}