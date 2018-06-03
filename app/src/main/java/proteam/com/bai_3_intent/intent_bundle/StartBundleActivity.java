package proteam.com.bai_3_intent.intent_bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import proteam.com.bai_3_intent.R;

public class StartBundleActivity extends AppCompatActivity {

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
                Intent intent = new Intent(StartBundleActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("key1", "test key 1");
                bundle.putString("key2", "test key 2");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mBtnStartIntentForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartBundleActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("key1", "test data");
                intent.putExtras(bundle);
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
