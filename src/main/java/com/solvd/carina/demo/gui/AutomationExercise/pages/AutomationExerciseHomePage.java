package com.solvd.carina.demo.gui.AutomationExercise.pages;

import com.solvd.carina.demo.gui.AutomationExercise.common.AutomationExerciseBasePage;
import com.solvd.carina.demo.gui.AutomationExercise.components.AutomationExerciseHeader;
import com.solvd.carina.demo.gui.AutomationExercise.components.AutomationExerciseSliderCarousel;
import org.openqa.selenium.WebDriver;

public class AutomationExerciseHomePage extends AutomationExerciseBasePage {

    public AutomationExerciseHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AutomationExerciseSliderCarousel getSliderCarousel() {
        return super.getSliderCarousel();
    }

    @Override
    public AutomationExerciseHeader getHeader() {
        return super.getHeader();
    }
}
