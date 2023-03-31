package com.example.segundoparcialmovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DBConnectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbconnection)

        GlobalScope.launch {
            val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
            val repository = BookRepository(bookDao)
            repository.insert(Book("Cien años de soledad", "Libro de Gabriel Garcia Marquez"))
            val list = repository.getListBooks()
            list.forEach{
                Log.d("DBTEST", "Id book = ${it.id}, Title: ${it.title}, Desc: ${it.description}")
            }
        }
    }
}