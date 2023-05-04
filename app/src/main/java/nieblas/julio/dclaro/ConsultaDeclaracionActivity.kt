package nieblas.julio.dclaro

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


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
