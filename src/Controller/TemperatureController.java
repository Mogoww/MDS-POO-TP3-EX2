package Controller;

import Model.TemperatureModel;
import Vue.TemperatureVue;
import Vue.TemperatureVueTermometre;

interface ModifieTemperature {
    public double augmenteDegres(double temp);
    public double diminueDegres(double temp);
}

class ModifieTemperaturePlus1 implements ModifieTemperature {
    public double augmenteDegres(double temp) {
        return temp + 1;
    }
    public double diminueDegres(double temp) {
        return temp - 1;
    }
}
public class TemperatureController {
    private TemperatureModel model;
    private TemperatureVue view = null;
    private TemperatureVueTermometre  viewTermometre = null;
    private ModifieTemperature modtemp = new ModifieTemperaturePlus1();
    public TemperatureController(TemperatureModel m) {
        model = m;
    }

    public void augmenteDegresC() {
        model.setC(modtemp.augmenteDegres(model.getC()));
        controle();
    }

    public void diminueDegresC(){
        model.setC(modtemp.diminueDegres(model.getC()));
        controle();
    }

    public void fixeDegresC(double tempC){
        model.setC(tempC);
        controle();
    }

    public void augmenteDegresF() {
        model.setF(modtemp.augmenteDegres(model.getF()));
        controle();
    }

    public void diminueDegresF(){
        model.setF(modtemp.diminueDegres(model.getF()));
        controle();
    }

    public void fixeDegresF(double tempF){
        model.setF(tempF);
        controle();
    }

    public void controle() {
        if (view != null) {
            if (model.getC() > 40.0){
                view.enableWarningColor();
            }else {
                view.disableWarningColor();
            }
        }
    }
    public void addView(TemperatureVue v) {
        view = v;
    }
    public void addViewTermometre(TemperatureVueTermometre v) {
        viewTermometre = v;
    }
}
