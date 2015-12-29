package src.presentation.staffmanageui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import src.vo.StaffInfoVO;
import src.vo.UserVO;

public class StaffGroup {
	
	private ArrayList<StaffInfoVO> staffs;
    private int num; // text行数
    private int page;  // 页数
    private int x;
    private int y;
    private int height = 23;
    private JLabel[][] presentStaffs;
    
    Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);

    public StaffGroup(ArrayList<StaffInfoVO> staffs, int num, int x, int y) {
        this.staffs = staffs;
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
        return presentStaffs;
    }

    private void setTextLabel() {
        int start = num * (page - 1);
        if (staffs.size() - start < num)
        	presentStaffs = new JLabel[staffs.size() - start][3];
        else
        	presentStaffs = new JLabel[num][3];

        // 获得当前页数的员工信息
        for (int i = start; i < num * page && i < staffs.size(); i++) {
            JLabel ID = new JLabel(String.valueOf(staffs.get(i).getID()));
            JLabel position = new JLabel(staffs.get(i).getPosition());
            JLabel name = new JLabel(staffs.get(i).getStaffName());

            ID.setBounds(x, y + (i - start) * height, 80, height);
            name.setBounds(x + 162, y + (i - start) * height, 80, height);
            position.setBounds(x + 323, y + (i - start) * height, 80, height);

            presentStaffs[i - start][0] = ID;
            presentStaffs[i - start][1] = name;
            presentStaffs[i - start][2] = position;
        }

        for (int m = 0; m < presentStaffs.length; m++) {
            for (int n = 0; n < 3; n++) {
            	presentStaffs[m][n].setForeground(Color.WHITE);
            	presentStaffs[m][n].setFont(myFont);
            }
        }

    }

}

