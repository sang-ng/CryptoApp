package com.example.cryptoapp.ui.coinList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.databinding.FragmentOverviewBinding
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
    }

    private fun setupRecyclerView() {
        coinsAdapter = CoinsAdapter()

        binding.overviewRv.apply {
            adapter = coinsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }
}