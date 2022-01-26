package com.example.cryptoapp.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.FragmentOverviewBinding
import kotlinx.android.synthetic.main.fragment_overview.*
import org.koin.android.viewmodel.ext.android.viewModel


class OverviewFragment : Fragment() {

    private val TAG = "TEST"

    private val viewModel: OverViewViewModel by viewModel()
    private lateinit var binding: FragmentOverviewBinding
    lateinit var coinsAdapter: CoinsAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOverviewBinding.inflate(inflater, container, false)

        setupRecyclerView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()
    }

    private fun initObserver() {
        viewModel.coins.observe(viewLifecycleOwner, { coins ->
            coinsAdapter.differ.submitList(coins)
        })

        viewModel.status.observe(viewLifecycleOwner, { status ->
            when (status) {
                OverViewViewModel.CoinApiStatus.ERROR -> {
                    hideProgressBar()
                    Toast.makeText(requireContext(), "no internet", Toast.LENGTH_SHORT).show()
                }
                OverViewViewModel.CoinApiStatus.LOADING -> {
                    showProgressBar()
                }
                OverViewViewModel.CoinApiStatus.SUCCESS -> {
                    hideProgressBar()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        coinsAdapter = CoinsAdapter()

        binding.overviewRv.apply {
            adapter = coinsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        coinsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply { putSerializable("coin", it) }
            findNavController().navigate(R.id.overviewFragment_to_detailFragment, bundle)
        }
    }

    private fun showProgressBar() {
        overview_progressbar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        overview_progressbar.visibility = View.INVISIBLE
    }
}