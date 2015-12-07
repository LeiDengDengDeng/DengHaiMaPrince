package src.vo;

import src.enums.SheetType;

import java.util.ArrayList;

/**
 * Created by dell on 2015/12/7.
 * ”√Õæ:
 */
public class ReceivingMoneySheetVO implements SheetVO {
    SheetType type = SheetType.RECEIVING_MONEY_SHEET;

    ArrayList<String[]> items;

    public ReceivingMoneySheetVO(ArrayList<String[]> items) {
        this.items = items;

    }

    public ArrayList<String[]> getItems() {
        return items;
    }

    public void setItems(ArrayList<String[]> items) {
        this.items = items;
    }

    @Override
    public SheetType getType() {
        return type;
    }
}
