package com.project.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.project.myapplication.*
import com.project.myapplication.fragment.AboutUsFragment
import com.project.myapplication.fragment.DashboardFragment
import com.project.myapplication.fragment.FavouritesFragment
import com.project.myapplication.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var drawerlayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frame: FrameLayout
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    lateinit var navigationview:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var previousMenuItem: MenuItem?=null
        drawerlayout=findViewById(R.id.drawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        frame=findViewById(R.id.frame)
        toolbar=findViewById(R.id.toolbar)
        navigationview=findViewById(R.id.navigation)
        SetUpToolbar()
        val actionBarDrawerToggle= ActionBarDrawerToggle(this@MainActivity,drawerlayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        openDashboardFragment()

        navigationview.setNavigationItemSelectedListener {
            if(previousMenuItem!=null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it
            when(it.itemId)
            {
                R.id.dashboard ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        DashboardFragment()
                    ).commit()
                    drawerlayout.closeDrawers()
                    supportActionBar?.title="Food Items"
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        ProfileFragment()
                    ).commit()
                    drawerlayout.closeDrawers()
                    supportActionBar?.title="Profile"
                }
                R.id.aboutUs ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        AboutUsFragment()
                    ).commit()
                    drawerlayout.closeDrawers()
                    supportActionBar?.title="About Us"
                }
                R.id.favourites ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        FavouritesFragment()
                    ).commit()
                    drawerlayout.closeDrawers()
                    supportActionBar?.title="Favourites"
                }
            }
            return@setNavigationItemSelectedListener true
        }

    }
    fun SetUpToolbar()
    {
        setSupportActionBar(toolbar)
        supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId

        if(id==android.R.id.home)
        {
            drawerlayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)


    }
    fun openDashboardFragment()
    {
        val fragment= DashboardFragment()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.frame,
            DashboardFragment()
        )
        transaction.commit()
        supportActionBar?.title="DashBoard"
        navigationview.setCheckedItem(R.id.dashboard)
        drawerlayout.closeDrawers()

    }

    override fun onBackPressed() {
        val frag=supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            !is DashboardFragment -> openDashboardFragment()
            else ->super.onBackPressed()
        }

    }
}
