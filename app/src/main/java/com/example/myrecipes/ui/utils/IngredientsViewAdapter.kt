package com.example.myrecipes.ui.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myrecipes.R
import com.example.myrecipes.model.Ingredient

class IngredientsViewAdapter(private val context: Context,
                             private val dataSource: MutableList<Ingredient>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.ingredient_list, parent, false)
        val nameTextView = rowView.findViewById(R.id.ingredientName) as TextView
        val countTextView = rowView.findViewById(R.id.ingredientCount) as TextView
        val unitTextView = rowView.findViewById(R.id.ingredientUnit) as TextView

        val ing = getItem(position) as Ingredient
        nameTextView.text = ing.name
        countTextView.text = ing.quantity.toString()
        unitTextView.text = ing.unit

        return rowView
    }

}