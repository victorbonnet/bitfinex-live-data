package vbonnet.bitfinex.adapters

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_currency_pairs.view.*
import vbonnet.bitfinex.R
import vbonnet.bitfinex.fragments.CURRENCY_PAIR_ARG
import vbonnet.bitfinex.fragments.FragmentCurrencyPairDetails
import vbonnet.bitfinex.model.CurrencyPair

class CurrencyPairsAdapter(val items : ArrayList<CurrencyPair>, val context: Context?) : RecyclerView.Adapter<CurrencyPairsAdapter.CurrencyPairViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyPairViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.row_currency_pairs, parent, false)
        return CurrencyPairViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CurrencyPairViewHolder, position: Int) {
        holder.pair?.text = items[position].pair

        holder.row.setOnClickListener({
            _ -> val fragmentCurrencyPairDetails = FragmentCurrencyPairDetails()
            var bundle = Bundle()
            bundle.putString(CURRENCY_PAIR_ARG, items[position].pair)
            fragmentCurrencyPairDetails.arguments = bundle
            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragmentCurrencyPairDetails)
                    .addToBackStack("details")
                    .commit()
        })
    }

    class CurrencyPairViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val row = view
        val pair = view.pair
    }

    interface ClickListener {
        fun onItemClick()
    }
}