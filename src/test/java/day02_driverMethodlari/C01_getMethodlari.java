package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.tracing.model.TraceConfig;

public class C01_getMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();//bos bir kopya browser olusturucak
        driver.manage().window().maximize();

        driver.get("http://www.testotomasyonu.com");

        driver.get("http://www.wisequarter.com");


        //driver.get("www.youtube.com");//Process finished with exit code 1
        //driver.get() methodu https:// yazilmadan calismaz
        //Ama www. yazmadan calisir.or=> https://youtube.com

        driver.get("https://youtube.com");


        driver.quit();
    }
}
