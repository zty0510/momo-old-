package men.adg666.momo;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WordData {

    public String[] getBiglist() {
        return biglist;
    }

    public void setBiglist(String[] biglist) {
        this.biglist = biglist;
    }

    private String[] biglist;




    public void getword() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://joyooz.com/momo/data/pages/1.dat")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responsedata = response.body().string();
                    String[] wordlist = responsedata.split("#");
                    String[] newlist = new String[wordlist.length];
                    for (int i = 0; i < wordlist.length; i++) {
                        biglist = wordlist[i].split("&");
                    }//分割字符串，获取内容
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } ).start();
    }


}
