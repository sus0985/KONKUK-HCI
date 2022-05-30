package com.hci.obtt.ui.tab.home.bottom_menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.hci.obtt.R
import com.hci.obtt.model.ShareData

class ShareRecyclerViewAdapter(private val ShareDataList : ArrayList<ShareData>) :
    RecyclerView.Adapter<ShareRecyclerViewAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_share,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = ShareDataList[position]
        holder.shareuserimg.setImageResource(currentItem.shareuserimgs)
        holder.sharenickname.text = currentItem.sharenicknames
        holder.shareottname.text = currentItem.shareottnames
        holder.sharetext.text = currentItem.sharetexts
    }

    override fun getItemCount(): Int {
        return ShareDataList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val shareuserimg : ShapeableImageView = itemView.findViewById(R.id.shareuserimg)
        val sharenickname : TextView = itemView.findViewById(R.id.sharenickname)
        val shareottname : TextView = itemView.findViewById(R.id.shareottname)
        val sharetext : TextView = itemView.findViewById(R.id.sharetext)

    }


}