package vbonnet.bitfinex.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import vbonnet.bitfinex.model.CurrencyPair
import java.net.URL


class CurrencyPairsViewModel : ViewModel() {
    private val currencyPairs = MutableLiveData<Iterable<CurrencyPair>>()

    fun loadCurrencyPairs() {
        doAsync {
            //request
            val url = "https://api.bitfinex.com/v1/symbols"
            val json = URL(url).readText()

            val jsonArray = JSONArray(json)
            val list = ArrayList<CurrencyPair>()
            for (i in 0 until jsonArray.length()) {
                list.add(CurrencyPair(jsonArray.getString(i)))
            }

            uiThread {
                if (list != null) currencyPairs.value = list
            }

        }
    }

    fun getCurrencyPair(): LiveData<Iterable<CurrencyPair>> {
        return currencyPairs
    }
}