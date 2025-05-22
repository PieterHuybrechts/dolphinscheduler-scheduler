package be.pieterh.dolphinscheduler_scheduler;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.NotImplementedError;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;

@Component
public class DolphinRequestBodyHttpMessageConverter implements HttpMessageConverter<DolphinRequestBody> {

    private final ObjectMapper objectMapper;

    public DolphinRequestBodyHttpMessageConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return getSupportedMediaTypes().contains(mediaType);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return List.of(APPLICATION_FORM_URLENCODED);
    }

    @Override
    public DolphinRequestBody read(Class<? extends DolphinRequestBody> clazz, HttpInputMessage inputMessage) throws HttpMessageNotReadableException {
        throw new NotImplementedError();
    }

    @Override
    public void write(DolphinRequestBody o, MediaType contentType, HttpOutputMessage outputMessage) throws HttpMessageNotWritableException {
        if (o != null) {
            String body = objectMapper.convertValue(o, UrlEncodeWriter.class).toString();
            try {
                outputMessage.getBody().write(body.getBytes(UTF_8));
            } catch (IOException ignored) {

            }
        }
    }

    private static class UrlEncodeWriter {
        StringBuilder out = new StringBuilder();

        public UrlEncodeWriter() {

        }

        @JsonAnySetter
        public void write(String name, Object property) {
            if (!out.isEmpty()) {
                out.append('&');
            }

            out.append(URLEncoder.encode(name, UTF_8)).append('=');

            if (property != null) {
                out.append(URLEncoder.encode(property.toString(), UTF_8));
            }
        }

        @Override
        public String toString() {
            return out.toString();
        }
    }
}
