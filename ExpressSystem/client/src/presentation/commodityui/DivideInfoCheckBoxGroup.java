package src.presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import src.vo.ExpressInfoVO;

public class DivideInfoCheckBoxGroup {
	private ArrayList<ExpressInfoVO> storages;
	private int num; // text行数
    private int page;  // 页数
    private int x;
    private int y;
    private int height = 23;
    private JCheckBox[] presentBoxs;
    private ArrayList<JCheckBox> boxs;
    Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);
    
    public DivideInfoCheckBoxGroup(ArrayList<ExpressInfoVO> storages, int num, int x, int y) {
        this.storages = storages;
        this.num = num;
        this.page = 1;
        this.x = x;
        this.y = y;

        boxs = new ArrayList<JCheckBox>();
        for(int i = 0;i < storages.size();i++){
        	boxs.add(new JCheckBox());
        }
        setTextLabel();
    }
    
    public void setPage(int page) {
        this.page = page;

        setTextLabel();
    }

    public JCheckBox[] getCheckBox() {
        return presentBoxs;
    }
    
    public ArrayList<JCheckBox> getCheckBoxList(){
    	return boxs;
    }
    
    private void setTextLabel() {
        int start = num * (page - 1);
        if (storages.size() - start < num)
            presentBoxs = new JCheckBox[storages.size() - start];
        else
            presentBoxs = new JCheckBox[num];

        // 获得当前页数的日志内容
        for (int i = start; i < num * page && i < storages.size(); i++) {
            JCheckBox checkBox = boxs.get(i);

            checkBox.setBounds(x + 450, y + (i - start) * height, 50, height);
            checkBox.setOpaque(false);
            
            presentBoxs[i - start] = checkBox;
        }

        for (int m = 0; m < presentBoxs.length; m++) {
        	presentBoxs[m].setForeground(Color.WHITE);
        	presentBoxs[m].setFont(myFont);
            
        }

    }
}
