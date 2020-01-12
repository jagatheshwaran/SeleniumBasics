package handleCookies;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseStoredCookies extends StoreCookies {

	public static void main(String ar[]) throws IOException, InterruptedException {

		// Set the Browser Driver path
		System.setProperty("webdriver.chrome.driver", "src/main/resources/BrowserDrivers/chromedriver.exe");

		// Driver instance is created
		WebDriver driver = new ChromeDriver();

		// manage().window().maximize() - To Maximize Browser Window
		driver.manage().window().maximize();

		Cookie cookieObject = null;

		File file = new File("cookie.info");
		try {
			FileReader fileRead = new FileReader(file);
			BufferedReader bufferedRead = new BufferedReader(fileRead);
			String dataLine;

			if ((dataLine = bufferedRead.readLine()) != null) {

				StringTokenizer stringToken = new StringTokenizer(dataLine, ";");

				while (stringToken.hasMoreTokens()) {

					String name = stringToken.nextToken();
					String value = stringToken.nextToken();
					String domain = stringToken.nextToken();
					String path = stringToken.nextToken();
					Date expiry = null;
					String val;
					if (!(val = stringToken.nextToken()).equals("null")) {
						SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
						expiry = sdf.parse(val);
					}
					Boolean isSecure = new Boolean(stringToken.nextToken()).booleanValue();
					cookieObject = new Cookie(name, value, domain, path, expiry, isSecure);
					bufferedRead.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// get() - It will take you to Amazon sign in page
		driver.get(
				"https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&switch_account=");

		// addCookie() - It will add the cookie to the current session
		driver.manage().addCookie(cookieObject);

		// refresh() - It is used to refresh the current web page
		driver.navigate().refresh();

		// get() - It will take you to Amazon after sign in page
		driver.get(
				"https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&switch_account=");
		Thread.sleep(5000);

		// close() - It is used to close the current browser window
		driver.close();
	}
}
