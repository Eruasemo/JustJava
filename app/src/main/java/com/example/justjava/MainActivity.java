package com.example.justjava;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    int basePrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //displayPrice(5);
    }

    public void submitOrder(View view) {
        //displayPrice(quantity * 5);
        EditText editText = (EditText) findViewById(R.id.texto_nombre);
        CheckBox creamCheckBox = (CheckBox) findViewById(R.id.checkbox_crema);
        CheckBox chipsCheckBox = (CheckBox) findViewById(R.id.checkbox_chispas);
        boolean cream = creamCheckBox.isChecked();
        boolean chips = chipsCheckBox.isChecked();

        String name = editText.getText().toString();
        String message = " Resumen de la orden: \n" +
                "Nombre: "+name +"\n"
                +"Cantidad de cafés: "+quantity+"\n";

        if(cream) {
            message += "Con Crema Batida\n";
            basePrice+=1;
        }
        if(chips) {
            message += "Con chispas de chocolate\n";
            basePrice+=2;
        }
        int total = basePrice*quantity;
        message+="Total: "+NumberFormat.getCurrencyInstance().format(total);

        displayMessage(message);

    }

   /* private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }*/

    /*private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/

    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void incrementCoffee(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantity++;
        quantityTextView.setText("" + quantity);
    }

    public void decrementCoffee(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if (quantity > 1) {
            quantity--;
            quantityTextView.setText("" + quantity);
        }
    }

}