package com.example.kotlrecyclerview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlrecyclerview.data.ProductData
import com.example.databinding.FragmentFirstBinding
import kotlinx.android.synthetic.main.fragment_first.*

class MainFragment : Fragment() {

    private var _fragmentFirst: FragmentFirstBinding? = null
    //This property is only valid between onCreateView and
    //onDestroyView.
    private val fragmentFirst get() = _fragmentFirst!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFirst = FragmentFirstBinding.inflate(inflater, container, false)
        val view = fragmentFirst.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodItems = ProductData().allProducts()

        restaurantsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MenuItemAdapter(foodItems)
        }

        val textViewText = requireActivity().getSharedPreferences("shopping_cart", Context.MODE_PRIVATE)
            .getString("cart_latest_item", "default value")

    }
}
