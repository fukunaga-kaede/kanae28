package jp.wings.nikkeibp.kanae28

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // アクションバー（上の青いところ）にタイトル「home」を追加
        supportActionBar?.title = "home"

        // scheduleボタンでスケジュール画面に遷移
        var scheButton : ImageButton = findViewById(R.id.schedule)

        scheButton.setOnClickListener{
            val intent = Intent(this@MainActivity, scheduleActivity::class.java)
            startActivity(intent)
        }

        // calenderボタンでカレンダー画面に遷移
        var calButton : ImageButton = findViewById(R.id.calender)

        calButton.setOnClickListener {
            val intent = Intent(this@MainActivity, calenderActivity::class.java)
            startActivity(intent)
        }
    }
}