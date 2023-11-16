package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05__findElements {

    public static void main(String[] args) {

        //1)gerekli ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2) testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");

        //3) shoes linkine tiklayin
        driver.findElement(By.partialLinkText("hoes")).click();

        //4) cikan urunlerden 3.urune tiklayin
        /*
          3.urunu ozel olarak locate edemiyorsak, tum urunleri bir list'e atip
           sonra listedeki 3.urunu secebiliriz.
         */
        List<WebElement> urunElementleriListesi=driver.findElements(By.className("prod-img"));//urunleri bu list'e atadik.
        urunElementleriListesi.get(2).click();//0-1-2.index ==3.webelementine click yaptik

        //5) urun kisa aciklamalarinda case sensitive olmadan shoe gectigini test edin
        WebElement urunDetaylariElementi=driver.findElement(By.className("prod-detail"));
        //System.out.println(urunDetaylariElementi.getText());//textin tum detaylarini yazdirdi.

        String expectedIcerik="shoe";
        String actualIcerik=urunDetaylariElementi.getText().toLowerCase();
        if(actualIcerik.contains(expectedIcerik)){
            System.out.println("Urun detay testi PASSED");
        }else{
            System.out.println("Urun detay testi FAILED");
        }


        driver.quit();



    }
}
