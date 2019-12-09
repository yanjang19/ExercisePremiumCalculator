package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
//

class MainActivity : AppCompatActivity() {


    lateinit var premium: PremiumVeiwModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//

        premium = ViewModelProviders.of(this).get(PremiumVeiwModel::class.java)


        btnClear.setOnClickListener {
            radioGroup_gender.clearCheck()
            spinner_Age.setSelection(0)
            checkBox_Smoker.setChecked(false)
            premium.premiumValue = calPremium()
            txtPremium.text= premium.premiumValue.toString()
        }


    }

    fun calPremium(): Double {


        var premium: Double = 0.0


        val age: Number = spinner_Age.selectedItemPosition
        when (age) {
            0 -> premium += 60
            1 -> premium += 70
            2 -> premium += 90
            3 -> premium += 120
            4 -> premium += 150
            5 -> premium += 150
        }

        //smoker checkingg
        val check: Boolean = checkBox_Smoker.isChecked

        if (check == true) {
            when (age) {
                0 -> premium += 0
                1 -> premium += 100
                2 -> premium += 150
                3 -> premium += 200
                4 -> premium += 250
                5 -> premium += 300
            }
        }

        val select: String = radioGroup_gender.checkedRadioButtonId.toString()

        if (select == R.id.radioButton_male.toString()) {
            when (age) {
                0 -> premium += 0
                1 -> premium += 50
                2 -> premium += 100
                3 -> premium += 150
                4 -> premium += 200
                5 -> premium += 200
            }

        }
        txtPremium.text = premium.toString()

return premium
    }



}
