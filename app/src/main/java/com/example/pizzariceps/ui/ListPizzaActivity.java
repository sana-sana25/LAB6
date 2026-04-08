package com.example.pizzariceps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pizzariceps.R;
import com.example.pizzariceps.adapter.PizzaAdapter;
import com.example.pizzariceps.classes.Produit;
import com.example.pizzariceps.service.ProduitService;

import java.util.List;

public class ListPizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_list_pizza);

        // LISTVIEW
        ListView lv = findViewById(R.id.lvPizzas);
        List<Produit> pizzas = ProduitService.getInstance().findAll();

        lv.setAdapter(new PizzaAdapter(this, pizzas));


        lv.setOnItemClickListener((parent, view, pos, id) -> {
            Intent i = new Intent(this, PizzaDetailActivity.class);
            i.putExtra("pizza_id", id);
            startActivity(i);
        });

        //  BOUTON SHARE POUR QUITTER L'APP
        ImageView btnShare = findViewById(R.id.btnShare);

        btnShare.setOnClickListener(v -> {
            finishAffinity(); // ferme toute l'application
        });
    }
}