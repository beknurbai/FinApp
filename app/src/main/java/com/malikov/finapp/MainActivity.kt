package com.malikov.finapp

import CreateAlert
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.malikov.finapp.databinding.ActivityMainBinding
import com.malikov.finapp.ui.`object`.AppDrawer
import com.malikov.finapp.ui.framents.AccountFragment
import com.malikov.finapp.ui.framents.CostsFragment
import com.malikov.finapp.ui.framents.SuccessesFragment
import com.malikov.finapp.utils.APP_ACTIVITY
import com.malikov.finapp.utils.replaceFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: AppDrawer
    lateinit var mToolbar: Toolbar
    lateinit var mAlert: CreateAlert


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        initFields()
        init()

    }


    private fun initFields() {
        mBinding.bottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_account -> replaceFragment(AccountFragment())
                R.id.menu_costs -> replaceFragment(CostsFragment())
                R.id.menu_successes -> replaceFragment(SuccessesFragment())
            }
            true
        }
        mToolbar = mBinding.mainToolbar
        mDrawer = AppDrawer()
        mAlert = CreateAlert()
    }


    private fun init() {
        setSupportActionBar(mToolbar)
        mDrawer.create()
    }


}