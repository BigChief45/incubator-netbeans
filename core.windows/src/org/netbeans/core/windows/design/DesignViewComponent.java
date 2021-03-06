/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.core.windows.design;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.util.NbBundle;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.netbeans.core.windows.ModeImpl;
import org.openide.windows.WindowManager;

@ConvertAsProperties(
    dtd = "-//org.netbeans.core.windows.model//DesignViewComponent//EN",
    autostore = false
)
@TopComponent.Description(preferredID = "DesignViewComponentTopComponent",
    iconBase = "org/netbeans/core/windows/model/DesignView.png",
    persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED
)
final class DesignViewComponent extends TopComponent implements DocumentListener {
    DesignViewComponent() {
        initComponents();
        setName(NbBundle.getMessage(DesignViewComponent.class, "CTL_DesignViewComponentTopComponent"));
        setToolTipText(NbBundle.getMessage(DesignViewComponent.class, "HINT_DesignViewComponentTopComponent"));
        putClientProperty("TopComponentAllowDockAnywhere", true);
        refresh();
        modeName.getDocument().addDocumentListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeName = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        modeName.setText(org.openide.util.NbBundle.getMessage(DesignViewComponent.class, "DesignViewComponent.modeName.text", new Object[] {})); // NOI18N
        modeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 88, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(DesignViewComponent.class, "DesignViewComponent.jLabel1.text", new Object[] {})); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(modeName, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refresh() {
        Mode mode = WindowManager.getDefault().findMode(this);
        if (mode != null) {
            if (!modeName.getText().equals(mode.getName())) {
                modeName.setText(mode.getName());
            }
            setName(mode.getName());
        }
    }
    
    private void modeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeNameActionPerformed
        Mode mode = WindowManager.getDefault().findMode(this);
        if (mode instanceof ModeImpl) {
            ModeImpl mi = (ModeImpl)mode;
            mi.setModeName(modeName.getText());
        }

        for (TopComponent tc : mode.getTopComponents()) {
            if (tc instanceof DesignViewComponent) {
                DesignViewComponent dvc = (DesignViewComponent)tc;
                dvc.refresh();
            }
        }
    }//GEN-LAST:event_modeNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField modeName;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void componentOpened() {
        refresh();
    }

    @Override
    protected void componentActivated() {
        refresh();
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                modeNameActionPerformed(null);
            }
        });
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                modeNameActionPerformed(null);
            }
        });
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                modeNameActionPerformed(null);
            }
        });
    }
}
