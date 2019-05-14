import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import io.swagger.Swagger2SpringBoot;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Karate.class)
@CucumberOptions(features = "classpath:tests")
public class ApiKarateTest {

    @BeforeClass
    public static void setUp() throws Exception {
        String[] args = new String[0];
        Swagger2SpringBoot.main(args);
    }
}
