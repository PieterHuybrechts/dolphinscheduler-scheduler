package be.pieterh.dolphinscheduler_scheduler

import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpInputMessage
import org.springframework.http.HttpOutputMessage
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.stereotype.Component
import java.net.URLEncoder

@Component
class DolphinRequestBodyHttpMessageConverter(val mapper: ObjectMapper) : HttpMessageConverter<DolphinRequestBody> {

    override fun canRead(clazz: Class<*>, mediaType: MediaType?): Boolean {
        return false
    }

    override fun canWrite(clazz: Class<*>, mediaType: MediaType?): Boolean {
        return supportedMediaTypes.contains(mediaType)
    }

    override fun getSupportedMediaTypes(): List<MediaType?> {
        return listOf(APPLICATION_FORM_URLENCODED)
    }

    override fun read(clazz: Class<out DolphinRequestBody?>, inputMessage: HttpInputMessage): DolphinRequestBody {
        throw NotImplementedError()
    }

    override fun write(t: DolphinRequestBody, contentType: MediaType?, outputMessage: HttpOutputMessage) {
        println(t)
        val body = mapper.convertValue(t, UrlEncodedWriter::class.java).toString()
        println(body)

        outputMessage.body.write(body.toByteArray(Charsets.UTF_8))
    }

    private class UrlEncodedWriter() {
        val out: StringBuilder = StringBuilder()

        @JsonAnySetter
        fun write(name: String, property: Object?) {
            if (out.isNotEmpty()) {
                out.append('&')
            }

            out.append(URLEncoder.encode(name, Charsets.UTF_8)).append('=')
            out.append(URLEncoder.encode(property?.toString() ?: "", Charsets.UTF_8))
        }

        override fun toString(): String {
            return out.toString()
        }
    }
}