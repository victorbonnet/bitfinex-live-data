package vbonnet.bitfinex.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import vbonnet.bitfinex.R

const val CURRENCY_PAIR_ARG: String = "currencypair"

class FragmentCurrencyPairDetails : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_currency_pair_details, container, false)

        val textView = view.findViewById<TextView>(R.id.text)
        val text = arguments!![CURRENCY_PAIR_ARG].toString()
        textView.text = text

        return view
    }

}