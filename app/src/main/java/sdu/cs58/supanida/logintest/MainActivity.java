package sdu.cs58.supanida.logintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //1. Explicit (ประกาศตัวแปรบน Java)
    TextView NameTextView;
    String GetNameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. Initial view ผูกตัวแปร Java กับ Element บนหน้า UI
        NameTextView = findViewById(R.id.txvName);

        //3. รับค่า NameString จากหน้า Login
        GetNameString = getIntent().getStringExtra("NameString");
        NameTextView.setText("ยินดีต้อนรับ "+GetNameString+" เข้าสู่ระบบ");
    } // End onCreate
}//End Class