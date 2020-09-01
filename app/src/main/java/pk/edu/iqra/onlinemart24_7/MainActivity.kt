package pk.edu.iqra.onlinemart24_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signin.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // to launch signup activity
        btnNotRegistered.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


//to validate all the null fields in signin form and after signin Intent to homepage activity

        btnsignin.setOnClickListener{
            //        to get text
            val eml = Utils.getText(ed_signin_Email)
            val psw = Utils.getText(ed_signin_Password)

            //  to validate null fields
            if (Utils.validate(eml, psw)){
                showToast("SignIn Successfully!")
                val intent2 = Intent(this, HomepageActivity::class.java)
                startActivity(intent2)
            }
            else {
                showToast("Please fill all the empty fields!")
            }
        }
    }
}