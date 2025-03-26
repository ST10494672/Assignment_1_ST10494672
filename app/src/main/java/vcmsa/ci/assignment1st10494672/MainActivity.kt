package vcmsa.ci.assignment1st10494672

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // insert variables
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // meal button click listener
        suggestButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()

            // Using meal options using IF statement
            val suggestion = when (timeOfDay) {
                "morning" -> "Breakfast: Eggs and toast"
                "mid morning" -> "Snack: Fresh fruit salad "
                "afternoon" -> "Lunch: Sandwich and salad"
                "mid afternoon" -> "Snack: Biltong & energy bar"
                "dinner" -> "Dinner: Pasta with tomato sauce"
                else -> "Invalid time of day. Please try again."
            }
            //
            mealSuggestion.text = suggestion
        }
        // Reset Button Click Listener
        resetButton.setOnClickListener {
            timeInput.text.clear()
            mealSuggestion.text = "Your meal suggestion will appear below."
        }
    }
}

