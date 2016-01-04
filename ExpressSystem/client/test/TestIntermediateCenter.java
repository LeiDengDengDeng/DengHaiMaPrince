package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.IntermediateCenter;

public class TestIntermediateCenter {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void test() {
		IntermediateCenter intermediateCenter = new IntermediateCenter(new Log());

		assertEquals("0250",intermediateCenter.getIntermediateCenterInfo("ÄÏ¾©").getId());
		
		assertEquals("0250",intermediateCenter.getAllIntermediateCenterInfo().get(0).getId());
	}
}
