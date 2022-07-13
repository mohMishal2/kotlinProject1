package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button=findViewById(R.id.button)
        val edtxt1: EditText = findViewById(R.id.edprice)
        val resultTV: TextView = findViewById(R.id.resultid)

        var flag:String="Burger"
        val spinnerVal:Spinner=findViewById(R.id.spinner)
        var options=arrayOf("Burger","Pizza")
        spinnerVal.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        button.setOnClickListener{ view->
            var x:Int=edtxt1.text.toString().toInt();

            if(flag=="Burger"){
                resultTV.text= mulBurger(x).toString();
            }
            else{
                resultTV.text= mulPizza(x).toString();
            }
        }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                flag = options.get(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}
public fun mulBurger(a: Int):Int{
    return a * 5;
}
public fun mulPizza(a: Int):Int{
    return a * 7;
}
