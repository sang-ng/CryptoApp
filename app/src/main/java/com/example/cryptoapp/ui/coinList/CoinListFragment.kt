package com.example.cryptoapp.ui.coinList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cryptoapp.databinding.FragmentCoinListBinding
import org.koin.android.viewmodel.ext.android.viewModel


class CoinListFragment : Fragment() {

    private val TAG = "TEST"

    private val viewModel: CoinListViewModel by viewModel()
    private lateinit var binding: FragmentCoinListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()
    }

    private fun initObserver() {
        viewModel.coins.observe(viewLifecycleOwner, { coins ->

        })
    }
}