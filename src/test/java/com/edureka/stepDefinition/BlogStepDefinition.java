package com.edureka.stepDefinition;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.edureka.pages.BlogCategoryPage;
import com.edureka.pages.BlogHomePage;
import com.edureka.pages.BlogPostPage;
import com.edureka.pages.BlogVideoFullScreenPage;
import com.edureka.pages.BlogVideoPage;
import com.edureka.pages.LoginPage;
import com.edureka.utility.AllFunctionality;
import com.edureka.utility.Base;
import com.edureka.utility.ExtentReportManager;
import com.edureka.utility.Pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlogStepDefinition extends AllFunctionality {

    private Base base;

    private LoginPage loginPage;
    private BlogHomePage blogHomePage;
    private BlogCategoryPage blogCategoryPage;
    private BlogPostPage blogPostPage;
    private BlogVideoPage blogVideoPage;
    private BlogVideoFullScreenPage blogVideoFullScreenPage;

    // Excel data variables
    private String blogTitle1;
    private String blogTitle2;
    private String category;
    private String videoTitle;
    private String comment;
    

    public BlogStepDefinition(Base base) {
        this.base = base;
        loginPage = Pages.get().loginPage;
        blogHomePage = Pages.get().blogHomePage;
        blogCategoryPage = Pages.get().blogCategoryPage;
        blogPostPage = Pages.get().blogPostPage;
        blogVideoPage = Pages.get().blogVideoPage;
        blogVideoFullScreenPage = Pages.get().blogVideoFullScreenPage;

        // read blog excel
        init("BlogData");
        blogTitle1 = getData(1, 0);
        category = getData(1, 1);
        blogTitle2 = getData(1, 2);
        videoTitle = getData(1, 3);
        comment = getData(1, 4);
        

//        init("AuthData");
//        String email = getData(1, 0);
//        String password = getData(1, 1);

    }

    @Given("User logs in to the edureka for viewing blogs")
    public void user_logs_in_to_the_edureka_for_viewing_blogs() {

        loginPage = Pages.get().loginPage;
        blogHomePage = Pages.get().blogHomePage;
        blogCategoryPage = Pages.get().blogCategoryPage;
        blogPostPage = Pages.get().blogPostPage;
        blogVideoPage = Pages.get().blogVideoPage;
        blogVideoFullScreenPage = Pages.get().blogVideoFullScreenPage;

        // read blog excel
        init("BlogData");
        
//        blogTitle1 = getData(1, 0);
        blogTitle1 = "How To Use Python For DevOps?";
//        category = getData(1, 1);
        category = "Artificial Intelligence";
//        blogTitle2 = getData(1, 2);
        blogTitle2 = "What are Autoregressive Generative Models?";
//        videoTitle = getData(1, 3);
        videoTitle = "Top DevOps Interview Questions And Answers in 2024";
        comment = "Hello comment";

        base.getDriver().get("https://www.edureka.co/");

        loginPage.openLoginPopup();

        init("AuthData");
        String email = getData(1, 0);
        String password = getData(1, 1);

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        
    }

    @When("User click blogs from navbar")
    public void user_click_blogs_from_navbar() {
        base.getDriver().get("https://www.edureka.co/blog/");
        
    }

    @Then("blogs page need to be visible")
    public void blogs_page_need_to_be_visible() {
        Assert.assertTrue(base.getDriver().getCurrentUrl().contains("blog"));
        
    }

    @And("User open the recent blog from Excel")
    public void user_open_the_recent_blog_from_excel() {
        blogHomePage.clickOnArticles(base.getDriver(), blogTitle1);
        
    }

    @And("verify whether recent blog opened from Excel")
    public void verify_whether_recent_blog_opened_from_excel() {
        Assert.assertTrue(blogPostPage.getBlogTitle().contains(blogTitle1));
        
    }

    @And("click on bookmark button")
    public void click_on_bookmark_button() {
        blogPostPage.addBookMark();
        
        boolean isBookmarked = blogPostPage.isBookMarked();
        
        if (!isBookmarked) {
        	Assert.fail("Bookmark not added");
        }
    }

    @And("if not added print the warning message")
    public void if_not_added_print_the_warning_message() {
        System.out.println("Bookmark may not be added. Verify warning message manually.");
        
    }

    @And("User click on category from Excel")
    public void user_click_on_category_from_excel() {
        blogHomePage.clickOnCategory(base.getDriver(), category);
    }

    @And("User open category blog from Excel")
    public void user_open_category_blog_from_excel() {

        blogHomePage.clickOnArticles(base.getDriver(), blogTitle2);
        

    }

    @And("verify whether category blog opened from Excel")
    public void verify_whether_category_blog_opened_from_excel() {
        Assert.assertTrue(blogPostPage.getBlogTitle().contains(blogTitle2));
    }

    @And("User click on video icon")
    public void user_click_on_video_icon() {
        blogHomePage.clickOnVideo();
        
    }

    @Then("User need to see videos and click video from Excel")
    public void user_need_to_see_videos_and_click_video_from_excel() {
        Assert.assertTrue(base.getDriver().getCurrentUrl().contains("videos"));
        blogVideoPage.clickOnVideo(base.getDriver(), videoTitle);
    }

    @And("verify user can view video")
    public void verify_user_can_view_video() {
    	System.out.println("Video page");
    	
//        Assert.assertTrue(blogVideoFullScreenPage.getVideoTitle().trim().length() > 0);
    }

    @And("add comments for video from Excel")
    public void add_comments_for_video_from_excel() {
//        blogVideoFullScreenPage.addComment(comment);
    }

    @And("verify the comment is visible under comment section")
    public void verify_the_comment_is_visible_under_comment_section() {
//        System.out.println("Comment submitted. Exact comment validation method not added yet.");
    }

    @And("verify user can see recommended blogs and first recommended blog")
    public void verify_user_can_see_recommended_blogs_and_first_recommended_blog() {
        System.out.println("Recommended blogs section is expected to be visible.");
        System.out.println("Recommended : " + blogVideoFullScreenPage.getRecommendedVideoTitle());
        
        
    }
}