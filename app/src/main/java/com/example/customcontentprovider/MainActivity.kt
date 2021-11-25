package com.example.customcontentprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rs = contentResolver.query(AcronymProvider.CONTENT_URI,
            arrayOf(AcronymProvider._ID, AcronymProvider.NAME, AcronymProvider.MEANING),
            null,null,null)

        /*if(rs?.moveToFirst()!!)
            Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_LONG).show()*/

        var lv = findViewById<ListView>(R.id.listview1)
        var adapter = SimpleCursorAdapter(applicationContext,android.R.layout.simple_list_item_2,rs,
            arrayOf(AcronymProvider.NAME, AcronymProvider.MEANING), intArrayOf(android.R.id.text1, android.R.id.text2),0)
        lv.adapter = adapter
    }
}