import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import io.swagger.GarageCornerApplication;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Collections;


@RunWith(Karate.class)
@CucumberOptions(features = "classpath:tests/garage")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class GarageKarateTest {

    @BeforeClass
    public static void setUp() {
        String[] args = new String[0];
        SpringApplication app = new SpringApplication(GarageCornerApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
    }
}