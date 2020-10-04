package jp.wings.nikkeibp.kanae28

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import java.util.*

class addActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        // アクションバーに戻るボタン（←）を追加
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // アクションバーにタイトル「add」を追加
        supportActionBar?.title = "add"

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