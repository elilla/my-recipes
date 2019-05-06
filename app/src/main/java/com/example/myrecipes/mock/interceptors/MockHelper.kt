package com.example.myrecipes.mock.interceptors

import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import okio.BufferedSource
import okio.Okio
import java.io.ByteArrayInputStream
import java.io.IOException
/**
 * Created by Acer on 2019. 05. 06..
 */
object MockHelper {

    fun makeResponse(request: Request, headers: Headers, code: Int, content: String): Response {
        val responseBody = object : ResponseBody() {
            override fun contentType(): MediaType? = MediaType.parse("application/json")

            override fun contentLength(): Long = content.toByteArray().size.toLong()

            override fun source(): BufferedSource = Okio.buffer(Okio.source(ByteArrayInputStream(content.toByteArray())))
        }

        return Response.Builder()
                .protocol(Protocol.HTTP_2)
                .code(code)
                .request(request)
                .headers(headers)
                .message("")
                .body(responseBody)
                .build()
    }

    fun bodyToString(request: Request): String {
        try {
            val copy = request.newBuilder().build()
            val buffer = Buffer()
            val body = copy.body() ?: return ""
            body.writeTo(buffer)
            return buffer.readUtf8()
        } catch (e: IOException) {
            return ""
        }
    }

}