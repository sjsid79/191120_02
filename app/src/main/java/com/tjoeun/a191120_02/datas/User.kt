package com.tjoeun.a191120_02.datas

import org.json.JSONObject
import java.io.Serializable

class User : Serializable {

    var loginId = ""
    var name = ""
    var category:Category? = null

    companion object {
        fun getUserFromJson(userJson : JSONObject) : User {
            var userObject = User()

            // 왼쪽 : 우리가 만든 클래스 변수
            // 오른쪽 : 서버에서 내려주는 JSON 활용
            userObject.loginId = userJson.getString("login_id")
            userObject.name = userJson.getString("name")

            userObject.category = Category.getCategoryFromJson(userJson.getJSONObject("category"))

            return userObject
        }
    }

}