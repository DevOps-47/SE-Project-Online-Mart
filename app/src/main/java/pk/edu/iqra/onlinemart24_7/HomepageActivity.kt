package pk.edu.iqra.onlinemart24_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.main_navigation_drawer.*
import kotlinx.android.synthetic.main.menu_toolbar.*

class HomepageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

//    fun for user logged validation
        User_Logged_Validation()

//        for side menu bar btn
        Menu.setOnClickListener{
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
            showToast("In-Progess")
        }

////for logout btn
//        btn_logout.setOnClickListener{
////            code to do
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
}