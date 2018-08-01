package men.adg666.momo;

import android.content.Intent;
import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WordActivity extends AppCompatActivity {
   private TextView wordshow ;
   private Button submit;
   private EditText inputword;
   private String [] EnglishList;
   private String[] ChineseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        wordshow = findViewById(R.id.wordshow);
        Intent intent = getIntent();
        int a = intent.getIntExtra("pages",0);
        String pages = String.valueOf(a);
        getword(pages);

    }

    public void showWord (final String wordtext){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                wordshow.setText(wordtext);
            }
        });

    }


    public void getword(final String pages) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://momo.adg666.men/wordlist/"+pages+".dat")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responsedata = response.body().string();//获取单词库并解析
                    String[] wordlist = responsedata.split("#");//分割字符串
                      EnglishList = new String[wordlist.length];//英文词库
                      ChineseList = new String[wordlist.length];//中文词库
                    for (int i = 0; i < wordlist.length; i++) {
                       String[] newlist = wordlist[i].split("&");
                       ChineseList[i] = newlist[0];
                       EnglishList[i] = newlist[1];
                        }
                    //分割字符串，获取内容
                    showWord(ChineseList[0]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } ).start();
    }

    public  void  judgement(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = inputword.getText().toString();
                String show = wordshow.getText().toString();
                final ArrayList arrayList = new ArrayList();
                for (int i=0 ; i<ChineseList.length ; i++){
                    arrayList.add(ChineseList[i]);
                }
                final int number = arrayList.indexOf(show);//获取当前单词组数索引
                String answer = EnglishList[number];
                if(input.equals(show)){
                    inputword.setText("回答正确");
                    inputword.setTextColor(Integer.parseInt("#F9E09398"));
                }else{
                    inputword.setText("回答错误,应为:"+answer);
                    inputword.setTextColor(Integer.parseInt("#F9E09398"));
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            wordshow.setText(ChineseList[number+1]);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        });


    }
}