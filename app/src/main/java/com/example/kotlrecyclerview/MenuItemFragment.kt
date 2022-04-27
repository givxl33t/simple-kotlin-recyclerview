package com.example.kotlrecyclerview

import android.app.ActionBar
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.databinding.FragmentMenuItemBinding
import com.example.kotlrecyclerview.data.ProductData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_menu_item.*

class MenuItemFragment : Fragment() {

    private var _fragmentMenuItem: FragmentMenuItemBinding? = null

    private val fragmentMenuItem get() = _fragmentMenuItem!!

    private val args: MenuItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = activity as? MainActivity
        activity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)
        _fragmentMenuItem = FragmentMenuItemBinding.inflate(inflater, container, false)
        val view = fragmentMenuItem.root
        return view
    }

    override fun onDestroyView() {
        val activity = activity as? MainActivity
        activity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        setHasOptionsMenu(false)
        super.onDestroyView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val activity = activity as? MainActivity
        when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productCode = args.productCodeArgument

        val product = ProductData().allProducts().find { it.productCode == productCode }

        if (product != null) {

            productTitle.text = product.name
            productInfoDescription.text = product.description
            productPrice.text = "Rp ${product.price}"
            productPhotoMain.setImageDrawable(
                ContextCompat.getDrawable(
                    requireActivity(),
                    product.photo
                )
            )

            addToCartButton.setOnClickListener {
                Toast.makeText(context, "Ditambahkan ke keranjang!", Toast.LENGTH_SHORT).show()
            }

        }

    }
}
