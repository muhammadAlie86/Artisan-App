package com.example.artisan.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artisan.databinding.ItemListBinding
import com.example.artisan.domain.model.Artisan
import com.example.artisan.utils.DataCallbackArtisan

class HomeAdapter(val dataCallbackArtisan: DataCallbackArtisan) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>(){

    private val listArtisan = ArrayList<Artisan>()

    fun setArtisan(artistes : List<Artisan>){
        listArtisan.clear()
        this.listArtisan.addAll(artistes)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val artis = listArtisan[position]
        holder.bind(artis)
    }

    override fun getItemCount(): Int = listArtisan.size

    inner class MyViewHolder (private val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artisan: Artisan) {
            with(binding) {
                tvName.text = artisan.name
                tvDescription.text = artisan.description
                itemView.setOnClickListener {
                    dataCallbackArtisan.setDataArtisan(artisan)
                }
                Glide.with(itemView.context)
                    .load(artisan.image)
                    .into(imgUser)
            }

        }
    }
}