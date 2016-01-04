package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.commoditybl.Commodity;
import src.businesslogic.logbl.Log;
import src.enums.GoodsType;

public class TestCommodity {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void test() {
		Commodity commodity = new Commodity(new Log());
		assertEquals("血吼",commodity.stockTaking("南京").get(0).getGoodsName());
		
		assertEquals("0.9",commodity.getAlarmScale("南京") + "");
		
		assertEquals("血吼",commodity.checkStorageMessage("南京", 20151201, 20151230).get(0).getGoodsName());
		
		assertEquals(3,commodity.getStorageNum("南京", 20151201, 20151230).getInNum());
		
		assertEquals("血吼",commodity.getAreaGoodsPOs("南京", GoodsType.RAIL).get(0).getGoodsName());
	}
}
