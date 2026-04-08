package com.example.pizzariceps.adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;
import com.example.pizzariceps.R;
import com.example.pizzariceps.classes.Produit;
import java.util.List;

public class PizzaAdapter extends BaseAdapter {

    private Context ctx;
    private List<Produit> pizzas;

    public PizzaAdapter(Context ctx, List<Produit> pizzas) {
        this.ctx = ctx;
        this.pizzas = pizzas;
    }

    public int getCount() { return pizzas.size(); }
    public Object getItem(int i) { return pizzas.get(i); }
    public long getItemId(int i) { return pizzas.get(i).getId(); }

    public View getView(int pos, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(ctx)
                    .inflate(R.layout.row_pizza, parent, false);

        ImageView img = convertView.findViewById(R.id.imgPizza);
        TextView tvNom = convertView.findViewById(R.id.tvNom);
        TextView tvPrix = convertView.findViewById(R.id.tvPrix);
        TextView tvDuree = convertView.findViewById(R.id.tvDuree);

        Produit p = pizzas.get(pos);

        img.setImageResource(p.getImageRes());
        tvNom.setText(p.getNom());


        tvPrix.setText(String.format("%.2f $", p.getPrix()));

        tvDuree.setText(p.getDuree());

        return convertView;
    }
}
