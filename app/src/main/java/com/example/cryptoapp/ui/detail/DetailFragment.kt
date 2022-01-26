package com.example.cryptoapp.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.FragmentDetailBinding
import com.example.cryptoapp.databinding.FragmentOverviewBinding
import com.example.cryptoapp.model.Coin
import com.example.cryptoapp.model.CoinDetail
import com.example.cryptoapp.ui.overview.OverViewViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_overview.*
import kotlinx.android.synthetic.main.fragment_overview.overview_progressbar
import org.koin.android.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModel()
    private val args: DetailFragmentArgs by navArgs()
    private val TAG = "TEST"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getSelectedCoin()
        initObserver()
    }

    private fun getSelectedCoin() {
        val coin = args.coin
        coin?.id?.let { viewModel.getCoinById(coindId = it) }
    }

    private fun initObserver() {
        viewModel.coin.observe(viewLifecycleOwner, { it ->
            updateUI(it)
        })

        viewModel.status.observe(viewLifecycleOwner, { status ->
            when (status) {
                DetailViewModel.CoinApiStatus.ERROR -> {
                    hideProgressBar()
                    Toast.makeText(requireContext(), "no internet", Toast.LENGTH_SHORT).show()
                }
                DetailViewModel.CoinApiStatus.LOADING -> {
                    showProgressBar()
                }
                DetailViewModel.CoinApiStatus.SUCCESS -> {
                    hideProgressBar()
                }
            }
        })
    }

    private fun updateUI(coinDetail: CoinDetail) {
        detail_coin_name.text = coinDetail.name
        detail_coin_description.text = coinDetail.description
        detail_type.text = "Type: " + coinDetail.type
        detail_start_date.text = "Start date: " + coinDetail.started_at
        detail_proof_type.text = "Proof type: " + coinDetail.proof_type
        detail_development.text = "Development status: " + coinDetail.development_status

    }

    private fun showProgressBar() {
        detail_progressbar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        detail_progressbar.visibility = View.INVISIBLE
    }
}
