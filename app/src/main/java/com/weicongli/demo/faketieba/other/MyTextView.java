package com.weicongli.demo.faketieba.other;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author: WeicongLi
 * @time: 2019/3/6 19:50
 * @email: 912220261@qq.com
 * @Function:
 */
@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {
    private int num;

    public MyTextView(Context context) {
        super(context);
        num = 0;
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        this.setText(num+"");
    }
}
