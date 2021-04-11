package ro.pub.cs.systems.eim.practicaltest01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01MainActivity extends AppCompatActivity {

    private EditText leftEditText;
    private EditText rightEditText;
    private Button PressMeButton;
    private Button PressMeTooButton;
    private Button NavigateToSecondaryActivityButton;

    private  ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener{

        int LeftNumberOfClicks = Integer.valueOf(leftEditText.getText().toString());
        int RightNumberOfClicks = Integer.valueOf(rightEditText.getText().toString());

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.press_me_button:
                    LeftNumberOfClicks++;
                    leftEditText.setText(String.valueOf(LeftNumberOfClicks));
                    break;
                case R.id.press_me_too_button:
                    RightNumberOfClicks++;
                    rightEditText.setText(String.valueOf(RightNumberOfClicks));
                    break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftEditText = (EditText)findViewById(R.id.left_edit_text);
        rightEditText = (EditText)findViewById(R.id.right_edit_text);
        PressMeButton = (Button)findViewById(R.id.press_me_button);
        PressMeTooButton = (Button)findViewById(R.id.press_me_too_button);

        PressMeButton.setOnClickListener(buttonClickListener);
        PressMeTooButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null){
            if(savedInstanceState.containsKey(Constants.LEFT_COUNT)){
                leftEditText.setText(savedInstanceState.getString(Constants.LEFT_COUNT));
            } else {
                leftEditText.setText(String.valueOf(0));
            }
            if(savedInstanceState.containsKey(Constants.RIGHT_COUNT)){
                rightEditText.setText(savedInstanceState.getString((Constants.RIGHT_COUNT)));
            } else {
                rightEditText.setText(String.valueOf(0));
            }
        } else {
            leftEditText.setText(String.valueOf(0));
            rightEditText.setText(String.valueOf(0));
        }
    }
}