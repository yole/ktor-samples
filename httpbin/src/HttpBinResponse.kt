package io.ktor.samples.httpbin

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*

class HttpBinResponse(
    var parameters: Parameters? = null,
    var headers: Map<String, List<String>>? = null,
    var origin: String? = null,
    var url: String? = null,
    var `user-agent`: String? = null,
    var data: String? = null,
    var files: Map<String, PartData.FileItem>? = null,
    var form: Parameters? = null,
    val json: Map<String, Any>? = null,
    var gzipped: Boolean? = null,
    var deflated: Boolean? = null,
    var method: String? = null,
    var cookies: Map<String, String>? = null,
    var uuid: String? = null
)

fun HttpBinResponse.clear() {
    parameters = null
    headers = null
    url = null
    origin = null
    method = null
}

/**
 * By default send what is expected for /get
 * Use a lambda to customize the response
 **/
suspend fun ApplicationCall.sendHttpBinResponse(configure: suspend HttpBinResponse.() -> Unit = {}) {
    val response = HttpBinResponse(
        parameters = request.queryParameters,
        url = request.url(),
        origin = request.origin.remoteHost,
        method = request.origin.method.value
    )
    response.configure()
    respond(response)
}
