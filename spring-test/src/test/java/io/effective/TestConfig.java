package io.effective;

import lombok.val;
import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

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
        val sr = new SecureRandom(new byte[]{0});
        val bytes = sr.generateSeed(1);
        val pe = new BCryptPasswordEncoder(31);
        val encoded = pe.encode("123456");
        System.out.println(encoded);
    }
}
