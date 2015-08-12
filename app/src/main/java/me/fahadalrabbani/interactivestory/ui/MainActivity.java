package me.fahadalrabbani.interactivestory.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import me.fahadalrabbani.interactivestory.R;

public class MainActivity extends AppCompatActivity {

    private EditText mNameField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mName = mNameField.getText().toString();
                startStory(mName);
            }
        });
    }

    private void startStory(String name) {
        Intent mIntent = new Intent(this,StoryActivity.class);
        mIntent.putExtra(getString(R.string.key_name),name);
        startActivity(mIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");
    }
}