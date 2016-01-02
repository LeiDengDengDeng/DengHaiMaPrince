package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import src.businesslogic.accountbl.Account;
import src.businesslogic.commoditybl.Logistic;
import src.businesslogic.logbl.Log;
import src.businesslogic.loginbl.LogIn;
import src.businesslogic.sheetbl.PaymentSheet;
import src.vo.PaymentSheetVO;
import src.vo.UserVO;

public class TestPaymentSheet {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "测试者", "财务人员",
				null, null, "南京", "鼓楼营业厅");
	}

	@Test
	public void test() {
		PaymentSheet paymentSheetBL = new PaymentSheet(new Log(), new Logistic(
				new Log()), new Account(new Log()));

		// 测试银行账户数据是否正常
		assertEquals("2000111122223333666",
				paymentSheetBL.getExistedInfo()[0][0]);
		assertEquals("噔噔", paymentSheetBL.getExistedInfo()[0][1]);

		// 测试账户余额充足与账户余额不足时付款单反馈情况
		double money = Double
				.parseDouble(paymentSheetBL.getExistedInfo()[0][2]);
		PaymentSheetVO vo1 = new PaymentSheetVO("测试者", "2015-1-2", 10,
				paymentSheetBL.getExistedInfo()[0][0],
				paymentSheetBL.getExistedInfo()[0][1], "租金", "测试用例");
		assertEquals(true, paymentSheetBL.add(vo1));
		assertEquals(money - 10,
				Double.parseDouble(paymentSheetBL.getExistedInfo()[0][2]), 0.1);
		money = Double.parseDouble(paymentSheetBL.getExistedInfo()[0][2]);
		PaymentSheetVO vo2 = new PaymentSheetVO("测试者", "2015-1-2", money + 10,
				paymentSheetBL.getExistedInfo()[0][0],
				paymentSheetBL.getExistedInfo()[0][1], "租金", "测试用例");
		assertEquals(false, paymentSheetBL.add(vo2));
		assertEquals(money,
				Double.parseDouble(paymentSheetBL.getExistedInfo()[0][2]), 0.1);

	}

}
