package com.project.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.myapplication.R
import com.project.myapplication.model.Food

class FavouritesRecyclerAdapter(val context: Context, val itemList:ArrayList<Food>) : RecyclerView.Adapter<FavouritesRecyclerAdapter.FavouritesViewHolder>(){

    class FavouritesViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtFoodName: TextView =view.findViewById(R.id.txtRecyclerRowItem)
        val txtFoodPrice: TextView =view.findViewById(R.id.txtFoodCost)
        val txtFoodRating: RatingBar =view.findViewById(R.id.FoodRating)
        val txtRating: TextView =view.findViewById(R.id.txtFRating)
        val imgFoodImage: ImageView =view.findViewById(R.id.imgFoodImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_fav,parent,false)
        return FavouritesViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        val food=itemList[position]
        holder.txtFoodName.text=food.foodName
        holder.txtFoodPrice.text=food.foodCost
        holder.txtRating.text=food.foodRating
        holder.imgFoodImage.setImageResource(food.foodImage)
        holder. txtFoodRating.setOnRatingBarChangeListener(RatingBar.OnRatingBarChangeListener { ratingBar, rating, fromUser ->
            holder.txtRating.setText("$rating/5")
        })
    }
}