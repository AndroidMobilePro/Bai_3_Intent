package proteam.com.bai_3_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import proteam.com.bai_3_intent.intent1.StartIntentActivity;
import proteam.com.bai_3_intent.intent_bundle.StartBundleActivity;
import proteam.com.bai_3_intent.intent_object.ParseObjectActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnIntentStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StartIntentActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btnBundleStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StartBundleActivity.class));
            }
        });
        findViewById(R.id.btnParseObject).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ParseObjectActivity.class));
            }
        });

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
