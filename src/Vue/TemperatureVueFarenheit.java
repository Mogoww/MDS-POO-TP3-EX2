package Vue;

import Controller.TemperatureController;
import Model.TemperatureModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class TemperatureVueFarenheit extends TemperatureVue {

    public TemperatureVueFarenheit(TemperatureModel modele, TemperatureController controleur, int posX, int posY) {
        super("Temperature￿Farenheit",modele, controleur, posX, posY);
        setDisplay(""+model.getF());
        addUpListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.augmenteDegresF();
            }
        });
        addDownListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.diminueDegresF();
            }
        });
        addDisplayListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double tempF = getDisplay();
                controller.fixeDegresF(tempF);
            }});
    }

    public void update(Observable s, Object o) {
        setDisplay(""+model.getF());
    }
}
