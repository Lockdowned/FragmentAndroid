package com.example.menagevehiclefragment

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.menagevehiclefragment.databinding.ActivityMainBinding
import com.example.menagevehiclefragment.fragment.CreateFragment
import com.example.menagevehiclefragment.fragment.EditFragment
import com.example.menagevehiclefragment.fragment.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)  // 1: почему так теперь не работает

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView) // 1: а так ок

        val listFragment = ListFragment()
        val createFragment = CreateFragment()
        val editFragment = EditFragment()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miList -> setCurrentFragment(listFragment)
                R.id.miCreate -> setCurrentFragment(createFragment)
                R.id.miEdit -> setCurrentFragment(editFragment)
            }
            true
        }




    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFragment, fragment)
            commit()
        }
    }
}