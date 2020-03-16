package com.example.iphone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.iphone.fragments.ShowListEquipment
import com.example.iphone.interfaces.ActivityListener

class MainActivity : AppCompatActivity(), ActivityListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.layoutMain, ShowListEquipment())
                .addToBackStack("f1")
                .commit()
        }
    }

    override fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.layoutMain, fragment)
            addToBackStack(fragment.tag)
            commit()
        }
    }

}
