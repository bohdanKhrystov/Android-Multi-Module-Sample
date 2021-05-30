package com.bohdanhub.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class UnauthorizedInterceptor @Inject constructor(): Interceptor {

    object UnauthorizedObserver {
        interface UnauthorizedListener {
            fun onUnauthorized()
        }

        private val observers = arrayListOf<UnauthorizedListener>()

        fun subscribe(observer : UnauthorizedListener) {
            if (!observers.contains(observer)) {
                observers.add(observer)
            }
        }

        fun unsubscribe(observer: UnauthorizedListener) {
            observers.remove(observer)
        }

        fun notifyUserBecomeUnauthorized() {
            if (observers.isNotEmpty()) {
                try {
                    for (observer in observers) {
                        observer.onUnauthorized()
                    }
                } catch (ex: Exception) {
                }
            }
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (UNAUTHORIZED_ERRORS.contains(response.code)) {
            UnauthorizedObserver.notifyUserBecomeUnauthorized()
        }
        return response
    }

    companion object {
        private val UNAUTHORIZED_ERRORS = arrayListOf(401, 403)
    }
}