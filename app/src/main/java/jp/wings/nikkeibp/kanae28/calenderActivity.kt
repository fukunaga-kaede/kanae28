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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "calender"

        var plusButton : ImageButton = findViewById(R.id.plus)

        plusButton.setOnClickListener {
            val intent = Intent(this@calenderActivity, addActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}