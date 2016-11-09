package facitec.edu.py.op2francisco_amaral;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ServicioAdapter extends BaseAdapter {
    private List<Servicio> servicios;
    private Context context;

    public ServicioAdapter(List<Servicio> servicios, Context context) {
        this.servicios = servicios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return servicios.size();
    }

    @Override
    public Object getItem(int position) {
        return servicios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return servicios.get(position).getUid();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v =convertView;
        if (v==null){
            LayoutInflater inf =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.servicio_layou,null);

            TextView username = (TextView) v.findViewById(R.id.textViewUsername);
            TextView texto = (TextView) v.findViewById(R.id.textViewTexto);
            ImageView avatar = (ImageView) v.findViewById(R.id.imageViewAvatar);

            Servicio servicio = servicios.get(position);
            username.setText(servicio.getUsername());
            texto.setText(servicio.getText());
            Picasso.with(context).load("http://servidor-monkydevs.rhcloud.com/"+servicio.getAvatar()).error(R.mipmap.ic_launcher).resize(100, 100).into(avatar);

        }
        return v;
    }

}
