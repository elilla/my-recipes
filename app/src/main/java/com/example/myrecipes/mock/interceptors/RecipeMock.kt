package com.example.myrecipes.mock.interceptors

/**
 * Created by Acer on 2019. 05. 06..
 */
import android.net.Uri
import com.example.myrecipes.model.Image
import com.example.myrecipes.model.Ingredient
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.network.NetworkConfig
import com.google.gson.Gson
import okhttp3.Request
import okhttp3.Response

object RecipeMock {

    var gson = Gson()

    val TITLE1 = "Mákosguba"
    val IMAGE1 = Image("http://www.mindmegette.hu/images/231/O/img_4557.jpg", 100, 100);
    val INGREDIENT1 = Ingredient("mák", 10.0, "dkg");
    val DESCRIPTION1 = "És kész is a mákosguba.";
    val INGREDIENT_LIST1: MutableList<Ingredient> = mutableListOf()


    fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        val responseString: String
        val responseCode: Int
        val headers = request.headers()

        // TODO every endpoint
        if (uri.path == NetworkConfig.ENDPOINT_PREFIX + "recipe" && request.method() == "GET") {

            responseString = gson.toJson("asd");
            responseCode = 200
        } else if (uri.path == NetworkConfig.ENDPOINT_PREFIX + "recipe" && request.method() == "POST") {
            // TODO

            responseString = gson.toJson("asd");
            responseCode = 200
        } else {
            responseString = "ERROR"
            responseCode = 503
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString)
    }

}