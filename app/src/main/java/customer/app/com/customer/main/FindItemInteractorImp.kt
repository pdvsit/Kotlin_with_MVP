package customer.app.com.customer.main

import android.os.Handler
import java.util.*

class FindItemInteractorImp: FindItemInteractor {


    override fun findItems(listener: FindItemInteractor.OnFinishedListener) {

        Handler().postDelayed({ listener.onFinished(createArrayList()) }, 2000)

    }


    private fun createArrayList(): List<String> {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        )
    }


}