package com.fox.polyproduct

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fox.polyproduct.fragment.HomeFragment
import com.fox.polyproduct.fragment.InboxFragment
import com.fox.polyproduct.fragment.SaleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(savedInstanceState)
    }

    private fun loadFragment(savedInstanceState: Bundle?){
        val fragmentList : MutableList<Fragment> = mutableListOf()
        fragmentList.add(HomeFragment())
        fragmentList.add(SaleFragment())
        fragmentList.add(InboxFragment())
        navigation.initialize(viewPager,supportFragmentManager,fragmentList,savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        navigation.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when{
            item.itemId == R.id.action_nav_cart -> {
                startActivity(Intent(this@MainActivity,CartActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

}
