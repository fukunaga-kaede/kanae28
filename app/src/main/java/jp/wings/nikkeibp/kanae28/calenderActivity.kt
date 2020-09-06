package jp.wings.nikkeibp.kanae28

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class calenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)

        var plusButton : ImageButton = findViewById(R.id.plus)

        plusButton.setOnClickListener {
            val intent = Intent(this@calenderActivity, addActivity::class.java)
            startActivity(intent)
        }
    }
}