/*
 * Copyright 2011 CISIAD, UNED, Spain Licensed under the European Union Public
 * Licence, version 1.1 (EUPL) Unless required by applicable law, this code is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OF ANY KIND.
 */

package org.openmarkov.dbgenerator.gui;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.io.FilenameUtils;
import org.openmarkov.core.gui.configuration.OpenMarkovPreferences;
import org.openmarkov.core.gui.dialog.io.FileFilterElv;
import org.openmarkov.core.gui.dialog.io.FileFilterPGMX;
import org.openmarkov.core.gui.dialog.io.NetsIO;
import org.openmarkov.core.gui.loader.element.OpenMarkovLogoIcon;
import org.openmarkov.core.gui.localize.StringResource;
import org.openmarkov.core.gui.localize.StringResourceLoader;
import org.openmarkov.core.gui.plugin.ToolPlugin;
import org.openmarkov.core.gui.window.MainPanel;
import org.openmarkov.core.gui.window.edition.NetworkPanel;
import org.openmarkov.core.learning.io.CaseDatabase;
import org.openmarkov.core.learning.io.CaseDatabaseWriter;
import org.openmarkov.core.model.network.ProbNet;
import org.openmarkov.dbgenerator.DBGenerator;
import org.openmarkov.dbgenerator.io.FileFilterArff;
import org.openmarkov.dbgenerator.io.FileFilterDbc;
import org.openmarkov.dbgenerator.io.FileFilterXls;
import org.openmarkov.learning.io.DatabaseWriterFactory;

/**
 * GUI to the DBGenerator option
 * @author fjdiez
 * @author ibermejo
 * @version 1.0
 * @since OpenMarkov 1.0
 */
@SuppressWarnings("serial")
@ToolPlugin(name = "DBGenerator", command = "Tools.DBGenerator")
public class DBGeneratorGUI extends javax.swing.JDialog
{
    private ProbNet        net;
    private String         databasePath        = null;
    private String         netFilePath         = null;
    private String         fileName            = null;
    private CaseDatabaseWriter databaseWriter = null;
    /**
     * Directory where the dialog box searches the files.
     */
    private String  directoryPath       = System.getProperty ("user.home");
    /**
     * Messages string resource.
     */
    private StringResource stringResource;
    private StringResource generatorStringResource;
    private JFrame         parent;

    /**
     * Constructor for DBGeneratorGUI.
     * @param parent
     */
    public DBGeneratorGUI (JFrame parent)
    {
        super (parent, true);
        this.parent = parent;
        stringResource = StringResourceLoader.getUniqueInstance ().getBundleMessages ();
        generatorStringResource = StringResourceLoader.getUniqueInstance ().getBundle ("DBGenerator");
        try
        {
            UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName ());
            initComponents ();
            setIconImage (OpenMarkovLogoIcon.getUniqueInstance ().getOpenMarkovLogoIconImage16 ());
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger (DBGeneratorGUI.class.getName ()).log (Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            Logger.getLogger (DBGeneratorGUI.class.getName ()).log (Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            Logger.getLogger (DBGeneratorGUI.class.getName ()).log (Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger (DBGeneratorGUI.class.getName ()).log (Level.SEVERE, null, ex);
        }
        setDefaultCloseOperation (HIDE_ON_CLOSE);
        setLocationRelativeTo (null);
        netButtonGroup = new ButtonGroup ();
        netButtonGroup.add (fromFileRadioButton);
        netButtonGroup.add (fromOpenMarkovRadioButton);
        boolean isOpenNet = MainPanel.getUniqueInstance ().getMainPanelListenerAssistant ().getCurrentNetworkPanel () != null;
        if(isOpenNet)
        {
			net = MainPanel.getUniqueInstance().getMainPanelListenerAssistant()
					.getCurrentNetworkPanel().getProbNet();
        }
        fromOpenMarkovRadioButton.setEnabled (isOpenNet);
        fromOpenMarkovRadioButton.setSelected (isOpenNet);
        fromFileRadioButton.setSelected (!isOpenNet);
        loadNetButton.setEnabled (!isOpenNet);
        setVisible (true);
    }

    private ProbNet loadNet (String filePath)
    {
        ProbNet probNet = null;
        if ((netFilePath != null) && (!netFilePath.equals ("")))
        {
            if (!isSupportedNetFormat (fileName))
            {
                JOptionPane.showMessageDialog (null,
                                               generatorStringResource.getString ("DBGenerator.IncorrectFileFormat"),
                                               stringResource.getString ("ErrorWindow.Title.Label"),
                                               JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                try
                {
                    probNet = NetsIO.openNetworkFile (filePath).getProbNet ();
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog (null,
                                                   generatorStringResource.getString ("DBGenerator.UnableToLoadNet"),
                                                   stringResource.getString ("ErrorWindow.Title.Label"),
                                                   JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace ();
                }
            }
        }
        return probNet;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        caseFileChooser = new javax.swing.JFileChooser();
        netFileChooser = new javax.swing.JFileChooser();
        netButtonGroup = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        fromFileRadioButton = new javax.swing.JRadioButton();
        fromOpenMarkovRadioButton = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        netFilePathTextPane = new javax.swing.JTextPane();
        loadNetButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dbFileTextPane = new javax.swing.JTextPane();
        saveAsButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        generateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        caseNumber = new javax.swing.JSpinner();

        caseFileChooser.addChoosableFileFilter(new FileFilterArff());
        caseFileChooser.addChoosableFileFilter(new FileFilterDbc());
        caseFileChooser.addChoosableFileFilter(new FileFilterXls());
        caseFileChooser.setFileFilter(caseFileChooser.getAcceptAllFileFilter());
        caseFileChooser.setCurrentDirectory(new File(directoryPath));

        netFileChooser.addChoosableFileFilter(new FileFilterElv());
        netFileChooser.addChoosableFileFilter(new FileFilterPGMX());
        netFileChooser.setFileFilter(netFileChooser.getAcceptAllFileFilter());
        netFileChooser.setCurrentDirectory(new File(directoryPath));
        netFileChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OpenMarkov - DBGenerator");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose net"));

        fromFileRadioButton.setText("Open from file");
        fromFileRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromFileRadioButtonActionPerformed(evt);
            }
        });

        fromOpenMarkovRadioButton.setText("Use open net");
        fromOpenMarkovRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromOpenMarkovRadioButtonActionPerformed(evt);
            }
        });

        netFilePathTextPane.setEditable(false);
        netFilePathTextPane.setEnabled(false);
        jScrollPane5.setViewportView(netFilePathTextPane);

        loadNetButton.setText("Open");
        loadNetButton.setEnabled(false);
        loadNetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadNetButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(fromFileRadioButton)
                        .add(18, 18, 18)
                        .add(loadNetButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 297, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(fromOpenMarkovRadioButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(fromOpenMarkovRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(fromFileRadioButton)
                        .add(loadNetButton)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Database"));

        dbFileTextPane.setEditable(false);
        dbFileTextPane.setEnabled(false);
        jScrollPane2.setViewportView(dbFileTextPane);

        saveAsButton.setText("Save as...");
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Database:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(38, 38, 38)
                .add(saveAsButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 321, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel1)
                        .add(saveAsButton))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        generateButton.setText("Generate");
        generateButton.setEnabled(false);
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(99, 23));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Number of cases"));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(99, 99, 99)
                .add(caseNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .add(caseNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(generateButton)
                        .add(18, 18, 18)
                        .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(176, 176, 176))))
        );

        layout.linkSize(new java.awt.Component[] {cancelButton, generateButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(generateButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.getAccessibleContext().setAccessibleName("Select net");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * It asks the user to choose a file by means of a open-file dialog box.
     * @return complete path of the file, or null if the user selects cancel.
     */
    private String requestNetworkFileToOpen ()
    {
        netFileChooser.setDialogTitle (stringResource.getString ("OpenNetwork.Title.Label"));
        File currentDirectory = new File (
                                          OpenMarkovPreferences.get (OpenMarkovPreferences.LAST_OPEN_DIRECTORY,
                                                                     OpenMarkovPreferences.OPENMARKOV_DIRECTORIES,
                                                                     "."));
        netFileChooser.setCurrentDirectory (currentDirectory);
        String filePath = (netFileChooser.showOpenDialog (this.parent) == JFileChooser.APPROVE_OPTION) ? netFileChooser.getSelectedFile ().getAbsolutePath ()
                                                                                                  : null;
        if (filePath != null)
        {
            directoryPath = netFileChooser.getSelectedFile ().getParent ();
            fileName = netFileChooser.getSelectedFile ().getName ();
            netFilePathTextPane.setText (filePath);
        }
        return filePath;
    }

    private void cancelButtonActionPerformed (java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible (false);
    }// GEN-LAST:event_cancelButtonActionPerformed

    private void generateButtonActionPerformed (java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_EvaluateButtonActionPerformed
    	
    	DBGenerator dbGenerator = new DBGenerator();
    	CaseDatabase database = dbGenerator.generate(net, ((Integer)caseNumber.getValue()));
    	
    	try {
			databaseWriter.save(databasePath, database);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(
					null, generatorStringResource.getString("DBGenerator.Error"),  
					stringResource.getString("ErrorWindow.Title.Label"), 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
    	this.setVisible (false);
        
    }// GEN-LAST:event_EvaluateButtonActionPerformed

    private void fromOpenMarkovRadioButtonActionPerformed (java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_fromOpenMarkovRadioButtonActionPerformed
        if (fromOpenMarkovRadioButton.isSelected ())
        {
            NetworkPanel networkPanel = MainPanel.getUniqueInstance ().getMainPanelListenerAssistant ().getCurrentNetworkPanel ();
            net = networkPanel.getProbNet ();
        }
    }// GEN-LAST:event_fromOpenMarkovRadioButtonActionPerformed

    private void loadNetButtonActionPerformed (java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_loadModelNetButtonActionPerformed
        netFilePath = requestNetworkFileToOpen ();
        if(netFilePath != null)
        {
            net = loadNet (netFilePath);
            generateButton.setEnabled (net != null);
        }
    }// GEN-LAST:event_loadModelNetButtonActionPerformed

    private void fromFileRadioButtonActionPerformed (java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_fromFileRadioButton1ActionPerformed
        if (netFilePath == null)
        {
            netFilePath = requestNetworkFileToOpen ();
            if(netFilePath != null)
            {
                net = loadNet (netFilePath);
            }
        }
        if (netFilePath != null)
        {
            loadNetButton.setEnabled (fromFileRadioButton.isSelected ());
            generateButton.setEnabled (net != null);
        }
    }// GEN-LAST:event_fromFileRadioButton1ActionPerformed

    private void saveAsButtonActionPerformed (java.awt.event.ActionEvent evt)
    {// GEN-FIRST:event_loadCaseFileButtonActionPerformed
        if (caseFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
        	String filename = caseFileChooser.getSelectedFile ().getName ();
        	databaseWriter = DatabaseWriterFactory.getWriter (FilenameUtils.getExtension (filename));
            if(databaseWriter == null){
            	JOptionPane.showMessageDialog(
    					null, generatorStringResource.getString("DBGenerator.IncorrectCaseDatabaseFileFormat"),  
    					stringResource.getString("ErrorWindow.Title.Label"), 
    					JOptionPane.ERROR_MESSAGE);
            }else{
                dbFileTextPane.setText (filename);
                generateButton.setEnabled (net != null);
                databasePath =  caseFileChooser.getSelectedFile ().getPath();
            }        	
        }
    }// GEN-LAST:event_loadCaseFileButtonActionPerformed

    /**
     * @param path
     * @return whether a file format is supported or not
     */
    private static boolean isSupportedNetFormat (String path)
    {
        return (FilenameUtils.getExtension (path).toLowerCase ().equals ("elv")
                || FilenameUtils.getExtension (path).toLowerCase ().equals ("xml") || FilenameUtils.getExtension (path).toLowerCase ().equals ("pgmx"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton cancelButton;
    private static javax.swing.JFileChooser caseFileChooser;
    private javax.swing.JSpinner caseNumber;
    private static javax.swing.JTextPane dbFileTextPane;
    private static javax.swing.JRadioButton fromFileRadioButton;
    private static javax.swing.JRadioButton fromOpenMarkovRadioButton;
    private static javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private static javax.swing.JButton loadNetButton;
    private javax.swing.ButtonGroup netButtonGroup;
    private static javax.swing.JFileChooser netFileChooser;
    private static javax.swing.JTextPane netFilePathTextPane;
    private javax.swing.JButton saveAsButton;
    // End of variables declaration//GEN-END:variables
}
