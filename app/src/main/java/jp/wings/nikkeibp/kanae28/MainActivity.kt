package jp.wings.nikkeibp.kanae28

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_fortune.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
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

        // fortuneボタンで占い画面に遷移
        var forButton : ImageButton = findViewById(R.id.fortune)

        forButton.setOnClickListener {
            val intent = Intent(this@MainActivity, fortuneActivity::class.java)
            startActivity(intent)
        }

        // calenderボタンでカレンダー画面に遷移
        var calButton : ImageButton = findViewById(R.id.calendar)

        calButton.setOnClickListener {
            val intent = Intent(this@MainActivity, calenderActivity::class.java)
            startActivity(intent)
        }

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


        var secretButton : Button = findViewById(R.id.secret)
        secretButton.setOnClickListener {
            val count = Random().nextInt(5)
            when {
                count == 0 -> greetText.text = "お嬢様のこと、いつも応援しております"
                count == 1 -> greetText.text = "何かお悩みがありましたらお聞きしますよ"
                count == 2 -> greetText.text = "私はいつでもお嬢様の味方ですよ"
                count == 3 -> greetText.text = "ひとりで無理しないでくださいね"
                count == 4 -> greetText.text = "いつも頑張っておられること、私は知っていますよ"
                else -> greetText.text = ""
            }
        }

    }

}