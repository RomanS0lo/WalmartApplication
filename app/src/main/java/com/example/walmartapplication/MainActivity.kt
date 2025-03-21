package com.example.walmartapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.walmartapplication.databinding.ActivityMainBinding
import com.example.walmartapplication.ui.country_list.CountryListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CountryListFragment()).commit()
        }
    }
}
