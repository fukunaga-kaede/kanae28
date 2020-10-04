package jp.wings.nikkeibp.kanae28

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import java.text.SimpleDateFormat
import java.util.*

class calenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)



        // アクションバーに戻るボタン（←）を追加
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // アクションバーにタイトル「calender」を追加
        supportActionBar?.title = "calendar"

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

        // plusボタンでadd画面に遷移
        var plusButton : Button = findViewById(R.id.plus)

        plusButton.setOnClickListener {
            val intent = Intent(this@calenderActivity, addActivity::class.java)
            startActivity(intent)
        }

        val format = SimpleDateFormat("yyyy/MM/dd", Locale.US)

        val calendarView = findViewById<CalendarView>(R.id.calendar)

        // 初期選択日を取得
        val defaultDate = calendarView.date
        val today = format.format(defaultDate)

        var scheduleText : TextView = findViewById(R.id.message)
        scheduleText.text = "本日$today の\n予定でございます。"



        // 日付変更イベントを追加
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val month2 = month +1
            val date = "$year/$month2/$dayOfMonth"

            var scheduleText : TextView = findViewById(R.id.message)
            scheduleText.text = "$date の\n予定でございます。"
        }

    }

    // 戻るボタンの機能を実装
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
