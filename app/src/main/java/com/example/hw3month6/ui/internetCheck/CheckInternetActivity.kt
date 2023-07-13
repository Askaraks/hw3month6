package com.example.hw3month6.ui.internetCheck

import android.content.Intent
import com.example.hw3month6.core.base.BaseActivity
import com.example.hw3month6.databinding.ActivityCheckInternetBinding
import com.example.hw3month6.ui.playlist.PlayListsActivity

class CheckInternetActivity : BaseActivity<ActivityCheckInternetBinding>() {

    override fun inflateViewBinding() = ActivityCheckInternetBinding.inflate(layoutInflater)

    override fun initUI() {
        val checkInternet = CheckInternet(application)
        checkInternet.observe(this) { isConnected ->
            binding.btnCheck.setOnClickListener {
                if (isConnected) {
                    val intent = Intent(this, PlayListsActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }
        }
    }
}