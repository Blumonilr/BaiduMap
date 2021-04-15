package nju.edu.iot.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nju.iot.map.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText networkPathEditText;
    private Spinner networkTypeSpinner;
    private Button startButton;
    private String networkType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkPathEditText = findViewById(R.id.network_path_input);
        networkTypeSpinner = findViewById(R.id.network_type_spinner);
        startButton = findViewById(R.id.start_button);

        networkTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                networkType = getResources().getStringArray(R.array.network_types)[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        startButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "start Map!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MapActivity.class);
        String networkPath = networkPathEditText.getText().toString();
        intent.putExtra("NETWORK_PATH", networkPath);
        intent.putExtra("NETWORK_TYPE", networkType);
        startActivity(intent);
    }
}
