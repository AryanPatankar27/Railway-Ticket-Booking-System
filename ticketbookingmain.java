/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

// Inside your class...

/**
 *
 * @author Rahul Vijayan
 */
public class Reservation extends javax.swing.JFrame {
    private Object jLabel12;
    private Font Font;
    private PopupMenu jLabel10;
    private Color Color;
    private PopupMenu date;
    private Amenityratings amenityRatings;

    // ...

    private final JComboBox<String> startComboBox;
    private final JComboBox<String> destinationComboBox;
    private final javax.swing.JButton historyAndAnalyticsButton;

    public Reservation() {
        initComponents();
        Connect();
        this.getContentPane().setBackground(Color.CYAN);

        // Initialize JComboBox instances
        startComboBox = new JComboBox<>();
        destinationComboBox = new JComboBox<>();

        // You can add items to the JComboBox components if needed
        startComboBox.addItem("Option 1");
        startComboBox.addItem("Option 2");
        // Add more items as needed

        destinationComboBox.addItem("Destination 1");
        destinationComboBox.addItem("Destination 2");
        // Add more items as needed

        // Initialize the "Travel History and Analytics" button
        historyAndAnalyticsButton = new javax.swing.JButton();
        historyAndAnalyticsButton.setText("Travel History and Analytics");
        historyAndAnalyticsButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyAndAnalyticsButtonActionPerformed(evt);
            }

            private void historyAndAnalyticsButtonActionPerformed(ActionEvent evt) {
                throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
                                                                               // choose Tools | Templates.
            }
        });
    }

    /**
     * Creates new form Reservation
     */

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/railwaydetails", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Train_Details.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Train_Details.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void LoadStartPlace() {
        try {
            pst = con.prepareStatement("SELECT startPlace From traindetails");
            rs = pst.executeQuery();
            startComboBox.removeAllItems();

            while (rs.next()) {
                startComboBox.addItem(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void LoadDestinationPlace() {
        try {
            pst = con.prepareStatement("SELECT destinationPlace From traindetails");
            rs = pst.executeQuery();
            destinationComboBox.removeAllItems();

            while (rs.next()) {
                destinationComboBox.addItem(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void load() {
        String StartPlace = startComboBox.getSelectedItem().toString();
        String DestinationPlace = destinationComboBox.getSelectedItem().toString();

        try {
            pst = con.prepareStatement("SELECT * FROM traindetais where startPlace = ? and destinationPlace = ?");

            pst.setString(1, StartPlace);
            pst.setString(2, DestinationPlace);

            rs = pst.executeQuery();

            if (rs.next() == true) {
                trainid.setText(rs.getString(1));
                trainname.setText(rs.getString(2));
                price.setText(rs.getString(5));
            }

            else {
                JOptionPane.showMessageDialog(this, "Record not Found!!!!!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /*
     * 
     * 
     * // <editor-fold defaultstate="collapsed" desc="Generated Code">
     * private void initComponents() {
     * 
     * jLabel2 = new javax.swing.JLabel();
     * jLabel3 = new javax.swing.JLabel();
     * jLabel4 = new javax.swing.JLabel();
     * jLabel5 = new javax.swing.JLabel();
     * jLabel6 = new javax.swing.JLabel();
     * jLabel7 = new javax.swing.JLabel();
     * jLabel8 = new javax.swing.JLabel();
     * jLabel9 = new javax.swing.JLabel();
     * jLabel10 = new javax.swing.JLabel();
     * jLabel12 = new javax.swing.JLabel();
     * userid = new javax.swing.JTextField();
     * start = new javax.swing.JComboBox<>();
     * destination = new javax.swing.JComboBox<>();
     * trainid = new javax.swing.JTextField();
     * trainname = new javax.swing.JTextField();
     * price = new javax.swing.JTextField();
     * ticket = new javax.swing.JTextField();
     * total = new javax.swing.JTextField();
     * date = new com.toedter.calendar.JDateChooser();
     * jButton1 = new javax.swing.JButton();
     * jButton2 = new javax.swing.JButton();
     * jLabel1 = new javax.swing.JLabel();
     * 
     * setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     * getContentPane().setLayout(null);
     * 
     * jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
     * jLabel2.setForeground(new java.awt.Color(0, 0, 204));
     * jLabel2.setText("RESERVATION");
     * getContentPane().add(jLabel2);
     * jLabel2.setBounds(610, 40, 420, 60);
     * 
     * jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel3.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel3.setText("Passenger ID");
     * getContentPane().add(jLabel3);
     * jLabel3.setBounds(320, 150, 160, 40);
     * 
     * jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel4.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel4.setText("Start Place");
     * getContentPane().add(jLabel4);
     * jLabel4.setBounds(320, 210, 140, 20);
     * 
     * jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel5.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel5.setText("Destination Place");
     * getContentPane().add(jLabel5);
     * jLabel5.setBounds(320, 250, 190, 30);
     * 
     * jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel6.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel6.setText("Train No");
     * getContentPane().add(jLabel6);
     * jLabel6.setBounds(320, 310, 110, 20);
     * 
     * jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel7.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel7.setText("Train Name");
     * getContentPane().add(jLabel7);
     * jLabel7.setBounds(320, 360, 150, 20);
     * 
     * jLabel8.setBackground(new java.awt.Color(51, 51, 51));
     * jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel8.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel8.setText("Price");
     * getContentPane().add(jLabel8);
     * jLabel8.setBounds(320, 400, 100, 40);
     * 
     * jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel9.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel9.setText("Date");
     * getContentPane().add(jLabel9);
     * jLabel9.setBounds(320, 450, 70, 30);
     * 
     * jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel10.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel10.setText("Number of Tickets");
     * getContentPane().add(jLabel10);
     * jLabel10.setBounds(320, 500, 200, 20);
     * 
     * jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jLabel12.setForeground(new java.awt.Color(0, 255, 0));
     * jLabel12.setText("Total");
     * getContentPane().add(jLabel12);
     * jLabel12.setBounds(320, 540, 90, 40);
     * 
     * userid.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
     * getContentPane().add(userid);
     * userid.setBounds(570, 150, 230, 30);
     * 
     * start.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
     * getContentPane().add(start);
     * start.setBounds(570, 196, 230, 28);
     * 
     * destination.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
     * getContentPane().add(destination);
     * destination.setBounds(570, 250, 230, 30);
     * 
     * trainid.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
     * getContentPane().add(trainid);
     * trainid.setBounds(570, 300, 230, 30);
     * 
     * trainname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
     * getContentPane().add(trainname);
     * trainname.setBounds(570, 350, 230, 30);
     * 
     * price.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
     * getContentPane().add(price);
     * price.setBounds(570, 400, 230, 30);
     * 
     * ticket.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
     * ticket.addKeyListener(new java.awt.event.KeyAdapter() {
     * public void keyPressed(java.awt.event.KeyEvent evt) {
     * ticketKeyPressed(evt);
     * }
     * });
     * getContentPane().add(ticket);
     * ticket.setBounds(570, 490, 230, 30);
     * 
     * total.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
     * getContentPane().add(total);
     * total.setBounds(570, 540, 230, 30);
     * getContentPane().add(date);
     * date.setBounds(570, 440, 230, 30);
     * 
     * jButton1.setBackground(new java.awt.Color(51, 51, 0));
     * jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jButton1.setText("Reserve");
     * jButton1.addActionListener(new java.awt.event.ActionListener() {
     * public void actionPerformed(java.awt.event.ActionEvent evt) {
     * jButton1ActionPerformed(evt);
     * }
     * });
     * getContentPane().add(jButton1);
     * jButton1.setBounds(680, 610, 220, 80);
     * 
     * jButton2.setBackground(new java.awt.Color(51, 51, 0));
     * jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
     * jButton2.setText("Search");
     * jButton2.addActionListener(new java.awt.event.ActionListener() {
     * public void actionPerformed(java.awt.event.ActionEvent evt) {
     * jButton2ActionPerformed(evt);
     * }
     * });
     * getContentPane().add(jButton2);
     * jButton2.setBounds(900, 210, 120, 60);
     * 
     * jLabel1.setIcon(new javax.swing.
     * ImageIcon("C:\\Users\\Rahul Vijayan\\Documents\\NetBeansProjects\\Railway Reservation System\\images\\2.jpg"
     * )); // NOI18N
     * jLabel1.setText("jLabel1");
     * getContentPane().add(jLabel1);
     * jLabel1.setBounds(-20, -50, 1430, 780);
     * 
     * pack();
     * }// </editor-fold>
     * /*
     * 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        String Passenger = userid.getText();
        String StartPlace = startComboBox.getSelectedItem().toString();
        String DestinationPlace = destinationComboBox.getSelectedItem().toString();
        String TrainID = trainid.getText();
        String TrainName = trainname.getText();
        String Price = price.getText();

        String Ticket = ticket.getText();
        String Total = total.getText();
        String StationID = sid.getText();

        try {
            pst = con.prepareStatement(
                    "INSERT INTO reservation (passengerid, startplace, destinationplace, trainid, trainname, price, ticket,stationID,total)\n"
                            +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);");

            pst.setString(1, Passenger);
            pst.setString(2, StartPlace);
            pst.setString(3, DestinationPlace);
            pst.setString(4, TrainID);
            pst.setString(5, TrainName);
            pst.setString(6, Price);

            pst.setString(7, Ticket);
            pst.setString(8, Total);
            pst.setString(9, StationID);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Ticket Reserved Successfully");
            }

            else {
                JOptionPane.showMessageDialog(this, "Ticket Reservation Failed");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void ticketKeyPressed(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:

        int amt, tckt, tot;

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            amt = Integer.parseInt(price.getText());
            tckt = Integer.parseInt(ticket.getText());

            tot = amt * tckt;

            total.setText(Integer.toString(tot));

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation().setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();
        start = new javax.swing.JTextField();
        destination = new javax.swing.JTextField();
        trainid = new javax.swing.JTextField();
        trainname = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        ticket = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("RAILWAY TICKET BOOKING");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Passenger ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Start Place");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Destination Place");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Train No");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Train Name");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Price");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Total");

        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });

        jButton1.setText("Book Ticket");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Number of tickets");

        jButton3.setText("Amenity_ratings");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("stationID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(331, 331, 331)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(jLabel5))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(75, 75, 75)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel11)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(43, 43, 43)
                                                                .addComponent(jLabel8))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(74, 74, 74)
                                                                .addComponent(jLabel9)))
                                                .addGap(17, 17, 17)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(total,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 167,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(trainid,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        167, Short.MAX_VALUE)
                                                                                .addComponent(userid)
                                                                                .addComponent(start)
                                                                                .addComponent(destination)
                                                                                .addComponent(trainname)
                                                                                .addComponent(price)
                                                                                .addComponent(ticket))
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(62, 62, 62)
                                                                                        .addComponent(jButton1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                101,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(36, 36, 36)
                                                                                        .addComponent(jButton2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                100,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(141, 141, 141)
                                                                                        .addComponent(jButton3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                128,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(sid,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 176,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(299, 299, 299)))))
                                .addContainerGap(14, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(userid, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(trainid, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(trainname, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ticket, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addGap(28, 28, 28)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(64, 64, 64)));

        pack();
    }// </editor-fold>
    /*
    
    */

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void startActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (amenityRatings == null) {
            // Create an instance of the AmenityRatingsPage if it doesn't exist
            amenityRatings = new Amenityratings();
        }
        amenityRatings.setVisible(true);
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField destination;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField price;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField start;
    private javax.swing.JTextField ticket;
    private javax.swing.JTextField total;
    private javax.swing.JTextField trainid;
    private javax.swing.JTextField trainname;
    private javax.swing.JTextField userid;
    // End of variables declaration

    private void AllItems() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void Item() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void setForeground() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void removeAllItems() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void setText(com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type String) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void addItem() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void valueOf() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void addItem(com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type String) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void getSelectedItems() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void destination() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    private void addItems() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }
}
