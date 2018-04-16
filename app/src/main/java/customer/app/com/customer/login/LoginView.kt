package customer.app.com.customer.login

interface LoginView {


    fun showProgress()

    fun hideProgress()

    fun setUserNameError()

    fun setPasswordError()

    fun navigateToHome()
}