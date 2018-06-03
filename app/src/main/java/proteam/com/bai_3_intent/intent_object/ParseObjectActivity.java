package proteam.com.bai_3_intent.intent_object;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import proteam.com.bai_3_intent.R;
import proteam.com.bai_3_intent.models.UserPacer;
import proteam.com.bai_3_intent.models.UserSeriable;

public class ParseObjectActivity extends AppCompatActivity {

    private static final int REQUEST_ID = 100;

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
                Intent intent = new Intent(ParseObjectActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                UserPacer userPacer = new UserPacer("Android", "12345");
                UserSeriable userSeriable = new UserSeriable("iOS", "bcd");
                bundle.putParcelable("pac", userPacer);
                bundle.putSerializable("ser", userSeriable);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        mBtnStartIntentForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParseObjectActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                UserPacer userPacer = new UserPacer("Android", "12345");
                UserSeriable userSeriable = new UserSeriable("iOS", "bcd");
                bundle.putParcelable("pac", userPacer);
                bundle.putSerializable("ser", userSeriable);
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_ID);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data.getStringExtra("result");
        mtvResult.setText("request_code: " + requestCode + "-- result_code: " + resultCode + "--result: " + result);
    }
}
