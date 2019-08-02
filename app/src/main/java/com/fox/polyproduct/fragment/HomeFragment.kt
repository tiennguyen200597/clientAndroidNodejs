package com.fox.polyproduct.fragment

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fox.polyproduct.R
import com.fox.polyproduct.adapter.ProductAdapter
import com.fox.polyproduct.model.Product
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import org.json.JSONArray
import org.json.JSONObject






class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var myDataset: ArrayList<Product> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: View = inflater.inflate(R.layout.fragment_home, container, false)
        var hc = HttpConnect()
        hc.execute()
        viewManager = LinearLayoutManager(context)
        viewAdapter = ProductAdapter(myDataset)
        recyclerView = view.findViewById<RecyclerView>(R.id.re_productsList).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

        return view
    }

    //
    inner class HttpConnect : AsyncTask<Void, Void, String>() {
        private val server: String = "http://10.22.207.150:8080/api/app-product"
        private lateinit var result: String

        override fun doInBackground(vararg p0: Void?): String? {
            try {
                val url = URL(server)
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                val inputStreamReader = InputStreamReader(connection.inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                val stringBuilder = StringBuilder()
                var readLine: String? = null
                while ({ readLine = bufferedReader.readLine();readLine }() != null) {
                    stringBuilder.append(readLine)
                }
                result = stringBuilder.toString()
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e("Error", e.toString())
            }
            return result
        }


        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            var jsonarray = JSONArray(result)
            for (i in 0 until jsonarray.length()) {
                val jsonobject = jsonarray.getJSONObject(i)
                val name = jsonobject.getString("name")
                val price = jsonobject.getString("price")
                val description = jsonobject.getString("decription")
                var product1: Product = Product(name, price, description)
                myDataset.add(product1)
            }
        }

    }
}