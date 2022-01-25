package com.example.cryptoapp.presentation.ui.coinList

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val repository: CoinRepository,
    private val dispatchers: Dispatchers
) : ViewModel() {


}