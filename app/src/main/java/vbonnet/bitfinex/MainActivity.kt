package vbonnet.bitfinex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import vbonnet.bitfinex.fragments.FragmentCurrencyPairs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) return

        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, FragmentCurrencyPairs())
                .commit()
    }
}
