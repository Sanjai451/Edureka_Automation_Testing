package com.edureka.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.edureka.pages.CareerInterestsPage;
import com.edureka.pages.CareerServicePage;
import com.edureka.pages.ChangePasswordPage;
import com.edureka.pages.Dashboard;
import com.edureka.pages.LearningGoalsPage;
import com.edureka.pages.MyOrdersAndInvoicesPage;
import com.edureka.pages.MyProfile;
import com.edureka.pages.OtherDetailsPage;
import com.edureka.pages.ProfessionalDetailsPage;
import com.edureka.pages.StudyPlanPage;
import com.edureka.pages.TopicsOfInterestPage;
import com.edureka.pages.TopicsSelectionPage;
import com.edureka.pages.UserDetailsPage;
import com.edureka.pages.WalletPage;


public class Pages {
	
	 public static MyProfile myProfile;
	    public static Dashboard dashboard;
	    public static ChangePasswordPage changePasswordPage;
	    public static CareerServicePage careerServicePage;
	    public static ProfessionalDetailsPage professionalDetailsPage;
	    public static CareerInterestsPage careerInterestsPage;
	    public static OtherDetailsPage otherDetailsPage;   
	    public static TopicsOfInterestPage topicsOfInterestPage;
	    public static TopicsSelectionPage topicsSelectionPage;
	    public static UserDetailsPage userDetailsPage;
	    public static LearningGoalsPage learningGoalsPage;
	    public static StudyPlanPage studyPlanPage;
	    public static WalletPage walletPage;
	    public static MyOrdersAndInvoicesPage ordersPage;

	    public static void loadAllPages(WebDriver driver) {

	        myProfile = PageFactory.initElements(driver, MyProfile.class);
	        dashboard = PageFactory.initElements(driver, Dashboard.class);
	        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
	        careerServicePage = PageFactory.initElements(driver, CareerServicePage.class);
	        professionalDetailsPage = PageFactory.initElements(driver, ProfessionalDetailsPage.class);
	        careerInterestsPage = PageFactory.initElements(driver, CareerInterestsPage.class);
	        otherDetailsPage = PageFactory.initElements(driver, OtherDetailsPage.class); // ✅ ADDED
	        topicsOfInterestPage = PageFactory.initElements(driver, TopicsOfInterestPage.class);
	        topicsSelectionPage = PageFactory.initElements(driver, TopicsSelectionPage.class);
	        userDetailsPage = PageFactory.initElements(driver, UserDetailsPage.class);
	        learningGoalsPage = PageFactory.initElements(driver, LearningGoalsPage.class);
	        studyPlanPage = PageFactory.initElements(driver, StudyPlanPage.class);
	        walletPage = PageFactory.initElements(driver, WalletPage.class);
	        ordersPage = PageFactory.initElements(driver, MyOrdersAndInvoicesPage.class);
	        
	    }
}

