package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_ByClassname {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        /*
        1)manuel olarak siteye gidip Category bolumunun html kodlari kopyalanmalidir
        2)driver.findElements() methodu ile hangi locator'u kullanacaksan icine coller yapalim
        3)WebElement'leri icine koyacagimiz bir List<WebElement> atayalim.
         */
       List<WebElement> kategoriElementleriListi= driver.findElements(By.className("panel-title"));

       //4- Category bolumunde 3 element oldugunu test edin
        int expectedKategoriSayisi=3;
        int actualKategoriSayisi=kategoriElementleriListi.size();

        if(expectedKategoriSayisi == actualKategoriSayisi){
            System.out.println("Kategori sayisi testi PASSED");
        }else {
            System.out.println("Kategori sayisi testi FAILED");
            System.out.println("Actual kategori sayisi: "+actualKategoriSayisi);
        }


        //5- Category isimlerini yazdirin
        System.out.println(ReusableMethods.stringListeDonustur(kategoriElementleriListi));

        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();


    }
}
