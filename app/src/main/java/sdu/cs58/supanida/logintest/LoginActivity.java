package sdu.cs58.supanida.logintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //1. Explicit (ประกาศตัวแปรบน Java)
    EditText NameEditText, UsernameEditText, PasswordEditText;
    Button LoginButton;
    String NameString, UserString, PassString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //2. Initial view ผูกตัวแปร Java ให้รู้จักกับ Element บน XML
        NameEditText = findViewById(R.id.txtName);
        UsernameEditText = findViewById(R.id.txtUsername);
        PasswordEditText = findViewById(R.id.txtPassword);
        LoginButton = findViewById(R.id.btnlogin);

        //3. สั่งให้ปุ่มคอยดักฟังว่า User คลิกที่ปุ่ม Login
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ดึงข้อมูลที่ User ป้อนในหน้า UI มาเก็บในตัวแปรชนิด String
                NameString = NameEditText.getText().toString().trim();
                UserString = UsernameEditText.getText().toString().trim();
                PassString = PasswordEditText.getText().toString().trim();

                //ตรวจสอบค่าว่าง
                if ((NameString.length()==0) || (UserString.length()==0) || (PassString.length()==0)) {
                    Toast.makeText(getApplicationContext(),"กรุณาใส่ข้อมูลให้ครบทุกช่อง",Toast.LENGTH_SHORT).show();
                }

                //ตรวจสอบการ Login
                else if ((UserString.equals("admin")) && (PassString.equals("1234"))) {
                    Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();

                    //ส่งข้อมูล NameString ไปหน้า MainActivity
                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    mainIntent.putExtra("NameString",NameString);
                    startActivity(mainIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(getApplicationContext(),"Hello!! " +NameString,Toast.LENGTH_SHORT).show();
            }
        }); //4. End OnClickListener
    } //End Method onCreate
} //End Class

