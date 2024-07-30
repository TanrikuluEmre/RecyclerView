package com.example.recyclerviewapp.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.databinding.FragmentRowBinding


class Fragment_row : Fragment() {


    private var _binding: FragmentRowBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val args = Fragment_rowArgs.fromBundle(requireArguments())
        val collectionName = args.collectionName
        val artistName = args.artistName
        val collectionPrice = args.collectionPrice
        val artworkUrl = args.artworkUrl


        _binding!!.collectionNameTextView.text = collectionName
        _binding!!.artistNameTextView.text = artistName
        _binding!!.collectionPriceTextView.text = collectionPrice
        Glide.with(this).load(artworkUrl).into(_binding!!.artworkImageView)

        _binding!!.buttonHome.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_row_to_mainFragment)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRowBinding.inflate(layoutInflater)
        val view = _binding!!.root
        return view
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            Fragment_row().apply {
                arguments = Bundle().apply {

                }
            }
    }
}