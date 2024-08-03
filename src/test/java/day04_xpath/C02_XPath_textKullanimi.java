package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPath_textKullanimi {

    public static void main(String[] args) {

         /*
        Xpath link olmasa bile yazisi olan webelementlerini
        yazi ile locate etmemize imkan tanir.
        Ornegin:By.xpath("//button[text()='Remove']")
        */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButton =driver.findElement(By.xpath("//button[text()='Remove']"));
        //Bu locate Add'e click() yapildiktan sonra alinan locate'dir.

        if(removeButton.isDisplayed()){
            System.out.println("Test remove button PASSED");
        }else{
            System.out.println("Test remove button FAILED");
        }

        //4- Remove tusuna basin
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement=driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if(addRemoveElement.isDisplayed()){
            System.out.println("Test Displayed Add/Remove Elements PASSED");
        }else{
            System.out.println("Test Displayed Add/Remove Elements FAILED");
        }


        //6- Remove butonunun gorunur olmadigini (gorunmedigini) test edin
        /*
        Remove butonu Add'e click() yapildiginda gozukuyor ama normalde gozukmuyor.
        Oyuzden gorunur olma durumu icin =>expected olan= gorunmemesidir.
        Eger Add'e click() yapilinca alinan locate click() yapilmadan da calisiyorsa;testimiz FAILED olur.
        Eger Add'e click() yapilinca alinan locate click() yapilmadan calismiyorsa;testimiz PASSED olur.

         */

        try {
            removeButton =driver.findElement(By.xpath("//button[text()='Remove']"));
            //Bu locate Add'e click() yapildiktan sonra alinan locate'dir.
            System.out.println("Remove butonu gorunmeme testi FAILED");
        } catch (NoSuchElementException e) {//bulamayinca bu exception'i firlaticak
            System.out.println("Remove butonu gorunmeme testi PASSED");

        }


        driver.quit();




    }
}
