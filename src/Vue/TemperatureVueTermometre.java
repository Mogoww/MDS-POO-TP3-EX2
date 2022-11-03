package Vue;

import Controller.TemperatureController;
import Model.TemperatureModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class TemperatureVueTermometre implements Observer {
    private String label;
    protected TemperatureModel model;
    protected TemperatureController controller;
    private JFrame temperatureJFrame;

    private JSlider slider = new JSlider(JSlider.VERTICAL, -100, 100, 0);



    public TemperatureVueTermometre(String label, TemperatureModel model, TemperatureController controller, int posX, int posY){
        this.label = label;
        this.model = model;
        this.controller = controller;
        temperatureJFrame = new JFrame(label);
        temperatureJFrame.add(slider, BorderLayout.CENTER);
        temperatureJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.addObserver(this);
        // display pourcentage
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        // start at controller value
        slider.setValue((int) model.getC());

        temperatureJFrame.setSize(200, 400);
        temperatureJFrame.setLocation(posX, posY);
        temperatureJFrame.setVisible(true);


        // TODO: add listeners
        slider.addChangeListener(e -> {
            controller.fixeDegresC(slider.getValue());
        });


    }





    protected TemperatureModel model() {
        return model;
    }

    @Override
    public void update(Observable o, Object arg) {
        slider.setValue((int) model().getC());
    }
}
