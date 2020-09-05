package pk.edu.iqra.onlinemart24_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
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

//        for side menu bar btn
//        Menu.setOnClickListener{
//            showToast("In Progess")
//        }

////for logout btn
//        btn_logout.setOnClickListener{
////            code to do
//        }

//        btn_logout.setOnClickListener{
//            showToast("Logout")
//        }


//        txtmycart_navbar.setOnClickListener{
//            showToast("My Cart")
//            Log.d("Homepage", "My cart is pressed!")
//        }

//        btn_topdeal1.setOnClickListener{
//            showToast("Pixal 4a")
//        }

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
                showToast("Categories")
            }
        }

        when(item.itemId){
            R.id.cat_cart -> {
                val intent = Intent(this, Cart::class.java)
                startActivity(intent)
                showToast("My Cart")
            }
        }

        when(item.itemId){

            R.id.cat_order -> {
                val intent = Intent(this, ItemList::class.java)
                startActivity(intent)
                showToast("Your Orders!")
            }
        }

        when(item.itemId){

            R.id.cat_Acc -> {
                showToast("Account Setting")
            }
        }

        when(item.itemId){

            R.id.cat_E_Wallet -> {
                showToast("My E-Wallet")
            }
        }

        when(item.itemId){

            R.id.cat_About -> {
                val intent = Intent(this, aboutUs::class.java)
                startActivity(intent)
                showToast("About Us")
            }
        }

        when(item.itemId){

            R.id.cat_Logout -> {
                showToast("Logout")
            }
        }
        return true
    }
}