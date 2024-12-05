package com.lonx.ecjtutoolbox.utils

import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.net.wifi.WifiManager
import com.lonx.ecjtutoolbox.ui.wifi.getNoConnectionPresentStatus
import com.lonx.ecjtutoolbox.ui.wifi.getWifiStatus
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate

class WifiStatusMonitor(
    private val wifiManager: WifiManager,
    private val connectivityManager: ConnectivityManager
) {
    private val networkRequest = NetworkRequest
        .Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .build()

    val wifiStatus: Flow<WifiStatus> = callbackFlow {
        channel.trySend(
            getWifiStatus(
                wifiManager,
                connectivityManager
            )
                .log { "Sent $it as initial" }
        )

        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                channel.trySend(WifiStatus.Connected.log { "Sent $it onAvailable" })
            }

            override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
                if (network == connectivityManager.activeNetwork) {
                    channel.trySend(WifiStatus.Connected.log { "Sent $it onCapabilitiesChanged" })
                }
            }

            override fun onLinkPropertiesChanged(network: Network, linkProperties: LinkProperties) {
                if (network == connectivityManager.activeNetwork) {
                    channel.trySend(WifiStatus.Connected.log { "Sent $it onLinkPropertiesChanged" })
                }
            }

            override fun onUnavailable() {
                channel.trySend(
                    wifiManager.getNoConnectionPresentStatus()
                        .log { "Sent $it onUnavailable" }
                )
            }

            override fun onLost(network: Network) {
                channel.trySend(
                    wifiManager.getNoConnectionPresentStatus()
                        .log { "Sent $it onLost" }
                )
            }
        }

        connectivityManager.registerNetworkCallback(
            networkRequest,
            callback
        )

        awaitClose {
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }.conflate()
}