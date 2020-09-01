package pk.edu.iqra.onlinemart24_7

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // to launch signin activity
        btnRegistered.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


//to validate all the null fields in signup form and after signup Intent to signin activity
        btn_signup.setOnClickListener{
//          calling SignUpAuth fun
            SignUpAuth()
        }
    }



//    fun for signup authentication using firebase
    private fun SignUpAuth() {

//            to get text
    val eml = Utils.getText(ed_signup_email)
    val usr = Utils.getText(ed_signup_username)
    val phn = Utils.getText(ed_signup_phone)
    val cnc = Utils.getText(ed_signup_cnic)
    val psw = Utils.getText(ed_signup_password)

//            to validate null fields
    if (Utils.validate(eml, usr, phn, cnc, psw)){
//                showToast("SignUp Successfully!")
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)

//                firebase authentication using email and password-sign In activity
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(eml, psw)
            .addOnCompleteListener{
                //result, if isn't successful to create user account it return default activity with return message!
                if(!it.isSuccessful) return@addOnCompleteListener

//                    else if successful
                Log.d("SignUp", "Successfully created account with uid: ${it.result?.user?.uid}")
                showToast("Account Created Successfully!")

//                        after signup intent to sign in form
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
//                  message for  the unsuccessful account creation
//                  lambda expression
            .addOnFailureListener{
                Log.d("SignUp", "Failed To Create Account, ${it.message}")
                showToast("Failed To Create Account, ${it.message}")
            }
    }
    else {
        showToast("Please fill all the empty fields!")
    }
}

}