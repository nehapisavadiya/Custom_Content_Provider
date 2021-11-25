package com.example.customcontentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class AcronymProvider : ContentProvider() {
    companion object{
        val PROVIDER_NAME = "com.example.customcontentprovider/AcronymProvider"
        val URL = "content://$PROVIDER_NAME/actable"
        val CONTENT_URI = Uri.parse(URL)

        val _ID = "_id"
        val NAME = "NAME"
        val MEANING = "MEANING"
    }
    lateinit var db : SQLiteDatabase

    override fun onCreate(): Boolean {
        var helper = MyHelper(getContext()!!)
        db = helper.writableDatabase
        return if(db == null) false else true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        return db.query("actable",p1,p2,p3,null,null,p4)
    }

    override fun getType(p0: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.actable"
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        db.insert("actable",null,p1)
        return p0
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        var count = db.delete("actable",p1,p2)
        return count
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        var count = db.update("actable",p1,p2,p3)
        return count
    }
}