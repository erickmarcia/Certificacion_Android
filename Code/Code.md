# Uso Second Activity
# Pasar Datos

// main activity
fun callToSecondActivity(view: View){

val name: String = userName.text.toString()

// creo el objeto Intent
var myIntent = Intent(this, SecondActivity::class.java)

// Le agrego los datos que deseo enviar a la otra actividad
myIntent.putExtra("PARAMETER_NAME", name)


// lanzo el Intent
startActivity(myIntent)

} 
- 
- 
- 
- 
- 
// Second Activity
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_second)

var datoRecibido = intent.getStringExtra("PARAMETER_NAME")

tvDatoRecibido.text = datoRecibido
} 