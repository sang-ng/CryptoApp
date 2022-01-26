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
import com.example.cryptoapp.ui.overview.OverViewViewModel
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

        val coin = args.coin

        Log.d(TAG, "onViewCreated: " + coin?.id)
        Toast.makeText(requireContext(), coin?.name, Toast.LENGTH_SHORT).show()
    }

}
