package com.ashrafmohamed.utils.network.callback

import android.net.ConnectivityManager
import android.net.Network
import com.ashrafmohamed.utils.network.*

class MobileDataCallback (private val mobileDataCallBack: (NetworkStatus) -> Unit) :
    ConnectivityManager.NetworkCallback() {

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        mobileDataCallBack.invoke(Available(network))
    }

    override fun onUnavailable() {
        super.onUnavailable()
        mobileDataCallBack.invoke(UnAvailable)
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        mobileDataCallBack.invoke(Lost(network))
    }

    override fun onLosing(network: Network, maxMsToLive: Int) {
        super.onLosing(network, maxMsToLive)
        mobileDataCallBack.invoke(Losing(network, maxMsToLive))
    }
}