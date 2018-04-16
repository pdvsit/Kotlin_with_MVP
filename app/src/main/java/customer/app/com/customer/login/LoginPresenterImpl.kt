package customer.app.com.customer.login

class LoginPresenterImpl(private var loginView: LoginView?, private val loginInteractor: LoginInteractor)
    :  LoginPresenter, LoginInteractor.onLoginFinishedListener {


    override fun validateCredentials(username: String, password: String) {

        if(loginView != null) {
            loginView!!.showProgress()
        }

        loginInteractor.login(username, password, this)
    }

    override fun onDestroy() {

        loginView = null;
    }


    override fun onUserNameError() {

            if(loginView != null) {
                loginView!!.setUserNameError()
                loginView!!.hideProgress()
            }
    }

    override fun onPasswordError() {

            if(loginView != null) {
                loginView!!.setPasswordError()
                loginView!!.hideProgress()

            }
    }

    override fun success() {

        if(loginView != null) {
            loginView!!.navigateToHome()
        }
    }




}