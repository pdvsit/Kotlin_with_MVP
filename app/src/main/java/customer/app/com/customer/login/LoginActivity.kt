package customer.app.com.customer.login

import android.content.Intent
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import customer.app.com.customer.R
import customer.app.com.customer.main.MainActivity

class LoginActivity : AppCompatActivity() , LoginView, View.OnClickListener {


    private var loginPresenter: LoginPresenter? = null

    private var etUserName: EditText? = null
    private var etPassword: EditText? = null
    private var progressBar: ProgressBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        loginPresenter = LoginPresenterImpl(this, LoginInteractorImpl())

        initView()


    }


    fun initView() {

        progressBar = findViewById(R.id.progress)
        etUserName = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        findViewById<View>(R.id.button).setOnClickListener(this);

    }



    override fun showProgress () {

        progressBar!!.visibility = View.VISIBLE;
    }

    override fun hideProgress () {

        progressBar!!.visibility = View.GONE;

    }

    override fun setUserNameError () {

        etUserName!!.error = getString(R.string.username_error)

    }

    override fun setPasswordError () {

        etPassword!!.error = getString(R.string.password_error)

    }

    override fun navigateToHome () {

        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }

    override fun onClick(v: View?) {

        loginPresenter!!.validateCredentials(etUserName!!.text.toString(), etPassword!!.text.toString())

    }

    override fun onDestroy() {

        loginPresenter!!.onDestroy()
        super.onDestroy()
    }


}

