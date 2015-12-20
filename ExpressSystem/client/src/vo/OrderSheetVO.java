package src.vo;


import src.enums.SheetState;
import src.enums.SheetType;

public class OrderSheetVO implements SheetVO {
    SheetType type = SheetType.ORDER_SHEET;
    SheetState state;
    String builder;
    String time;

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
    String receivingTime;

    public OrderSheetVO(String builder, String time, long courierNumber, String senderName,
                        String senderAddress, String senderOrganization,
                        String senderTelNum, String senderMobNum, String receiverName,
                        String receiverAddress, String receiverOrganization,
                        String receiverTelNum, String receiverMobNum) {
        super();
        this.builder = builder;
        this.time = time;
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
    }

    public void setReceivingInformation(String actualReceiverName, String recevingState, String time) {
        this.actualReceiverName = actualReceiverName;
        this.recevingState = recevingState;
        this.time = time;
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

    public String getReceivingTime() {
        return receivingTime;
    }

    public String getBuilder() {
        return builder;
    }

    @Override
    public void setID(long ID) {
    }

    public long getID() {
        return courierNumber;
    }

    public void setState(SheetState state) {
        this.state = state;
    }

    public SheetState getState() {
        return state;
    }

    public SheetType getType() {
        return type;
    }

    public String getTime() {
        return time;
    }
}
