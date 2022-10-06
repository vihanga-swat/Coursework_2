package com.tech.assignment02

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.tech.assignment02.RoomData.Movies
import com.tech.assignment02.RoomData.MoviesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject

class SearchMovies : AppCompatActivity() {

    var textView1: TextView? = null
    var textView2: TextView? = null
    var textView3: TextView? = null
    var textView4: TextView? = null
    var textView5: TextView? = null
    var textView6: TextView? = null
    var textView7: TextView? = null
    var textView8: TextView? = null
    var textView9: TextView? = null
    var textView10: TextView? = null
    var editText1: EditText? = null
    var button1: Button? = null
    var button2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movies)

        textView1 = findViewById<View>(R.id.stitle) as TextView
        textView2 = findViewById<View>(R.id.syear) as TextView
        textView3 = findViewById<View>(R.id.srated) as TextView
        textView4 = findViewById<View>(R.id.sreleased) as TextView
        textView5 = findViewById<View>(R.id.sruntime) as TextView
        textView6 = findViewById<View>(R.id.sgenere) as TextView
        textView7 = findViewById<View>(R.id.sdirector) as TextView
        textView8 = findViewById<View>(R.id.swriter) as TextView
        textView9 = findViewById<View>(R.id.sactors) as TextView
        textView10 = findViewById<View>(R.id.splot) as TextView
        editText1 = findViewById<View>(R.id.searchname) as EditText
        button1 = findViewById<View>(R.id.retrive) as Button
        button2 = findViewById<View>(R.id.savebtn) as Button

        button1!!.setOnClickListener {
         Search()
        }

        button2!!.setOnClickListener {
            if (textView1==null||textView2==null||textView3==null||textView4==null||textView5==null||
                textView6==null||textView7==null||textView8==null||textView9==null||textView10==null){

                Toast.makeText(this, "Failed. Check the fields again", Toast.LENGTH_SHORT).show()

            }else{
                val movieInfo= Movies(null, textView1!!.text.toString(),textView2!!.text.toString(),
                    textView3!!.text.toString(),textView4!!.text.toString(),textView5!!.text.toString(),
                    textView6!!.text.toString(),textView7!!.text.toString(),textView8!!.text.toString(),
                    textView9!!.text.toString(),textView10!!.text.toString())

                GlobalScope.launch(Dispatchers.IO) {

                    MoviesDatabase.getInstance(this@SearchMovies).moviesDao().insert(movieInfo)
                }
                Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show()
            }
        }

    }


    fun Search() {
        val name = editText1!!.text.toString()
        if (name.isEmpty()) {
            editText1!!.error = "Please provide movie name"
            return
        }
        val url = "https://www.omdbapi.com/?t=$name&apikey=5c4f143d"
        val queue: RequestQueue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->

                try {

                    val movie = JSONObject(response)

                    val title = movie.getString("Title")
                    val year = movie.getString("Year")
                    val rated = movie.getString("Rated")
                    val released = movie.getString("Released")
                    val runtime = movie.getString("Runtime")
                    val genere = movie.getString("Genre")
                    val director = movie.getString("Director")
                    val writer = movie.getString("Writer")
                    val actors = movie.getString("Actors")
                    val plot = movie.getString("Plot")

                    textView1!!.text = title
                    textView2!!.text = year
                    textView3!!.text = rated
                    textView4!!.text = released
                    textView5!!.text = runtime
                    textView6!!.text = genere
                    textView7!!.text = director
                    textView8!!.text = writer
                    textView9!!.text = actors
                    textView10!!.text = plot

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            },
            { })
        queue.add(stringRequest)
    }

}