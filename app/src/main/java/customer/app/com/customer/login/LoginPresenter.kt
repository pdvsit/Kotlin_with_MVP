package customer.app.com.customer.login

interface LoginPresenter {

    fun validateCredentials(username: String, password: String)

    fun onDestroy()


}