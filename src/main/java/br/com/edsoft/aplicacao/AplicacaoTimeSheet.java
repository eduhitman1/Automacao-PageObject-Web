package br.com.edsoft.aplicacao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.edsoft.apoio.Date;
import br.com.edsoft.contexto.ContextoPortalTimeSheet;


public class AplicacaoTimeSheet {
	
	public static WebDriver createChrome() {
//		ContextoWeb navegador = new ContextoWeb();
//		getDriver().get("C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
//      System.setProperty(Navegador.GoogleChrome,"C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
        
        System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
        Date datetime = new Date();
		System.out.println(datetime.getDataFormatada()+" "+datetime.getHoraFormatada()+ " |"+"Abrindo o navegador");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		ContextoPortalTimeSheet portal = new ContextoPortalTimeSheet();
		portal.URL(driver);
		return driver;
	}
}
