package com.project.myapplication.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.myapplication.R
import com.project.myapplication.adapter.DashboardRecyclerAdapter
import com.project.myapplication.adapter.FavouritesRecyclerAdapter
import com.project.myapplication.model.Food

class FavouritesFragment : Fragment() {
    lateinit var recyclerfavourites: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager


    val foodList= arrayListOf("Butter Naan",
        "Roti","pulka","Biryani","Fired rice",
        "Kaju curry","paneer Butter Masala",
        "Veg salad","Apollo Fish","pizza")
    lateinit var recyclerAdapter: FavouritesRecyclerAdapter
    val foodInfoList= arrayListOf<Food>(
        Food(
            "Butter Naan",
            "Rs.40",
            "4/5",
            R.drawable.butter_naan,
            4.0
        ),

        Food(
            "Pulka",
            "Rs.10",
            "4.5/5",
            R.drawable.pulka,
            4.5
        ),
        Food(
            "Biryani",
            "Rs.250",
            "4.5/5",
            R.drawable.biryani,
            4.5
        ),
        Food(
            "Fired rice",
            "Rs.180",
            "4/5",
            R.drawable.fired_rice,
            4.0
        ),
        Food(
            "Kaju curry",
            "Rs.180",
            "4.5/5",
            R.drawable.kaju_curry,
            4.5
        ),
        Food(
            "Veg salad",
            "Rs.210",
            "4/5",
            R.drawable.veg_salad,
            4.0
        ),
        Food(
            "Apollo Fish",
            "Rs.250",
            "4.5/5",
            R.drawable.apolo_fish,
            4.5
        ),
        Food(
            "Pizza",
            "Rs.450",
            "4.5/5",
            R.drawable.pizza,
            4.5
        ),
        Food(
            "Roti",
            "Rs.20",
            "4.5/5",
            R.drawable.rotti,
            4.5
        ),
        Food(
            "Kadai Paneer",
            "Rs.200",
            "4/5",
            R.drawable.paneer_butter,
            4.0
        )
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_favourites, container, false)
        recyclerfavourites=view.findViewById(R.id.recyclerfavourites)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter=
            FavouritesRecyclerAdapter(
                activity as Context,
                foodInfoList
            )
        recyclerfavourites.adapter=recyclerAdapter
        recyclerfavourites.layoutManager=layoutManager
        recyclerfavourites.addItemDecoration(
            DividerItemDecoration(recyclerfavourites.context,
                (layoutManager as LinearLayoutManager).orientation)
        )
        return view
    }

}

