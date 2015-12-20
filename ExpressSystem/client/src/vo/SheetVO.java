package src.vo;

import src.enums.SheetState;
import src.enums.SheetType;

public interface SheetVO {

    public SheetType getType();

    public String getTime();

    public String getBuilder();

    public void setID(long ID);

    public long getID();

    public void setState(SheetState state);

    public SheetState getState();

}
