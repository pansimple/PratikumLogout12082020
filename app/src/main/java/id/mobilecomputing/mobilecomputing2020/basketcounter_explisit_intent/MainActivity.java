package id.mobilecomputing.mobilecomputing2020.basketcounter_explisit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import id.mobilecomputing.mobilecomputing2020.R;
import id.mobilecomputing.mobilecomputing2020.auth.PrefManager;
import id.mobilecomputing.mobilecomputing2020.auth.SimpleLoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefManager.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(), SimpleLoginActivity.class));
                finish();
            }
        });

    }

    public void inputName(View view){
        EditText nameTimA = findViewById(R.id.edt_name_tim_a);
        EditText nameTimB = findViewById(R.id.edt_name_tim_b);

        String getNameTimA = nameTimA.getText().toString();
        String getNameTimB = nameTimB.getText().toString();

        Intent dataName = new Intent(this, CounterActivity.class);
        dataName.putExtra("TIM A", getNameTimA);
        dataName.putExtra("TIM B", getNameTimB);
        startActivity(dataName);
    }
}
