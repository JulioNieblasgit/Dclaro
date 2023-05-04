package nieblas.julio.dclaro

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class ConsultaDeclaracionActivity : AppCompatActivity() {

    private lateinit var usuario: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_declaracion)

        val bundle = intent.extras
        var nameTxt: TextView = findViewById(R.id.tv_rfc)
        var emailTxt: TextView = findViewById(R.id.tv_campoRfc)

        if (bundle != null) {
            val name = bundle.getString("name")
            val email = bundle.getString("email")

            nameTxt.text = name
            emailTxt.text = email
        } else {
            nameTxt.text = usuario.currentUser?.email.toString()
            emailTxt.text = usuario.currentUser?.email.toString()
        }

    }
}
