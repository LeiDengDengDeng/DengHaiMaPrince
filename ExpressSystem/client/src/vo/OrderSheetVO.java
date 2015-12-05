package src.vo;


import src.enums.SheetType;

public class OrderSheetVO implements SheetVO {
    SheetType type = SheetType.ORDER_SHEET;

    long courierNumber; // 快递物流编号
    String senderName; // 姓名
    String senderAddress; // 地址
    String senderOrganization; // 单位
    String senderTelNum; // 电话
    String senderMobNum; // 手机号码
    String receiverName;
    String receiverAddress;
    String receiverOrganization;
    String receiverTelNum;
    String receiverMobNum;
    String actualReceiverName; // 实际收件人
    String recevingState; //收件状态

    public OrderSheetVO(long courierNumber, String senderName,
                        String senderAddress, String senderOrganization,
                        String senderTelNum, String senderMobNum, String receiverName,
                        String receiverAddress, String receiverOrganization,
                        String receiverTelNum, String receiverMobNum, String actualReceiverName, String recevingState) {
        super();
        this.courierNumber = courierNumber;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderOrganization = senderOrganization;
        this.senderTelNum = senderTelNum;
        this.senderMobNum = senderMobNum;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverOrganization = receiverOrganization;
        this.receiverTelNum = receiverTelNum;
        this.receiverMobNum = receiverMobNum;
        this.actualReceiverName = actualReceiverName;
        this.recevingState = recevingState;
    }

    public long getCourierNumber() {
        return courierNumber;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSenderOrganization() {
        return senderOrganization;
    }

    public String getSenderTelNum() {
        return senderTelNum;
    }

    public String getSenderMobNum() {
        return senderMobNum;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public String getReceiverOrganization() {
        return receiverOrganization;
    }

    public String getReceiverTelNum() {
        return receiverTelNum;
    }

    public String getReceiverMobNum() {
        return receiverMobNum;
    }

    public String getRecevingState() {
        return recevingState;
    }

    public String getActualReceiverName() {
        return actualReceiverName;
    }

    @Override
    public SheetType getType() {
        return type;
    }
}
