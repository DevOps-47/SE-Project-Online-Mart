package pk.edu.iqra.onlinemart24_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.menu_header.*

class HomepageActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout:DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

//    fun for user logged validation
        User_Logged_Validation()


        btn_topdeal1.setOnClickListener{
            showToast("Pixal 4a")
        }

//for toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)

        val Toggle = ActionBarDrawerToggle (
            this, drawerLayout, toolbar, 0, 0
        )

        drawerLayout.addDrawerListener(Toggle)
        Toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

//        menu header - user image
//        btnuser_profile_navbar.setOnClickListener{
//            showToast("Add Image")
//        }

    }


    //    fun for user logged validation
    private fun User_Logged_Validation(){
//    check to see the user is logged or not
    val uid = FirebaseAuth.getInstance().uid
    if (uid == null){
        val intent = Intent(this, SignupActivity::class.java)
//     to clear the back stack
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        for menu
        when(item.itemId){

            R.id.Cat_items -> {
//                sub categories
                val intent = Intent(this, category::class.java)
                showToast("Categories")
                startActivity(intent)
            }
        }

        when(item.itemId){
            R.id.cat_cart -> {
                val intent = Intent(this, Cart::class.java)
                showToast("My Cart")
                startActivity(intent)
            }
        }

        when(item.itemId){

            R.id.cat_order -> {
                val intent = Intent(this, ItemList::class.java)
                showToast("Your Orders!")
                startActivity(intent)
            }
        }

        when(item.itemId){

            R.id.cat_Acc -> {
                showToast("Account Setting in Process")
            }
        }

        when(item.itemId){

            R.id.cat_E_Wallet -> {
                val intent = Intent(this, mywallet::class.java)
                showToast("My E-Wallet")
                startActivity(intent)
            }
        }

        when(item.itemId){

            R.id.cat_About -> {
                val intent = Intent(this, aboutUs::class.java)
                showToast("About Us")
                startActivity(intent)
            }
        }

//            for the user logout
        when(item.itemId){
            R.id.cat_Logout -> {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, MainActivity::class.java)
                showToast("Logout Successfully")
                startActivity(intent)
            }
        }
        return true
    }
}