package com.example.artisan.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.artisan.databinding.FragmentDetailBinding
import com.example.artisan.domain.model.Artisan
import com.example.artisan.utils.Resource
import org.koin.android.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {


    private val detailViewModel : DetailViewModel by viewModel()
    private val args : DetailFragmentArgs by navArgs()
    private var _binding: FragmentDetailBinding? = null
    private val binding  get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.setNavigationOnClickListener {
            (activity as AppCompatActivity?)?.supportActionBar?.show()
            findNavController().navigateUp()
        }

        val artisanId = args.data?.id
        if (artisanId != null) {
            detailViewModel.getArtisanById(artisanId).observe(viewLifecycleOwner, { detail ->
                when (detail) {
                    is Resource.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        populateArtisan(detail.data)
                     }
                    is Resource.Error -> {
                        Toast.makeText(requireContext(),"error", Toast.LENGTH_SHORT).show()
                        binding.progressBar.visibility = View.GONE
                    }
                }
            })

        }
    }


    private fun populateArtisan(artisan: Artisan?) {
        if (artisan != null) {
            with(binding) {
                tvUser.text = StringBuilder(artisan.name)
                ratingBar.rating = artisan.rating.toFloat()
                tvDescription.text = StringBuilder(artisan.description)
                tvNameServices.text =  StringBuilder(artisan.services[0])
                tvNameServicesTwo.text = StringBuilder(artisan.services[0])
                tvCaption.text = StringBuilder("Caption :  ${artisan.services[1]}")
                tvCaptionTwo.text = StringBuilder("Caption :  ${artisan.services[1]}")

                Glide.with(requireActivity())
                    .load(artisan.image)
                    .into(imgUser)

                Glide.with(requireActivity())
                    .load(artisan.image)
                    .into(imgUserTwo)

                Glide.with(requireActivity())
                    .load(artisan.avatar)
                    .into(imgDetailUser)


            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
