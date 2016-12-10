package vazha.bichiashvili.assign2.gameofthrones.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vazha.bichiashvili.assign2.gameofthrones.R;
import vazha.bichiashvili.assign2.gameofthrones.model.GameOfThroneCharacter;

public class CustomDragonGlassAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<GameOfThroneCharacter> listData;
    private LayoutInflater inflater;

    public CustomDragonGlassAdapter(Context conetxt, ArrayList<GameOfThroneCharacter> data) {
        this.context = conetxt;
        this.listData = data;
        this.inflater = (LayoutInflater) conetxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.listData.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View itemView;
        ViewHolder viewHolder;

        if (convertView == null) {
            itemView = View.inflate(context, R.layout.listview_item, null);
            viewHolder = new ViewHolder();

            ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
            TextView nameView = (TextView) itemView.findViewById(R.id.name);

            viewHolder.imageView = imageView;
            viewHolder.nameView = nameView;

            itemView.setTag(viewHolder);
        } else {
            itemView = convertView;
            viewHolder = (ViewHolder) itemView.getTag();
        }

        GameOfThroneCharacter johnSnow = (GameOfThroneCharacter) getItem(i);
        viewHolder.nameView.setText(johnSnow.getName());

        Picasso.with(context)
                .load(johnSnow.getImage())
                .resize(200, 200)
                .centerCrop()
                .into(viewHolder.imageView);
        return itemView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView nameView;
    }
}
