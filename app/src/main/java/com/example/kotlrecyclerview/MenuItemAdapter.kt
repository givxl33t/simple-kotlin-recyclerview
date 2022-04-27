package com.example.kotlrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.databinding.MenuItemRowBinding
import com.example.kotlrecyclerview.data.FoodItem
import kotlinx.android.synthetic.main.menu_item_row.view.*

class MenuItemAdapter(private val foodItems: List<FoodItem>) : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>(){


    class ViewHolder(val binding: MenuItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(foodItem: FoodItem) {
            binding.foodItemTitle.text = foodItem.name
            binding.foodPrice.text = "Harga: Rp ${foodItem.price}"
            binding.mainPhoto.setImageResource(foodItem.photo)
            if (foodItem.isHighlyRated) {
                itemView.highlyRatedIcon.visibility = View.VISIBLE
            }

            binding.buttonFirst.setOnClickListener {
                Toast.makeText(itemView.context, "Ditambahkan ke keranjang!", Toast.LENGTH_SHORT).show()
            }

            binding.mainPhoto.setOnClickListener {
                val action = MainFragmentDirections.actionFirstFragmentToProductInfo(foodItem.productCode)
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = MenuItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = foodItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodItem = foodItems[position]
        holder.bind(foodItem)
    }

}
