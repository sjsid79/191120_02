package com.tjoeun.a191120_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a191120_02.datas.Category
import com.tjoeun.a191120_02.utils.ConnectServer
import org.json.JSONObject

class UserDetailActivity : BaseActivity() {

    var categoryList =  ArrayList<Category>()

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

                var code = json.getInt("code")

                if (code == 200) {
                    var data = json.getJSONObject("data")
                    var userCategories = data.getJSONArray("user_categories")

                    categoryList.clear()

                    for (i in 0..userCategories.length() - 1){
                        var uc = userCategories.getJSONObject(i)
                        var categoryData = Category.getCategoryFromJson(uc)

                        categoryList.add(categoryData)
                    }

                    runOnUiThread{
                        //스피너 새로고침 필요
                    }

                }

            }

        })
    }
}
