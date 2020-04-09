package Workflow;

import org.junit.Assert;
import support.*;
import pages.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SavingsSimulationWorkflow {

    private WebDriver driver;
    private WebDriverWait waitPage;

    public SavingsSimulationWorkflow (WebDriver driver)  {
        this.driver = driver;
        waitPage = new WebDriverWait(driver, 10);
    }


    public Boolean simularInvestimentoPoupancaOk(String tipoAssociado, String valorAplicar, String valorSalvar, String periodo) throws InterruptedException {
        SimuladorInvestimentoPage sip = new SimuladorInvestimentoPage(driver);

        if(tipoAssociado.contains("Individual")) {
            sip.selectSimulationForMyself();
        }
        else if (tipoAssociado.contains("EmpresaOuAgro")) {
            sip.selectSimulationForCompany();
        }

        String pathEvidenciasTeste = "C:\\Users\\Lorenzo\\automation_output\\ibmTest\\ibmTesting" + Generators.dateTimeToFile() ;

        String screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
        Screenshot.takeScreenshot(driver, screenshotArquivo);

        sip.setInvestedValue(valorAplicar);

        screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
        Screenshot.takeScreenshot(driver, screenshotArquivo);

        sip.setSavingsValue(valorSalvar);

        screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
        Screenshot.takeScreenshot(driver, screenshotArquivo);

        sip.setSavingsPeriod(periodo);

        screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
        Screenshot.takeScreenshot(driver, screenshotArquivo);

        sip.clickSimulateButton();

        try {
            waitPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]")));
            screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
            Screenshot.takeScreenshot(driver, screenshotArquivo);

            return true;
        } catch (Exception e) {
            screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
            Screenshot.takeScreenshot(driver, screenshotArquivo);
            return false;
        }
    }

    public Boolean simularInvestimentoPoupancaComErros(String tipoAssociado, String valorAplicar, String valorSalvar, String periodo) throws Exception {
        SimuladorInvestimentoPage sip = new SimuladorInvestimentoPage(driver);

        if(tipoAssociado.contains("Individual")) {
            sip.selectSimulationForMyself();
        }
        else if (tipoAssociado.contains("EmpresaOuAgro")) {
            sip.selectSimulationForCompany();
        }

        String pathEvidenciasTeste = "C:\\Users\\Lorenzo\\automation_output\\ibmTest\\ibmTesting" + Generators.dateTimeToFile() ;

        String screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
        Screenshot.takeScreenshot(driver, screenshotArquivo);

        if(Integer.parseInt(valorAplicar) < 2000) {
            sip.setInvestedValue(valorAplicar);
            driver.findElement(By.id("valorInvestir")).click();

            try{
                waitPage.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorAplicar-error")));
                screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
                Screenshot.takeScreenshot(driver, screenshotArquivo);
            } catch (Exception e) {
                screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
                Screenshot.takeScreenshot(driver, screenshotArquivo);

                throw new Exception(e.getMessage());
            }
        }
        else {
            sip.setInvestedValue(valorAplicar);

            screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
            Screenshot.takeScreenshot(driver, screenshotArquivo);
        }

        if(Integer.parseInt(valorSalvar) < 2000) {
            sip.setSavingsValue(valorSalvar);
            driver.findElement(By.id("valorAplicar")).click();

            try{
                waitPage.until(ExpectedConditions.visibilityOfElementLocated(By.id("valorInvestir-error")));
                screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
                Screenshot.takeScreenshot(driver, screenshotArquivo);
            } catch (Exception e) {
                screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
                Screenshot.takeScreenshot(driver, screenshotArquivo);

                throw new Exception(e.getMessage());
            }
        }
        else {
            sip.setSavingsValue(valorSalvar);

            screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
            Screenshot.takeScreenshot(driver, screenshotArquivo);
        }

        if(Integer.parseInt(periodo) <= 0) {
            sip.setSavingsPeriod(periodo);
            driver.findElement(By.id("valorInvestir")).click();

            try{
                waitPage.until(ExpectedConditions.visibilityOfElementLocated(By.id("tempo-error")));
                screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
                Screenshot.takeScreenshot(driver, screenshotArquivo);
            } catch (Exception e) {
                screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
                Screenshot.takeScreenshot(driver, screenshotArquivo);

                throw new Exception(e.getMessage());
            }
        }
        else {
            sip.setSavingsPeriod(periodo);

            screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
            Screenshot.takeScreenshot(driver, screenshotArquivo);
        }


        try {
            sip.clickSimulateButton();

            waitPage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]")));
            screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
            Screenshot.takeScreenshot(driver, screenshotArquivo);

            return false;
        } catch (Exception e) {
            screenshotArquivo = pathEvidenciasTeste + "\\ibmTesting" + Generators.dateTimeToFile() + "simularInvestimentoPoupanca" + ".png";
            Screenshot.takeScreenshot(driver, screenshotArquivo);
            return true;
        }
    }

}
