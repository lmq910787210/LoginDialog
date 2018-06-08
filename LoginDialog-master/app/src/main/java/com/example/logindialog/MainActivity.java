package com.example.logindialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = (Button) findViewById(R.id.Login_button);
        Button tip = (Button) this.findViewById(R.id.Tip_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View loginView= inflater.inflate(R.layout.login_dialog,null);
                final EditText name = (EditText) loginView.findViewById(R.id.editTextUserId);
                final EditText key = (EditText) loginView.findViewById(R.id.text_word);

                builder.setView(loginView)
                        .setTitle("登录对话框")
                        .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                         @Override
                        public void onClick(DialogInterface dialog, int id) {
                            String ID=name.getText().toString();
                            String password=key.getText().toString();
                            if (ID.equals("abc") && password.equals("123")) {
                                Toast.makeText(MainActivity.this, "登陆成功！", Toast.LENGTH_LONG).show();
                            } else if(ID.equals("abc")&&!password.equals("123")) {
                                Toast.makeText(MainActivity.this, "密码错误！", Toast.LENGTH_LONG).show();
                            }
                             else{
                                Toast.makeText(MainActivity.this,"用户不存在！",Toast.LENGTH_LONG).show();
                            }
                         }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "取消！", Toast.LENGTH_SHORT).show();
                            }
                        });
                    builder.show();
                }
        });

        tip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个提示对话框")
                        .setTitle("对话框")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "您选择了确定！", Toast.LENGTH_LONG).show();
                             }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "您选择了取消！", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });
    }

}