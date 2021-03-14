package com.example.menagevehiclefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.menagevehiclefragment.fragment.CreateFragment
import com.example.menagevehiclefragment.fragment.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = ListFragment()
        val createFragment = CreateFragment()

//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.mainFragment, createFragment)
//            commit()
//        }

        btnAdd.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.mainFragment, createFragment)
                commit()
            }
        }
    }
}