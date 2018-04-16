package customer.app.com.customer.main

interface FindItemInteractor {

    interface OnFinishedListener {
        fun onFinished(items: List<String>)
    }

    fun findItems(listener: OnFinishedListener)

}