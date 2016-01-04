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
		
		assertEquals("����Ӫҵ��",bussinessHall.getBussinessHallInfo("025000").getHallName());
		
		assertEquals("����Ӫҵ��",bussinessHall.getBussinessHallInfoByCity("�Ͼ�").get(0).getHallName());
		
		assertEquals("����Ӫҵ��",bussinessHall.getAllBussinessHallInfo().get(0).getHallName());
	}
}
