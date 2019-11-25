package tw.org.iii.android201903;

import androidx.appcompat.app.AlertDialog;
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
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        log = findViewById(R.id.log);
        answer = createAnswer(3);
        Log.v("brad", answer);
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

    private String checkAB(String g){
        int a, b; a = b =0;

        for (int i=0; i<answer.length(); i++){
            if (g.charAt(i) == answer.charAt(i)){
                a++;
            }else if(answer.indexOf(g.charAt(i)) != -1){
                b++;
            }
        }

        return a + "A" + b + "B";
    }

    public void guess(View view) {
        counter++;
        String strInput = input.getText().toString();

        String result = checkAB(strInput);
        log.append(counter + ". " + strInput + " => " + result + "\n");
        input.setText("");

        if (result.equals("3A0B")){
            // WINNER
            showDialog();
        }else if (counter == 10){
            // LOSER
        }
    }

    private void showDialog(){
        AlertDialog alertDialog = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Title");
        builder.setMessage("xxxx");
        alertDialog = builder.create();
        alertDialog.show();
    }
}
