package seleniumWebdriver;

import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/* for Docs
 * https://github.com/YadaGiriReddy/HYR-Tutorials
 */
public class Test_36_FindBroken_Images {

	public static void main(String[] args) throws Exception {
		 //VerifyBrokenImagesUsingSelenium();
		VerifyBrokenImagesUsingJsoup();
	}

	public static void VerifyBrokenImagesUsingSelenium() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.theworldsworstwebsiteever.com/");

		Thread.sleep(5000);

		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println(images.size());

		for (WebElement image : images) {
			String imageSrc = image.getAttribute("src");

			try {
				URL url = new URL(imageSrc);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setConnectTimeout(5000);
				httpURLConnection.connect();

				if (httpURLConnection.getResponseCode() == 200)
					System.out.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> "
							+ httpURLConnection.getResponseMessage());
				else
					System.err.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> "
							+ httpURLConnection.getResponseMessage());

				httpURLConnection.disconnect();
			} catch (Exception e) {
				System.err.println(imageSrc);
			}
		}
		driver.quit();
	}

	/**************************************************************
	 * By default selenium have this No need to put in pom
		<!-- https://mvnrepository.com/artifact/org.jsoup/jsoup -->
		<dependency>
		    <groupId>org.jsoup</groupId>
		    <artifactId>jsoup</artifactId>
		    <version>1.13.1</version>
		</dependency>
	 ****************************************************************/
	public static void VerifyBrokenImagesUsingJsoup() throws Exception {
		Document doc = Jsoup.connect("https://www.theworldsworstwebsiteever.com/").get();
		Elements images = doc.select("img");

		for (Element image : images) {
			String imageSrc = image.attr("src");
			if (!imageSrc.startsWith("http"))
				imageSrc = "https://www.theworldsworstwebsiteever.com/" + imageSrc;
			try {
				//Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("testhost", 8080));
				URL url = new URL(imageSrc);
				//URLConnection urlConnection = url.openConnection(proxy);
				URLConnection urlConnection = url.openConnection();
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setConnectTimeout(5000);
				httpURLConnection.connect();

				if (httpURLConnection.getResponseCode() == 200)
					System.out.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> "
							+ httpURLConnection.getResponseMessage());
				else
					System.err.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> "
							+ httpURLConnection.getResponseMessage());

				httpURLConnection.disconnect();
			} catch (Exception e) {
				System.err.println(imageSrc);
			}
		}
	}
}
