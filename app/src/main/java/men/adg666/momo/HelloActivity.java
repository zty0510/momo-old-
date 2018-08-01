package men.adg666.momo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeoutException;

import butterknife.BindView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        getSupportActionBar().hide();
       final EditText username = findViewById(R.id.username);
       final EditText passwd = findViewById(R.id.password);
        Button login = findViewById(R.id.button);
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(HelloActivity.this, "欢迎使用默默", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(HelloActivity.this,ModeChoose.class));
                 finish();
                 /*if (username.getText().toString().equals("test") && passwd.getText().toString().equals("test")){
                  startActivity(new Intent(HelloActivity.this,WordActivity.class));
                     Toast.makeText(HelloActivity.this, "欢迎使用默默", Toast.LENGTH_SHORT).show();
                     finish();
                 }else{
                     passwd.setError("密码错误");
                 }*/
             }
         });
    }
}
