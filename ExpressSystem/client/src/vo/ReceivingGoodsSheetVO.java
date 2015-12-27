package src.vo;

import src.enums.SheetState;
import src.enums.SheetType;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by dell on 2015/12/26.
 * ��;:
 */
public class ReceivingGoodsSheetVO implements SheetVO {
    SheetType type;
    SheetState state = SheetState.NOT_EXAMINED;
    String builder;
    long ID;

    String name;
    String time;
    ArrayList<String[]> contents;  // ����СΪ4���������������š������ء�Ŀ�ĵء����ﵽ��״̬

    public ReceivingGoodsSheetVO(String builder,String time,String name,ArrayList<String[]> contents) {
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
    public void setState(SheetState state) {
        this.state = state;
    }

    @Override
    public SheetState getState() {
        return state;
    }
}
