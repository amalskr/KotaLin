package com.ceylonapz.kotalin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var userList: ArrayList<String> = ArrayList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


        val fullWeight = toAdd(10, 25);
        //sample_text.text = stringFromJNI() + fullWeight
        basic();
        maps()
        ranges()
        trys()


        //add Users
        addUsers()

        //create vertical layout manager
        usersRecycler.layoutManager = LinearLayoutManager(this)
        //multiple colums
        //usersRecycler.layoutManager = GridLayoutManager(this, 2);

        //access adapter
        usersRecycler.adapter = UserAdapter(this, userList)
    }

    private fun addUsers() {
        userList.add("Amal")
        userList.add("Kamal")
        userList.add("Nimal")
        userList.add("Namal")
        userList.add("Ajmal")
        userList.add("Nirmal")
        userList.add("Supumal")
        userList.add("Rajmal")
        userList.add("Sunimal")
    }

    private fun trys() {

        try {
            val myVar: Int = 12;
            val v: String = "Tutorialspoint.com";
            v.toInt();
        } catch (e: Exception) {
            e.printStackTrace();
        } finally {
            println("Exception Handeling in Kotlin");
        }

    }

    private fun ranges() {
        for (i in 1..5) {
            println("Num " + i) //1 2 3 4 5
        }

        for (i in 5 downTo 1) {
            println("Num d " + i) //5 4 3 2 1
        }


        for (i in 1..5 step 2) {
            println("Num s " + i) //1 3 5
        }

        for (i in 1 until 5) {
            println("Num u " + i) // 1 2 3 4 no5
        }

    }

    fun basic() {
        val id = 10
        val name = "Amal"
        var weg = 25.5f
        var heg = 55.5
        var isSingle = false

        println("User Data : " + id)
        println("User Data : " + name)
        println("User Data : " + weg)
        println("User Data : " + heg)
        println("User Data : " + isSingle)
    }

    fun maps() {
        var names: MutableList<String> = mutableListOf("A", "B", "C")

        var nameList: List<String> = names
        println("DATA_LIST " + nameList)

        names.add("D")
        println("DATA_LIST " + nameList)

        val list = listOf('a', 'b', 'c')
        println(list.size) // 3
        println(list.indexOf('b')) // 1
        println(list[2]) // c
    }


    fun toAdd(age: Int, weight: Int): Int {
        println("For Demo sout")
        return age + weight;
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
