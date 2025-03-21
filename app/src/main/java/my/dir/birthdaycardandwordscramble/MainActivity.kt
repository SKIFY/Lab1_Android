package my.dir.birthdaycardandwordscramble

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.animation.ObjectAnimator
import android.view.View
import android.widget.ImageView

class                   MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Кнопка для переходу до гри
        val confettiImage = findViewById<ImageView>(R.id.confettiImage)
        val fadeOut = ObjectAnimator.ofFloat(confettiImage, View.ALPHA, 1f, 0f)
        fadeOut.duration = 2000 // Тривалість анімації (2 секунди)
        fadeOut.start()

        val startGameButton: Button = findViewById(R.id.startGameButton)
        startGameButton.setOnClickListener {
            val intent = Intent(this, WordScrambleActivity::class.java)
            startActivity(intent)
        }
    }
}