package day01_seleniumIlkOtomasyon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebdriverOlusturma {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        //Bu satir olusturacagimiz webdriver'in ozelliklerini set ediyor,
        // webdriver otomasyon sirasinda bizim elimiz, gozumuz, herseyimizdir.

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.testotomasyonu.com");//bu siteyi bana getir.parantez icindeki siteye gider

        Thread.sleep(5000);//5 sn beklesin

        driver.manage().window().maximize();
        //bu 3 methodla kopyaladigi web sitesini tam ekran yapiyor.

        

        driver.close();//actigin websitesini kapat






    }
}
