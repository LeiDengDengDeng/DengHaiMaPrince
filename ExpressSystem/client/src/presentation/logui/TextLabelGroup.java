package src.presentation.logui;

import src.vo.LogVO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dell on 2015/11/29.
 * 用途
 */
public class TextLabelGroup {

    private ArrayList<LogVO> logs;
    private int num; // text行数
    private int page;  // 页数
    private int x;
    private int y;
    private int height = 23;
    private JLabel[][] presentLogs;
    Font myFont = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, 14);

    public TextLabelGroup(ArrayList<LogVO> logs, int num, int x, int y) {
        this.logs = logs;
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
        return presentLogs;
    }

    private void setTextLabel() {
        int start = num * (page - 1);
        if (logs.size() - start < num)
            presentLogs = new JLabel[logs.size() - start][5];
        else
            presentLogs = new JLabel[num][5];

        // 获得当前页数的日志内容
        for (int i = start; i < num * page && i < logs.size(); i++) {
            JLabel time = new JLabel(logs.get(i).getTime());
            JLabel position = new JLabel(logs.get(i).getPosition());
            JLabel name = new JLabel(logs.get(i).getName());
            JLabel operation = new JLabel(logs.get(i).getOperation());
            JLabel statement = new JLabel(logs.get(i).getStatement());

            time.setBounds(x, y + (i - start) * height, 80, height);
            position.setBounds(x + 90, y + (i - start) * height, 80, height);
            name.setBounds(x + 187, y + (i - start) * height, 80, height);
            operation.setBounds(x + 250, y + (i - start) * height, 80, height);
            statement.setBounds(x + 403, y + (i - start) * height, 135, height);

            presentLogs[i - start][0] = time;
            presentLogs[i - start][1] = position;
            presentLogs[i - start][2] = name;
            presentLogs[i - start][3] = operation;
            presentLogs[i - start][4] = statement;
        }

        for (int m = 0; m < presentLogs.length; m++) {
            for (int n = 0; n < 5; n++) {
                presentLogs[m][n].setForeground(Color.WHITE);
                presentLogs[m][n].setFont(myFont);
            }
        }

    }

}
