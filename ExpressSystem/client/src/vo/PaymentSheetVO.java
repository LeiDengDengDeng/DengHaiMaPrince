package src.vo;

import src.enums.SheetState;
import src.enums.SheetType;

public class PaymentSheetVO implements SheetVO {
    SheetType type = SheetType.PAYMENT_SHEET;
    SheetState state;
    String builder;
    long ID;

    String time; // ��������
    double money; // ������
    String name; // ������
    String account; // �����˺�
    String way; // ��Ŀ
    String remark; // ��ע

    public PaymentSheetVO(String builder, String time, double money, String name, String account, String
            way, String remark) {
        super();
        this.builder = builder;
        this.time = time;
        this.money = money;
        this.name = name;
        this.account = account;
        this.way = way;
        this.remark = remark;
    }

    public String getTime() {
        return time;
    }

    public double getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getWay() {
        return way;
    }

    public String getRemark() {
        return remark;
    }

    public String getBuilder() {
        return builder;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getID() {
        return ID;
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

}
