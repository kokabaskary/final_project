package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mohammad Mutakim on 11/11/17.
 */
public class ConfigReader {

    private String sauceOrLocal;
    private String url;
    private String chromeDriverPath;
    private String platform;
    private String browser;
    private String version;

    public ConfigReader() {
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.url = prop.getProperty("url");
            this.chromeDriverPath = prop.getProperty("chrome_driver_path");
            this.sauceOrLocal = prop.getProperty("run_test");
            this.platform = prop.getProperty("platform");
            this.browser = prop.getProperty("browser");
            this.version =prop.getProperty("version");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() { return url; }

    public String getChromeDriverPath() { return chromeDriverPath; }

    public String getSauceOrLocal() { return sauceOrLocal; }

    public void getPlatform(){ }

    public String getBrowser(){ return browser; }

    public String getVersion(){ return version; }

}








