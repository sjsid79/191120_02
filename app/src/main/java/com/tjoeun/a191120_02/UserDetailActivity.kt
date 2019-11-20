package com.tjoeun.a191120_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a191120_02.utils.ConnectServer
import org.json.JSONObject

class UserDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
    }


    override fun setupEvents() {

    }

    override fun setValues() {

    }

    fun getCategoryListFromServer() {
        ConnectServer.getRequestCategoryList(mComtext, object : ConnectServer.JsonResponseHandler {
            override fun onResponse(json: JSONObject) {

                Log.d("카타고리응답", json.toString())

            }

        })
    }
}
