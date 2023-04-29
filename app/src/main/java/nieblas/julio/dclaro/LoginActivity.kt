package nieblas.julio.dclaro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.btnEntrar.setOnClickListener {
            val rfc = binding.etRfc.text.toString()
            val contrasena = binding.etContrasena.text.toString()

            if (rfc.isNotEmpty() && contrasena.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(rfc, contrasena).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent: Intent = Intent(this, DeclaracionesPagadasActivity::class.java)
                        startActivity(intent)
                    } else {

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
                        Toast.makeText(
                            this,
                            "No se tiene registro de su cuenta.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

            } else {
                Toast.makeText(this, "Es necesario llenar los campos de texto.", Toast.LENGTH_LONG)
                    .show()
            }

        }


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googlesigninclient = GoogleSignIn.getClient(this, gso)

        val btn_entrarGoogle = findViewById<Button>(R.id.btn_entrarGoogle)
        btn_entrarGoogle.setOnClickListener {
            signInGoogle()
        }
    }

    private fun signInGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResults(task)
            }
        }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if (account != null) {
                updateUI(account)
            }
        } else {
            Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
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
}