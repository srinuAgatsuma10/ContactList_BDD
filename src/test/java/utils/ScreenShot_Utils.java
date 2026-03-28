package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class ScreenShot_Utils {
    // Capturing Screen Shot
    public String captureScreen(String tname) throws Exception {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") +
                "\\ScreenShots\\" + tname + "_" + timeStamp + ".png";

        File targetFile = new File(targetFilePath);

        targetFile.getParentFile().mkdirs();

        org.openqa.selenium.io.FileHandler.copy(sourceFile, targetFile);

        return targetFilePath;
    }
}
