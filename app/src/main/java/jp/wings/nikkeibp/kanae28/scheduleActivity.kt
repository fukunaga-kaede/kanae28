package jp.wings.nikkeibp.kanae28

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.*

class scheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)


        // アクションバーにタイトル「home」を追加
        supportActionBar?.title = "home"

        //現在時刻の取得
        val calendar: Calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN);

        //時間の取得 24時間表示
        val time = calendar.get(Calendar.HOUR_OF_DAY)

        //時間に合わせて背景画像を変更
        val room : ImageView = findViewById<ImageView>(R.id.room)

        if( 4 <= time && time < 16 ){
            room.setImageResource(R.drawable.room1)
        }else if( 16 <= time && time < 19 ){
            room.setImageResource(R.drawable.room2)
        }else{
            room.setImageResource(R.drawable.room3)
        }

        // calenderボタンでカレンダー画面に遷移
        var Button : Button = findViewById(R.id.close)

        Button.setOnClickListener {
            val intent = Intent(this@scheduleActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
