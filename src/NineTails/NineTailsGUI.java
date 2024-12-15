package NineTails;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        NineTailsGUI.java
 * Description  Main form for running the application of solving a NineTails 
 *              problem with graph theory.
 * Project      Project 4 -- ine Tails Problem.
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
 * Course       CS 143
 * Hours        2 hours 45 minutes
 * Date         11/17/2023
 * @author	<i>Robert Zimmerman</i>
 * @version 	1.0.0
 *</pre>
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class NineTailsGUI extends javax.swing.JFrame {

    public String input = "";       //Hold the input from the user.
    public char[] startNode;        //Hold the intital node passed in.
    public StringBuffer output = new StringBuffer();
    public int numberOfNodes = 512;     //Number of nodes
    public NineTailsModel model;    //Nine tails class for all logic
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  NineTailsGUI - Default Constructor
     * Description  Defualt constructor for the NineTailsGUI class
     * Date:        11/17/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public NineTailsGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        ButtonGroup gridSizeGroup = new ButtonGroup();
        gridSizeGroup.add(threeJRadioButton);
        gridSizeGroup.add(fourJRadioButton);
        //Select radio button three
        threeJRadioButton.setSelected(true);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       displayPath()
     * Description  Runs the program when called by the SubmitActionPerformed,
     *              displays the information for the graph inc;uding all steps to
     *              the rich text field.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void displayPath() {
        output = new StringBuffer();
        infoJTextArea.setText("");
        setNodeCount(numberOfNodes);  //Set the number of nodes
        model = new NineTailsModel(numberOfNodes);
        int initialIndex = model.getIndex(startNode);
        List<Integer> path = model.bfsShortestPath(initialIndex);
        String temp = "";
        //Build the buffer
        temp = "The number of coin flips: " + (path.size() - 1) + "\n";
        output.append(temp);
        temp = "The steps to being solved were: \n";
        output.append(temp);
        for(int i = 0; i < path.size(); i++) {
            temp = model.printNode(model.getNode(
                    path.get(i)));
            output.append(temp);
        }
        infoJTextArea.setText(output.toString());
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setNodeCount()
     * Description  This functions sets the number of nodes based on user choice.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       nodes int
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setNodeCount(int nodes) {
        if(fourJRadioButton.isSelected()) {
            //Number of nodes in graph for 4x4 (2^(16))
            nodes = 65536;
        } else {
            //Number of nodes in graph for 3x3 (2^(9))
            nodes = 512;
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        inputJTextField = new javax.swing.JTextField();
        inputJLabel = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        quitJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoJTextArea = new javax.swing.JTextArea();
        threeJRadioButton = new javax.swing.JRadioButton();
        inputJLabel1 = new javax.swing.JLabel();
        fourJRadioButton = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        saveJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        quitJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();
        exampleJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleJLabel.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 51, 204));
        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NineTailsSmall.png"))); // NOI18N
        titleJLabel.setText("Nine Tails Problem");

        inputJTextField.setToolTipText("Enter a 9 character string of H and T characters");
        inputJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputJTextFieldKeyTyped(evt);
            }
        });

        inputJLabel.setText("Grid Size:");

        submitJButton.setText("Submit");
        submitJButton.setToolTipText("Submit the inputted string");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        quitJButton.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        quitJButton.setText("Quit");
        quitJButton.setToolTipText("Exit the program");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });

        infoJTextArea.setEditable(false);
        infoJTextArea.setColumns(20);
        infoJTextArea.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        infoJTextArea.setLineWrap(true);
        infoJTextArea.setRows(5);
        infoJTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(infoJTextArea);

        threeJRadioButton.setSelected(true);
        threeJRadioButton.setText("3x3");
        threeJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeJRadioButtonActionPerformed(evt);
            }
        });

        inputJLabel1.setText("Input first state:");

        fourJRadioButton.setText("4x4");
        fourJRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourJRadioButtonActionPerformed(evt);
            }
        });

        fileJMenu.setText("File");

        saveJMenuItem.setText("Save");
        saveJMenuItem.setToolTipText("Save the current solution");
        saveJMenuItem.setEnabled(false);
        fileJMenu.add(saveJMenuItem);

        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Print the form");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);

        quitJMenuItem.setText("Quit");
        quitJMenuItem.setToolTipText("Exit the program");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        jMenuBar1.add(fileJMenu);

        helpJMenu.setText("Help");

        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("Open the about page for more info");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        exampleJMenuItem.setText("Example Input");
        exampleJMenuItem.setToolTipText("View and example of inputting a value");
        exampleJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exampleJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(exampleJMenuItem);

        jMenuBar1.add(helpJMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(threeJRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fourJRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(submitJButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(inputJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitJButton)
                        .addGap(19, 19, 19)
                        .addComponent(inputJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(threeJRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourJRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       submitJButtonActionPerformed()
     * Description  Evaluates the entered value for initial grid pattern on
     *              submission.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        String message = "Error!";
        try {
            //Store the value of the inputJTextArea
            input = inputJTextField.getText().toUpperCase();
            if((input.length() != 9) && (threeJRadioButton.isSelected())) {
                message = "Input is not equal to 9 characters.";
                throw new IllegalArgumentException();
                
            } else if((input.length() != 16) && (fourJRadioButton.isSelected())) {
                message = "Input is not equal to 16 characters.";
                throw new IllegalArgumentException();
                
            } else {
                startNode = input.toCharArray();
                displayPath();
            }
        }
        catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, message, 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       quitJButtonActionPerformed()
     * Description  Closes the application.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       exampleJMenuItemActionPerformed()
     * Description  Shows an example image of what entered text will look like
     *              in grid form.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void exampleJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exampleJMenuItemActionPerformed
        InputExample example = new InputExample();
        example.setVisible(true);
    }//GEN-LAST:event_exampleJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       inputJTextFieldKeyTyped()
     * Description  Only allows T,t,H and h into the text field.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void inputJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputJTextFieldKeyTyped
        if((evt.getKeyChar() != 'T') && (evt.getKeyChar() != 'H') && 
                (evt.getKeyChar() != 't') && (evt.getKeyChar() != 'h')) {
            evt.consume();
        }
    }//GEN-LAST:event_inputJTextFieldKeyTyped
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       quitJMenuItemActionPerformed()
     * Description  Closes the application.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       printJMenuItemActionPerformed()
     * Description  Prints the current state of the application.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       aboutJMenuItemActionPerformed()
     * Description  Opens an About window for more information about the 
     *              applicaton.
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        About aboutWindow = new About(null, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       threeJRadioButtonActionPerformed()
     * Description  Sets the number of nodes to 512 (2^9).
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void threeJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeJRadioButtonActionPerformed
        numberOfNodes = 512;
    }//GEN-LAST:event_threeJRadioButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       fourJRadioButtonActionPerformed()
     * Description  Sets the number of nodes to 65536 (2^16).
     * Date         11/17/2023
     * History      11/17/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void fourJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourJRadioButtonActionPerformed
        numberOfNodes = 65536;
    }//GEN-LAST:event_fourJRadioButtonActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NineTailsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenuItem exampleJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JRadioButton fourJRadioButton;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JTextArea infoJTextArea;
    private javax.swing.JLabel inputJLabel;
    private javax.swing.JLabel inputJLabel1;
    private javax.swing.JTextField inputJTextField;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JButton quitJButton;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JButton submitJButton;
    private javax.swing.JRadioButton threeJRadioButton;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
