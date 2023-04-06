package com.example.listadapterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapterexample.Adapter
import com.example.listadapterexample.Item
import com.example.listadapterexample.ItemDecoration

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter= Adapter(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recView)

        val p1 = Item(1,"J", "Java")
        val p2 = Item(2,"S", "Scala")
        val p3 = Item(3,"P", "Python")
        adapter.submitList(listOf(p1,p2,p3))

        recyclerView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        val largePadding = resources.getDimensionPixelSize(R.dimen.updown_product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.side_product_grid_spacing_small)
        recyclerView.addItemDecoration(ItemDecoration(largePadding,smallPadding))
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val p4 = Item(1,"J", "Java")
            val p5 = Item(4,"R", "Rust")
            val p3 = Item(5,"S", "SQL")
            val p6 = Item(6,"K", "Kotlin")
            adapter.submitList(listOf(p5,p3,p4,p6))

        },4000)
    }
}