package com.tech.assignment02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tech.assignment02.RoomData.Movies
import com.tech.assignment02.RoomData.MoviesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddMovies : AppCompatActivity() {

    var edittext1: EditText? = null
    var edittext2: EditText? = null
    var edittext3: EditText? = null
    var edittext4: EditText? = null
    var edittext5: EditText? = null
    var edittext6: EditText? = null
    var edittext7: EditText? = null
    var edittext8: EditText? = null
    var edittext9: EditText? = null
    var edittext10: EditText? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movies)

        edittext1 = findViewById<View>(R.id.title) as EditText
        edittext2 = findViewById<View>(R.id.year) as EditText
        edittext3 = findViewById<View>(R.id.rated) as EditText
        edittext4 = findViewById<View>(R.id.released) as EditText
        edittext5 = findViewById<View>(R.id.runtime) as EditText
        edittext6 = findViewById<View>(R.id.genere) as EditText
        edittext7 = findViewById<View>(R.id.director) as EditText
        edittext8 = findViewById<View>(R.id.writer) as EditText
        edittext9 = findViewById<View>(R.id.actors) as EditText
        edittext10 = findViewById<View>(R.id.plot) as EditText

        button = findViewById<View>(R.id.save) as Button

        button!!.setOnClickListener{
          if (edittext1==null||edittext2==null||edittext3==null||edittext4==null||edittext5==null||
              edittext6==null||edittext7==null||edittext8==null||edittext9==null||edittext10==null){

              Toast.makeText(this, "Failed. Check the fields again", Toast.LENGTH_SHORT).show()

          }else{
              val movieInfo=Movies(null, edittext1!!.text.toString(),edittext2!!.text.toString(),
                  edittext3!!.text.toString(),edittext4!!.text.toString(),edittext5!!.text.toString(),
                  edittext6!!.text.toString(),edittext7!!.text.toString(),edittext8!!.text.toString(),
                  edittext9!!.text.toString(),edittext10!!.text.toString())

              GlobalScope.launch(Dispatchers.IO) {

                  MoviesDatabase.getInstance(this@AddMovies).moviesDao().insert(movieInfo)
              }
              Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show()
          }
        }
    }
}