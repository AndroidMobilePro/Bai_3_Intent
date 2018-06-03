package proteam.com.bai_3_intent.intent_bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import proteam.com.bai_3_intent.R;

public class MainActivity2 extends AppCompatActivity {
    private Button mBtnSend;
    private TextView mTvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBtnSend = (Button) findViewById(R.id.btnSendResult);
        mTvData = (TextView) findViewById(R.id.tvData);

        //get data from bundle
        Bundle bundle = getIntent().getExtras();
        mTvData.setText(bundle.getString("key1", ""));

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("result", "100");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
