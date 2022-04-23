package com.ashrafmohamed.utils.network

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest

class NetworkService (private val connectivityManager: ConnectivityManager){
    private val wifiNetworkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build()

    fun whenWiFi(wifiCallBack: (NetworkStatus) -> Unit) {
        return connectivityManager.requestNetwork(wifiNetworkRequest, object : ConnectivityManager.NetworkCallback() {
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
        })
    }

}