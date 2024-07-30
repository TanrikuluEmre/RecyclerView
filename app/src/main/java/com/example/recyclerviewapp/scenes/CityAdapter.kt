package com.example.recyclerviewapp.scenes

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.databinding.CityItemRowBinding
import com.firesoftwaregroup.itunessearchapi.network.response.ResultDataVariables


class CityAdapter(private val dataSet: List<ResultDataVariables>?) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>()
{

    class ViewHolder(val binding: CityItemRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding = CityItemRowBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.binding.root.setOnClickListener{
            findNavController(viewHolder.itemView).navigate(
                MainFragmentDirections.actionMainFragmentToFragmentRow(
                    dataSet?.get(position)?.collectionName.toString(),
                    dataSet?.get(position)?.artistName.toString(),
                    dataSet?.get(position)?.collectionPrice.toString(),
                    dataSet?.get(position)?.artworkUrl100.toString()
                )
            )
        }
        viewHolder.binding.collectionName.text= dataSet?.get(position)?.collectionName
        viewHolder.binding.artistName.text = dataSet?.get(position)?.artistName
        viewHolder.binding.price.text = dataSet?.get(position)?.collectionPrice.toString()
        Glide.with(viewHolder.itemView.context).load(dataSet?.get(position)?.artworkUrl100).into(viewHolder.binding.image)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet?.size ?: 0

}
