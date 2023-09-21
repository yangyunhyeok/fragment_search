package com.example.npcamp_fragmentsearch20230918

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.npcamp_fragmentsearch20230918.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            home.setOnClickListener {
                setFragment(SearchFragment())
            }
            like.setOnClickListener {
                setFragment(LikeFragment())
            }
        }
        setFragment(SearchFragment())
    }
    private fun setFragment(Fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentLayout, Fragment)
            .commit()
    }
}