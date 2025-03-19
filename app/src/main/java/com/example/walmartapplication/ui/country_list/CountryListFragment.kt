package com.example.walmartapplication.ui.country_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walmartapplication.databinding.FragmentCountryListBinding
import com.example.walmartapplication.di.CountryViewModelFactory
import com.example.walmartapplication.ui.country_list.adapter.CountryAdapter
import com.example.walmartapplication.ui.state.UiState

class CountryListFragment : Fragment() {
    private lateinit var binding: FragmentCountryListBinding

    private lateinit var viewModel: CountryViewModel
    private lateinit var adapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup RecyclerView
        adapter = CountryAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Setup ViewModel
        viewModel = ViewModelProvider(
            requireActivity(), CountryViewModelFactory()
        )[CountryViewModel::class.java]

        // Observe changes
        viewModel.countries.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Loading -> showLoading()
                is UiState.Success -> showCountries()
                is UiState.Error -> showError(state.message)
            }
        }

        // Setup retry button
        binding.btnRetry.setOnClickListener {
            viewModel.fetchCountries()
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
        binding.errorLayout.visibility = View.GONE
    }

    private fun showCountries() {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
        binding.errorLayout.visibility = View.GONE

    }

    private fun showError(message: String) {
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.GONE
        binding.errorLayout.visibility = View.VISIBLE
        binding.tvError.text = "Error: $message"
    }
}
