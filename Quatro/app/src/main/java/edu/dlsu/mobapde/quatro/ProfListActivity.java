package edu.dlsu.mobapde.quatro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ProfListActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<Prof> profList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_list);

        rv = (RecyclerView) findViewById(R.id.profListFeed);

        initList();

        ProfListAdapter pa = new ProfListAdapter(profList);

        pa.setmOnItemClickListener(new ProfListAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Prof prof){
                // TODO: intent to go to prof page
            }
        });
    }

    public void initList(){
        profList = new ArrayList<>();

        profList.add(new Prof("Jordan Deja", "ST", 4.5f, 3.0f, 41));
        profList.add(new Prof("Solomon Sy", "ST", 3.0f, 2.0f, 36));
        profList.add(new Prof("Roger Uy", "ST", 5.0f, 2.5f, 62));

    }
}
