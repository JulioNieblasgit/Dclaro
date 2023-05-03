package nieblas.julio.dclaro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import nieblas.julio.dclaro.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googlesigninclient = GoogleSignIn.getClient(this, gso)
        googlesigninclient.signOut()

        fun updateUI(account: GoogleSignInAccount) {
            val credencial = GoogleAuthProvider.getCredential(account.idToken, null)
            firebaseAuth.signInWithCredential(credencial).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent: Intent = Intent(this, DeclaracionesPagadasActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "No se pudo acceder a la cuenta de Google",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }

        fun handleResults(task: Task<GoogleSignInAccount>) {
            if (task.isSuccessful) {
                val account: GoogleSignInAccount? = task.result
                if (account != null) {
                    updateUI(account)
                }
            } else {
                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        val launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    handleResults(task)
                }
            }

        fun signInGoogle() {
            val signInIntent = googleSignInClient.signInIntent
            launcher.launch(signInIntent)
        }


        //Al momento de hacer click se validaran los datos del campo de texto

        binding.btnEntrar.setOnClickListener {
            val rfc = binding.etRfc.text.toString()
            val contrasena = binding.etContrasena.text.toString()

            //Valida campos de texto, que no se encuentren vacios
            if (rfc.isNotEmpty() && contrasena.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(rfc, contrasena).addOnCompleteListener {
                    //Si tuvo exito pasa a la otra pantalla
                    if (it.isSuccessful) {
                        val intent: Intent = Intent(this, DeclaracionesPagadasActivity::class.java)
                        startActivity(intent)
                    } else {

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
                        //Mensaje de error
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }

            } else {
                Toast.makeText(this, "Es necesario llenar los campos de texto.", Toast.LENGTH_LONG)
                    .show()
            }

        }
    }


}