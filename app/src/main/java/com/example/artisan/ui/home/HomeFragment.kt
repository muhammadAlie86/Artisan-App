package com.example.artisan.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artisan.R
import com.example.artisan.databinding.FragmentHomeBinding
import com.example.artisan.domain.model.Artisan
import com.example.artisan.utils.DataCallbackArtisan
import com.example.artisan.utils.Resource
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(),DataCallbackArtisan {

    private val homeViewModel : HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding  get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            binding.imgProfile.setOnClickListener {
                view.findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
            }
            val homeAdapter = HomeAdapter(this)

            homeViewModel.artisan.observe(viewLifecycleOwner, { artisan ->
                when (artisan) {
                        is Resource.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            Toast.makeText(requireContext(),"loading",Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            artisan.data?.let {
                                homeAdapter.setArtisan(it)
                            }
                        }
                        is Resource.Error -> {
                            Toast.makeText(requireContext(),"error",Toast.LENGTH_SHORT).show()
                            binding.progressBar.visibility = View.GONE
                         }
                    }

            })
            with(binding.rvArtisan) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = homeAdapter
            }
        }
    }


    override fun setDataArtisan(artisan : Artisan) {
        val extraData = HomeFragmentDirections.actionHomeFragmentToDetailFragment(artisan)
        view?.findNavController()?.navigate(extraData)

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}