package com.selenium.javaSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		List <WebElement> input = driver.findElements(By.xpath("//table[@id='table1']//th"));
		System.out.println(input.size());
		for(WebElement data: input) {
		System.out.println(data.getText());
		}
		
		System.out.println("-----------------Table datas---------------");
		
		List<WebElement> datas=driver.findElements(By.xpath("//table[@id='table1']//td"));
		System.out.println(datas.size());
		for(WebElement data1: datas) {
		System.out.println(data1.getText());
		}
		
		System.out.println("-----------------Table row2, col3---------------");
		List<WebElement> rowData=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));
		System.out.println(rowData.size());
		for(WebElement row2: rowData) {
		System.out.println(row2.getText());
		}
		
		System.out.println("-----------------Table row2 all--------------");
		List<WebElement> row2All=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[2]/td"));
		System.out.println(row2All.size());
		for(WebElement row2: row2All) {
		System.out.println(row2.getText());
		}
		
		System.out.println("-----------------Table row and col count--------------");
		List<WebElement> rowsize=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rowcount=rowsize.size();
		System.out.println(rowcount);
		List<WebElement> colsize=driver.findElements(By.xpath("//table[@id='table1']//th"));
		int colcount=colsize.size();
		System.out.println(colcount);
		
		
		for(int r=1; r < rowcount ; r++) {
			for(int c=1; c < colcount; c++) {
				WebElement data1;
				if(r==1) {
					data1=(WebElement) driver.findElements(By.xpath("//table[@id='table1']//tr[" + r +"]//th[" + c + "]"));
				}
				else {
					data1=(WebElement) driver.findElements(By.xpath("//table[@id='table1']//tr[" +r +"]//td["+c+"]"));
				}
			}
		}
		
		driver.quit();
	}

}
