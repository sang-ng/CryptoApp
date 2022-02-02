package com.example.cryptoapp.ui.overview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.R
import com.example.cryptoapp.data.domain.model.Coin
import kotlinx.android.synthetic.main.list_item_coin.view.*

class CoinsAdapter : RecyclerView.Adapter<CoinsAdapter.CoinViewHolder>() {

    inner class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_coin, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = differ.currentList[position]
        holder.itemView.apply {

            tv_coin.text = coin.rank.toString() + ". " + coin.name + " (" + coin.symbol + ")"

            setOnClickListener { onItemClickListener?.let { it(coin) } }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Coin) -> Unit)? = null

    fun setOnItemClickListener(listener: (Coin) -> Unit) {
        onItemClickListener = listener
    }
}