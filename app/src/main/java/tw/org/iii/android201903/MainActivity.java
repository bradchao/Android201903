package tw.org.iii.android201903;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private String createAnswer(int dig){
        HashSet<Integer> set = new HashSet<>();
        while (set.size()<dig){
            set.add((int)(Math.random()*10));
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (Integer temp : set){
            list.add(temp);
        }
        Collections.shuffle(list);

        StringBuffer sb = new StringBuffer();
        for (Integer temp : list){
            sb.append(temp);
        }

        return sb.toString();
    }

    public void guess(View view) {
        answer = createAnswer(3);
        Log.v("brad", answer);
    }
}
