package men.adg666.momo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class ModeChoose extends AppCompatActivity {
    private Button page10;
    private Button page20 ;
    private Button page30 ;
    private Button page40 ;
    private Button page50 ;
    private Button page60 ;
    private Button page70 ;
    private Button page80 ;
    private Button page90 ;
    private Button page100 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_choose);
        page10 = findViewById(R.id.page1);
        page20 = findViewById(R.id.page2);
        page30 = findViewById(R.id.page3);
        page40 = findViewById(R.id.page4);
        page50 = findViewById(R.id.page5);
        page60 = findViewById(R.id.page6);
        page70 = findViewById(R.id.page7);
        page80 = findViewById(R.id.page8);
        page90 = findViewById(R.id.page9);
        page100 = findViewById(R.id.page10);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            int pages ;
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.page1: pages = 1;
                        break;
                    case R.id.page2: pages = 2;
                        break;
                    case R.id.page3: pages = 3;
                        break;
                    case R.id.page4: pages = 4;
                        break;
                    case R.id.page5: pages = 5;
                        break;
                    case R.id.page6: pages = 6;
                        break;
                    case R.id.page7: pages = 7;
                        break;
                    case R.id.page8: pages = 8;
                        break;
                    case R.id.page9: pages = 9;
                        break;
                    case R.id.page10: pages = 10;
                        break;
                    default:break;
                }
                Intent intent = new Intent(ModeChoose.this,WordActivity.class);
                intent.putExtra("pages",pages);
                startActivity(intent);

            }
        };
        page10.setOnClickListener(onClickListener);
        page20.setOnClickListener(onClickListener);
        page30.setOnClickListener(onClickListener);
        page40.setOnClickListener(onClickListener);
        page50.setOnClickListener(onClickListener);
        page60.setOnClickListener(onClickListener);
        page70.setOnClickListener(onClickListener);
        page80.setOnClickListener(onClickListener);
        page90.setOnClickListener(onClickListener);
        page100.setOnClickListener(onClickListener);
    }



}

