package com.example.segundoparcialmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DBConnectionActivity : AppCompatActivity() {
    private val bookTitle: EditText
        get() = findViewById(R.id.pt_title)
    private val bookDescription: EditText
        get() = findViewById(R.id.pt_description)
    private val btnSaveDataBase: Button
        get() = findViewById(R.id.btn_savedatabase)
    private val btnShowDataBase: Button
        get() = findViewById(R.id.btn_showdatabase)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbconnection)


        btnSaveDataBase.setOnClickListener{
            GlobalScope.launch {
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)

                repository.insert(Book(bookTitle.text.toString(), bookDescription.text.toString()))
            }
        }

        btnShowDataBase.setOnClickListener{
            GlobalScope.launch {
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)

                val list = repository.getListBooks()
                list.forEach{
                    Log.d("DBTEST", "Id book = ${it.id}, Title: ${it.title}, Desc: ${it.description}")
                }
            }
        }
    }
}