package customer.app.com.customer.main

class MainPreseterImp(private var mainView: MainView?, private val findItemInteractor: FindItemInteractor): MainViewPresenter , FindItemInteractor.OnFinishedListener {



    override fun onFinished(items: List<String>) {

        if (mainView != null) {
            mainView!!.setItems(items)
            mainView!!.hideProgress()
        }
    }


    override fun onResume() {

        if(mainView != null) {

            mainView!!.showProgress()

        }

        findItemInteractor.findItems(this)
    }


    override fun onItemClick(position: Int) {

        if (mainView != null) {
            mainView!!.showMessage(String.format("Position %d clicked", position + 1))
        }
    }



    override fun onDestroy() {
        mainView = null
    }


}