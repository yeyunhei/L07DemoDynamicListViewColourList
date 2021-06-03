package sg.edu.rp.c346.id20011806.l07demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    ArrayList<String> alColours;
    EditText etIndexElement;
    Button btnRemove;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);

        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if (pos <= alColours.size()) {
                alColours.add(pos, etElement.getText().toString());
                aaColour.notifyDataSetChanged();
                } else {
                    Toast invalid = Toast.makeText(getApplicationContext(), "Invalid position", Toast.LENGTH_SHORT);
                    invalid.show();
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast toast = Toast.makeText(getApplicationContext(), colour, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if (pos < alColours.size()) {
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
                }else {
                    Toast invalid = Toast.makeText(getApplicationContext(), "Invalid position", Toast.LENGTH_SHORT);
                    invalid.show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if (pos < alColours.size()) {
                String newColour = etElement.getText().toString();
                alColours.set(pos, newColour);
                aaColour.notifyDataSetChanged();
                }else {
                    Toast invalid = Toast.makeText(getApplicationContext(), "Invalid position", Toast.LENGTH_SHORT);
                    invalid.show();
                }
            }
        });
    }
}