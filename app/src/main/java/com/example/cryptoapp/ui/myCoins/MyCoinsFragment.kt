package com.example.cryptoapp.ui.myCoins

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.FragmentMyCoinsBinding
import com.example.cryptoapp.databinding.FragmentOverviewBinding
import com.example.cryptoapp.ui.overview.CoinsAdapter
import com.example.cryptoapp.ui.overview.OverViewViewModel
import kotlinx.android.synthetic.main.fragment_my_coins.*
import org.koin.android.viewmodel.ext.android.viewModel


class MyCoinsFragment : Fragment(R.layout.fragment_my_coins) {

    private val viewModel: MyCoinsViewModel by viewModel()
    private lateinit var binding: FragmentMyCoinsBinding
    lateinit var coinsAdapter: CoinsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyCoinsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        initObserver()
    }

    private fun initObserver() {
        viewModel.getMyCoins().observe(viewLifecycleOwner,{ coins ->
            coinsAdapter.differ.submitList(coins)
        })
    }

    private fun setupRecyclerView() {
        coinsAdapter = CoinsAdapter()
        my_coins_rv.apply {
            adapter = coinsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}