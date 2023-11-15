package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_manageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         /*
            Wait konusunu ilerde daha detayli anlatacagiz
            implicitlyWait() sayfanin yuklenmesi ve/veya
            arayacagimiz webelementleri bulmak icin dinamik olarak tanimlanmis
            maximum bekleme suresidir.

            Asil amac bekleme degil gorevi yapmaktir.

           Burada tanimlanan sure
           gorevi yapmaya cabalayacagi max suredir,
           bu sure icerisinde gorevi yapamazsa
           exception firlatir.
         */

        System.out.println("ilk bastaki konum : "+driver.manage().window().getPosition());//ilk bastaki konum : (22, 47)
        System.out.println("ilk bastaki size : "+driver.manage().window().getSize());//ilk bastaki size : (1200, 919)
        Thread.sleep(2000);


        driver.manage().window().maximize();
        System.out.println("maximize konum : "+driver.manage().window().getPosition());//maximize konum : (0, 25)
        System.out.println("maximize size : "+driver.manage().window().getSize());//maximize size : (1920, 963)


        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum : "+driver.manage().window().getPosition());//fullscreen konum : (0, 0)
        System.out.println("fullscreen size : "+driver.manage().window().getSize());//fullscreen size : (1920, 1080)

        Thread.sleep(2000);
        // pencereyi (position)baslangic noktasi (50,100) ve size'i (1000,700) yapin.
        driver.manage().window().setSize(new Dimension(1000,700));
        driver.manage().window().setPosition(new Point(50,100));

        System.out.println("ozel konum : "+driver.manage().window().getPosition());
        System.out.println("ozel size : "+driver.manage().window().getSize());


        System.out.println(driver.manage().window().getSize().getWidth());//1000


        Thread.sleep(2000);
        driver.quit();


    }
}
