package lat.pam.utsproject

import android.content.Intent
import android.net.wifi.p2p.WifiP2pManager.ExternalApproverRequestListener
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    val EXTRA_MESSAGE = "lat.pam.utdproject.orderactivity.extra.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val txtMenu = findViewById<TextView>(R.id.etFoodName)
        val txtServing = findViewById<EditText>(R.id.etServings)
        val txtName = findViewById<EditText>(R.id.etName)
        val txtNotes = findViewById<EditText>(R.id.etNotes)
        val btnSubmit = findViewById<Button>(R.id.btnOrder)

        txtMenu.text = "Tahu"
        txtServing.setText("1")
        txtName.setText("Aldy")
        txtNotes.setText("Tidak pedas")

        btnSubmit.setOnClickListener(View.OnClickListener {
            val intentorder = Intent(this,ConfirmationActivity::class.java)
            val message1 = txtMenu.text.toString()
            val message2 = txtServing.text.toString()

            Log.d(EXTRA_MESSAGE, message1)
            intentorder.putExtra(EXTRA_MESSAGE, message1)
            startActivity(intentorder)
        })



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}