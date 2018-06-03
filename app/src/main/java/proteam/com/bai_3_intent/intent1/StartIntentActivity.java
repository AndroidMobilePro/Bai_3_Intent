package proteam.com.bai_3_intent.intent1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import proteam.com.bai_3_intent.R;

public class StartIntentActivity extends AppCompatActivity {
    private static final int REQUEST_ID =  100;

    private Button mBtnStartIntent;
    private Button mBtnStartIntentForResult;
    private TextView mtvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mBtnStartIntent = (Button) findViewById(R.id.btnIntentStart);
        mBtnStartIntentForResult = (Button) findViewById(R.id.btnIntentStartForResult);
        mtvResult = (TextView) findViewById(R.id.tvResult);
        mBtnStartIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartIntentActivity.this, MainActivity2.class);
                intent.putExtra("key1", "test data");
                startActivity(intent);
            }
        });

        mBtnStartIntentForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartIntentActivity.this, MainActivity2.class);
                intent.putExtra("key1", "test data");
                startActivityForResult(intent, REQUEST_ID);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data.getStringExtra("result");
        mtvResult.setText("request_code: " + requestCode + "-- result_code: " + resultCode + "--result: " +result);
    }
}
