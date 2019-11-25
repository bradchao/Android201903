package tw.org.iii.android201903;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private String answer;
    private EditText input;
    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        log = findViewById(R.id.log);
        answer = createAnswer(3);

    }

    private String createAnswer(){
        return  createAnswer(3);
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
        String strInput = input.getText().toString();

        log.append(strInput + " => " + "1A1B\n");
        input.setText("");

    }
}
