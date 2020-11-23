package jp.wings.nikkeibp.kanae28

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fortune.*
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class fortuneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fortune)


        val assetManager = resources.assets //アセット呼び出し
        val inputStream = assetManager.open("fortune.json") //Jsonファイル
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val str: String = bufferedReader.readText() //データ



        try {
            val jsonObject = JSONObject(str)
            val jsonArray = jsonObject.getJSONArray("fortune")

            val i = Random().nextInt(12)

            val jsonData = jsonArray.getJSONObject(i)
            textView1.text = "${jsonData.getString("content")}"
            textView2.text = "ラッキーアイテム : ${jsonData.getString("item")}"
            textView3.text = "ラッキーカラー : ${jsonData.getString("color")}"


        }catch (e: JSONException) {
            e.printStackTrace()
        }
    }


}
