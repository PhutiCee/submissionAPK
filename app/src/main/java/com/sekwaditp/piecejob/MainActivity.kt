package com.sekwaditp.piecejob

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_content2.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this,drawerLayer,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayer.addDrawerListener(toggle)
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)

        setToolBar("Home")
        changeFragment(Home())


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayer.closeDrawer(GravityCompat.START)

        when(item.itemId){
            R.id.nav_home -> {
                setToolBar("Home")
                changeFragment(Home())
            }
            R.id.nav_dev -> {
                setToolBar("Profile")
                changeFragment(Profile())
            }
            R.id.nav_about -> {
                setToolBar("About Us")
                changeFragment(About())
            }
            R.id.nav_feed -> {
                setToolBar("Feed")
                changeFragment(Feed())
            }
            R.id.nav_login -> {
                setToolBar("Login")
                changeFragment(Login())
            }
        }
        return true
    }

    fun setToolBar(tittle:String){
        supportActionBar?.title = tittle
    }
    fun changeFragment(frag: Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container,frag).commit()
    }
}