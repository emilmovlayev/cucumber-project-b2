package com.loop.step_definitions;

import com.loop.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        Driver.getdriver();
    }

    @After
    public void tearDown(Scenario scenario){
        //only takes a screenshot when it fails

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getdriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }
      //  Driver.closedriver();
    }
}
