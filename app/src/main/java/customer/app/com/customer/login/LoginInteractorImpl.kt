package customer.app.com.customer.login

import android.os.Handler
import android.text.TextUtils

class LoginInteractorImpl : LoginInteractor{


    override fun login(userName: String, password: String, loginFinishedListener: LoginInteractor.onLoginFinishedListener) {

        Handler().postDelayed({

            if (TextUtils.isEmpty(userName)) {
                loginFinishedListener.onUserNameError()


            }
            else if (TextUtils.isEmpty(password)) {
                loginFinishedListener.onPasswordError()

            }
               else {

                loginFinishedListener.success()
            }

        }, 3000)
    }

}