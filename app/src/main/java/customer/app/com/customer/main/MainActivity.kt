package customer.app.com.customer.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import customer.app.com.customer.R

class MainActivity : AppCompatActivity(), MainView, AdapterView.OnItemClickListener {


    private var listView: ListView? = null
    private var progressBar: ProgressBar? = null
    private var mainViewPresenter: MainViewPresenter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView();
    }



    private fun initView() {
        listView = findViewById<View>(R.id.list) as ListView
        listView!!.onItemClickListener = this
        progressBar = findViewById<View>(R.id.progress) as ProgressBar
        mainViewPresenter = MainPreseterImp(this, FindItemInteractorImp())
    }

    override fun onResume() {
        super.onResume()

        mainViewPresenter!!.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()

        mainViewPresenter!!.onDestroy()
    }


    override fun showProgress() {

        progressBar!!.visibility = View.VISIBLE
        listView!!.visibility = View.INVISIBLE

    }

    override fun hideProgress() {

        progressBar!!.visibility = View.INVISIBLE
        listView!!.visibility = View.VISIBLE

    }

    override fun setItems(items: List<String>) {

        listView!!.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

    }

    override fun showMessage(message: String) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        mainViewPresenter!!.onItemClick(position)
    }
}
