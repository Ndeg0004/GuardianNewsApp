package com.example.cst2335finalproject


import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val item_selected = "item"
    val item_position = "position"
    val item_id = "id"
    val article_title = "title"
    val web_url = "web_url"
    val activity = "activity"
    var articles: ArrayList<String>? = null

    var list: ListView? = null
    var search: EditText? = null
    var list_adapter: MyListAdapter? = null
    var json: JSONObject? = null
    var article_data: JSONArray? = null
    var url: URL? = null
    var guardian: Guardian? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        //constant toolbar
        val myToolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(myToolbar)
        supportActionBar?.title = "Guardian News";


        // Your onCreate logic here
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation item selection here
        return true
    }

    companion object {
        const val item_selected = "item"
        const val item_position = "position"
        const val item_id = "id"
        const val article_title = "title"
        const val web_url = "web_url"
        const val activity = "activity"
    }
}