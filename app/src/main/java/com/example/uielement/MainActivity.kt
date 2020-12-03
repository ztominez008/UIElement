package com.example.uielement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val age = findViewById<SeekBar>(R.id.ageBar)
        val ageValue = findViewById<TextView>(R.id.ageValue)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumber)
        val phoneLabel = findViewById<TextView>(R.id.textPhone)
        val enableNum = findViewById<Switch>(R.id.enableNum)

        phoneNumber.visibility = View.INVISIBLE
        phoneLabel.visibility = View.INVISIBLE

        age?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                ageValue.text = (seek.progress+18).toString()
            }
        })

        enableNum.setOnClickListener{
            if(enableNum.isChecked){
                phoneNumber.visibility = View.VISIBLE
                phoneLabel.visibility = View.VISIBLE
            }else{
                phoneNumber.visibility = View.INVISIBLE
                phoneLabel.visibility = View.INVISIBLE
            }
        }

        val nxtPage = findViewById<Button>(R.id.nxtPageBtn)
        nxtPage.setOnClickListener{
            nextPage(age.progress+18)
        }
    }

    fun nextPage(age: Int) {
        val firstName = findViewById<EditText>(R.id.firstName).text.toString()
        val lastName = findViewById<EditText>(R.id.lastName).text.toString()
        val emailAddress = findViewById<EditText>(R.id.emailAddressEt).text.toString()
        val phoneNumber = findViewById<EditText>(R.id.phoneNumber).text.toString()

        val intent = Intent(this, CalendarActivity::class.java)
        intent.putExtra("FirstName","$firstName")
        intent.putExtra("LastName","$lastName")
        intent.putExtra("Age","$age")
        intent.putExtra("Email","$emailAddress")
        intent.putExtra("Phone","$phoneNumber")

        startActivity(intent)
    }

}
