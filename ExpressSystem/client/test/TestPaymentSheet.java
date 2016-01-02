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
		LogIn.currentUser = new UserVO(123456, 123456, "123456", "������", "������Ա",
				null, null, "�Ͼ�", "��¥Ӫҵ��");
	}

	@Test
	public void test() {
		PaymentSheet paymentSheetBL = new PaymentSheet(new Log(), new Logistic(
				new Log()), new Account(new Log()));

		// ���������˻������Ƿ�����
		assertEquals("2000111122223333666",
				paymentSheetBL.getExistedInfo()[0][0]);
		assertEquals("����", paymentSheetBL.getExistedInfo()[0][1]);

		// �����˻����������˻�����ʱ����������
		double money = Double
				.parseDouble(paymentSheetBL.getExistedInfo()[0][2]);
		PaymentSheetVO vo1 = new PaymentSheetVO("������", "2015-1-2", 10,
				paymentSheetBL.getExistedInfo()[0][0],
				paymentSheetBL.getExistedInfo()[0][1], "���", "��������");
		assertEquals(true, paymentSheetBL.add(vo1));
		assertEquals(money - 10,
				Double.parseDouble(paymentSheetBL.getExistedInfo()[0][2]), 0.1);
		money = Double.parseDouble(paymentSheetBL.getExistedInfo()[0][2]);
		PaymentSheetVO vo2 = new PaymentSheetVO("������", "2015-1-2", money + 10,
				paymentSheetBL.getExistedInfo()[0][0],
				paymentSheetBL.getExistedInfo()[0][1], "���", "��������");
		assertEquals(false, paymentSheetBL.add(vo2));
		assertEquals(money,
				Double.parseDouble(paymentSheetBL.getExistedInfo()[0][2]), 0.1);

	}

}
