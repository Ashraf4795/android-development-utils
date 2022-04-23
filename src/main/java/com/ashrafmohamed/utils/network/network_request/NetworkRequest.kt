package com.ashrafmohamed.utils.network.network_request

import android.net.NetworkCapabilities
import android.net.NetworkRequest

var wifiNetworkRequest = NetworkRequest.Builder()
    .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
    .build()

var mobileDataNetworkRequest =  NetworkRequest.Builder()
    .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
    .build()