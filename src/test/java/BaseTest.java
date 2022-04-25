import constants.AplicationConstants;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

import static constants.DriverConstants.CLOSE_BROWNSER;
import static factory.DriverFactory.getDriver;
import static factory.DriverFactory.killDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        /* Tags que estão na Feature, é aqui que definimos o que será executado ao realizar os testes*/
        tags = "@validado",

         /*apresenta o diretorio onde se encontra as features*/
        features = "src/test/resources",

        /* defini onde esta os metodos que estao ligados a feature*/
        glue = "steps",

        /*apresentar os logs de forma legível*/
        monochrome = true,

        /* apresenta metodos a serem inseridos nos steps, de acordo com a feature*/
        snippets = CucumberOptions.SnippetType.CAMELCASE,

        /* para geração de relatorios formato cucumber*/
        plugin = {
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber-report.json"
        }
)
public class BaseTest {

        /*Método que será invocado antes de iniciar a bateria de testes*/
        @BeforeClass
        public static void setup() throws Exception {
                try {
                         /* -informa para a instancia da JVM que o driver esta no referido diretório
                         *  - daria certo também, informando o "path" como variável de ambiente, no entanto dessa forma
                         *  é mais genérica e também uma boa prática
                         */
                        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//driver//geckodriver");
//                        System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") + "//driver//chromedriver");

                        /*Comando para maximizar a janela do navegador*/
                        getDriver().manage().window().maximize();

                        /*Acessa a URL definida nas constantes*/
                        getDriver().get(AplicationConstants.URL);

                } catch (Exception e) {
                        e.printStackTrace();
                        throw new Exception("Erro no método Before! ");
                }
        }

        /*Método que será invocado quando terminar a bateria de testes*/
        @AfterClass
        public static void afterTest() throws IOException, InterruptedException, Exception {

                try {
                        /*Verifica se está setado para fechar o brownser ao terminar os testes*/
                        if (CLOSE_BROWNSER) {
                                /*"Mata" a sessão do driver*/
                                killDriver();
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                        throw new Exception(e.getMessage() + "\n\nErro no método AfterTest! \n" + e.getMessage());
                }
        }
}
