package com.example.homework2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ratingTV : TextView = findViewById(R.id.TVrating)
        ratingTV.setOnClickListener{
            var dialog_var = Dialog()
            dialog_var.show(supportFragmentManager, "Custom Dialog")

        }
        val button: Button = findViewById(R.id.Resultbt)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val resultTV: TextView = findViewById(R.id.Result)
        //global variable
        var flag : String = "foreigner"
        //here .. create a spinner items (options)
        val spinnerVal : Spinner = findViewById(R.id.spinner)
        var options = arrayOf("foreigner","citizen")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
            //code here
            var x: Int = edtxt1.text.toString().toInt();
            if(flag =="foreigner")
                resultTV.text = foreigner(x).toString();
            else
                resultTV.text = citizen(x).toString();
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 ->Toast.makeText(this, "This will be available in the next version ", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "This will be available in the next version ", Toast.LENGTH_SHORT).show()
        }
        return true;
    }

    fun receiveFeedback(feedback: String) {
        val ratingTV : TextView = findViewById(R.id.TVrating)
        ratingTV.text = feedback;
    }


}
public fun foreigner(a: Int): Double {
    return a* 0.3
}
public fun citizen(a: Int): Double {
    return a* 0.1
}