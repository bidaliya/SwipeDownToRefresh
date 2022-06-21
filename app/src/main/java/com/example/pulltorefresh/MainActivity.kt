package com.example.pulltorefresh

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


class MainActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.refresh_layout)
        supportActionBar?.title = "                    Convin Assignment"

        val list = ArrayList<String>()

        //first we refresh our empty list
        val items = refresh(list)

        // Create a reference of the recycler view
        val recyclerView:RecyclerView = findViewById(R.id.recycler_view)
        // create the adapter class and its members
        val adapter = Item_adpater(items, this)
        recyclerView.adapter =  adapter
        // set the layout of the recycler view
        recyclerView.layoutManager = LinearLayoutManager(this)

        // swipe to refresh functionality
        val swipe = findViewById<SwipeRefreshLayout>(R.id.swipe_layout)
        //
        swipe.setOnRefreshListener {
            //update the data
            refresh(items)
            //notify the adapter about the data changes
            adapter.notifyDataSetChanged()
            //stop refreshing when task completed
            swipe.isRefreshing = false
        }

    }

    private fun refresh(items: ArrayList<String>): ArrayList<String> {
        for (i in 0 until 5 ){
            // adding 5 elements on each swipe up
            items.add("Item no ${items.size + 1}")
        }
        return items
    }
}
