package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {

    public static void main(String[] args) {

        /*
        1- https://testotomasyonu.com/addremove/ adresine gidin
        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
         */

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@id='sub-btn']")).click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement removeButton =driver.findElement(By.xpath("//button[@class='remove-btn']"));

        if(removeButton.isDisplayed()){
            System.out.println("Test remove button PASSED");
        }else{
            System.out.println("Test remove button FAILED");
        }

        //4- Delete tusuna basin
        driver.findElement(By.xpath("//button[@class='remove-btn']")).click();

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement=driver.findElement(By.xpath("//div[@class='container']"));

        if(addRemoveElement.isDisplayed()){
            System.out.println("Test Add/Remove Elements PASSED");
        }else{
            System.out.println("Test Add/Remove Elements FAILED");
        }

        driver.quit();


    }
}
