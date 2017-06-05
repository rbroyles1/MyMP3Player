package com.example.rxbro.mymp3player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button startButton;
    Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.start_button);
        startButton.setOnClickListener(this);
        stopButton = (Button)findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);
    }
    private Intent getServiceIntent() {
        return new Intent(getBaseContext(), PlayMusic.class);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button:
                PlayService();
                break;
            case R.id.stop_button:
                StopService();
                break;
            default:
                return;
        }
    }
    private void StopService() {
        Intent intent = getServiceIntent();
        Bundle bundle = new Bundle();
        bundle.putString(PlayMusic.MESSAGE_KEY, PlayMusic.STOP);
        intent.putExtras(bundle);
        startService(intent);
    }
    private void PlayService() {
        Intent intent = new Intent(getBaseContext(), PlayMusic.class);
        Bundle bundle = new Bundle();
        bundle.putString(PlayMusic.MESSAGE_KEY, PlayMusic.PLAY);
        intent.putExtras(bundle);
        startService(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
