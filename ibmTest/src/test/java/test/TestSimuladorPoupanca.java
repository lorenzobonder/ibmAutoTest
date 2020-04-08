package test;

import Workflow.SavingsSimulationWorkflow;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import support.Screenshot;
import support.Web;

import java.util.Random;

@RunWith(DataDrivenTestRunner.class)
@DataLoader( filePaths = "fileInfoUserTest.csv")
public class TestSimuladorPoupanca {

    private WebDriver webDriver;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() {
        webDriver = Web.createChromeInstance();
    }

    @Test
    public void simularInvestimentoPoupancaOk(@Param(name="tipoUsuario")String tipo, @Param(name="valorAplicar")String valAplicar, @Param(name="valorPoupar")String valPoupar, @Param(name="periodo")String tempo) throws Exception {
        try {
            SavingsSimulationWorkflow ssw = new SavingsSimulationWorkflow(webDriver);

            Assert.assertTrue(ssw.simularInvestimentoPoupancaOk(tipo, valAplicar, valPoupar, tempo));
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simularInvestimentoComaValorAplicadoInvalido(@Param(name="tipoUsuario")String tipo, @Param(name="valorAplicar")String valAplicar, @Param(name="valorPoupar")String valPoupar, @Param(name="periodo")String tempo) throws Exception {
        try {
            SavingsSimulationWorkflow ssw = new SavingsSimulationWorkflow(webDriver);

            Assert.assertTrue(ssw.simularInvestimentoPoupancaComErros(tipo, valAplicar, valPoupar, tempo));
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simularInvestimentoComPeriodoInvalido(@Param(name="tipoUsuario")String tipo, @Param(name="valorAplicar")String valAplicar, @Param(name="valorPoupar")String valPoupar, @Param(name="periodo")String tempo) throws Exception {
        try {
            SavingsSimulationWorkflow ssw = new SavingsSimulationWorkflow(webDriver);

            Assert.assertTrue(ssw.simularInvestimentoPoupancaComErros(tipo, valAplicar, valPoupar, tempo));
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }



    @After
    public void shutDown() {
        webDriver.quit();
    }
}
