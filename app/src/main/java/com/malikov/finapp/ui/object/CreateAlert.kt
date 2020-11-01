import android.app.AlertDialog
import android.content.DialogInterface
import com.malikov.finapp.R
import com.malikov.finapp.utils.APP_ACTIVITY
import com.malikov.finapp.utils.showToast

class CreateAlert {


    fun createLanguage() {
        val alertDialogLanguage = AlertDialog.Builder(APP_ACTIVITY)
        val items = (R.array.valut_item)
        alertDialogLanguage.setTitle(APP_ACTIVITY.getString(R.string.valut))
            .setSingleChoiceItems(items, -1, DialogInterface.OnClickListener { dialogInterface, i ->
                when (i) {
                    0 -> showToast("Руский язык")
                    1 -> showToast("English")

                }
                dialogInterface.dismiss()
            })
        alertDialogLanguage.setNeutralButton(
            "Отмена",
            DialogInterface.OnClickListener { dialogInterface, which ->
                dialogInterface.cancel()
            })
        alertDialogLanguage.create().show()
    }
}


