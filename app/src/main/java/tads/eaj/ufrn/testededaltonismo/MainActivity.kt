package tads.eaj.ufrn.testededaltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.testededaltonismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var teste = Teste(" ", " ", " ", -1)

    val setRes1 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            binding.resposta?.res1 = result.data!!.getStringExtra("RESPOSTA").toString()
            Log.i("RESPOSTA1", teste.res1)
        }
    }

    val setRes2 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            teste.res2 = result.data!!.getStringExtra("RESPOSTA").toString()
            Log.i("RESPOSTA2", teste.res2)
        }
    }

    val setRes3 = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == RESULT_OK){
            teste.res3 = result.data!!.getStringExtra("RESPOSTA").toString()
            Log.i("RESPOSTA3", teste.res3)
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.resposta = teste

        val intent = Intent(this, TesteActivity::class.java)
        val bundle = Bundle()

        binding.btnteste1.setOnClickListener {
            bundle.putInt("imagem", R.drawable.teste2)
            intent.putExtras(bundle)

            setRes1.launch(intent)
        }

        binding.btnteste2.setOnClickListener {
            bundle.putInt("imagem", R.drawable.teste10)
            intent.putExtras(bundle)

            setRes2.launch(intent)
        }

        binding.btnteste3.setOnClickListener {
            bundle.putInt("imagem", R.drawable.teste74)
            intent.putExtras(bundle)

            setRes3.launch(intent)
        }

        binding.btnverificar.setOnClickListener{
            val resultado = teste.respostaFinal()

            when (resultado) {
                -1 -> {
                    Toast.makeText(this, "Finalize todos os testes para ter um resultado final!", Toast.LENGTH_SHORT).show()
                }
                1 -> {
                    Toast.makeText(this, "Teste Finalizado. Sua visão está boa!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Sua visão não está boa. Procure um médico!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}