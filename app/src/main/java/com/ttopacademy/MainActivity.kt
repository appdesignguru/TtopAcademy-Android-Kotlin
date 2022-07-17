package com.ttopacademy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.ttopacademy.ui.fragments.CategoryListFragment
import com.ttopacademy.ui.viewmodels.FakeMainViewModel
import com.ttopacademy.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/** Main Activity for app. */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel: MainViewModel = ViewModelProvider(this).get(FakeMainViewModel::class.java)

        val fragmentManager: FragmentManager = supportFragmentManager
        var fragment: Fragment? = fragmentManager.findFragmentById(R.id.fragment_container_view);
        if (fragment == null){
            fragment =  CategoryListFragment()
            fragmentManager.beginTransaction().add(R.id.fragment_container_view, fragment).commit()
        }
    }
}