package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties prop;
    FileInputStream fis;
    String brwser;
    String url;
    FileOutputStream fos;
    String projectPath = System.getProperty("user.dir");

    public ConfigReader()
    {
        try {
            prop = new Properties();
            fis = new FileInputStream(projectPath+"/src/main/resources/Config.properties");
            prop.load(fis);
        }
        catch (FileNotFoundException e) {
            e.getCause();
            e.getMessage();
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.getCause();
            e.getMessage();
            System.out.println("File Not Loaded");
        }
    }

    public String getBrowser()
    {
        brwser = prop.getProperty("browser");
        return brwser;
    }

    public String getURL()
    {
        url = prop.getProperty("url");
        return url;
    }



}
