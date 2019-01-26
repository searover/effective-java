import org.jooq.codegen.GenerationTool;

import java.nio.file.Files;

public class Main {
    public static void main(String[] args) throws Exception {

    }

    private static void generate() throws Exception {
        String userDir = System.getProperty("user.dir");
        String javaDir = userDir + "/jooq/src/main/java";
        String library = userDir + "/jooq/src/main/resources/library.xml";
        System.out.println(library);
        GenerationTool.main(new String[]{library});
    }
}
