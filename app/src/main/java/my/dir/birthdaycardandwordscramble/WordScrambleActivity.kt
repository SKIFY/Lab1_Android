package my.dir.birthdaycardandwordscramble

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class WordScrambleActivity : AppCompatActivity() {

    private lateinit var scrambledWordTextView: TextView
    private lateinit var guessEditText: EditText
    private lateinit var checkButton: Button

    // Список слів для гри
    private val words = listOf("apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "kiwi")
    private lateinit var currentWord: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_scramble)

        // Ініціалізація елементів інтерфейсу
        scrambledWordTextView = findViewById(R.id.scrambledWordTextView)
        guessEditText = findViewById(R.id.guessEditText)
        checkButton = findViewById(R.id.checkButton)

        // Початок нової гри
        startNewGame()

        // Обробник натискання кнопки "Перевірити"
        checkButton.setOnClickListener {
            checkAnswer()
        }
    }

    // Функція для початку нової гри
    private fun startNewGame() {
        if (words.isNotEmpty()) {
            currentWord = words.random()
            val scrambledWord = shuffleWord(currentWord)
            scrambledWordTextView.text = scrambledWord
            guessEditText.text.clear()
        } else {
            Toast.makeText(this, "Немає слів для гри.", Toast.LENGTH_SHORT).show()
        }
    }

    // Функція для перемішування літер у слові
    private fun shuffleWord(word: String): String {
        val characters = word.toCharArray().toList()
        Collections.shuffle(characters)
        return String(characters.toCharArray())
    }

    // Функція для перевірки відповіді гравця
    private fun checkAnswer() {
        val guess = guessEditText.text.toString().trim()

        if (guess.equals(currentWord, ignoreCase = true)) {
            // Якщо гравець вгадав слово
            Toast.makeText(this, "Правильно! Починаємо нову гру.", Toast.LENGTH_SHORT).show()
            startNewGame() // Початок нової гри
        } else {
            // Якщо гравець не вгадав
            Toast.makeText(this, "Неправильно. Спробуйте ще раз.", Toast.LENGTH_SHORT).show()
        }
    }
}