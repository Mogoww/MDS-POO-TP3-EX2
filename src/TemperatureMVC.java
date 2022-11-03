import Controller.TemperatureController;
import Model.TemperatureModel;
import Vue.TemperatureVueCelsuis;
import Vue.TemperatureVueFarenheit;
import Vue.TemperatureVueTermometre;

public class TemperatureMVC {

    public TemperatureMVC() {
        TemperatureModel tempmod = new TemperatureModel();
        TemperatureController tempcontrolC = new TemperatureController(tempmod);
        TemperatureController tempcontrolF = new TemperatureController(tempmod);
        TemperatureVueCelsuis pvc = new TemperatureVueCelsuis(tempmod, tempcontrolC, 100, 200);
        TemperatureVueTermometre pvt = new TemperatureVueTermometre("Thermometre fara ", tempmod, tempcontrolF, 100, 200);
        TemperatureVueFarenheit tvf = new TemperatureVueFarenheit(tempmod, tempcontrolF, 100, 350);
        tempcontrolC.addView(pvc);
        tempcontrolF.addView(tvf);




    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureMVC();
            }
        });
    }
}
