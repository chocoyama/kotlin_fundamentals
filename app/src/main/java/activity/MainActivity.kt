package activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.kotlin_fundamental.R
import java.util.*

// MEMO: AppCompatActivityは後方互換性も考慮した上で全ての最新機能を利用できるようにするために用いる
class MainActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MEMO: LayoutInflationはXMLファイルをViewObjectに変換するための処理
        setContentView(R.layout.activity_main)

        // findViewByIdは重たい操作
        diceImage = findViewById(R.id.dice_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1

        val drawableResource = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
}
