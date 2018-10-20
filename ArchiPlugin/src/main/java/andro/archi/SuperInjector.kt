package andro.archi

interface SuperInjector {
    fun injectActivity(activity: SuperActivity)
    fun injectReceiver(receiver: SuperReceiver)
}