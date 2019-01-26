package io.effective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.templates.TemplateFormats;

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
}
