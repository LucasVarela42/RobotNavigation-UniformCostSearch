/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.main;

import br.edu.ifsc.robotnavigation.controller.RobotNavigationController;
import br.edu.ifsc.robotnavigation.view.RobotNavigationFrame;

/**
 *
 * @author Lucas
 */
public class RobotNavigationApp {

    public static void main(String[] args) {

        RobotNavigationFrame view = new RobotNavigationFrame();

        new RobotNavigationController(view);

        view.setVisible(true);

    }
}
