
package com.edureka.utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;




import com.edureka.pages.HomePage;
import com.edureka.pages.SearchHomePage;
import com.edureka.pages.SearchResultsPage;

public class Pages {
	  private static final ThreadLocal<Pages> INSTANCE = new ThreadLocal<>();

    public SearchHomePage shp;
    public SearchResultsPage srp;
    public HomePage homePage;

    private Pages(WebDriver driver) {
    	 shp = PageFactory.initElements(driver, SearchHomePage.class);
    	 srp = PageFactory.initElements(driver, SearchResultsPage.class);
     //   shp = new SearchHomePage(driver);
     //   srp = new SearchResultsPage(driver);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
    public static void loadAllPages(WebDriver driver) {
        INSTANCE.set(new Pages(driver));
    }
    public static Pages get() {
        Pages pages = INSTANCE.get();
        if (pages == null) {
            throw new IllegalStateException(
                "Pages not initialised for thread " + Thread.currentThread().getName() +
                ". Ensure Hook.setUp() ran before accessing Pages.get()."
            );
        }
        return pages;
    }
    public static void cleanUp() {
        INSTANCE.remove();
    }
}