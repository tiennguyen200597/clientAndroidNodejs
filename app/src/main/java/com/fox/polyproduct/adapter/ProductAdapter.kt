package com.fox.polyproduct.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fox.polyproduct.R
import com.fox.polyproduct.model.Product
import kotlinx.android.synthetic.main.product_item.view.*

//class ProductAdapter(context: Context, arrayListDetails:ArrayList<Product>) : BaseAdapter(){
//
//    private val layoutInflater: LayoutInflater
//    private val arrayListDetails:ArrayList<Product>
//
//    init {
//        this.layoutInflater = LayoutInflater.from(context)
//        this.arrayListDetails=arrayListDetails
//    }
//
//    override fun getCount(): Int {
//        return arrayListDetails.size
//    }
//
//    override fun getItem(position: Int): Any {
//        return arrayListDetails.get(position)
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
//        val view: View?
//        val listRowHolder: ListRowHolder
//        if (convertView == null) {
//            view = this.layoutInflater.inflate(R.layout.product_item, parent, false)
//            listRowHolder = ListRowHolder(view)
//            view.tag = listRowHolder
//        } else {
//            view = convertView
//            listRowHolder = view.tag as ListRowHolder
//        }
//
//        listRowHolder.tvName.text = arrayListDetails.get(position).name
//        listRowHolder.tvPrice.text = arrayListDetails.get(position).price
//        listRowHolder.tvDescription.text = arrayListDetails.get(position).description
//        return view
//    }
//}
//
//private class ListRowHolder(row: View?) {
//    public val tvName: TextView
//    public val tvPrice: TextView
//    public val tvDescription: TextView
//
//
//    init {
//        this.tvName = row?.findViewById<TextView>(R.id.tvName) as TextView
//        this.tvPrice = row?.findViewById<TextView>(R.id.tvPrire) as TextView
//        this.tvDescription = row?.findViewById<TextView>(R.id.tvDescription) as TextView
//        //this.linearLayout = row?.findViewById<LinearLayout>(R.id.linearLayout) as LinearLayout
//    }
//}
class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private var data : List<Product>

    constructor(data : List<Product>) : super() {
        this.data = data
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ProductHolder {
        return ProductHolder(
            LayoutInflater.from(viewGroup.context).inflate(
                R.layout.product_item,
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductHolder, i: Int) {
        holder.tvName.text = "Name : " +data[i].name
        holder.tvPrire.text = "Price : " + data[i].price
        holder.tvDescription.text = "Description : " + data[i].description
        //holder.tvExample.text = data[i].KOTOBA_EXAMPLE
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data.size
    }

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.tvName
        var tvPrire : TextView = itemView.tvPrire
        var tvDescription : TextView = itemView.tvDescription
        //var tvExample : TextView = itemView.tvExample

    }

}