package src.businesslogic.sheetbl;

import src.enums.FindingType;
import src.businesslogicservice.sheetblservice.SheetBLService;
import src.dataservice.sheetdataservice.SheetDataService;
import src.enums.SheetType;
import src.po.SheetPO;
import src.enums.SheetState;
import src.vo.SheetVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by dell on 2015/11/25.
 * 用途
 */
public abstract class Sheet implements SheetBLService {
    SheetDataService sheetData;

    @Override
    abstract public String[][] getExistedInfo();

    @Override
    final public boolean add(SheetVO vo) {
        SheetPO po = generatePO(vo);
        try {
            sheetData.insert(po);
        } catch (RemoteException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean modify(long ID, SheetVO vo){
        SheetPO po = generatePO(vo);
        po.setID(ID);
        try {
            sheetData.update(po);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    final public SheetVO find(long ID) {
        try {
            SheetPO po = sheetData.find(ID, getType());
            SheetVO vo = generateVO(po);
            return vo;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    final public ArrayList<SheetVO> findVOs(FindingType findingType) {
        ArrayList<SheetVO> sheetVOs = new ArrayList<>();

        try {
            ArrayList<SheetPO> sheetPOs = sheetData.finds(getType());

            switch (findingType) {
                case ALL:
                    for (SheetPO po : sheetPOs) sheetVOs.add(generateVO(po));
                    break;
                case NOT_EXAMINED:
                    for (SheetPO po : sheetPOs) {
                        if (po.getSheetState() == SheetState.NOT_EXAMINED) {
                            sheetVOs.add(generateVO(po));
                        }
                    }
                    break;
            }

            return sheetVOs;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    final public boolean examineSheet(long ID, SheetState state) {
        try {
            SheetPO po = sheetData.find(ID, getType());
            po.setSheetState(state);
            sheetData.update(po);
        } catch (RemoteException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return false;
        }
        return true;
    }

    abstract public SheetType getType();

    abstract public SheetVO generateVO(SheetPO po);

    abstract public SheetPO generatePO(SheetVO vo);
}
