package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.Truck;

public class TestTruck {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void test() {
		Truck truck = new Truck(new Log());

		assertEquals(10,truck.getTruckInfo("025000000").getActiveTime());
		
		assertEquals(10,truck.getTruckByBusinesshall("025000000").get(0).getActiveTime());
		
		assertEquals(10,truck.getAllTruckInfo().get(0).getActiveTime());
	}
}
