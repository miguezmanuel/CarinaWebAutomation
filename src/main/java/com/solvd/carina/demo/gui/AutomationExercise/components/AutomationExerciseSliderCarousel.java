package com.solvd.carina.demo.gui.AutomationExercise.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AutomationExerciseSliderCarousel extends AbstractUIObject {

    @FindBy(xpath = "//div[@id='slider-carousel']/a[@class='left control-carousel hidden-xs']")
    private ExtendedWebElement leftSliderControl;

    public AutomationExerciseSliderCarousel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLeftSliderControlVisible () {
        return leftSliderControl.isVisible();
    }
}
