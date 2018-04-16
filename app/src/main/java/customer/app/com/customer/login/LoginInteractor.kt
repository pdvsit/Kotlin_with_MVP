package customer.app.com.customer.login

interface LoginInteractor {

    interface onLoginFinishedListener {


        fun onUserNameError()

        fun onPasswordError()

        fun success()

    }


    fun login(userName: String, password: String, loginFinishedListener: onLoginFinishedListener)

}