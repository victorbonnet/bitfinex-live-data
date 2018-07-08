package vbonnet.bitfinex.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vbonnet.bitfinex.R
import vbonnet.bitfinex.adapters.CurrencyPairsAdapter
import vbonnet.bitfinex.model.CurrencyPair
import vbonnet.bitfinex.viewmodels.CurrencyPairsViewModel

class FragmentCurrencyPairs : Fragment() {

    private lateinit var currencyPairsViewModel: CurrencyPairsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currencyPairsViewModel = ViewModelProviders.of(this).get(CurrencyPairsViewModel::class.java)

        if (savedInstanceState != null) return


        currencyPairsViewModel.loadCurrencyPairs()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_currency_pairs, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val items = ArrayList<CurrencyPair>()
        recyclerView.adapter = CurrencyPairsAdapter(items, context)

        currencyPairsViewModel.getCurrencyPair().observe(this, Observer { currencyPairs ->
            run {
                items.clear()
                if (currencyPairs != null) items.addAll(currencyPairs)
                recyclerView.adapter.notifyDataSetChanged()
            }
        })

        return view
    }

}