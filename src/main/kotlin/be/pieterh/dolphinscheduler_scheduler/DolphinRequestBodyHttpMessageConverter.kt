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
import kotlin.text.Charsets.UTF_8

@Component
class DolphinRequestBodyHttpMessageConverter(val mapper: ObjectMapper) : HttpMessageConverter<Object> {

    override fun canRead(clazz: Class<*>, mediaType: MediaType?): Boolean {
        return false
    }

    override fun canWrite(clazz: Class<*>, mediaType: MediaType?): Boolean {
        return supportedMediaTypes.contains(mediaType)
    }

    override fun getSupportedMediaTypes(): List<MediaType?> {
        return listOf(APPLICATION_FORM_URLENCODED)
    }

    override fun read(clazz: Class<out Object?>, inputMessage: HttpInputMessage): Object {
        throw NotImplementedError()
    }

    override fun write(t: Object, contentType: MediaType?, outputMessage: HttpOutputMessage) {
        val body = mapper.convertValue(t, UrlEncodedWriter::class.java).toString()
        outputMessage.body.write(body.toByteArray(UTF_8))
    }

    private class UrlEncodedWriter() {
        val out: StringBuilder = StringBuilder()

        @JsonAnySetter
        fun write(name: String, property: Object?) {
            if (property == null) {
                return
            }

            if (out.isNotEmpty()) {
                out.append('&')
            }

            out.append(URLEncoder.encode(name, UTF_8)).append('=')
            out.append(URLEncoder.encode(property.toString(), UTF_8))
        }

        override fun toString(): String {
            return out.toString()
        }
    }
}