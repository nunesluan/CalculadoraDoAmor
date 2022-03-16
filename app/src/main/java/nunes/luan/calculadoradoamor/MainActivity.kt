package nunes.luan.calculadoradoamor

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import model.Person
import model.RandomNumber

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNameOne: EditText
    private lateinit var editTextNameTwo: EditText
    private lateinit var buttonOk: Button
    private lateinit var buttonClear: Button
    private lateinit var textViewResult: TextView
    private lateinit var textViewMessage: TextView
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var buttonStop: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializing()
        play(R.raw.song)


        buttonOk.setOnClickListener {
            val person = Person(editTextNameOne.text.toString(), editTextNameTwo.text.toString())
            if (person.name!!.isEmpty())
                toast("${resources.getText(R.string.toast_error_message_one)}")
            else if (person.nameTwo!!.isEmpty()) {
                toast("${resources.getText(R.string.toast_error_message_two)}")
            }
            else {
                val randomNumber = RandomNumber().generateRandomNumber()
                textViewResult.text = randomNumber.toString() + "%"
                if (randomNumber > 50) {
                    textViewMessage.text = resources.getText(R.string.message_maior_cinquenta)
                } else {
                    textViewMessage.text = resources.getText(R.string.message_menor_cinquenta)
                }
            }


        }

        buttonClear.setOnClickListener {
            clear()
        }

        buttonStop.setOnClickListener {
            stop()
        }

    }

    fun initializing() {
        editTextNameOne = findViewById(R.id.editTextName)
        editTextNameTwo = findViewById(R.id.editTextName2)
        buttonOk = findViewById(R.id.buttonOk)
        buttonClear = findViewById(R.id.buttonClear)
        textViewResult = findViewById(R.id.textViewResult)
        textViewMessage = findViewById(R.id.textViewMessage)
        buttonStop = findViewById(R.id.buttonStop)

    }

    private fun clear() {
        textViewResult.text = null
        editTextNameOne.text = null
        editTextNameTwo.text = null
        textViewMessage.text = null
    }

    fun toast(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG ).show()
    }

    fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(this@MainActivity, sound)
        mediaPlayer.start()
    }

    fun stop() {
        if(mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
    }

}


