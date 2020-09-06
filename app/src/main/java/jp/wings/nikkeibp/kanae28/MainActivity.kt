package jp.wings.nikkeibp.kanae28

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        setContentView(R.layout.home)

        var calButton : ImageButton = findViewById(R.id.calender)
        // var scheButton : Button = findViewById(R.id.schedule)
        calButton.setOnClickListener{
            val intent = Intent(this@MainActivity, scheduleActivity::class.java)
            startActivity(intent)
        }
    }
}