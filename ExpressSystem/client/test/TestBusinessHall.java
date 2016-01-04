package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.logbl.Log;
import src.businesslogic.nonUserbl.BussinessHall;

public class TestBusinessHall {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void test() {
		BussinessHall bussinessHall = new BussinessHall(new Log());
		
		assertEquals("仙林营业厅",bussinessHall.getBussinessHallInfo("025000").getHallName());
		
		assertEquals("仙林营业厅",bussinessHall.getBussinessHallInfoByCity("南京").get(0).getHallName());
		
		assertEquals("仙林营业厅",bussinessHall.getAllBussinessHallInfo().get(0).getHallName());
	}
}
