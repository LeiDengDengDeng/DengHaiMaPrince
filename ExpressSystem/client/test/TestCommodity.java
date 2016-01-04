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
		assertEquals("Ѫ��",commodity.stockTaking("�Ͼ�").get(0).getGoodsName());
		
		assertEquals("0.9",commodity.getAlarmScale("�Ͼ�") + "");
		
		assertEquals("Ѫ��",commodity.checkStorageMessage("�Ͼ�", 20151201, 20151230).get(0).getGoodsName());
		
		assertEquals(3,commodity.getStorageNum("�Ͼ�", 20151201, 20151230).getInNum());
		
		assertEquals("Ѫ��",commodity.getAreaGoodsPOs("�Ͼ�", GoodsType.RAIL).get(0).getGoodsName());
	}
}
