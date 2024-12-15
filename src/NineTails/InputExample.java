package NineTails;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        InputExample.java
 * Description  Example of an input for the Nine Tails problem.
 * Project      Project 4--Nine Tails Problem
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
 * Hourse       20 minutes
 * Date         1/26/2024
 * Histoly log  1/26/2024
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1%
 * @see     	javax.swing.JDialog
 *</pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class InputExample extends javax.swing.JDialog {
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor  InputExample()
     * Description  Forms the InputExample when called with no parameters
     * Date:        1/26/2024
     * Histroy Log: 1/26/2024
     * @author      <i>Robert Zimmerman</i>
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public InputExample() {
        initComponents();
        this.getRootPane().setDefaultButton(closeJButton); //Set default button
        //Set Icon
        this.setIconImage(Toolkit.getDefaultToolkit().  
                getImage("src/Images/NineTailsSmall.png"));   //Set icon
        this.setLocationRelativeTo(null);   //Center the dialog
        this.setResizable(false);   //Set the dialog non-resizable
        this.setModal(true);    //Set modal true
        setPicture(imageJLabel, "src/Images/", "InputExample");
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setPicture()
     * Description  Sets the city picture to the cityImageJLabel
     * Date         11/18/2023
     * History log  11/18/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       labelIn JLabel
     * @param       folderIn String
     * @param       nameIn String
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setPicture(JLabel labelIn, String folderIn, String nameIn)
    {
        String imagePath = folderIn + nameIn + ".png";
        labelIn.setIcon(new ImageIcon(imagePath));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageJLabel = new javax.swing.JLabel();
        closeJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        closeJButton.setText("Close");
        closeJButton.setToolTipText("Close the example image");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(closeJButton)
                .addContainerGap(340, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeJButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel imageJLabel;
    // End of variables declaration//GEN-END:variables
}
