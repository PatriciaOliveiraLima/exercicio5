package iterasys_login;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	String url;
	WebDriver driver;
	
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

	public void Print(String nomePrint) throws IOException {
		File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:\\Users\\patri\\Exercicio-workspace\\LoginIterasys\\target\\evidencias2\\"
				+ nomePasta + "\\" + nomePrint + ".png"));
	}

	@Before
	public void Iniciar() {
		url = "https://iterasys.com.br";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patri\\Exercicio-workspace\\LoginIterasys\\drivers\\chrome\\83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void Finalizar() {
		driver.quit();
	}
	
	@Given("^que acesso o site da Iterasys$")
	public void que_acesso_o_site_da_Iterasys() throws Throwable {
		driver.get(url);
		Print("Passo 1 - Acessar o site da Iterasys");
	}

	@When("^clico em Login$")
	public void clico_em_Login() throws Throwable {
		driver.findElement(By.linkText("Login")).click();
		Print("Passo 2 - Quando clico em Login");
	}

	@When("^preencho os dados$")
	public void preencho_os_dados() throws Throwable {
		String email = "patricia_oliveiralima5@hotmail.com";
		String senha = "patricia55";
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("senha")).clear();
		driver.findElement(By.id("senha")).sendKeys(senha);
		
		Print("Passo 3 - Quando preencho os dados");
	}

	@Then("^clico em Entrar$")
	public void clico_em_Entrar() throws Throwable {
		driver.findElement(By.id("btn_login")).click();
	    Print("Passo 4 - Quando clico em Criar Conta");
	}

}
