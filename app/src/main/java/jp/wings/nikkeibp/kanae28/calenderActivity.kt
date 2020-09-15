package jp.wings.nikkeibp.kanae28

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton

class calenderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender)



        // アクションバーに戻るボタン（←）を追加
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // アクションバーにタイトル「calender」を追加
        supportActionBar?.title = "calender"

        // plusボタンでadd画面に遷移
        var plusButton : ImageButton = findViewById(R.id.plus)

        plusButton.setOnClickListener {
            val intent = Intent(this@calenderActivity, addActivity::class.java)
            startActivity(intent)
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