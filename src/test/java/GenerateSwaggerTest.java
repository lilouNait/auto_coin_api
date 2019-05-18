import io.swagger.Swagger2SpringBoot;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.core.MediaType;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Swagger2SpringBoot.class)
public class GenerateSwaggerTest {

    @Autowired
    private WebApplicationContext context;

    @Test
    public void generateSwagger() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo((result) -> FileUtils.writeStringToFile(new File("./documentation/swagger.json"), result.getResponse().getContentAsString()));

    }
}
