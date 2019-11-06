package com.domain.drapps.appstore.shared.entities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.domain.drapps.appstore.shared.enums.EnumAppLayoutType
import com.domain.drapps.appstore.R

class AppObjectAdapter(
    val context: Context,
    val layoutType: EnumAppLayoutType
) : RecyclerView.Adapter<AppObjectAdapter.ViewHolder>() {
    val adapterList = ArrayList<AppObject>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (layoutType == EnumAppLayoutType.COMMON_APP) {
            ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.row_app_object,
                    parent,
                    false
                )
            )
        } else {
            ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.row_top_app_object,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = adapterList[position].name

        holder.tvRating.text = adapterList[position].rating
        if (layoutType == EnumAppLayoutType.COMMON_APP) {
            Glide.with(context).load(adapterList[position].icon)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(15)))
                .into(holder.ivLogo)
        } else {
            Glide.with(context).load(adapterList[position].graphic)
                .centerCrop()
                .apply(RequestOptions.bitmapTransform(RoundedCorners(15)))
                .into(holder.ivLogo)
        }
    }

    fun swapContent(updatedList: List<AppObject>) {
        adapterList.clear()
        for (appObject in updatedList) {
            if (layoutType != EnumAppLayoutType.TOP_APP || !appObject.graphic.isEmpty()) {
                adapterList.add(appObject)
            } else if (layoutType == EnumAppLayoutType.COMMON_APP) {
                adapterList.add(appObject)
            }
        }
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<AppCompatTextView>(R.id.tvName)
        val ivLogo = itemView.findViewById<ImageView>(R.id.ivLogo)
        val tvRating = itemView.findViewById<AppCompatTextView>(R.id.tvRating)
    }
}
