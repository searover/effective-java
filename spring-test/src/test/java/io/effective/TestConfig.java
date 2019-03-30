package io.effective;

import io.effective.model.AmsUser;
import lombok.val;
import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

import java.io.*;

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
    public void serialize() throws IOException {
        val user = new AmsUser();
        user.setName("Hello");
        val fos = new FileOutputStream("AmsUser.txt");
        val oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.flush();
        oos.close();
    }

    @Test
    public void deserialize() throws IOException, ClassNotFoundException {
        AmsUser user;
        val fis = new FileInputStream("AmsUser.txt");
        val ois = new ObjectInputStream(fis);
        user = (AmsUser) ois.readObject();
        ois.close();
        System.out.println("AmsUser deserialize: " + user);
    }
}
