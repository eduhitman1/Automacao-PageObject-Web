package br.com.edsoft.core;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
   public  static void tirar(WebDriver 	aplicacao, String arquivo) {
	   try {
		   File screenshot = ((TakesScreenshot)aplicacao).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(screenshot, new File(arquivo));  // APRESENTA ERRO NÃO TIRA PRINT
	   } catch(Exception ex) {
		   System.out.println("Houveram problemas ao copiar o arquivo para a paste: "+ ex.getMessage());
	   }
   }
}
