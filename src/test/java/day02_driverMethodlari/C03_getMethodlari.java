package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C03_getMethodlari {

    public static void main(String[] args) throws InterruptedException {

         /*
            Selenium 4.12 versiyonu ile
            kendi Webdriver'ini da olusturabiliyor.

            Yani artik disardan bir webdriver tanimlama MECBURIYETI kalmadi.

            ANCAK... sirketlerin pek cogu kendilerine ozel olarak
            satin aldiklari webdriver'lari kullanabiliyor.

            Biz bu duruma alismak icin
            Selenium webdriver yerine indirdigimiz driver.exe dosyasini kullanmaya devam edecegiz.
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(1000);
        //System.out.println(driver.getPageSource());Tum sayfanin kodlarini getiriyor

        System.out.println(driver.getWindowHandle());//E3E57308545A239373533CF79FAF8B4A
        // Window handle degeri : selenium'un olusturdugu her webdriver objesine verdigi
        //                        unique bir kod'dur.
        //Biz bu degerleri birden fazla sayfa acilirsa, sayfalar arasinda gecis yapmak icin kullanacagiz.

        System.out.println(driver.getWindowHandles());//[CB300EDB6C6A8D03FBBE67980B3E6824]
        // aktif webdriver objesinin actigi TUM SAYFALARIN window handle degerlerini getirir

        Thread.sleep(1000);

        driver.quit();

    }
}
