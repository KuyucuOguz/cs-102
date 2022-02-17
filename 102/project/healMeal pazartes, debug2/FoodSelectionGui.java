

import java.sql.*;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Food Selection GUI Class:
 * @author Asım Bilal Ak, Barış Tan Ünal
 * @date 03.05.2021
 */
public class FoodSelectionGui extends javax.swing.JFrame {
    String user;
    /**
     * Creates new form FoodSelection
     */
    public FoodSelectionGui() {
        try{
            user = textReader();
        }
        catch(FileNotFoundException e){
            System.out.println("1");
        }
        FoodSelection foodSelection = new FoodSelection( user );
        initComponents();
        try{

            Class.forName( "com.mysql.jdbc.Driver" );
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://34.69.74.87:3306/food", "root", "20210406cp" );

            Statement statement1 = connect.createStatement();
            ResultSet resultset1 = statement1.executeQuery("SELECT * FROM food.mainCourse" );

            while( resultset1.next() ) {
                mainCourseBox.addItem(resultset1.getString( 1 ));
            }
            Statement statement2 = connect.createStatement();
            ResultSet resultset2 = statement2.executeQuery("SELECT * FROM food.breakfast" );

            while( resultset2.next() ) {
                breakfastBox.addItem(resultset2.getString( 1 ));
            }
            Statement statement3 = connect.createStatement();
            ResultSet resultset3 = statement3.executeQuery("SELECT * FROM food.drinks" );

            while( resultset3.next() ) {
                drinksBox.addItem(resultset3.getString( 1 ));
            }
            Statement statement4 = connect.createStatement();
            ResultSet resultset4 = statement4.executeQuery("SELECT * FROM food.fruits" );

            while( resultset4.next() ) {
                fruitBox.addItem(resultset4.getString( 1 ));
            }
            Statement statement5 = connect.createStatement();
            ResultSet resultset5 = statement5.executeQuery("SELECT * FROM food.desserts" );

            while( resultset5.next() ) {
                dessertBox.addItem(resultset5.getString( 1 ));
            }
            Statement statement6 = connect.createStatement();
            ResultSet resultset6 = statement6.executeQuery("SELECT * FROM food.soups" );

            while( resultset6.next() ) {
                soupBox1.addItem(resultset6.getString( 1 ));
            }

            connect.close();

        }
        catch( Exception e ) {
            System.out.println( e ) ;

        }

        ArrayList<Food> breakfastList;
        ArrayList<Food> lunchList;
        ArrayList<Food> dinnerList;

        breakfastList = foodSelection.recommendBreakfast();
        lunchList = foodSelection.recommendLunch();
        dinnerList = foodSelection.recommendDinner();

        breakfastLabel1.setText( breakfastList.get( 0 ).toString() );
        breakfastLabel2.setText( breakfastList.get( 1 ).toString() );
        breakfastLabel3.setText( breakfastList.get( 2 ).toString() );
        breakfastLabel4.setText( breakfastList.get( 3 ).toString() );
        breakfastLabel5.setText( breakfastList.get( 4 ).toString() );
        breakfastLabel6.setText( breakfastList.get( 5 ).toString() );

        if ( breakfastList.size() == 7 ) {
            breakfastLabel7.setText( breakfastList.get( 6 ).toString() );
        }
        else {
            breakfastLabel7.setText( "" );
        }

        lunchLabel1.setText( lunchList.get( 0 ).toString() );
        lunchLabel2.setText( lunchList.get( 1 ).toString() );
        lunchLabel3.setText( lunchList.get( 2 ).toString() );
        lunchLabel4.setText( lunchList.get( 3 ).toString() );

        dinnerLabel1.setText( dinnerList.get( 0 ).toString() );
        dinnerLabel2.setText( dinnerList.get( 1 ).toString() );
        dinnerLabel3.setText( dinnerList.get( 2 ).toString() );
        dinnerLabel.setText( dinnerList.get( 3 ).toString() );

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        breakfastBox = new javax.swing.JComboBox<>();
        mainCourseBox = new javax.swing.JComboBox<>();
        fruitBox = new javax.swing.JComboBox<>();
        dessertBox = new javax.swing.JComboBox<>();
        drinksBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        logButton = new javax.swing.JButton();
        breakfastLabel7 = new javax.swing.JLabel();
        lunchLabel4 = new javax.swing.JLabel();
        dinnerLabel = new javax.swing.JLabel();
        breakfastAmount = new javax.swing.JTextField();
        drinksAmount = new javax.swing.JTextField();
        dessertAmount = new javax.swing.JTextField();
        mainAmount = new javax.swing.JTextField();
        fruitsAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        mainButton = new javax.swing.JButton();
        energyButton = new javax.swing.JButton();
        activityButton = new javax.swing.JButton();
        foodButton = new javax.swing.JButton();
        waterButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        personalButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        breakfastLabel1 = new javax.swing.JLabel();
        breakfastLabel2 = new javax.swing.JLabel();
        breakfastLabel3 = new javax.swing.JLabel();
        breakfastLabel4 = new javax.swing.JLabel();
        breakfastLabel5 = new javax.swing.JLabel();
        breakfastLabel6 = new javax.swing.JLabel();
        lunchLabel1 = new javax.swing.JLabel();
        lunchLabel2 = new javax.swing.JLabel();
        lunchLabel3 = new javax.swing.JLabel();
        dinnerLabel1 = new javax.swing.JLabel();
        dinnerLabel2 = new javax.swing.JLabel();
        dinnerLabel3 = new javax.swing.JLabel();
        soupBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        soupAmount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(253, 224, 224));
        jPanel3.setLayout(null);

        breakfastBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Breakfast"}));
        breakfastBox.setToolTipText("");
        jPanel3.add(breakfastBox);
        breakfastBox.setBounds(20, 170, 130, 30);

        mainCourseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"MainCourse"}));
        mainCourseBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainCourseBoxActionPerformed(evt);
            }
        });
        jPanel3.add(mainCourseBox);
        mainCourseBox.setBounds(230, 170, 170, 30);

        fruitBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fruits" }));
        jPanel3.add(fruitBox);
        fruitBox.setBounds(230, 230, 170, 30);

        dessertBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desserts" }));
        jPanel3.add(dessertBox);
        dessertBox.setBounds(20, 290, 130, 30);

        drinksBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Drinks" }));
        jPanel3.add(drinksBox);
        drinksBox.setBounds(20, 230, 130, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("FOOD SECTION");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(400, 30, 216, 51);

        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LOG NEW MEAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N
        jPanel3.add(jSeparator1);
        jSeparator1.setBounds(10, 110, 490, 240);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel2.setText("DESSERT");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(20, 270, 70, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel5.setText("DRINKS");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 210, 60, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel6.setText("BREAKFAST");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 150, 90, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel7.setText("MAIN COURSE");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(240, 150, 106, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel8.setText("FRUITS");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(240, 210, 93, 17);

        jSeparator2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECOMMENDED MENU", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11))); // NOI18N
        jPanel3.add(jSeparator2);
        jSeparator2.setBounds(510, 110, 500, 270);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("DINNER");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(840, 130, 150, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("BREAKFAST");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(540, 130, 84, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("LUNCH");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(660, 130, 90, 30);

        logButton.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        logButton.setText("LOG");
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });
        jPanel3.add(logButton);
        logButton.setBounds(230, 360, 75, 23);

        breakfastLabel7.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        breakfastLabel7.setText("Rec break");
        jPanel3.add(breakfastLabel7);
        breakfastLabel7.setBounds(540, 340, 120, 30);

        lunchLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lunchLabel4.setText("Rec lunch");
        jPanel3.add(lunchLabel4);
        lunchLabel4.setBounds(660, 250, 180, 30);

        dinnerLabel.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        dinnerLabel.setText("Rec dinner");
        jPanel3.add(dinnerLabel);
        dinnerLabel.setBounds(840, 250, 200, 30);

        breakfastAmount.setText("0");
        jPanel3.add(breakfastAmount);
        breakfastAmount.setBounds(160, 170, 50, 30);

        drinksAmount.setText("0");
        drinksAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drinksAmountActionPerformed(evt);
            }
        });
        jPanel3.add(drinksAmount);
        drinksAmount.setBounds(160, 230, 50, 30);

        dessertAmount.setText("0");
        jPanel3.add(dessertAmount);
        dessertAmount.setBounds(160, 290, 50, 30);

        mainAmount.setText("0");
        mainAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainAmountActionPerformed(evt);
            }
        });
        jPanel3.add(mainAmount);
        mainAmount.setBounds(430, 170, 50, 30);

        fruitsAmount.setText("0");
        fruitsAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fruitsAmountActionPerformed(evt);
            }
        });
        jPanel3.add(fruitsAmount);
        fruitsAmount.setBounds(430, 230, 50, 30);

        jLabel3.setText("AMOUNT (g)");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(420, 150, 70, 20);

        jLabel4.setText("AMOUNT (g)");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(130, 150, 70, 14);

        jLabel13.setText("DATE:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(10, 360, 40, 20);

        dateField.setText("date (*//*)");
        dateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateFieldActionPerformed(evt);
            }
        });
        jPanel3.add(dateField);
        dateField.setBounds(60, 350, 110, 30);

        mainButton.setText("MAIN PAGE");
        mainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainButtonActionPerformed(evt);
            }
        });
        jPanel3.add(mainButton);
        mainButton.setBounds(0, 0, 100, 23);

        energyButton.setText("ENERGY TRACKER");
        energyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                energyButtonActionPerformed(evt);
            }
        });
        jPanel3.add(energyButton);
        energyButton.setBounds(100, 0, 140, 23);

        activityButton.setText("ACTIVITIY");
        activityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activityButtonActionPerformed(evt);
            }
        });
        jPanel3.add(activityButton);
        activityButton.setBounds(240, 0, 110, 23);

        foodButton.setText("FOOD");
        foodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodButtonActionPerformed(evt);
            }
        });
        jPanel3.add(foodButton);
        foodButton.setBounds(350, 0, 90, 23);

        waterButton.setText("WATER INTAKE");
        waterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterButtonActionPerformed(evt);
            }
        });
        jPanel3.add(waterButton);
        waterButton.setBounds(440, 0, 130, 23);

        historyButton.setText("HISTORY");
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });
        jPanel3.add(historyButton);
        historyButton.setBounds(570, 0, 110, 23);

        personalButton.setText("PERSONAL INFO");
        personalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalButtonActionPerformed(evt);
            }
        });
        jPanel3.add(personalButton);
        personalButton.setBounds(670, 0, 130, 23);

        settingsButton.setText("SETTINGS");
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });
        jPanel3.add(settingsButton);
        settingsButton.setBounds(800, 0, 110, 23);

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel3.add(backButton);
        backButton.setBounds(910, 0, 100, 23);

        breakfastLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        breakfastLabel1.setText("Rec break");
        jPanel3.add(breakfastLabel1);
        breakfastLabel1.setBounds(540, 160, 120, 30);

        breakfastLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        breakfastLabel2.setText("Rec break");
        jPanel3.add(breakfastLabel2);
        breakfastLabel2.setBounds(540, 190, 120, 30);

        breakfastLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        breakfastLabel3.setText("Rec break");
        jPanel3.add(breakfastLabel3);
        breakfastLabel3.setBounds(540, 220, 120, 30);

        breakfastLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        breakfastLabel4.setText("Rec break");
        jPanel3.add(breakfastLabel4);
        breakfastLabel4.setBounds(540, 250, 110, 30);

        breakfastLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        breakfastLabel5.setText("Rec break");
        jPanel3.add(breakfastLabel5);
        breakfastLabel5.setBounds(540, 280, 120, 30);

        breakfastLabel6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        breakfastLabel6.setText("Rec break");
        jPanel3.add(breakfastLabel6);
        breakfastLabel6.setBounds(540, 310, 120, 30);

        lunchLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lunchLabel1.setText("Rec lunch");
        jPanel3.add(lunchLabel1);
        lunchLabel1.setBounds(660, 160, 180, 30);

        lunchLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lunchLabel2.setText("Rec lunch");
        jPanel3.add(lunchLabel2);
        lunchLabel2.setBounds(660, 190, 180, 30);

        lunchLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lunchLabel3.setText("Rec lunch");
        jPanel3.add(lunchLabel3);
        lunchLabel3.setBounds(660, 220, 180, 30);

        dinnerLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        dinnerLabel1.setText("Rec dinner");
        jPanel3.add(dinnerLabel1);
        dinnerLabel1.setBounds(840, 160, 200, 30);

        dinnerLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        dinnerLabel2.setText("Rec dinner");
        jPanel3.add(dinnerLabel2);
        dinnerLabel2.setBounds(840, 190, 200, 30);

        dinnerLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        dinnerLabel3.setText("Rec dinner");
        jPanel3.add(dinnerLabel3);
        dinnerLabel3.setBounds(840, 220, 210, 30);

        soupBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soups" }));
        jPanel3.add(soupBox1);
        soupBox1.setBounds(230, 290, 180, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel12.setText("SOUPS");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(250, 260, 110, 30);

        soupAmount.setText("0");
        jPanel3.add(soupAmount);
        soupAmount.setBounds(430, 290, 50, 30);

        jLabel14.setText("TİME :");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(10, 400, 40, 14);

        timeLabel.setText("*.*");
        jPanel3.add(timeLabel);
        timeLabel.setBounds(60, 390, 110, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed

        FoodSelection foodSelection = new FoodSelection( "baris123" );

        try{

            if ( !( breakfastBox.getSelectedItem().toString().equalsIgnoreCase( "breakfast" ) ) ) {
                foodSelection.logFood( dateField.getText(), timeLabel.getText(), "breakfast",
                        breakfastBox.getSelectedItem().toString(), Double.parseDouble( breakfastAmount.getText() ) );
            }
            if ( !( mainCourseBox.getSelectedItem().toString().equalsIgnoreCase( "mainCourse" ) ) ) {
                foodSelection.logFood( dateField.getText(), timeLabel.getText(), "mainCourse",
                        mainCourseBox.getSelectedItem().toString(), Double.parseDouble( mainAmount.getText() ) );
            }
            if ( !( drinksBox.getSelectedItem().toString().equalsIgnoreCase( "drinks" ) ) ) {
                foodSelection.logFood( dateField.getText(), timeLabel.getText(), "drinks",
                        drinksBox.getSelectedItem().toString(), Double.parseDouble( drinksAmount.getText() ) );
            }
            if ( !( fruitBox.getSelectedItem().toString().equalsIgnoreCase( "fruits" ) ) ) {
                foodSelection.logFood( dateField.getText(), timeLabel.getText(), "fruits",
                        fruitBox.getSelectedItem().toString(), Double.parseDouble( fruitsAmount.getText() ) );
            }
            if ( !( dessertBox.getSelectedItem().toString().equalsIgnoreCase( "desserts" ) ) ) {
                foodSelection.logFood( dateField.getText(), timeLabel.getText(), "desserts",
                        dessertBox.getSelectedItem().toString(), Double.parseDouble( dessertAmount.getText() ) );
            }
            if ( !( soupBox1.getSelectedItem().toString().equalsIgnoreCase( "soups" ) ) ) {
                foodSelection.logFood( dateField.getText(), timeLabel.getText(), "soups",
                        soupBox1.getSelectedItem().toString(), Double.parseDouble( soupAmount.getText() ) );
            }

        }
        catch( Exception e ) {
            System.out.println( e ) ;
            
        }
        
    }

    private void mainCourseBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainCourseBoxActionPerformed
        
    }//GEN-LAST:event_mainCourseBoxActionPerformed

    private void drinksAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drinksAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drinksAmountActionPerformed

    private void mainAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainAmountActionPerformed

    private void fruitsAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fruitsAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fruitsAmountActionPerformed

    private void dateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateFieldActionPerformed

    private void mainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainButtonActionPerformed
        MainPageGui main = new MainPageGui();
        main.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_mainButtonActionPerformed

    private void energyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_energyButtonActionPerformed
        CalorieFrame frame = new CalorieFrame(user);
        frame.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_energyButtonActionPerformed

    private void activityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activityButtonActionPerformed
        ActivityFrame2 frame= new ActivityFrame2(user);
        frame.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_activityButtonActionPerformed

    private void foodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodButtonActionPerformed
        // nothing
    }//GEN-LAST:event_foodButtonActionPerformed

    private void waterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waterButtonActionPerformed
        WaterIntake water = new WaterIntake(user);
        water.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_waterButtonActionPerformed

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed
        History2frame hist = new History2frame();
        hist.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_historyButtonActionPerformed

    private void personalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalButtonActionPerformed
        PersonalInfo info = new PersonalInfo(user);
        info.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_personalButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        Settings set = new Settings();
        set.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_settingsButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        feedback back = new feedback();
        back.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FoodSelectionGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodSelectionGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodSelectionGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodSelectionGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodSelectionGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activityButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField breakfastAmount;
    private javax.swing.JComboBox<String> breakfastBox;
    private javax.swing.JLabel breakfastLabel1;
    private javax.swing.JLabel breakfastLabel2;
    private javax.swing.JLabel breakfastLabel3;
    private javax.swing.JLabel breakfastLabel4;
    private javax.swing.JLabel breakfastLabel5;
    private javax.swing.JLabel breakfastLabel6;
    private javax.swing.JLabel breakfastLabel7;
    private javax.swing.JTextField dateField;
    private javax.swing.JTextField dessertAmount;
    private javax.swing.JComboBox<String> dessertBox;
    private javax.swing.JLabel dinnerLabel;
    private javax.swing.JLabel dinnerLabel1;
    private javax.swing.JLabel dinnerLabel2;
    private javax.swing.JLabel dinnerLabel3;
    private javax.swing.JTextField drinksAmount;
    private javax.swing.JComboBox<String> drinksBox;
    private javax.swing.JButton energyButton;
    private javax.swing.JButton foodButton;
    private javax.swing.JComboBox<String> fruitBox;
    private javax.swing.JTextField fruitsAmount;
    private javax.swing.JButton historyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton logButton;
    private javax.swing.JLabel lunchLabel1;
    private javax.swing.JLabel lunchLabel2;
    private javax.swing.JLabel lunchLabel3;
    private javax.swing.JLabel lunchLabel4;
    private javax.swing.JTextField mainAmount;
    private javax.swing.JButton mainButton;
    private javax.swing.JComboBox<String> mainCourseBox;
    private javax.swing.JButton personalButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JTextField soupAmount;
    private javax.swing.JComboBox<String> soupBox1;
    private javax.swing.JTextField timeLabel;
    private javax.swing.JButton waterButton;
    // End of variables declaration//GEN-END:variables,
    public static String textReader() throws FileNotFoundException
    {
        File file = new File( "filename.txt" );
        Scanner scan = new Scanner( file );
        String name = scan.next();
        //String userPassword = scan.next();
        scan.close();
        return name;
    }           
}