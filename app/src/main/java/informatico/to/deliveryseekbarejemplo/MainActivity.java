package informatico.to.deliveryseekbarejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    /*Creamos las variables de las clases*/
    EditText nombrepedido;
    TextView cantipedido;
    SeekBar cantseek;
    TextView resultado;
    Button btnpedir;
    Integer cant_pedido=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*ACTIVAMOS PARA QUE MUESTRE EL ICONO DE ACTION BAR*/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        /*llamamos al icono creado en la carpeta drawable*/
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
        /*Enlazamos los controles con las variables*/
        nombrepedido=(EditText)findViewById(R.id.edtencargadopedido);
        cantipedido=(TextView)findViewById(R.id.tvcantidad);
        cantseek=(SeekBar)findViewById(R.id.seekBarcantidad);
        resultado=(TextView)findViewById(R.id.tvresultado);
        btnpedir=(Button)findViewById(R.id.btnpedir);
        /*Indicamos que el textview cantidad capture el movimiento del seekbar*/
        cantipedido.setText(" "+cantseek.getProgress());
        /*Indicamos los valores minimos del seekbar  */
        cantseek.setMax(10);
        /*Indicamos los valores minimos del textview  */
        nombrepedido.setMaxEms(14);
        /*creamos los metodo del seekbar*/
        cantseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cantipedido.setText(" "+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /*creamos el metodo directamanete del button realizar pedido*/
        btnpedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cant_pedido=cantseek.getProgress();
                resultado.setText(nombrepedido.getText() +"  quiere  " + cant_pedido.toString() + " Sandwichs / Cafe  ");
            }
        });
    }
}