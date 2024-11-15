package com.example.film_s

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var movieTextView: TextView
    private lateinit var showMovieButton: Button
    private lateinit var resetButton: Button

    private lateinit var allMovies: MutableList<String>
    private lateinit var remainingMovies: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieTextView = findViewById(R.id.movieTextView)
        showMovieButton = findViewById(R.id.showMovieButton)
        resetButton = findViewById(R.id.resetButton)

        allMovies = resources.getStringArray(R.array.movies_list).toMutableList()
        remainingMovies = allMovies.toMutableList()

        showMovieButton.setOnClickListener {
            if (remainingMovies.isNotEmpty()) {
                val randomMovie = remainingMovies.random()
                remainingMovies.remove(randomMovie)
                movieTextView.text = randomMovie
            } else {
                movieTextView.text = "Фильмы закончились"
            }
        }

        resetButton.setOnClickListener {
            remainingMovies = allMovies.toMutableList()
            movieTextView.text = "Список сброшен"
        }
    }
}