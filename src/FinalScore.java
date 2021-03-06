/***************************************************************
* file: FinalScore.java
* authors: Garrick Lee, Paul Chiou, Gabriel Talavera
* class: CS 245 – Programming Graphical User Interfaces
*
* assignment: Quarter Project
* date last modified: 01/31/2016
*
* purpose: JPanel for FinalScore, displays final score and End button
*
****************************************************************/ 
public class FinalScore extends javax.swing.JPanel {

    /**
     * Creates new form Credits
     */
    public FinalScore() {
        initComponents();
        jButton1.setToolTipText("<html>Click to return to Main Menu</html>");
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
        jLabel1 = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelTitle2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setText("End");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(MainFrm.getUserName() + "....." + MainFrm.getScore());

        jLabelTitle.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(222, 0, 0));
        jLabelTitle.setText("Your Score");

        if(MainFrm.isHighScore == true)
        jLabelTitle2.setVisible(true);
        else
        jLabelTitle2.setVisible(false);
        jLabelTitle2.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        jLabelTitle2.setForeground(new java.awt.Color(255, 255, 0));
        jLabelTitle2.setText("New HIGH SCORE!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 165, Short.MAX_VALUE)
                .addComponent(jLabelTitle)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabelTitle2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelTitle)
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabelTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        //MainFrm.setScore(0);
        MainFrm.displayMenu();
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelTitle2;
    // End of variables declaration//GEN-END:variables
}
