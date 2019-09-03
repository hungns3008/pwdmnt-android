package hungnguyen.com.demo.utils;

import android.app.AlertDialog;
import android.content.Context;

import hungnguyen.com.demo.R;

public class AlertUtils {

    private static final AlertUtils ourInstance = new AlertUtils();

    public static AlertUtils getInstance() {
        return ourInstance;
    }

    public void showAlertGotIt(Context context, String title, String text) {
        AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.AppAlertDialog).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setTitle(title);
        alertDialog.setMessage(text);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (dialog, which) -> {
            alertDialog.dismiss();
        });

        alertDialog.show();
    }
}
