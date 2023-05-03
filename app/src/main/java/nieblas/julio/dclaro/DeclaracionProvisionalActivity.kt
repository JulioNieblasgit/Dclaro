package nieblas.julio.dclaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DeclaracionProvisionalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_declaracion_provisional)


        val btn_siguiente: Button = findViewById(R.id.btn_siguiente)
        btn_siguiente.setOnClickListener{
            val intent: Intent = Intent(this, ISRActivity::class.java)
            startActivity(intent)

        }
    }
}