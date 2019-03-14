package imc.sarahipina.com.imc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ImcFragment extends Fragment {
    private EditText mCampoPeso;
    private  EditText mCampoEstatura;
    private Button mBotonCalcular;
    private Button mBotonLimpiar;
    private TextView mImcTextView;
    private  TextView mEstadoNutricionalTextView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_imc,container, false);
        mCampoPeso=view.findViewById(R.id.campo_peso);
        mCampoEstatura= view.findViewById(R.id.campo_estatura);
        mBotonCalcular= view.findViewById(R.id.boton_calcular);
        mBotonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s= mCampoPeso.getText().toString();
                double peso=Double.parseDouble(s);
                s=mCampoEstatura.getText().toString();
                double estatura=Double.parseDouble(s);
                double imc = peso/Math.pow(estatura, 2);
                mImcTextView.setText(Double.toString(imc));
                if (imc<=18.5){
                    mEstadoNutricionalTextView.setText("Peso bajo");
                }else if (imc<=24.99){
                    mEstadoNutricionalTextView.setText("Peso normal");
                } else if (imc<=29.99){
                    mEstadoNutricionalTextView.setText("Sobrepeso");
                }else if (imc<= 39.99){
                    mEstadoNutricionalTextView.setText("Obesidad");
                } else {
                    mEstadoNutricionalTextView.setText("Obesidad extrema");
                }

            }
        });
        mBotonLimpiar=view.findViewById(R.id.boton_limpiar);
        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mImcTextView.setText("0.0");
                mEstadoNutricionalTextView.setText("");
            }
        });
        mImcTextView= view.findViewById(R.id.imc_text_view);
        mEstadoNutricionalTextView=view.findViewById(R.id.estado_nutricional_text_view);
        return view;
    }
}
