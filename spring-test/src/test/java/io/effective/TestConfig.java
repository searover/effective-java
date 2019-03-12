package io.effective;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import io.effective.model.Person;
import lombok.val;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.templates.TemplateFormats;

import java.util.List;

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
        System.out.println(RandomStringUtils.randomNumeric(6));
    }
}
