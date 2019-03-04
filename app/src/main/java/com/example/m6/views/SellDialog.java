package com.example.m6.views;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.example.m6.R;
import com.example.m6.model.Goods;
public class SellDialog extends AppCompatDialogFragment {
    int price;
    String goodstype;
    public interface SellDialogListener{
        void onInputData(String input);
        void sellItem(String goods, int price);
    }
    private SellDialogListener call;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            call = (SellDialogListener) activity;
        } catch(ClassCastException e) {
            Log.d("test", "activity doesnt implement");
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            price = bundle.getInt("price");
            goodstype = bundle.getString("goodstype");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.buy_dialog, null);
        final EditText input = (EditText)view.findViewById(R.id.buy_input);
        builder.setView(view)
                .setTitle("Enter the amount of items")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String inputStr = input.getText().toString();
//
                        call.onInputData(inputStr);
                        call.sellItem(goodstype, price);
                        dismiss();
                    }
                });
        return builder.create();
    }
}