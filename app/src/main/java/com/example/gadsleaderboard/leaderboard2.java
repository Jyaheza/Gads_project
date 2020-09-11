package com.example.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.example.gadsleaderboard.ui.main.SectionsPagerAdapter;

public class leaderboard2 extends AppCompatActivity {

//    public ProgressBar mpgBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard2);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        Button button = (Button) findViewById(R.id.button_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      startActivity(new Intent(leaderboard2.this,SubmitActivity.class));
            }
        });
//
//        mpgBar = (ProgressBar) findViewById(R.id.pb_loading);
//        try {
//            URL skillIqUrl = ApiUtil.buildUrl("api/hours");
//            new leaderboard2.skillIqQueryTask().execute(skillIqUrl);
//
//        }
//        catch (Exception e){
//            Log.d("Error", e.getMessage());
//        }

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


//    public class skillIqQueryTask extends AsyncTask<URL,Void,String> {
//
//        @Override
//        protected String doInBackground(URL... urls) {
//            URL searchUrl = urls[0];
//            String result = null;
//            try{
//                result= ApiUtil.getJSON(searchUrl);
//            }
//            catch (IOException e){
//                Log.e("Error", e.getMessage());
//            }
//            return result;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            TextView jsonText = (TextView) findViewById(R.id.tv_result);
//            TextView tvError= (TextView) findViewById(R.id.tv_error) ;
//            mpgBar.setVisibility(View.INVISIBLE);
//            if (result == null) {
//                jsonText.setVisibility(View.INVISIBLE);
//                tvError.setVisibility(View.VISIBLE);
//            }
//            else{
//                jsonText.setVisibility(View.VISIBLE);
//                tvError.setVisibility(View.INVISIBLE);
//            }
//            ArrayList<Learningleaders> leaders= ApiUtil.getLearningLeadersFromJson(result);
//            String leadersResult = "";
//            for(Learningleaders leader: leaders){
//                leadersResult= leadersResult+leader.name+"\n"+leader.country+"\n"+leader.hours+"\n\n";
//            }
//            jsonText.setText(leadersResult);
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            mpgBar.setVisibility(View.VISIBLE);
//        }
//    }

}






//    initilizeDisplayContent();
//}
//    public void initilizeDisplayContent() {
//
//        final RecyclerView recyclerLeader = (RecyclerView) findViewById(R.id.recycler_leader);
//        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
//        recyclerLeader.setLayoutManager(notesLayoutManager);
//
//        List<Learningleaders> learningleadersList = ApiUtil.getLeaders();
//        LearningLeadersRecyclerAdapter recycleradapter = new LearningLeadersRecyclerAdapter(this,learningleadersList);
//        recyclerLeader.setAdapter(recycleradapter);
//    }