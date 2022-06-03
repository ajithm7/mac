package com.example.recycler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.ItemTouchHelper
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var list: ArrayList<String>
    private val callback: ItemTouchHelper.SimpleCallback =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Toast.makeText(
                    applicationContext,
                    "${list[viewHolder.adapterPosition]} removed successfully",
                    Toast.LENGTH_SHORT
                ).show()
                list.removeAt(viewHolder.adapterPosition)
                adapter.notifyDataSetChanged()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setUi()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUi() {
        Log.i(TAG, "setUi")
        recyclerView = findViewById(R.id.recyclerView)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        list = ArrayList()
        list.add("cricket")
        list.add("football")
        list.add("hockey")
        list.add("tennis")
        list.add("kabadi")
        list.add("bat")
        list.add("ball")
        list.add("coin")
        list.add("book")
        list.add("pen")
        list.add("plate")
        list.add("spoon")
        list.add("stick")
        list.add("wire")
        list.add("cricket")
        list.add("football")
        list.add("hockey")
        list.add("tennis")
        list.add("kabadi")
        list.add("bat")
        list.add("ball")
        list.add("coin")
        list.add("book")
        list.add("pen")
        list.add("plate")
        list.add("spoon")
        list.add("stick")
        list.add("wire")

        adapter = Adapter(list)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        ItemTouchHelper(callback).attachToRecyclerView(recyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        val item = menu?.findItem(R.id.search)
        val searchView = item?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val list1 = ArrayList<String>()
                if (newText!!.trim().isNotEmpty()) {
                    for (i in list) {
                        if (i.lowercase(Locale.getDefault())
                                .contains(newText.lowercase(Locale.getDefault()))
                        ) {
                            list1.add(i)
                        }
                    }
                } else {
                    list1.addAll(list)
                }
                adapter.updateList(list)
                return true
            }
        })
        return true
    }
}