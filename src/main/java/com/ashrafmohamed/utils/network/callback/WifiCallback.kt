package com.ashrafmohamed.utils.network.callback

import android.net.ConnectivityManager
import android.net.Network
import com.ashrafmohamed.utils.network.*

class WifiCallback (private val wifiCallBack: (NetworkStatus) -> Unit) :
    ConnectivityManager.NetworkCallback() {

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        wifiCallBack.invoke(Available(network))
    }

    override fun onUnavailable() {
        super.onUnavailable()
        wifiCallBack.invoke(UnAvailable)
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        wifiCallBack.invoke(Lost(network))
    }

    override fun onLosing(network: Network, maxMsToLive: Int) {
        super.onLosing(network, maxMsToLive)
        wifiCallBack.invoke(Losing(network, maxMsToLive))
    }
}