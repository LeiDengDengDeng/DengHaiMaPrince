package src.presentation.sheetui;

import src.businesslogicservice.sheetblservice.SheetBLService;
import src.vo.ConstantVO;
import src.vo.SheetVO;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class FormulateConstantPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

//    private SheetBLService constantbl;

    private final static int WIDTH = 641;
    private final static int HEIGHT = 572;

    private JButton confirmButton;
    private JTable table;
    private JScrollPane scrollPane;

    public FormulateConstantPanel() {
        confirmButton = new JButton();
        confirmButton.setBounds(500, 400, 80, 40);

        initTable();

        this.setLayout(null);
        this.add(confirmButton);
        this.add(scrollPane);
    }

    public void initTable() {
        String[] columnNames = {"城市", "距离\n(公里km)", "价格\n(元RMB/公里km)"};

//        ArrayList<SheetVO> constantVOs = constantbl.findVOs(FindingType.ALL);
        ArrayList<SheetVO> constantVOs = new ArrayList<>();
        ConstantVO c1 = new ConstantVO(10,20,"南京-长沙");
        ConstantVO c2 = new ConstantVO(20,10,"北京-长沙");
        ConstantVO c3 = new ConstantVO(30,5,"南京-北京");
        constantVOs.add((SheetVO)c1);
        constantVOs.add((SheetVO)c2);
        constantVOs.add((SheetVO)c3);
        String[][] data = new String[constantVOs.size()][3];
        for (int i = 0; i < constantVOs.size(); i++) {
            data[i][0] = ((ConstantVO) (constantVOs.get(i))).getCity();
            data[i][1] = ((ConstantVO) (constantVOs.get(i))).getDistant() + "";
            data[i][2] = ((ConstantVO) (constantVOs.get(i))).getPrice() + "";
        }

        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,641,400);
    }


    public static void main(String[] args) {
        FormulateConstantPanel f = new FormulateConstantPanel();
        f.run();
    }

    public void run() {
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, WIDTH, HEIGHT);
        frame.setContentPane(this);
        frame.setVisible(true);
    }

}