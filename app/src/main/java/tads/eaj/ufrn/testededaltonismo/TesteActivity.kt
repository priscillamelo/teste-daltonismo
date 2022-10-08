package tads.eaj.ufrn.testededaltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.testededaltonismo.databinding.ActivityTesteBinding

class TesteActivity : AppCompatActivity() {

    lateinit var binding: ActivityTesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teste)
        intent.extras?.getInt("imagem")?.let { binding.img.setImageResource(it) }

        binding.btnOk.setOnClickListener {
            val intentMain = Intent()
            val bundle = Bundle()

            bundle.putString("RESPOSTA", binding.inputValor.text.toString())
            intentMain.putExtras(bundle)

            setResult(RESULT_OK, intentMain)
            finish()
        }

        binding.btnCancelar.setOnClickListener {
            Toast.makeText(this, "Teste cancelado", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
