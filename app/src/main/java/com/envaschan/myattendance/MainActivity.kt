package com.envaschan.myattendance

import android.Manifest
//import android.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val url = ContextCompat.checkSelfPermission(this,Manifest.permission.INTERNET)

    ActivityCompat.requestPermissions(
        this@MainActivity,
        arrayOf(Manifest.permission.INTERNET),
        1005
    )

    val name_text = findViewById<EditText>(R.id.message)

    val button_notice = findViewById<Button>(R.id.button_notice)
    val button_attend = findViewById<Button>(R.id.button_attend)
    val text = findViewById<TextView>(R.id.text_response)

    name_text.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {


        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })





    button_attend.setOnClickListener{
        val url = "http://218.237.246.15:8080/api/echo-json"
//           val response_text = URL("http://192.168.0.43:8080/api/echo-json").readText()

        val textView = findViewById<TextView>(R.id.text_response)
        // ...

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)

        // Request a string response from the provided URL.
        val json_obj = JSONObject()
        json_obj.put("student_name", name_text.text)
        val json_req = JsonObjectRequest(url, json_obj, Response.Listener
        { response ->

        }, Response.ErrorListener {
                error ->

        })
        // Add the request to the RequestQueue.
        queue.add(json_req)

    }

        button_notice.setOnClickListener {

//            button_attend.text = response_text
        }
    }
}
