package com.example.myapplication

import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.model.Data

class MainActivity : AppCompatActivity() {
    private lateinit var recv: RecyclerView
    private lateinit var userList:ArrayList<Data>
    private lateinit var userAdapter: UserAdapter
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var addsBtn: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById<EditText>(R.id.email)
        phone = findViewById<EditText>(R.id.number)
        userList = ArrayList()
        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)
        userAdapter = UserAdapter(this,userList)
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter
        addsBtn.setOnClickListener { addInfo() }

    }

    private fun addInfo() {

        val emailtext = email.text.toString()
        val number = phone.text.toString()

        if(emailtext.isEmpty() || number.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Fields Cannot be Empty",Toast.LENGTH_SHORT).show();

        }else {
            if (Patterns.EMAIL_ADDRESS.matcher(emailtext).matches() && number.length == 10 ) {
              
                userList.add(Data("Email: $emailtext","Mobile No. : $number"))
                userAdapter.notifyDataSetChanged()
                Toast.makeText(this,"Adding User Information Success", Toast.LENGTH_SHORT).show()
                email.text.clear()
                email.requestFocus()
                phone.text.clear()

            } else {
                Toast.makeText(getApplicationContext(),"Entered Formats are incorrect,Please Check", Toast.LENGTH_SHORT).show();

            }
        }



    }

}