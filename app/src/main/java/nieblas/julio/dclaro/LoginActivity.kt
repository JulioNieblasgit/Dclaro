package nieblas.julio.dclaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import nieblas.julio.dclaro.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnEntrar.setOnClickListener{
            val rfc = binding.etRfc.text.toString()
            val contrasena = binding.etContrasena.text.toString()


            if(rfc.isNotEmpty() && contrasena.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(rfc,contrasena).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent: Intent = Intent(this, DeclaracionesPagadasActivity::class.java)
                        startActivity(intent)
                    }else{

                        //Crea un usuario con base a los campos de textos
                        /**
                         *  firebaseAuth.createUserWithEmailAndPassword(rfc,contrasena).addOnCompleteListener {
                        if(it.isSuccessful){
                        val intent: Intent = Intent(this, DeclaracionesPagadasActivity::class.java)
                        startActivity(intent)
                        }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()

                        }
                        }
                         */


                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
                }
            }

        }else{
                Toast.makeText(this, "Es necesario llenar los campos de texto.", Toast.LENGTH_LONG).show()
            }

        }
    }
}