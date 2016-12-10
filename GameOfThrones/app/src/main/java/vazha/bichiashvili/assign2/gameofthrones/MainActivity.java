package vazha.bichiashvili.assign2.gameofthrones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import vazha.bichiashvili.assign2.gameofthrones.adapters.CustomDragonGlassAdapter;
import vazha.bichiashvili.assign2.gameofthrones.model.GameOfThroneCharacter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<GameOfThroneCharacter> listViewData = getGameOfThroneData();
        CustomDragonGlassAdapter adapter = new CustomDragonGlassAdapter(this, listViewData);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("GameOfThroneCharacter", (GameOfThroneCharacter)adapterView.getAdapter().getItem(i));
                startActivity(intent);
            }
        });
    }

    private ArrayList<GameOfThroneCharacter> getGameOfThroneData() {
        ArrayList<GameOfThroneCharacter> list = new ArrayList<>();

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < WInterIsComing.names.length; i++) {
                GameOfThroneCharacter person = new GameOfThroneCharacter(WInterIsComing.names[i], WInterIsComing.descriptions[i], WInterIsComing.images[i]);
                list.add(person);
            }
        }
        return list;
    }
}
