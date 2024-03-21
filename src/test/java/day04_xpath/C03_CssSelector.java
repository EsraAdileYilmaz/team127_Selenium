package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CssSelector {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // electronics linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();

        //kenarda bulunan fiyat filtresine min 10, max 200 yazarak
        WebElement minKutusu= driver.findElement(By.cssSelector("input[class='form-control minPrice']"));
        WebElement maxKutusu= driver.findElement(By.cssSelector("input[class='form-control maxPrice']"));

        minKutusu.clear();
        minKutusu.sendKeys("10");

        maxKutusu.clear();
        maxKutusu.sendKeys("200");

        //filtreleme yapin

         driver.findElement(By.xpath("//button[text()='Filter Price']")).submit();

        //arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi=driver.findElement(By.cssSelector(".product-count-text"));
        System.out.println(aramaSonucElementi.getText());

        String aramaSonucuStr = aramaSonucElementi.getText().replaceAll("\\D",""); // "11"

        int actualSonucSayisi =  Integer.parseInt(aramaSonucuStr); // int olarak 11

        if (actualSonucSayisi > 0){
            System.out.println("Filtreleme testi PASSED");
        }else System.out.println("Filtreleme testi FAILED");



        //sayfayi kapatin.
        driver.quit();

    }
}
