package src.po;

import src.enums.SheetState;
import src.enums.SheetType;

import java.util.ArrayList;

/**
 * Created by dell on 2015/12/27.
 * 用途:
 */
public class ReceivingGoodsSheetPO implements SheetPO{
    SheetType type;
    SheetState state = SheetState.NOT_EXAMINED;
    String builder;
    long ID;

    String name;
    String time;
    ArrayList<String[]> contents;  // 里层大小为4，包括快递物流编号、出发地、目的地、货物到达状态

    public ReceivingGoodsSheetPO(String builder,String time,String name,ArrayList<String[]> contents) {
        this.builder = builder;
        this.time = time;
        this.name = name;
        this.contents = contents;
    }

    public ArrayList<String[]> getContents() {
        return contents;
    }

    public void setContents(ArrayList<String[]> contents) {
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public SheetType getType() {
        return type;
    }

    @Override
    public String getTime() {
        return time;
    }

    @Override
    public String getBuilder() {
        return builder;
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
