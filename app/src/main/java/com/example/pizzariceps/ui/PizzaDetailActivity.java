package com.example.pizzariceps.ui;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pizzariceps.R;
import com.example.pizzariceps.classes.Produit;
import com.example.pizzariceps.service.ProduitService;

public class PizzaDetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_pizza_detail);

        long id = getIntent().getLongExtra("pizza_id", -1);
        Produit p = ProduitService.getInstance().findById(id);

        ImageView img = findViewById(R.id.img);
        TextView title = findViewById(R.id.title);
        TextView meta = findViewById(R.id.meta);
        TextView ingredients = findViewById(R.id.ingredients);
        TextView desc = findViewById(R.id.desc);
        TextView steps = findViewById(R.id.steps);

        if (p != null) {
            img.setImageResource(p.getImageRes());
            title.setText(p.getNom());
            meta.setText(p.getDuree() + " • " + p.getPrix() + " €");
            ingredients.setText(p.getIngredients());
            desc.setText(p.getDescription());
            steps.setText(p.getEtapes());
        }
    }
}