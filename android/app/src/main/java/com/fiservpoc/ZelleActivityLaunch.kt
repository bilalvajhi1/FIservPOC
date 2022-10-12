package com.fiservpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fiserv.dps.mobile.sdk.bridge.controller.Bridge
import com.fiserv.dps.mobile.sdk.bridge.model.Zelle

class ZelleActivityLaunch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zelle_launch2)
        val appName = intent.getStringExtra("appName").toString()
        val baseUrl = intent.getStringExtra("baseURL").toString()
        val instId = intent.getStringExtra("instId").toString()
        val product = intent.getStringExtra("product").toString()
        val ssoKey = intent.getStringExtra("ssoKey").toString()
        val parameters: HashMap<String, String>? = intent.getSerializableExtra("parameters") as HashMap<String, String>?
        val pd: Map<String, Map<String, String>> = intent.getSerializableExtra("pd") as Map<String, Map<String, String>>

        val zelle = Zelle( appName, baseUrl, instId, product, ssoKey, pd, parameters)
        val bridge = Bridge(this, zelle)
        zelle.preCacheContacts = true
        val view = bridge.view()

        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, view).commit()
    }
}