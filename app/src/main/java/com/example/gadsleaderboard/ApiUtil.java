package com.example.gadsleaderboard;

import android.net.Uri;
import android.renderscript.Sampler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class ApiUtil {

    private static ArrayList<Learningleaders> mIqleaders;

    public ApiUtil() {
    }

    public static final String BASE_API_URL = "https://gadsapi.herokuapp.com";
    public static final String queryKey = null;

    public static URL buildUrl(String title) {
//     String full_url=BASE_API_URL + title;
        URL url = null;
        Uri uri = Uri.parse(BASE_API_URL).buildUpon().appendEncodedPath(title).build();
        try {
            url = new URL(uri.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getJSON(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            InputStream stream = connection.getInputStream();
            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\\A");
            boolean urlHasData = scanner.hasNext();
            if (urlHasData) {
                return scanner.next();
            } else {
                return null;
            }
        } catch (Exception e) {
            Log.d("Error", e.toString());
            return null;
        } finally {
            connection.disconnect();
        }
    }

  public static ArrayList<Learningleaders> getLearningLeadersFromJson(String json) {
        final String name = "name";
        final int hours = 0;
        final String country = "country";
        final String badgeUrl = "badgeurl";
        JSONArray jsonArray = null;
      mIqleaders = new ArrayList<Learningleaders>();

        try {

//           JSONArray jsonLeaders = (JSONArray) JSONObject(json);
////            JSONObject jsonLeaders = new JSONObject(json);
            jsonArray = new JSONArray(json);

            int numberOfleaders = jsonArray.length();
           for (int i = 0; i < numberOfleaders; i++) {
                JSONObject leaderJson = jsonArray.getJSONObject(i);
               Learningleaders learningleader = new Learningleaders(leaderJson.getString("name"),
                leaderJson.getInt("hours"),
                        leaderJson.getString("country"),
                       leaderJson.getString("badgeUrl"));
                mIqleaders.add(learningleader);
            }

        } catch (JSONException e) {
           e.printStackTrace();
        }
        return mIqleaders;

//           JSONArray arrayLeaders = jsonLeaders.getJSONObject("name");
//          int numberOfleaders= arrayLeaders.length();
//       for(int i=0;i<numberOfleaders;i++){
//               JSONObject leaderJson = arrayLeaders.getJSONObject(i);
//      Learningleaders learningleader = new Learningleaders(leaderJson.getString(NAME),
//                       leaderJson.getInt(String.valueOf(HOURS)),
//                       leaderJson.getString(COUNTRY),
//                       leaderJson.getString(BADGEURL));
//               leaders.add(learningleader);
//           }
//       }
//       catch (JSONException e){
//           e.printStackTrace();
//       }
//       return leaders;
  }
    public static ArrayList<Learningleaders> getLeaders() {
        ArrayList<Learningleaders> learningleaders = new ArrayList<>();
        for(Learningleaders leader:mIqleaders) {

                learningleaders.add(leader);
        }
        return learningleaders;
    }
//
//    }
}
