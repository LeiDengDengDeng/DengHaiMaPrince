package src.vo;

import src.enums.SheetState;
import src.enums.SheetType;

public class ConstantVO implements SheetVO {
    SheetType type = SheetType.CONSTANT;
    SheetState state;
    String builder;
    String time;
    long ID;

    double distant;
    double price;
    String city;

    public ConstantVO(String builder, String time, double distant, double price, String city) {
        super();
        this.builder = builder;
        this.time = time;
        this.distant = distant;
        this.price = price;
        this.city = city;
    }

    public double getDistant() {
        return distant;
    }

    public double getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public String getTime() {
        return time;
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
