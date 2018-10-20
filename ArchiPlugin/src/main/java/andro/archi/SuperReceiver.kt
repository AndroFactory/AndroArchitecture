package andro.archi

import android.content.BroadcastReceiver
import android.content.Context

abstract class SuperReceiver : BroadcastReceiver() {

    open fun injectReceiver(context: Context) {
        (context.applicationContext as SuperInjector).injectReceiver(this)
    }
}
