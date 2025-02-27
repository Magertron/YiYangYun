package com.wd.yiyangyun.mvp.mine.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.wd.yiyangyun.R;

public class CreateUserDialog extends Dialog {

    /**
     * 上下文对象 *
     */
    Activity context;

    private Button btn_save;

    public Spinner text_name;

    public EditText text_mobile;

    public EditText text_info;


    private View.OnClickListener mClickListener;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;

    public CreateUserDialog(Activity context) {
        super(context);
        this.context = context;
    }

    public CreateUserDialog(Activity context, View.OnClickListener clickListener, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super(context);
        this.context = context;
        this.mClickListener = clickListener;
        this.mOnItemSelectedListener = onItemSelectedListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 指定布局
        this.setContentView(R.layout.create_user_dialog);

        text_mobile = (EditText) findViewById(R.id.text_mobile);
        text_info = (EditText) findViewById(R.id.text_info);

        /*
         * 获取圣诞框的窗口对象及参数对象以修改对话框的布局设置, 可以直接调用getWindow(),表示获得这个Activity的Window
         * 对象,这样这可以以同样的方式改变这个Activity的属性.
         */
        Window dialogWindow = this.getWindow();

        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
//        p.height = (int) (d.getHeight() * 0.4); // 高度设置为屏幕的0.6
//        p.width = (int) (d.getWidth() * 0.7); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(p);

        // 根据id在布局中找到控件对象
        btn_save = (Button) findViewById(R.id.btn_save_pop);
        text_name =  findViewById(R.id.text_name);

        // 为按钮绑定点击事件监听器
            text_name.setOnItemSelectedListener(mOnItemSelectedListener);
            btn_save.setOnClickListener(mClickListener);
        this.setCancelable(true);
    }
}
