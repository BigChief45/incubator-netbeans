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

package org.netbeans.modules.form;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * Dummy component used to visualize a bean
 * which class could not be loaded.
 *
 * @author Tomas Stupka
 */
public class InvalidComponent extends JPanel {

    private JLabel label = new JLabel();

    public InvalidComponent() {
        this.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.setLayout(new BorderLayout());
         
        label.setForeground(Color.RED);
        ResourceBundle bundle = FormUtils.getBundle();
        label.setText("<html><center>" + bundle.getString("CTL_LB_InvalidComponent") + "</center></html>"); // NOI18N
        add(label);                        
        
    }
        
}
