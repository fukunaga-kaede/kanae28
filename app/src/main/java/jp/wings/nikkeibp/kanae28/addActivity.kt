package jp.wings.nikkeibp.kanae28

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class addActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "add"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}