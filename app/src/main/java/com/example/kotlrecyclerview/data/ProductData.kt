package com.example.kotlrecyclerview.data

import com.example.R

class ProductData {

    fun allProducts(): List<FoodItem> {

        return listOf(
            FoodItem("AGM", "Ayam Mentega", 12.321, "Ayam Saus Mentega yang enak dan mudah untuk dibuat.", R.drawable.ayam_goreng_mentega),
            FoodItem("SRC", "Sushi Roll", 15.321, "Sushi Roll Crispy ini memiliki tekstur unik.", R.drawable.sushi_roll_crispy, true),
            FoodItem("CCK", "Salad", 20.321, "Salad ini merupakan salad yang disajikan dengan segar karena menggunakan bahan yang fresh.", R.drawable.fresh_salad),
            FoodItem("FFS", "French Fries", 18.321, "Kentang Goreng yang disajikan dengan sosis, serta tidak lupa juga untuk dimakan dengan saus!", R.drawable.french_fries_sausage),
            FoodItem("KW", "Kwetiau", 25.321, "Kwetiau ini disajikan dengan bahan pelengkap yang super komplet, seperti telur, sayuran, sosis dan bakso, makanan ini dijamin mengenyangkan!", R.drawable.kwetiau),
            FoodItem("LS", "Lasagna", 30.321, "Makanan tradisional Italia ini berbentuk hidangan pasta yang dimasak menggunakan oven dan diisi dengan banyak isian seperti daging, dsb.", R.drawable.lasagna),
            FoodItem("PK", "Pizza Keju", 40.321, "Makanan yang berbentuk lingkaran ini juga merupakan khas tradisional Italia yang dimasak menggunakan oven dengan topping keju mozarella yang menyelimuti daging salami", R.drawable.pizza_keju, true)
        )
    }
}