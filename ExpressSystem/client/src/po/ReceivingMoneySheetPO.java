package src.po;

import src.enums.SheetState;
import src.enums.SheetType;

import java.util.ArrayList;

/**
 * Created by dell on 2015/12/7.
 * ”√Õæ:
 */
public class ReceivingMoneySheetPO implements SheetPO {
    SheetType type = SheetType.RECEIVING_MONEY_SHEET;
    SheetState state = SheetState.NOT_EXAMINED;
    long ID;

    ArrayList<String[]> items;

    public ReceivingMoneySheetPO(ArrayList<String[]> items) {
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

    @Override
    public void setID(long ID) {
        this.ID = ID;
    }

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public void setSheetState(SheetState state) {
        this.state = state;
    }

    @Override
    public SheetState getSheetState() {
        return state;
    }
}
