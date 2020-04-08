package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SimuladorInvestimentoPage {

    private WebDriver driver;
    private WebDriverWait waitPage;

    public SimuladorInvestimentoPage (WebDriver driver)  {
        this.driver = driver;
        waitPage = new WebDriverWait(driver, 10);
    }

    private WebElement radioButtonForIndividual() {
        WebElement radio = driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[1]/input[1]"));
        waitPage.until((ExpectedConditions.elementToBeClickable(radio)));
        return radio;
    }

    private WebElement radioButtonForCompanyAgro() {
        WebElement radio = driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[1]/input[2]"));
        waitPage.until((ExpectedConditions.elementToBeClickable(radio)));
        return radio;
    }

    private WebElement investedValueTextField() {
        WebElement txtfld = driver.findElement(By.id("valorAplicar"));
        waitPage.until(ExpectedConditions.elementToBeClickable(txtfld));
        return txtfld;
    }

    private WebElement savingsValueTextField() {
        WebElement txtfld = driver.findElement(By.id("valorInvestir"));
        waitPage.until(ExpectedConditions.elementToBeClickable(txtfld));
        return txtfld;
    }

    private WebElement savingsAmountPeriodTextField() {
        WebElement txtfld = driver.findElement(By.id("tempo"));
        waitPage.until(ExpectedConditions.elementToBeClickable(txtfld));
        return txtfld;
    }

    private WebElement simulateButton() {
        WebElement button = driver.findElement(By.xpath("//*[@id=\"formInvestimento\"]/div[5]/ul/li[2]/button"));
        waitPage.until(ExpectedConditions.elementToBeClickable(button));
        return button;
    }

    public String getInvestedValue() {
        return investedValueTextField().getAttribute("value");
    }

    public String getSavingsValue() {
        return savingsValueTextField().getAttribute("value");
    }

    public String getSavingPeriodTime() {
        return savingsAmountPeriodTextField().getAttribute("value");
    }

    public void setInvestedValue(String value) throws InterruptedException {
        investedValueTextField().sendKeys(value);
        Thread.sleep(1000);
    }

    public void setSavingsValue(String value) throws InterruptedException {
        savingsValueTextField().sendKeys(value);
        Thread.sleep(1000);
    }

    public void setSavingsPeriod(String value) throws InterruptedException {
        savingsAmountPeriodTextField().sendKeys(value);
        Thread.sleep(1000);
    }

    public void selectSimulationForMyself() throws InterruptedException {
        radioButtonForIndividual().click();
        Thread.sleep(1500);
    }

    public void selectSimulationForCompany() throws InterruptedException {
        radioButtonForCompanyAgro().click();
        Thread.sleep(1500);
    }

    public void clickSimulateButton() throws InterruptedException {
        simulateButton().click();
        Thread.sleep(1000);
    }
}
