package com.example.artisan.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artisan.databinding.ItemListServicesBinding
import com.example.artisan.domain.model.Services

class DetailServicesAdapter : RecyclerView.Adapter<DetailServicesAdapter.MyViewHolder>(){

    private val listService = ArrayList<Services>()

    fun setArtisan(services: List<Services>){
        listService.clear()
        this.listService.addAll(services)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemListBinding = ItemListServicesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemListBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val service = listService[position]
        holder.bind(service)
    }

    override fun getItemCount(): Int = listService.size


    inner class MyViewHolder (private val binding : ItemListServicesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(services: Services) {
            with(binding) {
               tvNameServices.text = services.name
                tvPrice.text = services.price
                tvCaption.text = services.caption

            }

        }
    }
}