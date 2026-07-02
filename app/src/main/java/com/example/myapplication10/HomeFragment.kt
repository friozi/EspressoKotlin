package com.example.myapplication10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication10.databinding.FragmentHomeBinding
import com.example.myapplication10.databinding.ItemCategoryBinding
import com.example.myapplication10.databinding.ItemStayBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCategories()
        setupStays()
    }

    private fun setupCategories() {
        val categories = listOf(
            Category("Icons", android.R.drawable.btn_star_big_on),
            Category("Beachfront", android.R.drawable.ic_menu_compass),
            Category("Amazing pools", android.R.drawable.ic_menu_gallery),
            Category("Cabins", android.R.drawable.ic_menu_directions),
            Category("Design", android.R.drawable.ic_menu_manage),
            Category("Farms", android.R.drawable.ic_menu_myplaces)
        )

        binding.rvCategories.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = CategoryAdapter(categories)
    }

    private fun setupStays() {
        val stays = listOf(
            Stay("Guarda do Embaú, Brazil", "4.92", "637 kilometers away", "Sep 15 - 20", "R$ 450"),
            Stay("Florianópolis, Brazil", "4.88", "720 kilometers away", "Oct 10 - 15", "R$ 600"),
            Stay("Ubatuba, Brazil", "4.95", "250 kilometers away", "Nov 01 - 06", "R$ 350"),
            Stay("Paraty, Brazil", "4.90", "300 kilometers away", "Dec 20 - 27", "R$ 800")
        )

        binding.rvStays.layoutManager = LinearLayoutManager(context)
        binding.rvStays.adapter = StayAdapter(stays)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    data class Category(val name: String, val icon: Int)
    data class Stay(val location: String, val rating: String, val distance: String, val date: String, val price: String)

    inner class CategoryAdapter(private val items: List<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
        inner class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.tvCategoryName.text = items[position].name
            holder.binding.ivCategoryIcon.setImageResource(items[position].icon)
        }
        override fun getItemCount() = items.size
    }

    inner class StayAdapter(private val items: List<Stay>) : RecyclerView.Adapter<StayAdapter.ViewHolder>() {
        inner class ViewHolder(val binding: ItemStayBinding) : RecyclerView.ViewHolder(binding.root)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(ItemStayBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            holder.binding.tvLocation.text = item.location
            holder.binding.tvRating.text = item.rating
            holder.binding.tvDistance.text = item.distance
            holder.binding.tvDate.text = item.date
            holder.binding.tvPrice.text = item.price
        }
        override fun getItemCount() = items.size
    }
}