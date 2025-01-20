package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.AutomationExercise.components.AutomationExerciseHeader;
import com.solvd.carina.demo.gui.AutomationExercise.components.AutomationExerciseLoginForm;
import com.solvd.carina.demo.gui.AutomationExercise.components.AutomationExerciseSliderCarousel;
import com.solvd.carina.demo.gui.AutomationExercise.pages.AutomationExerciseAuthPage;
import com.solvd.carina.demo.gui.AutomationExercise.pages.AutomationExerciseHomePage;
import com.zebrunner.carina.core.IAbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebAutomationExerciseTest implements IAbstractTest {

    Logger logger = LogManager.getLogger();

    @Test(dataProvider = "loginData")
    public void test (String email, String password) {
        AutomationExerciseAuthPage authPage = new AutomationExerciseAuthPage(getDriver());
        AutomationExerciseHomePage homePage = new AutomationExerciseHomePage(getDriver());
        AutomationExerciseLoginForm loginForm = authPage.getLoginForm();
        AutomationExerciseSliderCarousel sliderCarousel = homePage.getSliderCarousel();
        AutomationExerciseHeader header = homePage.getHeader();

        getDriver().navigate().to("https://automationexercise.com/");
        logger.info("Checking if the homepage is visible successfully");
        Assert.assertTrue(sliderCarousel.isLeftSliderControlVisible());

        logger.info("navigating to auth section");
        header.clickAuthSectionButton();

        logger.info("verifying if title login is present");
        Assert.assertTrue(loginForm.loginToYourAccountTitleIsVisible());

        logger.info("typing credentials");
        loginForm.typeEmail(email);
        loginForm.typePassword(password);
        loginForm.clickLoginButton();

    }

    @DataProvider(name = "loginData")
    public Object[][] loginData () {
        return new Object[][] {
                {"qwerty7@gmail.com", "qwerty123"}
        };
    }

//    @Test(dataProvider = "loginDataProvider")
//    public void verifyUserLogin(String email, String password, boolean expectSuccess, String errorMessage) {
//        HomePage homePage = new HomePage(getDriver());
//        homePage.open();
//        Assert.assertTrue(homePage.isPageOpened(), "Home page doesn't open");
//
//        LoginPage loginPage = (LoginPage) homePage.getHeaderMenu().pickHeaderMenuItem(HeaderMenuItems.LOGIN_PAGE);
//        Assert.assertTrue(loginPage.getLoginForm().isLoginToAccountTitlePresent(), "Title doesn't present");
//        homePage = loginPage.getLoginForm().logIn(email, password);
//        if (expectSuccess) {
//            Assert.assertTrue(homePage.getHeaderMenu().getUserName().contains(VALID_NAME), "logged in as username is not visible");
//        } else {
//            Assert.assertEquals(loginPage.getLoginForm().loginFailed(), errorMessage, "Login verification failed");
//        }
//    }
//
//    @DataProvider(name = "loginDataProvider")
//    public Object [][] loginDataProvider() {
//        return new Object[][] {
//                {VALID_EMAIL, VALID_PASSWORD, true, ""},
//                {INVALID_EMAIL, VALID_PASSWORD, false, ERROR_MESSAGE},
//                {VALID_EMAIL, INVALID_PASSWORD, false, ERROR_MESSAGE}
//        };
//    }

}
