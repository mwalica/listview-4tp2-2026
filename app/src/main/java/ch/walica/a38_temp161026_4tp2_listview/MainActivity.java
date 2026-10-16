package ch.walica.a38_temp161026_4tp2_listview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.LongDef;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import ch.walica.a38_temp161026_4tp2_listview.model.Person;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Integer> numbers = new ArrayList<>();
    private List<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);

        for (int i = 0; i < 100; i++) {
            numbers.add(ThreadLocalRandom.current().nextInt(1, 1000));
        }

        people.add(new Person("Jan"));
        people.add(new Person("Konrad"));
        people.add(new Person("Kasia"));
        people.add(new Person("Zosia"));
        people.add(new Person("Karol"));
        people.add(new Person("Gustaw"));
        people.add(new Person("Weronika"));
        people.add(new Person("Lucjan"));

        //ArrayAdapter<Integer> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, numbers);
        //ArrayAdapter<Integer> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_item, numbers);
        ArrayAdapter<Person> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.list_item, people);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.d("my_log", "onItemClick: " + l);
//                Toast.makeText(MainActivity.this, "Wybrano: " + numbers.get(i), Toast.LENGTH_SHORT).show();
                Person person = people.get(i);
                Toast.makeText(MainActivity.this, person.getName() + " " + person.getAge(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}