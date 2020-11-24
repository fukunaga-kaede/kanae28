package jp.wings.nikkeibp.kanae28

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
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

        // アクションバーにタイトル「home」を追加
        supportActionBar?.title = "home"


        val assetManager = resources.assets //アセット呼び出し
        val inputStream = assetManager.open("fortune.json") //Jsonファイル
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val str: String = bufferedReader.readText() //データ



        try {
            val jsonObject = JSONObject(str)
            val jsonArray = jsonObject.getJSONArray("fortune")

            //1～12のランダムな整数をiに代入
            // val i = Random().nextInt(12)
            val i = 0;

            val jsonData = jsonArray.getJSONObject(i)
            message.text = "${jsonData.getString("content")}"
            item.text = "ラッキーアイテム : ${jsonData.getString("item")}"
            color.text = "ラッキーカラー : ${jsonData.getString("color")}"

            val totalcount = jsonData.getString("total")

            when {
                totalcount == "1" -> totalstar.text  = "☆"
                totalcount == "2" -> totalstar.text  = "☆☆"
                totalcount == "3" -> totalstar.text  = "☆☆☆"
                totalcount == "4" -> totalstar.text  = "☆☆☆☆"
                totalcount == "5" -> totalstar.text  = "☆☆☆☆☆"
                else -> totalstar.text  = ""
            }

            val lovecount = jsonData.getString("love")

            when {
                lovecount == "1" -> lovestar.text  = "☆"
                lovecount == "2" -> lovestar.text  = "☆☆"
                lovecount == "3" -> lovestar.text  = "☆☆☆"
                lovecount == "4" -> lovestar.text  = "☆☆☆☆"
                lovecount == "5" -> lovestar.text  = "☆☆☆☆☆"
                else -> lovestar.text  = ""
            }

            val jobcount = jsonData.getString("job")

            when {
                jobcount == "1" -> jobstar.text  = "☆"
                jobcount == "2" -> jobstar.text  = "☆☆"
                jobcount == "3" -> jobstar.text  = "☆☆☆"
                jobcount == "4" -> jobstar.text  = "☆☆☆☆"
                jobcount == "5" -> jobstar.text  = "☆☆☆☆☆"
                else -> totalstar.text  = ""
            }

            val moneycount = jsonData.getString("money")

            when {
                moneycount == "1" -> moneystar.text  = "☆"
                moneycount == "2" -> moneystar.text  = "☆☆"
                moneycount == "3" -> moneystar.text  = "☆☆☆"
                moneycount == "4" -> moneystar.text  = "☆☆☆☆"
                moneycount == "5" -> moneystar.text  = "☆☆☆☆☆"
                else -> totalstar.text  = ""
            }

        }catch (e: JSONException) {
            e.printStackTrace()
        }

        //現在時刻の取得
        val calendar: Calendar = Calendar.getInstance(
            TimeZone.getTimeZone("Asia/Tokyo"),
            Locale.JAPAN
        );

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

        // 「×」ボタンで消える
        var Button : Button = findViewById(R.id.close)

        Button.setOnClickListener {
            val intent = Intent(this@fortuneActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
