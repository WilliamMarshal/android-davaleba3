package vazha.bichiashvili.assign2.gameofthrones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import vazha.bichiashvili.assign2.gameofthrones.model.GameOfThroneCharacter;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        GameOfThroneCharacter johnSnow = (GameOfThroneCharacter) getIntent().getExtras().getSerializable("GameOfThroneCharacter");

        TextView nameView = (TextView) findViewById(R.id.name);
        TextView descriptionView = (TextView) findViewById(R.id.description);
        ImageView imgeView = (ImageView) findViewById(R.id.image);

        nameView.setText(johnSnow.getName());
        descriptionView.setText(johnSnow.getDescription());

        Picasso.with(this)
                .load(johnSnow.getImage())
                .resize(400, 400)
                .centerCrop()
                .into(imgeView);

    }
}