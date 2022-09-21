package com.fiservpoc

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fiserv.dps.mobile.sdk.bridge.model.Zelle
import com.fiserv.dps.mobile.sdk.bridge.view.BridgeView
import com.fiserv.dps.mobile.sdk.bridge.controller.Bridge


public class LaunchZelleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_zelle)
//        BridgeView.genericTag = this
        val appName = intent.getStringExtra("appName").toString()
        val baseUrl = intent.getStringExtra("baseURL").toString()
        val instId = intent.getStringExtra("instId").toString()
        val product = intent.getStringExtra("product").toString()
        val ssoKey = intent.getStringExtra("ssoKey").toString()


        val zelle = Zelle( appName, baseUrl,
                instId, product, ssoKey, null
        )
        val bridge = Bridge(this, zelle)
        zelle.preCacheContacts = true
        val view = bridge.view()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, view).commit()
    } }