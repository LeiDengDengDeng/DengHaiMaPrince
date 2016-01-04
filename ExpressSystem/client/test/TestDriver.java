package test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.Driver;

public class TestDriver {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void test() {
		Driver driver = new Driver(new Log());
		
		assertEquals("Ҷ����",driver.getDriverInfo("025000000").getName());
		
		assertEquals("Ҷ����",driver.getDriverByBusinesshall("025000000").get(0).getName());
		
		assertEquals("Ҷ����",driver.getAllDriverInfo().get(0).getName());
	}
}
