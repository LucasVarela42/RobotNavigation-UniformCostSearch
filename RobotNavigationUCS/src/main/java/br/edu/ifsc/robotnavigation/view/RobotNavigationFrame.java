/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.robotnavigation.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author Lucas
 */
public class RobotNavigationFrame extends javax.swing.JFrame {

    /**
     * Creates new form RobotNavigationFrame
     */
    public RobotNavigationFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanelControl = new javax.swing.JPanel();
        jButtonStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerSize = new javax.swing.JSpinner();
        jButtonGenerate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelCostValue = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelExplored = new javax.swing.JLabel();
        jLabelGenerated = new javax.swing.JLabel();
        jComboBoxAlgorithm = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelVisited = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelGrid = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robot Navigation");

        jPanelControl.setToolTipText("");

        jButtonStart.setText("Start");
        jButtonStart.setEnabled(false);
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jLabel1.setText("Grid size:");

        jSpinnerSize.setModel(new javax.swing.SpinnerNumberModel(5, 5, null, 1));

        jButtonGenerate.setText("Generate");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jLabel2.setText("Cost:");

        jLabelCostValue.setText("-");

        jLabel3.setText("Explored:");

        jLabel4.setText("Generated:");

        jLabelExplored.setText("-");

        jLabelGenerated.setText("-");

        jComboBoxAlgorithm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grafo", "Arvore" }));

        jLabel5.setText("Algorithm:");

        jLabel6.setText("Visited:");

        jLabelVisited.setText("-");

        javax.swing.GroupLayout jPanelControlLayout = new javax.swing.GroupLayout(jPanelControl);
        jPanelControl.setLayout(jPanelControlLayout);
        jPanelControlLayout.setHorizontalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelControlLayout.createSequentialGroup()
                        .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelControlLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelExplored))
                            .addGroup(jPanelControlLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelGenerated))
                            .addGroup(jPanelControlLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCostValue))
                            .addGroup(jPanelControlLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerSize, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanelControlLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelVisited)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelControlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonGenerate, jButtonStart, jComboBoxAlgorithm});

        jPanelControlLayout.setVerticalGroup(
            jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAlgorithm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(3, 3, 3)
                .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelControlLayout.createSequentialGroup()
                        .addComponent(jButtonGenerate)
                        .addGap(3, 3, 3)
                        .addComponent(jButtonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelControlLayout.createSequentialGroup()
                        .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabelCostValue))
                        .addGap(3, 3, 3)
                        .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabelExplored))
                        .addGap(3, 3, 3)
                        .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabelGenerated))
                        .addGap(3, 3, 3)
                        .addGroup(jPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabelVisited))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelControlLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonGenerate, jComboBoxAlgorithm});

        getContentPane().add(jPanelControl, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setBorder(null);

        jPanelGrid.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigation"));
        jPanelGrid.setAutoscrolls(true);
        jPanelGrid.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(jPanelGrid);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RobotNavigationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RobotNavigationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RobotNavigationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RobotNavigationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RobotNavigationFrame().setVisible(true);
            }
        });
    }

    /**
     *
     * @return
     */
    public JButton getjButtonStart() {
        return jButtonStart;
    }

    /**
     *
     * @param jButtonStart
     */
    public void setjButtonStart(JButton jButtonStart) {
        this.jButtonStart = jButtonStart;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanelControl() {
        return jPanelControl;
    }

    /**
     *
     * @param jPanelControl
     */
    public void setjPanelControl(JPanel jPanelControl) {
        this.jPanelControl = jPanelControl;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanelGrid() {
        return jPanelGrid;
    }

    /**
     *
     * @param jPanelGrid
     */
    public void setjPanelGrid(JPanel jPanelGrid) {
        this.jPanelGrid = jPanelGrid;
    }

    /**
     *
     * @return
     */
    public JSpinner getjSpinnerSize() {
        return jSpinnerSize;
    }

    /**
     *
     * @param jSpinnerSize
     */
    public void setjSpinnerSize(JSpinner jSpinnerSize) {
        this.jSpinnerSize = jSpinnerSize;
    }

    /**
     *
     * @return
     */
    public JButton getjButtonGenerate() {
        return jButtonGenerate;
    }

    /**
     *
     * @param jButtonGenerate
     */
    public void setjButtonGenerate(JButton jButtonGenerate) {
        this.jButtonGenerate = jButtonGenerate;
    }

    /**
     *
     * @return
     */
    public JComboBox<String> getjComboBoxAlgorithm() {
        return jComboBoxAlgorithm;
    }

    /**
     *
     * @param jComboBoxAlgorithm
     */
    public void setjComboBoxAlgorithm(JComboBox<String> jComboBoxAlgorithm) {
        this.jComboBoxAlgorithm = jComboBoxAlgorithm;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabelCostValue() {
        return jLabelCostValue;
    }

    /**
     *
     * @param jLabelCostValue
     */
    public void setjLabelCostValue(JLabel jLabelCostValue) {
        this.jLabelCostValue = jLabelCostValue;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabelExplored() {
        return jLabelExplored;
    }

    /**
     *
     * @param jLabelExplored
     */
    public void setjLabelExplored(JLabel jLabelExplored) {
        this.jLabelExplored = jLabelExplored;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabelGenerated() {
        return jLabelGenerated;
    }

    /**
     *
     * @param jLabelGenerated
     */
    public void setjLabelGenerated(JLabel jLabelGenerated) {
        this.jLabelGenerated = jLabelGenerated;
    }

    /**
     *
     * @return
     */
    public JLabel getjLabelVisited() {
        return jLabelVisited;
    }

    /**
     *
     * @param jLabelVisited
     */
    public void setjLabelVisited(JLabel jLabelVisited) {
        this.jLabelVisited = jLabelVisited;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JComboBox<String> jComboBoxAlgorithm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCostValue;
    private javax.swing.JLabel jLabelExplored;
    private javax.swing.JLabel jLabelGenerated;
    private javax.swing.JLabel jLabelVisited;
    private javax.swing.JPanel jPanelControl;
    private javax.swing.JPanel jPanelGrid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerSize;
    // End of variables declaration//GEN-END:variables
}
