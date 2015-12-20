package src.presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import src.enums.GoodsType;
import src.vo.ExpressInfoVO;

public class ExpressInfoLabelGroup {
	private ArrayList<ExpressInfoVO> storages;
	private int num; // text行数
    private int page;  // 页数
    private int x;
    private int y;
    private int height = 23;
    private JLabel[][] presentStorages;
    Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
    
    public ExpressInfoLabelGroup(ArrayList<ExpressInfoVO> storages, int num, int x, int y) {
        this.storages = storages;
        this.num = num;
        this.page = 1;
        this.x = x;
        this.y = y;

        setTextLabel();
    }
    
    public void setPage(int page) {
        this.page = page;

        setTextLabel();
    }

    public JLabel[][] getLabel() {
        return presentStorages;
    }
    
    private void setTextLabel() {
        int start = num * (page - 1);
        if (storages.size() - start < num)
            presentStorages = new JLabel[storages.size() - start][8];
        else
            presentStorages = new JLabel[num][8];

        // 获得当前页数的日志内容
        for (int i = start; i < num * page && i < storages.size(); i++) {
            JLabel goodsName = new JLabel(storages.get(i).getGoodsName());
            JLabel expressNumber = new JLabel(storages.get(i).getExpressNumber());
            JLabel inTime = new JLabel(storages.get(i).getInTime());
            JLabel destination = new JLabel(storages.get(i).getDestination());
            JLabel areaNumber = null;
            if(storages.get(i).getAreaNumber() == GoodsType.SHIPPING){
            	areaNumber = new JLabel("航运区");
            }
            else if(storages.get(i).getAreaNumber() == GoodsType.RAIL){
            	areaNumber = new JLabel("铁运区");
            }
            else if(storages.get(i).getAreaNumber() == GoodsType.TRANSPORT){
            	areaNumber = new JLabel("汽运区");
            }
            else if(storages.get(i).getAreaNumber() == GoodsType.FLXIBLE){
            	areaNumber = new JLabel("机动区");
            }
            JLabel rowNumber = new JLabel(storages.get(i).getRowNumber() + "");
            JLabel shelfNumber = new JLabel(storages.get(i).getShelfNumber() + "");
            JLabel seatNumber = new JLabel(storages.get(i).getSeatNumber() + "");

            goodsName.setBounds(x, y + (i - start) * height, 60, height);
            expressNumber.setBounds(x + 75, y + (i - start) * height, 130, height);
            inTime.setBounds(x + 220, y + (i - start) * height, 80, height);
            destination.setBounds(x + 315, y + (i - start) * height, 60, height);
            areaNumber.setBounds(x + 365, y + (i - start) * height, 60, height);
            rowNumber.setBounds(x + 430, y + (i - start) * height, 60, height);
            shelfNumber.setBounds(x + 470, y + (i - start) * height, 60, height);
            seatNumber.setBounds(x + 510, y + (i - start) * height, 60, height);

            presentStorages[i - start][0] = goodsName;
            presentStorages[i - start][1] = expressNumber;
            presentStorages[i - start][2] = inTime;
            presentStorages[i - start][3] = destination;
            presentStorages[i - start][4] = areaNumber;
            presentStorages[i - start][5] = rowNumber;
            presentStorages[i - start][6] = shelfNumber;
            presentStorages[i - start][7] = seatNumber;
        }

        for (int m = 0; m < presentStorages.length; m++) {
            for (int n = 0; n < 8; n++) {
                presentStorages[m][n].setForeground(Color.WHITE);
                presentStorages[m][n].setFont(myFont);
            }
        }

    }
}
