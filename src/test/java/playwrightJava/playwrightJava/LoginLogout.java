package playwrightJava.playwrightJava;

import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginLogout {

	public static void main(String[] args) {
		
		Browser br = null ;

		Page page = null ;
		try {
		
		br = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
				
		page= br.newPage();
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
		
		using id
		page.locator("#email1").fill("admin@email.com");
		
		//uing xpath 
//		page.locator("xpath=//input[@name='email1']").fill("admin@email.com");
		
		//using css
//		page.locator("css=input[name='email1']").fill("admin@email.com");
		
		
		//using placeholder
		page.getByPlaceholder("Enter Email").fill("admin@email.com");
		
		page.getByPlaceholder("Enter Password").fill("admin@123");
		
		//page.getByText("Sign in").nth(1).click();
		
		page.getByText("Sign in").last().click();
		
		PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
		
		page.getByAltText("menu").click();
		
		page.getByText("Sign out").click();
		
		PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
		
		}
		finally {
			
			page.close();
			
			br.close();
		}
		

	}

}
