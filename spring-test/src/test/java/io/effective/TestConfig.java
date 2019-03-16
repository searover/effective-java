package io.effective;

import lombok.val;
import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Map;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

@TestConfiguration
public class TestConfig {

    @Bean
    public RestDocumentationResultHandler handler() {
        return MockMvcRestDocumentation.document(
                "{method-name}",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint())
        );
    }

    private static final String a = null;

    @Test
    public void name() {
        val encoder = new BCryptPasswordEncoder();
        val encoded1 = encoder.encode("123456");
        val encoded2 = encoder.encode("123456");
        System.out.println(encoded1);
        System.out.println(encoded2);
//        System.out.println(encoder.matches("123456", encoded1));
//        System.out.println(encoder.matches("123456", encoded2));
        System.out.println(encoder.matches("123456", "$2a$10$z1haWd23mpjsfoR35OnV2uedpHD1S6Wn7lkGrDCBNuPkAOFXFy6vS"));
    }
}
