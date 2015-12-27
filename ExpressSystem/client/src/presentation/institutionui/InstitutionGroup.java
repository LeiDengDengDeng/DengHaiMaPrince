package src.presentation.institutionui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import src.vo.InstitutionVO;

public class InstitutionGroup {
	private ArrayList<InstitutionVO> institutionVOs;
    private int num; // text行数
    private int page;  // 页数
    private int x;
    private int y;
    private int height = 23;
    private JLabel[][] presentInstitutions;
    
    Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);

    public InstitutionGroup(ArrayList<InstitutionVO> institutionVOs, int num, int x, int y) {
        this.institutionVOs = institutionVOs;
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
        return presentInstitutions;
    }

    private void setTextLabel() {
        int start = num * (page - 1);
        if (institutionVOs.size() - start < num)
        	presentInstitutions = new JLabel[institutionVOs.size() - start][3];
        else
        	presentInstitutions = new JLabel[num][3];

        // 获得当前页数的员工信息
        for (int i = start; i < num * page && i < institutionVOs.size(); i++) {
            JLabel ID = new JLabel(String.valueOf(institutionVOs.get(i).getInstitutionID()));
            JLabel name = new JLabel(institutionVOs.get(i).getInstitutionName());
            JLabel staffNums = new JLabel(String.valueOf(institutionVOs.get(i).getStaff().size()));

            ID.setBounds(x, y + (i - start) * height, 150, height);
            name.setBounds(x + 195, y + (i - start) * height, 150, height);
            staffNums.setBounds(x + 385, y + (i - start) * height, 150, height);

            presentInstitutions[i - start][0] = ID;
            presentInstitutions[i - start][1] = name;
            presentInstitutions[i - start][2] = staffNums;
        }

        for (int m = 0; m < presentInstitutions.length; m++) {
            for (int n = 0; n < 3; n++) {
            	presentInstitutions[m][n].setForeground(Color.WHITE);
            	presentInstitutions[m][n].setFont(myFont);
            }
        }

    }

}
