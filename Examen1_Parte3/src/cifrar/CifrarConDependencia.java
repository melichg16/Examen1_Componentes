package cifrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import texto.Encripta;
public class CifrarConDependencia {
    private Encripta encripta;

    public void setEncripta (Encripta ptxt){
        this.encripta= ptxt;
    }

    public String runE( String texto){
        //String s = "ejemplo";

        return encripta.encriptar(texto);
    }

    public String runD(String texto){
        String s = "OXYBAZJ";

        return encripta.desencriptar(texto);
    }


}
