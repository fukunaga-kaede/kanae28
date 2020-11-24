package jp.wings.nikkeibp.kanae28

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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

        //　時間に合わせてメッセージの内容を変更
        var greetText : TextView = findViewById(R.id.message)

        when {
            4 <= time && time < 9  -> greetText.text = "おはようございます、お嬢様。\n本日もよい一日をお過ごしくださいませ。"
            9 <= time && time < 15 -> greetText.text = "今日もお仕事頑張ってくださいね。\n応援しております。"
            15 <= time && time < 18 -> greetText.text = "そろそろお疲れではないですか。\n無理しないでくださいね。"
            18 <= time && time < 21 -> greetText.text = "お帰りなさいませ、お嬢様。\nお仕事、お疲れ様でした。"
            else -> greetText.text = "お嬢様、本日もお疲れ様でした。\nおやすみなさいませ。"
        }
        //時間に合わせて背景画像を変更
        val room : ImageView = findViewById<ImageView>(R.id.room)

        when {
            4 <= time && time < 16 -> room.setImageResource(R.drawable.room1)
            16 <= time && time < 19 -> room.setImageResource(R.drawable.room2)
            else -> room.setImageResource(R.drawable.room3)
        }

        // 「×」ボタンで消える
        var Button : Button = findViewById(R.id.close)

        Button.setOnClickListener {
            val intent = Intent(this@scheduleActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
