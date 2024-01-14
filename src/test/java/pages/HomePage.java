package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    String categoryNext="//button[@aria-label='Next categories page']";
    String catScroll="//div[@id='categoryScroller']//label//span[text()='$$']//parent::div//parent::span//parent::div//parent::label";
    String catLabel="//div[@id='categoryScroller']//label//span[text()='$$']//parent::div//parent::span";
    String catList="//div[@data-testid='card-container']";
    String catSubtitle="//div[@data-testid='card-container']//span[1]";
    public String clickCategory(String category) throws InterruptedException {
        String catS=updateXpathValue(catScroll,category);
        String catSLab=updateXpathValue(catLabel,category);
        String newCompareSub="";
        while (true) {
            if(driver.findElement(By.xpath(catS)).getAttribute("aria-hidden").equalsIgnoreCase("true")) {
                driver.findElement(By.xpath(catSLab)).click();
                Thread.sleep(2000);
                List<WebElement> lst= driver.findElements(By.xpath(catList));
                if (lst.size() >0){
                    String subtitle=driver.findElement(By.xpath(catSubtitle)).getText();
                    String sub=subtitle.toLowerCase();
                    String[] newsub=sub.split(" ");
                    StringBuilder compareSub = new StringBuilder();
                    for(int i=2;i<newsub.length;i++){
                        compareSub.append(newsub[i]+" ");
                    }
                    newCompareSub=compareSub.toString();
                    newCompareSub.trim();
                }
                else {
                    System.out.println("No results for selected category!");
                }
                break;
            }
            else{
                categoryCarouselScroll();
            }
        }
        return newCompareSub;
    }
    public void categoryCarouselScroll(){
        driver.findElement(By.xpath(categoryNext)).click();
    }
    public String updateXpathValue(String xpath, String value){
        return xpath.replace("$$", value);
    }
}