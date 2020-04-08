package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChromeInstance() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lorenzo\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

        return webDriver;
    }
}
