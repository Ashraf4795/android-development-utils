package com.ashrafmohamed.utils.network

import android.net.ConnectivityManager
import com.ashrafmohamed.utils.network.callback.MobileDataCallback
import com.ashrafmohamed.utils.network.callback.WifiCallback
import com.ashrafmohamed.utils.network.network_request.mobileDataNetworkRequest
import com.ashrafmohamed.utils.network.network_request.wifiNetworkRequest

class NetworkService(private val connectivityManager: ConnectivityManager) {

    private lateinit var wifiCallback: WifiCallback
    private lateinit var mobileDataCallback: MobileDataCallback

    fun whenWiFi(wifiCallBack: (NetworkStatus) -> Unit) {
        wifiCallback = WifiCallback(wifiCallBack)
        return connectivityManager.requestNetwork(wifiNetworkRequest, wifiCallback)
    }

    fun whenMobileDataAvailable(mobileDataCallback: (NetworkStatus) -> Unit) {
        this.mobileDataCallback = MobileDataCallback(mobileDataCallback)
        return connectivityManager.requestNetwork(
            mobileDataNetworkRequest,
            this.mobileDataCallback
        )
    }

    fun unregisterCallBacks() {
        if (this::wifiCallback.isInitialized) {
            connectivityManager.unregisterNetworkCallback(wifiCallback)
        }

        if (this::mobileDataCallback.isInitialized) {
            connectivityManager.unregisterNetworkCallback(mobileDataCallback)
        }
    }

    fun clear() {
        wifiNetworkRequest = null
        mobileDataNetworkRequest = null
    }
}