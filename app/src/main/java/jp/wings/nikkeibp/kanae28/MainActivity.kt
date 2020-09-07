package jp.wings.nikkeibp.kanae28

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "home"

        var scheButton : ImageButton = findViewById(R.id.schedule)

        scheButton.setOnClickListener{
            val intent = Intent(this@MainActivity, scheduleActivity::class.java)
            startActivity(intent)
        }

        var calButton : ImageButton = findViewById(R.id.calender)

        calButton.setOnClickListener {
            val intent = Intent(this@MainActivity, calenderActivity::class.java)
            startActivity(intent)
        }
    }
}