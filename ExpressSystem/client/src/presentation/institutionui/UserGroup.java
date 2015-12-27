package src.presentation.institutionui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import src.vo.InstitutionVO;
import src.vo.UserVO;

public class UserGroup {
	
	private InstitutionVO institutionVO;
	private ArrayList<UserVO> staffs;
    private int num; // text行数
    private int page;  // 页数
    private int x;
    private int y;
    private int height = 23;
    private JLabel[][] presentStaffs;
    
    Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);

    public UserGroup(ArrayList<UserVO> staffs, int num, int x, int y,InstitutionVO institutionVO) {
        this.staffs = staffs;
        this.num = num;
        this.page = 1;
        this.x = x;
        this.y = y;
        this.institutionVO = institutionVO;
        
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
            JLabel ID = new JLabel(String.valueOf(staffs.get(i).getpersonalID()));
            JLabel position = new JLabel(staffs.get(i).getMyPosition());
            JLabel name = new JLabel(staffs.get(i).getpersonalName());
            new Ins_StaffListener(ID, institutionVO);

            ID.setBounds(x, y + (i - start) * height, 150, height);
            name.setBounds(x + 189, y + (i - start) * height, 150, height);
            position.setBounds(x + 350, y + (i - start) * height, 150, height);

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
