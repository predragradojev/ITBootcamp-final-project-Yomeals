package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasicPage {
	
	protected WebDriver driver;
	protected WebDriver wait;
	protected JavascriptExecutor js;

	public BasicPage(WebDriver driver, WebDriver wait, JavascriptExecutor js) {
		super();
		this.driver = driver;
		this.wait = wait;
		this.js = js;
	}

}
