package gurmeet.example.com.telljokesandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_jokes);

        Intent intent = getIntent();
        String current_joke = intent.getStringExtra("current_joke");
        TextView jokeTextView = (TextView) findViewById(R.id.textview_joke);
        jokeTextView.setText(current_joke);
    }
}
