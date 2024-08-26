import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.pdm.havagas.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeCompletoEt = findViewById<EditText>(R.id.nomeCompletoEt)
        val emailEt = findViewById<EditText>(R.id.emailEt)
        val receberEmailCb = findViewById<CheckBox>(R.id.receberEmailCb)
        val telefoneEt = findViewById<EditText>(R.id.telefoneEt)
        val tipoTelefoneRg = findViewById<RadioGroup>(R.id.tipoTelefoneRg)
        val adicionarCelularCb = findViewById<CheckBox>(R.id.adicionarCelularCb)
        val celularEt = findViewById<EditText>(R.id.celularEt)
        val sexoRg = findViewById<RadioGroup>(R.id.sexoRg)
        val dataNascimentoEt = findViewById<EditText>(R.id.dataNascimentoEt)
        val formacaoSp = findViewById<Spinner>(R.id.formacaoSp)
        val anoFormaturaEt = findViewById<EditText>(R.id.anoFormaturaEt)
        val instituicaoEt = findViewById<EditText>(R.id.instituicaoEt)
        val tituloMonografiaEt = findViewById<EditText>(R.id.tituloMonografiaEt)
        val orientadorEt = findViewById<EditText>(R.id.orientadorEt)
        val vagasInteresseEt = findViewById<EditText>(R.id.vagasInteresseEt)
        val salvarBt = findViewById<Button>(R.id.salvarBt)
        val limparBt = findViewById<Button>(R.id.limparBt)

        adicionarCelularCb.setOnCheckedChangeListener { _, isChecked ->
            celularEt.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    0, 1 -> {
                        anoFormaturaEt.visibility = View.VISIBLE
                        instituicaoEt.visibility = View.GONE
                        tituloMonografiaEt.visibility = View.GONE
                        orientadorEt.visibility = View.GONE
                    }
                    2, 3 -> {
                        anoFormaturaEt.visibility = View.VISIBLE
                        instituicaoEt.visibility = View.VISIBLE
                        tituloMonografiaEt.visibility = View.GONE
                        orientadorEt.visibility = View.GONE
                    }
                    4, 5 -> {
                        anoFormaturaEt.visibility = View.VISIBLE
                        instituicaoEt.visibility = View.VISIBLE
                        tituloMonografiaEt.visibility = View.VISIBLE
                        orientadorEt.visibility = View.VISIBLE
                    }
                    else -> {
                        anoFormaturaEt.visibility = View.GONE
                        instituicaoEt.visibility = View.GONE
                        tituloMonografiaEt.visibility = View.GONE
                        orientadorEt.visibility = View.GONE
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        salvarBt.setOnClickListener {
            val nome = nomeCompletoEt.text.toString()
            val email = emailEt.text.toString()
            val receberEmails = if (receberEmailCb.isChecked) "Sim" else "Não"
            val telefone = telefoneEt.text.toString()
            val tipoTelefone = findViewById<RadioButton>(tipoTelefoneRg.checkedRadioButtonId).text.toString()
            val celular = if (adicionarCelularCb.isChecked) celularEt.text.toString() else "Não adicionado"
            val sexo = findViewById<RadioButton>(sexoRg.checkedRadioButtonId).text.toString()
            val dataNascimento = dataNascimentoEt.text.toString()
            val formacao = formacaoSp.selectedItem.toString()
            val anoFormatura = anoFormaturaEt.text.toString()
            val instituicao = instituicaoEt.text.toString()
            val tituloMonografia = tituloMonografiaEt.text.toString()
            val orientador = orientadorEt.text.toString()
            val vagasInteresse = vagasInteresseEt.text.toString()

            val mensagem = """
                Nome: $nome
                E-mail: $email
                Receber e-mails: $receberEmails
                Telefone: $telefone ($tipoTelefone)
                Celular: $celular
                Sexo: $sexo
                Data de Nascimento: $dataNascimento
                Formação: $formacao
                Ano de Formatura: $anoFormatura
                Instituição: $instituicao
                Título da Monografia: $tituloMonografia
                Orientador: $orientador
                Vagas de Interesse: $vagasInteresse
            """.trimIndent()

            Toast.makeText(this@MainActivity, mensagem, Toast.LENGTH_LONG).show()
        }

        limparBt.setOnClickListener {
            nomeCompletoEt.text.clear()
            emailEt.text.clear()
            receberEmailCb.isChecked = false
            telefoneEt.text.clear()
            tipoTelefoneRg.clearCheck()
            adicionarCelularCb.isChecked = false
            celularEt.text.clear()
            sexoRg.clearCheck()
            dataNascimentoEt.text.clear()
            formacaoSp.setSelection(0)
            anoFormaturaEt.text.clear()
            instituicaoEt.text.clear()
            tituloMonografiaEt.text.clear()
            orientadorEt.text.clear()
            vagasInteresseEt.text.clear()

            celularEt.visibility = View.GONE
            anoFormaturaEt.visibility = View.GONE
            instituicaoEt.visibility = View.GONE
            tituloMonografiaEt.visibility = View.GONE
            orientadorEt.visibility = View.GONE
        }
    }
}
