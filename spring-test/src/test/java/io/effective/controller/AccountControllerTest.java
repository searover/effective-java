package io.effective.controller;

import io.effective.TestConfig;
import io.effective.model.AmsAccount;
import io.effective.service.AccountService;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.templates.TemplateFormat;
import org.springframework.restdocs.templates.TemplateFormats;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@ContextConfiguration(classes = TestConfig.class)
@AutoConfigureRestDocs
public class AccountControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private RestDocumentationResultHandler docHandler;
    @Autowired
    private MockMvcRestDocumentationConfigurer configurer;
    @MockBean
    private AccountService accountService;

    @Before
    public void setUp() throws Exception {
        configurer.uris().withHost("192.168.101.6").withPort(8012);
    }

    @Test
    public void getAccountTest() throws Exception {
        val account = new AmsAccount(1L, "", new Date());
        when(accountService.getAmsAccountById(anyLong())).thenReturn(account);
        mvc.perform(get("/account/{id}", account.getId()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", is(account.getName())))
                .andDo(docHandler.document(requestParameters(
                        parameterWithName("name").description("用户名").optional(),
                        parameterWithName("mobile").description("电话号码").optional(),
                        parameterWithName("email").description("邮箱").optional()
                        )))
                .andReturn();
    }
}
