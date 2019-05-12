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
import android.R.attr.path


object RecipeMock {

    var gson = Gson()

    val TITLE1 = "Mákosguba"
    val IMAGE1 = Image("http://www.mindmegette.hu/images/231/O/img_4557.jpg", 100, 100);
    val INGREDIENT1 = Ingredient("mák", 10.0, "dkg");
    val DESCRIPTION1 = "És kész is a mákosguba.";
    val INGREDIENT_LIST1: MutableList<Ingredient> = mutableListOf()
    val recipeList: MutableList<Recipe> = mutableListOf(
        Recipe(1, TITLE1, IMAGE1, INGREDIENT_LIST1, DESCRIPTION1),
        Recipe(2, "Almáspite", IMAGE1, INGREDIENT_LIST1, DESCRIPTION1)
    )


    fun process(request: Request): Response {
        val uri = Uri.parse(request.url().toString())

        val responseString: String
        val responseCode: Int
        val headers = request.headers()
        val idPath = uri.path.substring(0, uri.path.lastIndexOf('/'))
        // TODO every endpoint
        if (uri.path == NetworkConfig.ENDPOINT_PREFIX + "Recipe" && request.method() == "GET") {

            responseString = gson.toJson(recipeList);
            responseCode = 200
        } else if (uri.path == NetworkConfig.ENDPOINT_PREFIX + "Recipe" && request.method() == "POST") {
            // TODO

            responseString = gson.toJson("asd");
            responseCode = 200
        } else if (idPath == NetworkConfig.ENDPOINT_PREFIX + "Recipe" && request.method() == "DELETE") {
            var recipeId = uri.path.substring(uri.path.lastIndexOf('/') +1).toLong()
            var deleteItem = recipeList.find { recipe -> recipe.id == recipeId }
            recipeList.remove(deleteItem)
            responseString = gson.toJson("Successful delete");
            responseCode = 200
        } else {
            responseString = "ERROR"
            responseCode = 503
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString)
    }

}