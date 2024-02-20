import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class TextEditor extends javax.swing.JFrame {
    public TextEditor() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linkedList = new LinkedList();
        jButtonUndo = new javax.swing.JButton();
        jButtonRedo = new javax.swing.JButton();
        jButtonFind = new javax.swing.JButton();
        jButtonReplace = new javax.swing.JButton();
        txtField = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        openItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonUndo.setText("Undo");

        jButtonRedo.setText("Redo");

        jButtonFind.setText("Find");

        jButtonReplace.setText("Replace");

        txtField.setText("Find and Replace");
        txtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFieldFocusGained();
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                jTextAreaTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                jTextAreaTextChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                jTextAreaTextChanged();
            }
        });
        jScrollPane.setViewportView(jTextArea);

        jMenu.setText("File");
        openItem.setText("Open");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed();
            }
        });
        jMenu.add(openItem);
        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed();
            }
        });
        jMenu.add(saveItem);
        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed();
            }
        });
        jMenu.add(exitItem);
        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonUndo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRedo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtField, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReplace)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUndo)
                    .addComponent(jButtonRedo)
                    .addComponent(jButtonFind)
                    .addComponent(jButtonReplace)
                    .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitItemActionPerformed() {//GEN-FIRST:event_exitItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void openItemActionPerformed() {//GEN-FIRST:event_openItemActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                jTextArea.setText(content.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_openItemActionPerformed



    private void txtFieldFocusGained() {//GEN-FIRST:event_txtFieldFocusGained
        
    }//GEN-LAST:event_txtFieldFocusGained

    private void jTextAreaTextChanged() {//GEN-FIRST:event_jTextAreaTextChanged
        linkedList.insert(jTextArea.getText());
        linkedList.print();
    }//GEN-LAST:event_jTextAreaTextChanged

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
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LinkedList linkedList;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JButton jButtonFind;
    private javax.swing.JButton jButtonRedo;
    private javax.swing.JButton jButtonReplace;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables
}
