package com.aryasurya.restaurantreview.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aryasurya.restaurantreview.core.R
import com.aryasurya.restaurantreview.core.databinding.ItemListTourismBinding
import com.aryasurya.restaurantreview.core.domain.model.Restaurant
import com.bumptech.glide.Glide


class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.ListViewHolder>() {

  private var listData = ArrayList<Restaurant>()
  var onItemClick: ((Restaurant) -> Unit)? = null

  @SuppressLint("NotifyDataSetChanged")
  fun setData(newListData: List<Restaurant>?) {
    if (newListData == null) return
    listData.clear()
    listData.addAll(newListData)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_tourism, parent, false))

  override fun getItemCount() = listData.size

  override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
    val data = listData[position]
    holder.bind(data)
  }

  inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemListTourismBinding.bind(itemView)
    fun bind(data: Restaurant) {
      with(binding) {
        Glide.with(itemView.context)
          .load("https://restaurant-api.dicoding.dev/images/medium/"+data.pictureId)
          .into(ivItemImage)
        tvItemTitle.text = data.name
        tvItemSubtitle.text = data.city
      }
    }

    init {
      binding.root.setOnClickListener {
        onItemClick?.invoke(listData[absoluteAdapterPosition])
      }
    }
  }
}