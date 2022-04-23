package com.ashrafmohamed.utils.network

import android.net.Network

sealed class NetworkStatus

data class Lost(val network: Network): NetworkStatus()
data class Losing(val network: Network, val maxMsToLive: Int): NetworkStatus()
data class Available(val network: Network): NetworkStatus()
object UnAvailable: NetworkStatus()