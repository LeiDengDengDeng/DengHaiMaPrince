package src.enums;


/**
 * х╗оч
 * @author samsung
 *
 */
public enum Authority {
	STAFFMANAGE(1),INTER_RECEIVE(2),BUSINESS_RECEIVE(3),RECIEPTDOCUMENT(4),TRUCK(5),TRANSPORT(6),
		RECORD_ORDER(7),GOODS_RECEIPT(8),STORAGEMANAGE(9),DRIVERMANAGE(10),CHECK_BUSINESS(11),
		INSTITUTION(12),ACCESS(13),PAYMENTSHEET(14),ACCOUNTMANAGE(15),COSTMANAGE(16),
		SETTLERMENT(17),CHANGE_AUTHORITY(18),CHECK_LOG(19),CONSTANT(20),INITIAL(21);

	private int index;
	
	private Authority(){
		
	}
	
	private Authority(int index){
		this.index = index;
	}
	
	public static Authority getAuthority(int index){		
		 for (Authority s : Authority.values()) {
            if (s.getIndex() == index) {
                return s;
            }
        }
        return null;
	}
	
	public int getIndex() {
       return index;
   }
	
}
