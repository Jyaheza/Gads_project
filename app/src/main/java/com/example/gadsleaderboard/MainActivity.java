package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
private ProgressBar mpgBar;
    private String mLeadersResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        mpgBar = (ProgressBar) findViewById(R.id.pb_loading);

        try {
            URL skillIqUrl = ApiUtil.buildUrl("api/hours");
            new skillIqQueryTask().execute(skillIqUrl);

        }
        catch (Exception e){
            Log.d("Error", e.getMessage());
        }

//        ConstraintLayout bgImage = findViewById(R.id.bg_image);
//        bgImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, leaderboard2.class));
//            }
//        });




//       Intent intent = new Intent(MainActivity.this,leaderboard.class);
//        //Handler handler = new Handler();
//        Handler().postDelayed({startActivity(intent),3000);})
////        Runnable r = getIntent();
////                Intent intent= new Intent(MainActivity.this,leaderboard.class);
////         handler.postDelayed({Intent intent= new Intent(MainActivity.this,leaderboard.class)},3000});
//    //}}
     }
    public class skillIqQueryTask extends AsyncTask<URL,Void,String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String result = null;
            try{
                result= ApiUtil.getJSON(searchUrl);
            }
            catch (IOException e){
                Log.e("Error", e.getMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView jsonText = (TextView) findViewById(R.id.tv_result);
            TextView tvError= (TextView) findViewById(R.id.tv_error) ;
            mpgBar.setVisibility(View.INVISIBLE);
            if (result == null) {
                jsonText.setVisibility(View.INVISIBLE);
                tvError.setVisibility(View.VISIBLE);
            }
            else{
                jsonText.setVisibility(View.VISIBLE);
                tvError.setVisibility(View.INVISIBLE);
            }
   ArrayList<Learningleaders> leaders= ApiUtil.getLearningLeadersFromJson(result);
            mLeadersResult = "";
                 for(Learningleaders leader: leaders){
                     mLeadersResult = mLeadersResult +leader.name+"\n"+leader.country+"\n"+leader.hours+"\n\n";

                     jsonText.setText(mLeadersResult);
                    }

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mpgBar.setVisibility(View.VISIBLE);
        }
    }

}