package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ilkTest {
    public static void main(String[] args) throws InterruptedException {


        // testotomasyonu anasayfaya gidin
        // URL'in https://www.testotomasyonu.com/ oldugunu
        // ve Title'in test kelimesi icerdigini test edin

        // Her test icin Mutlaka bir webdriver olusturmali
        // ve gerekli ayarlamalari yapmaliyiz
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // URL'in https://www.testotomasyonu.com/ oldugunu

        //String expectedURL="https://www.testotomasyonu.com"; bununla failed oldu sonunda / yok
        String expectedURL="https://www.testotomasyonu.com/";
        String actualURL=driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("URL testi PASSED");
        }else{
            System.out.println("URL testi FAILED");
            System.out.println("Actual URL : " + actualURL);//Actual URL : https://www.testotomasyonu.com/  sonunda / oldugu icin failed oldu
            //bu bir BUG dir ve raporlanmasi gerekir.
        }

        //ve Title'in test kelimesi icerdigini test edin
        String expectedTitleIcerigi="test";
        String actualTitle=driver.getTitle();

        if(actualTitle.contains(expectedTitleIcerigi)){
            System.out.println("Test Title PASSED");
        }else {
            System.out.println("Test Title FAILDE");
            System.out.println("Actual title: "+actualTitle);
        }


        driver.quit();

    }
}
