package src.presentation.sheetui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

/**
 * Created by dell on 2015/11/27.
 * 用途：用于输入ID的一组TextField
 */
public class TextFieldGroup {
    int num;  // ID字符个数
    int x;
    int y;
    int width;
    int height;

    JTextField[] group;

    public TextFieldGroup(int num, int x, int y, int width, int height) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        init();
    }

    private void init() {
        group = new JTextField[num];
        for (int i = 0; i < num; i++) {
            JTextField temp = new JTextField(1);
            temp.setDocument(new JTextFieldLimit(1));
            temp.setBounds(x + i * width, y, width, height);
            group[i] = temp;
        }
    }

    public JTextField getTextField(int loc) {
        return group[loc];
    }

    public String getNumberString() {
        String res = "";
        for (JTextField temp : group) res += temp.getText();
        return res;
    }


    // 限制输入框的Text长度
    class JTextFieldLimit extends PlainDocument {
        private int limit;

        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }

        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null)
                return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

}
