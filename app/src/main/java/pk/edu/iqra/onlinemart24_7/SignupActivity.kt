package pk.edu.iqra.onlinemart24_7

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

            //        to get text
            val eml = Utils.getText(ed_signup_email)
            val usr = Utils.getText(ed_signup_username)
            val phn = Utils.getText(ed_signup_phone)
            val cnc = Utils.getText(ed_signup_cnic)
            val psw = Utils.getText(ed_signup_password)

            //          to validate null fields
            if (Utils.validate(eml, usr, phn, cnc, psw)){
                showToast("SignUp Successfully!")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else {
                showToast("Please fill all the empty fields!")
            }
        }
    }
}