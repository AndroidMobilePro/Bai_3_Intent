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

public class MainActivity2 extends AppCompatActivity {
    private Button mBtnSend;
    private TextView mtvSerializable;
    private TextView mtvParcelable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);

        mBtnSend = (Button) findViewById(R.id.btnSendResult);
        mtvParcelable = (TextView) findViewById(R.id.tvParcel);
        mtvSerializable = (TextView) findViewById(R.id.tvSerializable);

        //get data from bundle
        Bundle bundle = getIntent().getExtras();
        UserPacer userPacer = bundle.getParcelable("pac");
        mtvParcelable.setText(userPacer.getmName());

        UserSeriable userSeriable = (UserSeriable) bundle.getSerializable("ser");
        mtvSerializable.setText(userSeriable.getmName());


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
