package src.businesslogic.accountbl;
import java.util.ArrayList;

import src.businesslogic.logbl.Log;
import src.vo.AccountVO;

public class MockAccount extends Account {

	public MockAccount(Log log) {
		super(log);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<AccountVO> getAccountList() {
		AccountVO vo1=new AccountVO("Ð¡Íõ×Ó", 1234123412341234234L, 20000);
		ArrayList<AccountVO> voList=new ArrayList<AccountVO>();
		voList.add(vo1);
		return voList;
	}
	
	public void updateAmount(long ID,double difference){
	System.out.println(ID+"¡®s ammount Updated!!!: "+"-"+difference);	
	}
	
	public void initAmount(ArrayList<AccountVO> vo){
		AccountVO accountVO=vo.get(0);
		System.out.println("ID: "+accountVO.getID()+"name: "+accountVO.getName()+"amount "+accountVO.getAmount());
	}
}
