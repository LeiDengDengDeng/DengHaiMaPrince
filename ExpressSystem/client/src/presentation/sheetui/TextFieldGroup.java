package src.presentation.sheetui;

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

    TextField[] group;

    public TextFieldGroup(int num, int x, int y, int width, int height) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        init();
    }

    private void init() {
        group = new TextField[num];
        for (int i = 0; i < num; i++) {
            TextField temp = new TextField(1);
            temp.setBounds(x + i * width, y, width, height);
            group[i] = temp;
        }
    }

    public TextField getTextField(int loc) {
        return group[loc];
    }


}
