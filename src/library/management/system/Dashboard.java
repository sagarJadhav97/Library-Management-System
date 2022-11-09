package library.management.system;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class Dashboard extends javax.swing.JFrame {
CardLayout cardlayout;
Connection con;
Statement stmt;
ResultSet rs,rs2;
PreparedStatement pst,pst2;

    public Dashboard() {
        initComponents();
        setIconImage();
         Connect();
         thaedloading();
         setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadjcombo();
         datatabelload();
         datatabelload2();
         datatabelload3();
         datatabelload4();
         datatabelload5();
         datesettoday();
        cardlayout = (CardLayout)(Pincard.getLayout());
        cardlayout.show(Pincard, "Home_ss");
    }

 public void thaedloading(){
 
 stu_rep_displ.getTableHeader().setBackground(new Color(31, 3, 3));
 stu_rep_displ.getTableHeader().setOpaque(false);
 stu_rep_displ.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
 stu_rep_displ.getTableHeader().setForeground(new Color(255,255,255));
stu_rep_displ.setRowHeight(25);

dash_bo_set.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
dash_bo_set.getTableHeader().setOpaque(false);
dash_bo_set.getTableHeader().setBackground(new Color(32,136,203));
dash_bo_set.getTableHeader().setForeground(new Color(255,255,255));
dash_bo_set.setRowHeight(25);

stud_list_see_sho.getTableHeader().setBackground(new Color(1, 11, 28));
stud_list_see_sho.getTableHeader().setOpaque(false);
stud_list_see_sho.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
stud_list_see_sho.getTableHeader().setForeground(new Color(255,255,255));

book_list_show.getTableHeader().setBackground(new Color(1, 11, 28));
book_list_show.getTableHeader().setOpaque(false);
book_list_show.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
book_list_show.getTableHeader().setForeground(new Color(255,255,255));
book_list_show.setRowHeight(30);
 }
    public void Connect(){
    try{
        
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","");
      stmt = con.createStatement();
     
    }catch(SQLException ex){
       JOptionPane.showMessageDialog(this,ex.getMessage());
    }
    
    }
    
    public void loadjcombo(){
    try{
    String sql = "SELECT * FROM `course_set`";
    rs = stmt.executeQuery(sql);
    while(rs.next()){
         cou_ty.addItem(rs.getString("course_name"));  
         selc_cour_stu.addItem(rs.getString("course_name"));
    }}
    
    catch(SQLException ex){
     JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    }
    
    public void datesettoday(){
    Date date = new Date();
iss_date_set.setDate(date);
    }
    
     public void datatabelload(){ 
try{
    String sql = "SELECT * FROM `issue_book_set`";
    rs = stmt.executeQuery(sql);
    while(rs.next()){
    String id = String.valueOf(rs.getString("Book_name"));
    String nn = String.valueOf(rs.getString("subject"));
    String noo = String.valueOf(rs.getString("course_type"));
    String indate = String.valueOf(rs.getString("book_issue_date"));
    String outdate = String.valueOf(rs.getString("book_return_date"));
    String st = String.valueOf(rs.getString("status"));
    
     String stu_iddd = String.valueOf(rs.getString("stud_id"));
      String stu_name = String.valueOf(rs.getString("mob_stud"));
    
    String tbdata[] ={id,nn,noo,indate,outdate,st,stu_iddd,stu_name};
    DefaultTableModel tblmodel = (DefaultTableModel)dash_bo_set.getModel();
    tblmodel.addRow(tbdata);
    }
    
    }catch(SQLException ex){
     JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    }
    
     
      public void datatabelload5(){ 
try{
    String sql = "SELECT * FROM `student_record`";
    rs = stmt.executeQuery(sql);
    while(rs.next()){
    String id = String.valueOf(rs.getString("student_id"));
    String nn = String.valueOf(rs.getString("first_nam"));
    String noo = String.valueOf(rs.getString("las_name"));
    String indate = String.valueOf(rs.getString("mob_no_s"));
    String outdate = String.valueOf(rs.getString("address_stu_set"));
    String st = String.valueOf(rs.getString("aadhaar_set_stun"));
    
     String outdate1 = String.valueOf(rs.getString("cour_type_set_Student"));
    String st1 = String.valueOf(rs.getString("Gender"));
    String tbdata[] ={id,nn,noo,indate,outdate,st,outdate1,st1};
    DefaultTableModel tblmodel = (DefaultTableModel)stud_list_see_sho.getModel();
    tblmodel.addRow(tbdata);
    }
    
    }catch(SQLException ex){
     JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    }
     
      public void datatabelload2(){ 
try
   {
    String sql = "SELECT * FROM `book_data_recorde`";
    rs = stmt.executeQuery(sql);
    while(rs.next()){
    String id = String.valueOf(rs.getString("book_id"));
    String nn = String.valueOf(rs.getString("book_name"));
    String noo = String.valueOf(rs.getString("auther_name"));
    String indate = String.valueOf(rs.getString("publication_name"));
    String outdate = String.valueOf(rs.getString("publication_date"));
    String st = String.valueOf(rs.getString("Edition"));
    String ctpr = String.valueOf(rs.getString("course_type"));
    String stud_sub = String.valueOf(rs.getString("Subject"));
    String bqty1 = String.valueOf(rs.getString("Book_qty"));
    
    String tbdata1[] ={id,nn,noo,indate,outdate,st,ctpr,stud_sub,bqty1};
    DefaultTableModel tblmodel3 = (DefaultTableModel)book_list_show.getModel();
    tblmodel3.addRow(tbdata1);
    }
    }catch(SQLException ex){
     JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    }
      public void datatabelload3(){
      try{
    String sql = "SELECT * FROM `student_report_search`";
    rs = stmt.executeQuery(sql);
    while(rs.next()){
    String id = String.valueOf(rs.getString("Student_Name"));
    String nn = String.valueOf(rs.getString("mobile_no"));
    String noo = String.valueOf(rs.getString("course_type"));
    String indate = String.valueOf(rs.getString("book_id"));
    String outdate = String.valueOf(rs.getString("Book_name"));
    String st = String.valueOf(rs.getString("issue_date"));
    String re = String.valueOf(rs.getString("return_date"));
    String tbdata4[] ={id,nn,noo,indate,outdate,st,re};
    DefaultTableModel tblmodel4 = (DefaultTableModel)stu_rep_displ.getModel();
    tblmodel4.addRow(tbdata4);
    }
    
    }catch(SQLException ex){
     JOptionPane.showMessageDialog(this, ex.getMessage());
    }
      }
      
      public void datatabelload4(){
      try{
    String sql = "SELECT * FROM `book_report`";
    rs = stmt.executeQuery(sql);
    while(rs.next()){
    String id = String.valueOf(rs.getString("book_id"));
    String nn = String.valueOf(rs.getString("Book_Banding_Issue"));
    String noo = String.valueOf(rs.getString("Page_Damage"));
    String indate = String.valueOf(rs.getString("Loose_Page"));
 
    String tbdata5[] ={id,nn,noo,indate};
    DefaultTableModel tblmodel5 = (DefaultTableModel)bok_rep_tbl.getModel();
    tblmodel5.addRow(tbdata5);
    }
    
    }catch(SQLException ex){
     JOptionPane.showMessageDialog(this, ex.getMessage());
    }
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        stf_name_show = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Pincard = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        dash_bo_set = new javax.swing.JTable();
        data_sort_jt_db = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        B_Name = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Au_Name = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        pub_Name = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Edi_B = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        pub_Date = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Book_id_set = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        sub_Book = new javax.swing.JTextField();
        cou_ty = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        bokk_qty_ss = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        upBok_Name = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        upBok_Au = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        upBok_pub_name = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        upBok_Edi = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        upBok_corType = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        upBok_id = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        upBok_pub_date = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        upsub_set = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        book_list_show = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        bookiddser = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        bok_rep_tbl = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        ser_rpt_for_book = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        bok_Band_iss = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        pgn_dmg = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        lose_pg_see = new javax.swing.JTextArea();
        jButton13 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        studid = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        fname_stu = new javax.swing.JTextField();
        middl_nam_stu = new javax.swing.JTextField();
        last_name_St = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        mob_No_stu = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        add_Student_ap = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        aadh_no_stu = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        selc_cour_stu = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stud_list_see_sho = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        serlist_stud = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        stu_rep_displ = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        stu_rep_search = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        iss_book_search_set = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        iss_book_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        iss_auth_name = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        iss_pub_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        iss_bok_edi = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        iss_stu_id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        iss_stud_fir_name = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        iss_cour_type = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        iss_mob_no_stu = new javax.swing.JTextField();
        iss_date_set = new com.toedter.calendar.JDateChooser();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        retDate_set = new com.toedter.calendar.JDateChooser();
        iss_stu_last_name = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        iss_subject = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        pub_date_iss = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        qtybook_set = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        ret_ser_id_bokk = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        ret_stu_bok = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        auuuth_ret = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        pbli_ret_student_set = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        book_edition_ret = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel52 = new javax.swing.JLabel();
        stud_iddd = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        stud_ret_fname_Set = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        cur_set_std3 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        stud_mobi_set_art = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        iss_ret_date_stu = new javax.swing.JTextField();
        ret_dat_ret = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        iss_subject3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setDividerLocation(200);
        jSplitPane1.setDividerSize(1);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/add book new.png"))); // NOI18N
        jButton1.setText("Add Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/medical-report.png"))); // NOI18N
        jButton2.setText("Book Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/new-user.png"))); // NOI18N
        jButton3.setText("Add Student");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/report.png"))); // NOI18N
        jButton4.setText("Student Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/calendar (1).png"))); // NOI18N
        jButton5.setText("Issue Book");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/calendar.png"))); // NOI18N
        jButton6.setText("Return Book");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/logout.png"))); // NOI18N
        jButton7.setText("Logout");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/home-icon-silhouette.png"))); // NOI18N
        jButton11.setText("Dashboard");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        stf_name_show.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        stf_name_show.setForeground(new java.awt.Color(255, 255, 255));
        stf_name_show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stf_name_show.setText("Staff Name");

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/user (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(stf_name_show, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jSeparator3)
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(stf_name_show, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PD.VASANTDADA PATIL COLLEGE LIBRARY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Pincard.setBackground(new java.awt.Color(255, 255, 255));
        Pincard.setLayout(new java.awt.CardLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DashBoard");

        dash_bo_set.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        dash_bo_set.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Name", "Subject", "Course Type", "Book issue Date", "Book Return Date", "Status", "Student Id", "Student Mobile No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dash_bo_set.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dash_bo_set.setIntercellSpacing(new java.awt.Dimension(0, 0));
        dash_bo_set.setRowHeight(30);
        dash_bo_set.setRowSelectionAllowed(false);
        dash_bo_set.setSelectionBackground(new java.awt.Color(204, 255, 204));
        dash_bo_set.setSelectionForeground(new java.awt.Color(0, 0, 0));
        dash_bo_set.setShowVerticalLines(false);
        jScrollPane10.setViewportView(dash_bo_set);

        data_sort_jt_db.setForeground(new java.awt.Color(153, 153, 153));
        data_sort_jt_db.setText("Enter Book ID");
        data_sort_jt_db.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                data_sort_jt_dbFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                data_sort_jt_dbFocusLost(evt);
            }
        });
        data_sort_jt_db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_sort_jt_dbActionPerformed(evt);
            }
        });
        data_sort_jt_db.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                data_sort_jt_dbKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                data_sort_jt_dbKeyReleased(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel57.setText("Search Book:-");

        jButton21.setText("Refresh");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane10)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 267, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addGap(18, 18, 18)
                                .addComponent(data_sort_jt_db, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(253, 253, 253))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton21)
                                .addGap(313, 313, 313))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(data_sort_jt_db, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Pincard.add(jPanel5, "Home_ss");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Add Book");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setText("Book Name:-");
        jPanel12.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 89, 30));
        jPanel12.add(B_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 252, 30));

        jLabel19.setText("Author Name:-");
        jPanel12.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 89, 28));
        jPanel12.add(Au_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 252, 30));

        jLabel20.setText("Publication Name:-");
        jPanel12.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, 30));
        jPanel12.add(pub_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 252, 30));

        jLabel21.setText("Edition:-");
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 89, 30));
        jPanel12.add(Edi_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 252, 30));

        jLabel22.setText("Publish date:- ");
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, 30));

        pub_Date.setDateFormatString("yyyy-MM-dd");
        jPanel12.add(pub_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 127, 124, 30));

        jLabel23.setText("Course Type:-");
        jPanel12.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 89, 30));

        jLabel24.setText("Book Id:-");
        jPanel12.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 89, 30));
        jPanel12.add(Book_id_set, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 157, 30));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/add_book.png"))); // NOI18N
        jButton12.setText("Book Add");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 373, -1, 40));

        jLabel56.setText("Subject:-");
        jPanel12.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, 30));
        jPanel12.add(sub_Book, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 157, 30));

        cou_ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course Type" }));
        jPanel12.add(cou_ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 140, 30));

        jLabel43.setText("Book Qty:-");
        jPanel12.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, 30));
        jPanel12.add(bokk_qty_ss, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 90, 30));

        jTabbedPane1.addTab("Add Book", jPanel12);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel14.add(upBok_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 252, 30));

        jLabel26.setText("Book Name:-");
        jPanel14.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 89, 30));

        jLabel27.setText("Author Name:-");
        jPanel14.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 89, 40));
        jPanel14.add(upBok_Au, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 252, 30));

        jLabel28.setText("Publication Name:-");
        jPanel14.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 100, 30));
        jPanel14.add(upBok_pub_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 252, 30));

        jLabel29.setText("Edition:-");
        jPanel14.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 89, 30));
        jPanel14.add(upBok_Edi, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 252, 30));

        jLabel30.setText("Course Type:-");
        jPanel14.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 100, 30));
        jPanel14.add(upBok_corType, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 167, 30));

        jLabel31.setText("Book Id:-");
        jPanel14.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 89, 30));
        jPanel14.add(upBok_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 157, 30));

        jLabel32.setText("Publish date:- ");
        jPanel14.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, 30));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/update.png"))); // NOI18N
        jButton17.setText("Update");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, -1, -1));

        jButton19.setText("Search");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 70, 30));
        jPanel14.add(upBok_pub_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 120, 30));

        jLabel59.setText("Subject:-");
        jPanel14.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 90, 30));
        jPanel14.add(upsub_set, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 160, 30));

        jTabbedPane1.addTab("Update Book", jPanel14);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        book_list_show.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        book_list_show.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookId", "Book Name", "Author Name", "Publication Name", "publication_Date", "Edition", "CourseType", "Subject", "Book Qty"
            }
        ));
        book_list_show.setRowHeight(25);
        book_list_show.setShowVerticalLines(false);
        jScrollPane1.setViewportView(book_list_show);

        jButton20.setText("Refresh");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        bookiddser.setForeground(new java.awt.Color(153, 153, 153));
        bookiddser.setText("Enter Book ID");
        bookiddser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bookiddserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bookiddserFocusLost(evt);
            }
        });
        bookiddser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookiddserKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookiddserKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton20)
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookiddser, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookiddser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20))
        );

        jTabbedPane1.addTab("Book List", jPanel13);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jTabbedPane1)
                .addGap(25, 25, 25))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        Pincard.add(jPanel7, "add_book_set");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Book Report");

        bok_rep_tbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bok_rep_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "book Id", "Book Cover Issue  ", "Page Damage", "Loose Page"
            }
        ));
        bok_rep_tbl.setRowHeight(20);
        jScrollPane4.setViewportView(bok_rep_tbl);

        jLabel33.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel33.setText("Search:-");

        ser_rpt_for_book.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        ser_rpt_for_book.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ser_rpt_for_bookKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ser_rpt_for_bookKeyReleased(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel34.setText("Book Banding Issue :-");

        bok_Band_iss.setColumns(20);
        bok_Band_iss.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        bok_Band_iss.setRows(5);
        jScrollPane5.setViewportView(bok_Band_iss);

        jLabel35.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel35.setText("Page Damage:-");

        pgn_dmg.setColumns(20);
        pgn_dmg.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        pgn_dmg.setRows(5);
        jScrollPane6.setViewportView(pgn_dmg);

        jLabel36.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel36.setText("Loose Page:-");

        lose_pg_see.setColumns(20);
        lose_pg_see.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lose_pg_see.setRows(5);
        jScrollPane7.setViewportView(lose_pg_see);

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/checklist.png"))); // NOI18N
        jButton13.setText("Add Report");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton24.setText("Refresh");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ser_rpt_for_book)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ser_rpt_for_book, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 89, Short.MAX_VALUE))
        );

        Pincard.add(jPanel4, "book_rep_set");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Add Student");

        jPanel15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel15KeyPressed(evt);
            }
        });

        jLabel37.setText("Student Id:-");

        studid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                studidKeyReleased(evt);
            }
        });

        jLabel38.setText("Student Name:-");

        fname_stu.setForeground(new java.awt.Color(153, 153, 153));
        fname_stu.setText("First Name");
        fname_stu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fname_stuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fname_stuFocusLost(evt);
            }
        });
        fname_stu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fname_stuActionPerformed(evt);
            }
        });

        middl_nam_stu.setForeground(new java.awt.Color(153, 153, 153));
        middl_nam_stu.setText("Middle Name");
        middl_nam_stu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                middl_nam_stuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                middl_nam_stuFocusLost(evt);
            }
        });

        last_name_St.setForeground(new java.awt.Color(153, 153, 153));
        last_name_St.setText("Last Name");
        last_name_St.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                last_name_StFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                last_name_StFocusLost(evt);
            }
        });

        jLabel39.setText("Mobile No:-");

        jLabel40.setText("Address:-");

        add_Student_ap.setColumns(20);
        add_Student_ap.setRows(5);
        jScrollPane8.setViewportView(add_Student_ap);

        jLabel41.setText("Aadhaar No:-");

        jLabel42.setText("Course Type:-");

        selc_cour_stu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course Type" }));

        jButton14.setText("Add Student Recorde");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel60.setText("Gender:-");

        male.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        male.setText("Male");

        female.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        female.setText("Female");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14)
                .addGap(133, 133, 133))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selc_cour_stu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(27, 27, 27)
                        .addComponent(studid, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fname_stu)
                                    .addComponent(mob_No_stu, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(middl_nam_stu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(last_name_St, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel60)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(male, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(female))))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(aadh_no_stu, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fname_stu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(middl_nam_stu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last_name_St, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mob_No_stu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(male)
                            .addComponent(female))))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aadh_no_stu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selc_cour_stu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Add Student", jPanel18);

        stud_list_see_sho.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        stud_list_see_sho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "First Name", "Last Name", "Mobile No", "Address", "Aadhaar No", "Course Type", "Gender"
            }
        ));
        stud_list_see_sho.setRowHeight(30);
        stud_list_see_sho.setShowVerticalLines(false);
        jScrollPane2.setViewportView(stud_list_see_sho);

        jButton22.setText("Refresh");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        serlist_stud.setForeground(new java.awt.Color(153, 153, 153));
        serlist_stud.setText("Search Student");
        serlist_stud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                serlist_studFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                serlist_studFocusLost(evt);
            }
        });
        serlist_stud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serlist_studActionPerformed(evt);
            }
        });
        serlist_stud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                serlist_studKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                serlist_studKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton22)
                        .addGap(371, 371, 371))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(serlist_stud, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(serlist_stud, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22)
                .addGap(36, 36, 36))
        );

        jTabbedPane2.addTab("Student List", jPanel19);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        Pincard.add(jPanel8, "add_stud");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Student Report");

        stu_rep_displ.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        stu_rep_displ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "Mobile No", "Course Type", "Book Id", "Book Name", "Book issue Date", "Book Returen Date"
            }
        ));
        stu_rep_displ.setRowHeight(20);
        stu_rep_displ.setSelectionBackground(new java.awt.Color(255, 255, 102));
        stu_rep_displ.setSelectionForeground(new java.awt.Color(0, 0, 0));
        stu_rep_displ.setShowVerticalLines(false);
        jScrollPane9.setViewportView(stu_rep_displ);

        jLabel46.setText("Search:-");

        stu_rep_search.setForeground(new java.awt.Color(153, 153, 153));
        stu_rep_search.setText("Search Student");
        stu_rep_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stu_rep_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stu_rep_searchFocusLost(evt);
            }
        });
        stu_rep_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stu_rep_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stu_rep_searchKeyReleased(evt);
            }
        });

        jButton15.setText("Refresh");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel46)
                .addGap(18, 18, 18)
                .addComponent(stu_rep_search, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton15)
                .addGap(57, 57, 57))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stu_rep_search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(61, 61, 61))
        );

        Pincard.add(jPanel9, "stu_rep");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Issue Book");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iss_book_search_set.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        iss_book_search_set.setForeground(new java.awt.Color(153, 153, 153));
        iss_book_search_set.setText("Search Book ID");
        iss_book_search_set.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                iss_book_search_setFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                iss_book_search_setFocusLost(evt);
            }
        });
        jPanel2.add(iss_book_search_set, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 347, 34));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Book Name:-");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        iss_book_name.setEditable(false);
        iss_book_name.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(iss_book_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 270, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Author name:-");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 162, -1, 30));

        iss_auth_name.setEditable(false);
        iss_auth_name.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(iss_auth_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 270, 30));

        jButton8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/search book.png"))); // NOI18N
        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, 34));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Publication:-");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        iss_pub_name.setEditable(false);
        iss_pub_name.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(iss_pub_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 208, 275, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel6.setText("Issue Date:-");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 70, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("Return Date:-");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 80, 30));

        iss_bok_edi.setEditable(false);
        iss_bok_edi.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(iss_bok_edi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 106, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 84, -1, 410));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel8.setText("Student Id:-");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 111, -1, 32));
        jPanel2.add(iss_stu_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 82, 32));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel9.setText("Student Name:-");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 171, -1, 30));

        iss_stud_fir_name.setEditable(false);
        iss_stud_fir_name.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(iss_stud_fir_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 100, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel10.setText("Course Type:-");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 219, -1, 30));

        iss_cour_type.setEditable(false);
        iss_cour_type.setBackground(new java.awt.Color(204, 255, 204));
        iss_cour_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iss_cour_typeActionPerformed(evt);
            }
        });
        jPanel2.add(iss_cour_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 174, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel11.setText("Mobile No:-");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 267, 69, 30));

        iss_mob_no_stu.setEditable(false);
        iss_mob_no_stu.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(iss_mob_no_stu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, 153, 30));

        iss_date_set.setDateFormatString("yyyy-MM-dd");
        iss_date_set.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(iss_date_set, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 140, 30));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/search.png"))); // NOI18N
        jButton9.setText("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, 30));

        jButton10.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/checklist.png"))); // NOI18N
        jButton10.setText("Confirm");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, -1, 30));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel25.setText("Book Edition:-");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 80, 30));

        retDate_set.setDateFormatString("yyyy-MM-dd");
        retDate_set.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel2.add(retDate_set, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 140, 30));

        iss_stu_last_name.setEditable(false);
        iss_stu_last_name.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(iss_stu_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 110, 30));

        jLabel61.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel61.setText("Subject:-");
        jPanel2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 50, 30));

        iss_subject.setEditable(false);
        iss_subject.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(iss_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 110, 30));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel62.setText("Publication Date:-");
        jPanel2.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        pub_date_iss.setEditable(false);
        pub_date_iss.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(pub_date_iss, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 110, 30));

        jButton23.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton23.setText("Cancel");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, 100, 30));

        jLabel44.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel44.setText("Book Qty:-");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, 30));

        qtybook_set.setEditable(false);
        qtybook_set.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.add(qtybook_set, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 100, 30));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 260, -1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        Pincard.add(jPanel10, "iss_book");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Return Book");

        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ret_ser_id_bokk.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ret_ser_id_bokk.setForeground(new java.awt.Color(153, 153, 153));
        ret_ser_id_bokk.setText("Search Student Id");
        ret_ser_id_bokk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ret_ser_id_bokkFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ret_ser_id_bokkFocusLost(evt);
            }
        });
        jPanel17.add(ret_ser_id_bokk, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 347, 34));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel47.setText("Book Name:-");
        jPanel17.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        ret_stu_bok.setEditable(false);
        ret_stu_bok.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(ret_stu_bok, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 270, 30));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel48.setText("Author name:-");
        jPanel17.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 162, -1, 30));

        auuuth_ret.setEditable(false);
        auuuth_ret.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(auuuth_ret, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 270, 30));

        jButton16.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/search book.png"))); // NOI18N
        jButton16.setText("Search");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, 34));

        jLabel49.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel49.setText("Publication:-");
        jPanel17.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        pbli_ret_student_set.setEditable(false);
        pbli_ret_student_set.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(pbli_ret_student_set, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 208, 275, 30));

        jLabel50.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel50.setText("Issue Date:-");
        jPanel17.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 70, 30));

        jLabel51.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel51.setText("Book Edition:-");
        jPanel17.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 90, 30));

        book_edition_ret.setEditable(false);
        book_edition_ret.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(book_edition_ret, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 106, 30));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel17.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 84, -1, 430));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel52.setText("Book Id:-");
        jPanel17.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 60, 32));

        stud_iddd.setEditable(false);
        stud_iddd.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(stud_iddd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 100, 32));

        jLabel53.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel53.setText("Student Name:-");
        jPanel17.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, 30));

        stud_ret_fname_Set.setEditable(false);
        stud_ret_fname_Set.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(stud_ret_fname_Set, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 140, 30));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel54.setText("Course Type:-");
        jPanel17.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, 30));

        cur_set_std3.setEditable(false);
        cur_set_std3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(cur_set_std3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 80, 30));

        jLabel55.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel55.setText("Mobile No:-");
        jPanel17.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 69, 30));

        stud_mobi_set_art.setEditable(false);
        stud_mobi_set_art.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(stud_mobi_set_art, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 153, 30));

        jButton18.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/purchase.png"))); // NOI18N
        jButton18.setText("Return");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, -1, 30));

        iss_ret_date_stu.setEditable(false);
        iss_ret_date_stu.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(iss_ret_date_stu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 100, 30));

        ret_dat_ret.setEditable(false);
        ret_dat_ret.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(ret_dat_ret, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 106, 30));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel58.setText("Return Date:-");
        jPanel17.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 80, 30));

        jLabel63.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel63.setText("Subject:-");
        jPanel17.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 50, 30));

        iss_subject3.setEditable(false);
        iss_subject3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel17.add(iss_subject3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 110, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        Pincard.add(jPanel11, "ret_book_lib");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pincard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Pincard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Pincard.getAccessibleContext().setAccessibleName("");

        jSplitPane1.setRightComponent(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // issue book   

         if(iss_book_search_set.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Empty Id filed");
        }
        else if(iss_book_name.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Empty Book Name");
        }
        else if(iss_stu_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Empty Student Id");
        }
        else if(iss_stud_fir_name.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Empty Student Name");
        }
         else if(iss_date_set.getDate()== null){
            JOptionPane.showMessageDialog(this,"Empty Issue Date");
        }
          else if(retDate_set.getDate()== null){
            JOptionPane.showMessageDialog(this,"Empty Return Date");
        }
        
        else{
        String bok_name1 = iss_book_name.getText();
         String auth = iss_auth_name.getText();
         String publi_bok = iss_pub_name.getText();
         String edi_iss_stud = iss_bok_edi.getText();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String iss_da = sdf.format(iss_date_set.getDate());
         String ret_da = sdf.format(retDate_set.getDate());
         String c_typ_s1 = iss_cour_type.getText();
        String book_iD1 = iss_book_search_set.getText();
        String subj1 = iss_subject.getText();
        
        String stud_id_iss_up = iss_stu_id.getText();
        String iss_stud = iss_stud_fir_name.getText();
        String mobil = iss_mob_no_stu.getText();
        String cotype = iss_cour_type.getText();
        String boqty = qtybook_set.getText();
         int number = Integer.parseInt(boqty);
         int sumbook = number - 1;
         if(number==0){
         JOptionPane.showMessageDialog(this, "Book Not Available in Library");
         }else{
        try{
            String sql = "INSERT INTO `issue_book_set`(`book_id`, `Book_name`, `auther_name`, `publication_name`, `book_edition`, `subject`, `course_type`, `book_issue_date`, `book_return_date`, `status`, `stud_id`, `stdname`, `course_typ`, `mob_stud`)"
                    + " VALUES('"+book_iD1+"','"+bok_name1+"','"+auth+"','"+publi_bok+"','"+edi_iss_stud+"','"+subj1+"','"+c_typ_s1+"','"+iss_da+"','"+ret_da+"','"+"Issue"+"','"+stud_id_iss_up+"','"+iss_stud+"','"+cotype+"','"+mobil+"')";
            String sql2 = "INSERT INTO `student_report_search`( `Student_Name`, `mobile_no`, `course_type`, `book_id`, `Book_name`, `issue_date`, `return_date`)"
            +"VALUES('"+iss_stud+"','"+mobil+"','"+cotype+"','"+book_iD1+"','"+bok_name1+"','"+iss_da+"','"+ret_da+"')";
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql2);
           String bok_qtyup_set=String.valueOf(sumbook);  
           String sql3 = "UPDATE `book_data_recorde` SET `Book_qty` = '"+bok_qtyup_set+"' WHERE `book_data_recorde`.book_id='"+book_iD1+"';";
           stmt.executeUpdate(sql3);
           
            JOptionPane.showMessageDialog(this, "Book Issue Successfully");
        
        iss_book_name.setText("");
        iss_auth_name.setText("");
        iss_pub_name.setText("");
        iss_bok_edi.setText("");
          retDate_set.setCalendar(null);
       iss_cour_type.setText("");
        iss_book_search_set.setText("");
      iss_subject.setText("");
      iss_stu_id.setText("");
       iss_stud_fir_name.setText("");
        iss_mob_no_stu.setText("");
        iss_cour_type.setText("");
        pub_date_iss.setText("");
        iss_stu_last_name.setText("");
        qtybook_set.setText("");
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }}
        }   
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // add book
         cardlayout.show(Pincard, "add_book_set");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Book  report
         cardlayout.show(Pincard, "book_rep_set");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Add Student
        cardlayout.show(Pincard, "add_stud");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Student report
         cardlayout.show(Pincard, "stu_rep");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // issue date
        cardlayout.show(Pincard, "iss_book");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //return date
         cardlayout.show(Pincard, "ret_book_lib");
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // home
         cardlayout.show(Pincard, "Home_ss");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // return book
        try{
            
            String sql="DELETE FROM `issue_book_set` WHERE  stud_id = ?";
            pst = con.prepareStatement(sql);
            int rm =Integer.parseInt(ret_ser_id_bokk.getText());
            pst.setInt(1, rm);
            pst.executeUpdate();
            
          
           ret_stu_bok.setText("");
            auuuth_ret.setText("");
            pbli_ret_student_set.setText("");
            book_edition_ret.setText("");
            
            iss_subject3.setText("");
            auuuth_ret.setText("");
            iss_ret_date_stu.setText("");
            ret_dat_ret.setText("");
             
            stud_iddd.setText("");
            stud_ret_fname_Set.setText("");
            cur_set_std3.setText("");
            stud_mobi_set_art.setText("");
            JOptionPane.showMessageDialog(this, "Return Successfully");
            
        
        }catch(HeadlessException | NumberFormatException | SQLException ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Logout
        int a = JOptionPane.showConfirmDialog(jPanel6, "Are You Sure?");
        if(a == JOptionPane.YES_OPTION){
        dispose();
        Login_window lpage = new Login_window();
       // user_name_staff.setText("");
        lpage.setVisible(true);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void data_sort_jt_dbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_data_sort_jt_dbKeyReleased
        // search data for tabel
       DefaultTableModel model = (DefaultTableModel)dash_bo_set.getModel();
       TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
       dash_bo_set.setRowSorter(tr);
       tr.setRowFilter(RowFilter.regexFilter(data_sort_jt_db.getText().trim()));
    }//GEN-LAST:event_data_sort_jt_dbKeyReleased

    private void data_sort_jt_dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_sort_jt_dbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_sort_jt_dbActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
  
        if(B_Name.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Book Name");
        }
        else if(Au_Name.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Book Author");
        }
        else if(pub_Name.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Book Publication");
        }
        else if(Edi_B.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Book Edition");
        }
        
        
          else if(Book_id_set.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Book Id");
        }
        
        else if(sub_Book.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Subject");
        }

        else{


        // add Book
         String bok_name = B_Name.getText();
         String aut_n = Au_Name.getText();
         String pub_n = pub_Name.getText();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String pub_da = sdf.format(pub_Date.getDate());
        String book_edi = Edi_B.getText();
        String guest_country = cou_ty.getSelectedItem().toString();
        String book_iD = Book_id_set.getText();
        String subj = sub_Book.getText();
        String qtybook =  bokk_qty_ss.getText();
        try{
            String sql = "INSERT INTO `book_data_recorde`( `book_id`, `book_name`, `auther_name`, `publication_name`, `publication_date`, `Edition`, `course_type`, `Subject` ,  `Book_qty`)"
                    + " VALUES('"+book_iD+"','"+bok_name+"','"+aut_n+"','"+pub_n+"','"+pub_da+"','"+book_edi+"','"+guest_country+"','"+subj+"','"+qtybook+"')";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Book Add Successfully");
         B_Name.setText("");
         Au_Name.setText("");
         pub_Name.setText("");
        pub_Date.setDate(null);
        Edi_B.setText("");
       cou_ty.setSelectedItem(0);
        Book_id_set.setText("");
       sub_Book.setText("");
       bokk_qty_ss.setText("");

        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
        }        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        //search book
          try{
            pst = con.prepareStatement("SELECT `id`, `book_id`, `book_name`, `auther_name`, `publication_name`, `publication_date`, `Edition`, `course_type`, `Subject` FROM `book_data_recorde` WHERE  book_id=?");
            
            
            
            int rm =Integer.parseInt(upBok_id.getText());
            pst.setInt(1, rm);
            rs = pst.executeQuery();
            if(rs.next()==false){
            JOptionPane.showMessageDialog(this, "Recorde Not found");
            upBok_id.requestFocus();
            }
            else{
             upBok_Name.setText(rs.getString("book_name"));
            upBok_Au.setText(rs.getString("auther_name"));
            upBok_pub_name.setText(rs.getString("publication_name"));
            upBok_Edi.setText(rs.getString("Edition"));
            upBok_corType.setText(rs.getString("course_type"));
            upBok_pub_date.setText(rs.getString("publication_date"));
             upsub_set.setText(rs.getString("Subject"));
            
            }
        
        }catch(HeadlessException | NumberFormatException | SQLException ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void ser_rpt_for_bookKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_rpt_for_bookKeyPressed
        // Book Report Displye
DefaultTableModel model = (DefaultTableModel)bok_rep_tbl.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
bok_rep_tbl.setRowSorter(tr);
tr.setRowFilter(RowFilter.regexFilter(ser_rpt_for_book.getText().trim()));
    }//GEN-LAST:event_ser_rpt_for_bookKeyPressed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // Book Report Add
          String r_b_id = ser_rpt_for_book.getText();
         String bok_cor_iss = bok_Band_iss.getText();
         String damage_pp = pgn_dmg.getText();
        String looo_pg = lose_pg_see.getText();
       
        try{
            String sql = "INSERT INTO `book_report`(`book_id`, `Book_Banding_Issue`, `Page_Damage`, `Loose_Page`)"
                    + " VALUES('"+r_b_id+"','"+bok_cor_iss+"','"+damage_pp+"','"+looo_pg+"')";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Recored Save Successfully");

          

        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());

        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void stu_rep_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stu_rep_searchKeyPressed
        // Student report Displye
DefaultTableModel model = (DefaultTableModel)stu_rep_displ.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
stu_rep_displ.setRowSorter(tr);
tr.setRowFilter(RowFilter.regexFilter(stu_rep_search.getText().trim()));
        
    }//GEN-LAST:event_stu_rep_searchKeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // Book Issue Date 
        try{
            pst = con.prepareStatement("SELECT `id`, `book_id`, `book_name`, `auther_name`, `publication_name`, `publication_date`, `Edition`, `course_type`, `Subject` ,`Book_qty` FROM `book_data_recorde` WHERE  book_id=?");
            
            
            
            int rm =Integer.parseInt(iss_book_search_set.getText());
            pst.setInt(1, rm);
            rs = pst.executeQuery();
            if(rs.next()==false){
            JOptionPane.showMessageDialog(this, "Recorde Not found");
            iss_book_search_set.requestFocus();
            }
            else{
            iss_book_name.setText(rs.getString("book_name"));
            iss_auth_name.setText(rs.getString("auther_name"));
            iss_pub_name.setText(rs.getString("publication_name"));
            iss_bok_edi.setText(rs.getString("Edition"));
            iss_subject.setText(rs.getString("Subject"));
            pub_date_iss.setText(rs.getString("publication_date"));
            qtybook_set.setText(rs.getString("Book_qty"));
            }
        
        }catch(HeadlessException | NumberFormatException | SQLException ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // search Student and set text filed
        iss_stud_fir_name.setText("");
            iss_stu_last_name.setText("");
            iss_cour_type.setText("");
            iss_mob_no_stu.setText("");
        try{
           pst2 = con.prepareStatement("SELECT `id`, `book_id`, `Book_name`, `auther_name`, `publication_name`, `book_edition`, `subject`, `course_type`, `book_issue_date`, `book_return_date`, `status`, `stud_id`, `stdname`, `course_typ`, `mob_stud` FROM `issue_book_set` WHERE stud_id=?"); 
             int rm1 =Integer.parseInt(iss_stu_id.getText());
            pst2.setInt(1, rm1);
            rs = pst2.executeQuery();
            
            if(rs.next()==false){
            pst = con.prepareStatement("SELECT `id`, `student_id`, `first_nam`, `mid_name`, `las_name`, `mob_no_s`, `address_stu_set`, `aadhaar_set_stun`, `cour_type_set_Student`, `Gender` FROM `student_record` WHERE   student_id=?");
            int rm =Integer.parseInt(iss_stu_id.getText());
            pst.setInt(1, rm);
            rs = pst.executeQuery();
            if(rs.next()==false){
            iss_stud_fir_name.setText("");
            iss_stu_last_name.setText("");
            iss_cour_type.setText("");
            iss_mob_no_stu.setText("");
            JOptionPane.showMessageDialog(this, "Recorde Not found");
            iss_stu_id.requestFocus();
            }
            else{
            iss_stud_fir_name.setText(rs.getString("first_nam"));
            iss_stu_last_name.setText(rs.getString("las_name"));
            iss_cour_type.setText(rs.getString("cour_type_set_Student"));
            iss_mob_no_stu.setText(rs.getString("mob_no_s"));
           
            
            }
        
            }else{
               
               iss_stud_fir_name.setText("");
            iss_stu_last_name.setText("");
            iss_cour_type.setText("");
            iss_mob_no_stu.setText("");
            JOptionPane.showMessageDialog(this, "Book Already Issue");
            }
         
        }catch(HeadlessException | NumberFormatException | SQLException ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        } 
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // returen Book
          try{
            pst = con.prepareStatement("SELECT `id`, `book_id`, `Book_name`, `auther_name`, `publication_name`, `book_edition`, `subject`, `course_type`, `book_issue_date`, `book_return_date`, `status`, `stud_id`, `stdname`, `course_typ`, `mob_stud` FROM `issue_book_set` WHERE   stud_id=?");
        
            
            int rm =Integer.parseInt(ret_ser_id_bokk.getText());
            pst.setInt(1, rm);
            rs = pst.executeQuery();
            if(rs.next()==false){
            JOptionPane.showMessageDialog(this, "Recorde Not found");
            ret_ser_id_bokk.requestFocus();
            }
            else{
            ret_stu_bok.setText(rs.getString("Book_name"));
            auuuth_ret.setText(rs.getString("auther_name"));
            pbli_ret_student_set.setText(rs.getString("publication_name"));
            book_edition_ret.setText(rs.getString("book_edition"));
            
            iss_subject3.setText(rs.getString("subject"));
            auuuth_ret.setText(rs.getString("course_type"));
            iss_ret_date_stu.setText(rs.getString("book_issue_date"));
            ret_dat_ret.setText(rs.getString("book_return_date"));
             
            stud_iddd.setText(rs.getString("book_id"));
            stud_ret_fname_Set.setText(rs.getString("stdname"));
            cur_set_std3.setText(rs.getString("course_typ"));
            stud_mobi_set_art.setText(rs.getString("mob_stud"));
            }
        
        }catch(HeadlessException | NumberFormatException | SQLException ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        } 
        
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // update book
        try{
          String bid = upBok_id.getText();
          String bb = upBok_Name.getText();
           String ba =  upBok_Au.getText();
           String bp = upBok_pub_name.getText();
           String be = upBok_Edi.getText();
           String bc = upBok_corType.getText();
           String bpd = upBok_pub_date.getText();
            String bsb = upsub_set.getText();
        String sql5 ="UPDATE `book_data_recorde` SET `book_id`='"+bid+"',`book_name`='"+bb+"',`auther_name`='"+ba+"',`publication_name`='"+bp+"',`publication_date`='"+bpd+"',`Edition`='"+be+"',`course_type`='"+bc+"',`Subject`='"+bsb+"' WHERE `book_id`='"+bid+"'";
        pst=con.prepareStatement(sql5);
        pst.execute();
         JOptionPane.showMessageDialog(this, "Recored Update Successfully");
         upBok_id.setText("");
          upBok_Name.setText("");
            upBok_Au.setText("");
           upBok_pub_name.setText("");
           upBok_Edi.setText("");
           upBok_corType.setText("");
            upBok_pub_date.setText("");
            upsub_set.setText("");
         }catch(HeadlessException | NumberFormatException | SQLException ex){
        JOptionPane.showMessageDialog(this, ex.getMessage());
        } 
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // student report refresh table
         DefaultTableModel tblmodel = (DefaultTableModel)stu_rep_displ.getModel();
       tblmodel.setRowCount(0);
        datatabelload3();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // refresh date in book list
        DefaultTableModel tblmodel = (DefaultTableModel)book_list_show.getModel();
       tblmodel.setRowCount(0);
        datatabelload2();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void ser_rpt_for_bookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ser_rpt_for_bookKeyReleased
               // Book Report Displye
DefaultTableModel model = (DefaultTableModel)bok_rep_tbl.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
bok_rep_tbl.setRowSorter(tr);
tr.setRowFilter(RowFilter.regexFilter(ser_rpt_for_book.getText().trim()));
    }//GEN-LAST:event_ser_rpt_for_bookKeyReleased

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel tblmodel = (DefaultTableModel)dash_bo_set.getModel();
       tblmodel.setRowCount(0);
         datatabelload();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void data_sort_jt_dbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_data_sort_jt_dbKeyPressed
        // search data for tabel
       DefaultTableModel model = (DefaultTableModel)dash_bo_set.getModel();
       TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
       dash_bo_set.setRowSorter(tr);
       tr.setRowFilter(RowFilter.regexFilter(data_sort_jt_db.getText().trim()));
    }//GEN-LAST:event_data_sort_jt_dbKeyPressed

    private void stu_rep_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stu_rep_searchKeyReleased
                // Student report Displye
DefaultTableModel model = (DefaultTableModel)stu_rep_displ.getModel();
TableRowSorter<DefaultTableModel> tr1 = new TableRowSorter<>(model);
stu_rep_displ.setRowSorter(tr1);
tr1.setRowFilter(RowFilter.regexFilter(stu_rep_search.getText().trim()));
    }//GEN-LAST:event_stu_rep_searchKeyReleased

    private void fname_stuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fname_stuFocusGained
        // place holder for student first name
        if(fname_stu.getText().equals("First Name")){
            fname_stu.setText("");
            fname_stu.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_fname_stuFocusGained

    private void fname_stuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fname_stuFocusLost
        // place holder for student first name
        if(fname_stu.getText().equals("")){
            fname_stu.setText("First Name");
            fname_stu.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_fname_stuFocusLost

    private void fname_stuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fname_stuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fname_stuActionPerformed

    private void middl_nam_stuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middl_nam_stuFocusGained
        // middel
        if(middl_nam_stu.getText().equals("Middle Name")){
            middl_nam_stu.setText("");
            middl_nam_stu.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_middl_nam_stuFocusGained

    private void middl_nam_stuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middl_nam_stuFocusLost
        // Middle name
        if(middl_nam_stu.getText().equals("")){
            middl_nam_stu.setText("Middle Name");
            middl_nam_stu.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_middl_nam_stuFocusLost

    private void last_name_StFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_last_name_StFocusGained
        // last name
        if(last_name_St.getText().equals("Last Name")){
            last_name_St.setText("");
            last_name_St.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_last_name_StFocusGained

    private void last_name_StFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_last_name_StFocusLost
        // last name
        if(last_name_St.getText().equals("")){
            last_name_St.setText("Last Name");
            last_name_St.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_last_name_StFocusLost

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // Add Student record

        if(studid.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Empty Id filed");
        }
        else if(fname_stu.getText().equals("First Name")){
            JOptionPane.showMessageDialog(this,"Empty Name");
        }
        else if(middl_nam_stu.getText().equals("Middle Name")){
            JOptionPane.showMessageDialog(this,"Empty Middle");
        }
        else if(last_name_St.getText().equals("Last Name")){
            JOptionPane.showMessageDialog(this,"Empty Last Name");
        }
        
        
          else if(mob_No_stu.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Student Mobile No");
        }
        
        else if(add_Student_ap.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Address");
        }

        else if(aadh_no_stu.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Aadhaar No");
        }
        else{
            String student_id_set = studid.getText();
            String fsn = fname_stu.getText();
            String msn = middl_nam_stu.getText();
            String lsn = last_name_St.getText();
            String gender="";
            if(male.isSelected()){
                gender="Male";
            }else if(female.isSelected()){
                gender ="Female";
            }
            String mobile_no_stu = mob_No_stu.getText();
            String stud_cour = selc_cour_stu.getSelectedItem().toString();
            String Student_dd = add_Student_ap.getText();
            String aadh_no_student = aadh_no_stu.getText();

            try{
                String sql = "INSERT INTO `student_record`(`student_id`, `first_nam`, `mid_name`, `las_name`, `mob_no_s`, `address_stu_set`, `aadhaar_set_stun`, `cour_type_set_Student`, `Gender`)"
                + " VALUES('"+student_id_set+"','"+fsn+"','"+msn+"','"+lsn+"','"+mobile_no_stu+"','"+Student_dd+"','"+aadh_no_student+"','"+stud_cour+"','"+gender+"')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Recored Save Successfully");
                studid.setText("");
                fname_stu.setText("");
                middl_nam_stu.setText("");
                last_name_St.setText("");
                buttonGroup1.clearSelection();
                mob_No_stu.setText("");
                selc_cour_stu.setSelectedIndex(0);
                add_Student_ap.setText("");
                aadh_no_stu.setText("");

            }catch(HeadlessException | SQLException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());

            }

        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void serlist_studActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serlist_studActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serlist_studActionPerformed

    private void serlist_studKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serlist_studKeyPressed
        // student list  
        DefaultTableModel model = (DefaultTableModel)stud_list_see_sho.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
stud_list_see_sho.setRowSorter(tr);
tr.setRowFilter(RowFilter.regexFilter(serlist_stud.getText().trim()));
    }//GEN-LAST:event_serlist_studKeyPressed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // refresh student tabel
                DefaultTableModel tblmodel = (DefaultTableModel)stud_list_see_sho.getModel();
       tblmodel.setRowCount(0);
        datatabelload5();
    }//GEN-LAST:event_jButton22ActionPerformed

    private void serlist_studKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_serlist_studKeyReleased
  // student list  
        DefaultTableModel model = (DefaultTableModel)stud_list_see_sho.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
stud_list_see_sho.setRowSorter(tr);
tr.setRowFilter(RowFilter.regexFilter(serlist_stud.getText().trim()));
    }//GEN-LAST:event_serlist_studKeyReleased

    private void data_sort_jt_dbFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_data_sort_jt_dbFocusGained
        // focuse for dashbord
         if(data_sort_jt_db.getText().equals("Enter Book ID")){
            data_sort_jt_db.setText("");
            data_sort_jt_db.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_data_sort_jt_dbFocusGained

    private void data_sort_jt_dbFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_data_sort_jt_dbFocusLost
        // focues lost dashbord
         if(data_sort_jt_db.getText().equals("")){
            data_sort_jt_db.setText("Enter Book ID");
            data_sort_jt_db.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_data_sort_jt_dbFocusLost

    private void iss_cour_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iss_cour_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iss_cour_typeActionPerformed

    private void bookiddserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookiddserKeyPressed
        // book search id
        DefaultTableModel model = (DefaultTableModel)book_list_show.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
book_list_show.setRowSorter(tr);
tr.setRowFilter(RowFilter.regexFilter(bookiddser.getText().trim()));
    }//GEN-LAST:event_bookiddserKeyPressed

    private void bookiddserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookiddserKeyReleased
          // book search id
        DefaultTableModel model = (DefaultTableModel)book_list_show.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
book_list_show.setRowSorter(tr);
tr.setRowFilter(RowFilter.regexFilter(bookiddser.getText().trim()));
    }//GEN-LAST:event_bookiddserKeyReleased

    private void bookiddserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookiddserFocusGained
        //search book id 
        if(bookiddser.getText().equals("Enter Book ID")){
            bookiddser.setText("");
            bookiddser.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_bookiddserFocusGained

    private void bookiddserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bookiddserFocusLost
      // focues lost dashbord
         if(bookiddser.getText().equals("")){
            bookiddser.setText("Enter Book ID");
            bookiddser.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_bookiddserFocusLost

    private void serlist_studFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serlist_studFocusGained
       //search student  
         if(serlist_stud.getText().equals("Search Student")){
            serlist_stud.setText("");
            serlist_stud.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_serlist_studFocusGained

    private void serlist_studFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_serlist_studFocusLost
          // focues lost dashbord
         if(serlist_stud.getText().equals("")){
            serlist_stud.setText("Search Student");
            serlist_stud.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_serlist_studFocusLost

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
       // issue book clr
        iss_book_name.setText("");
        iss_auth_name.setText("");
        iss_pub_name.setText("");
        iss_bok_edi.setText("");
       
      
       iss_cour_type.setText("");
        iss_book_search_set.setText("");
      iss_subject.setText("");
      iss_stu_id.setText("");
       iss_stud_fir_name.setText("");
        iss_mob_no_stu.setText("");
        iss_cour_type.setText("");
        pub_date_iss.setText("");
        iss_stu_last_name.setText("");
        qtybook_set.setText("");
    }//GEN-LAST:event_jButton23ActionPerformed

    private void stu_rep_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stu_rep_searchFocusGained
        // Student Report
        if(stu_rep_search.getText().equals("Search Student")){
            stu_rep_search.setText("");
            stu_rep_search.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_stu_rep_searchFocusGained

    private void stu_rep_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stu_rep_searchFocusLost
        // student report
         if(stu_rep_search.getText().equals("")){
            stu_rep_search.setText("Search Student");
            stu_rep_search.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_stu_rep_searchFocusLost

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        //student report search 
          DefaultTableModel tblmodel = (DefaultTableModel)bok_rep_tbl.getModel();
       tblmodel.setRowCount(0);
        datatabelload4();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void iss_book_search_setFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iss_book_search_setFocusGained
        // search Book ID issue date
        if(iss_book_search_set.getText().equals("Search Book ID")){
            iss_book_search_set.setText("");
            iss_book_search_set.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_iss_book_search_setFocusGained

    private void iss_book_search_setFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iss_book_search_setFocusLost
        // search book id in issue
          if(iss_book_search_set.getText().equals("")){
            iss_book_search_set.setText("Search Book ID");
            iss_book_search_set.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_iss_book_search_setFocusLost

    private void ret_ser_id_bokkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ret_ser_id_bokkFocusGained
        // search student id for retrun book
        if(ret_ser_id_bokk.getText().equals("Search Student Id")){
            ret_ser_id_bokk.setText("");
            ret_ser_id_bokk.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_ret_ser_id_bokkFocusGained

    private void ret_ser_id_bokkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ret_ser_id_bokkFocusLost
        // Search student id dor return book
          if(ret_ser_id_bokk.getText().equals("")){
            ret_ser_id_bokk.setText("Search Student Id");
            ret_ser_id_bokk.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_ret_ser_id_bokkFocusLost

    private void studidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studidKeyPressed
/*    //student id set
     try{
           pst2 = con.prepareStatement("SELECT `id`, `book_id`, `Book_name`, `auther_name`, `publication_name`, `book_edition`, `subject`, `course_type`, `book_issue_date`, `book_return_date`, `status`, `stud_id`, `stdname`, `course_typ`, `mob_stud` FROM `issue_book_set` WHERE stud_id=?"); 
           int rm1 =Integer.parseInt(studid.getText());
           pst2.setInt(1, rm1);
           rs = pst2.executeQuery();
            
            if(rs.next()==false){
             JOptionPane.showMessageDialog(this, "Recored Save Successfully");
            }
            else{
              JOptionPane.showMessageDialog(this, "Recored");
            }
             }catch(HeadlessException | SQLException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());

            }
    */ 
    }//GEN-LAST:event_studidKeyPressed

    private void jPanel15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel15KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15KeyPressed

    private void studidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studidKeyReleased
   //student id set
     try{
           pst2 = con.prepareStatement("SELECT `id`, `book_id`, `Book_name`, `auther_name`, `publication_name`, `book_edition`, `subject`, `course_type`, `book_issue_date`, `book_return_date`, `status`, `stud_id`, `stdname`, `course_typ`, `mob_stud` FROM `issue_book_set` WHERE stud_id=?"); 
           int rm1 =Integer.parseInt(studid.getText());
           pst2.setInt(1, rm1);
           rs = pst2.executeQuery();
            
            if(rs.next()==false){
             
            }
            else{
              JOptionPane.showMessageDialog(this, "Already Id Set For Another Student Change ID ");
            }
             }catch(HeadlessException | SQLException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());

            }
    }//GEN-LAST:event_studidKeyReleased

  
    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Au_Name;
    private javax.swing.JTextField B_Name;
    private javax.swing.JTextField Book_id_set;
    private javax.swing.JTextField Edi_B;
    private javax.swing.JPanel Pincard;
    private javax.swing.JTextField aadh_no_stu;
    private javax.swing.JTextArea add_Student_ap;
    private javax.swing.JTextField auuuth_ret;
    private javax.swing.JTextArea bok_Band_iss;
    private javax.swing.JTable bok_rep_tbl;
    private javax.swing.JTextField bokk_qty_ss;
    private javax.swing.JTextField book_edition_ret;
    private javax.swing.JTable book_list_show;
    private javax.swing.JTextField bookiddser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cou_ty;
    private javax.swing.JTextField cur_set_std3;
    private javax.swing.JTable dash_bo_set;
    private javax.swing.JTextField data_sort_jt_db;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField fname_stu;
    private javax.swing.JTextField iss_auth_name;
    private javax.swing.JTextField iss_bok_edi;
    private javax.swing.JTextField iss_book_name;
    private javax.swing.JTextField iss_book_search_set;
    private javax.swing.JTextField iss_cour_type;
    private com.toedter.calendar.JDateChooser iss_date_set;
    private javax.swing.JTextField iss_mob_no_stu;
    private javax.swing.JTextField iss_pub_name;
    private javax.swing.JTextField iss_ret_date_stu;
    private javax.swing.JTextField iss_stu_id;
    private javax.swing.JTextField iss_stu_last_name;
    private javax.swing.JTextField iss_stud_fir_name;
    private javax.swing.JTextField iss_subject;
    private javax.swing.JTextField iss_subject3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField last_name_St;
    private javax.swing.JTextArea lose_pg_see;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField middl_nam_stu;
    private javax.swing.JTextField mob_No_stu;
    private javax.swing.JTextField pbli_ret_student_set;
    private javax.swing.JTextArea pgn_dmg;
    private com.toedter.calendar.JDateChooser pub_Date;
    private javax.swing.JTextField pub_Name;
    private javax.swing.JTextField pub_date_iss;
    private javax.swing.JTextField qtybook_set;
    private com.toedter.calendar.JDateChooser retDate_set;
    private javax.swing.JTextField ret_dat_ret;
    private javax.swing.JTextField ret_ser_id_bokk;
    private javax.swing.JTextField ret_stu_bok;
    private javax.swing.JComboBox<String> selc_cour_stu;
    private javax.swing.JTextField ser_rpt_for_book;
    private javax.swing.JTextField serlist_stud;
    public javax.swing.JLabel stf_name_show;
    private javax.swing.JTable stu_rep_displ;
    private javax.swing.JTextField stu_rep_search;
    private javax.swing.JTextField stud_iddd;
    private javax.swing.JTable stud_list_see_sho;
    private javax.swing.JTextField stud_mobi_set_art;
    private javax.swing.JTextField stud_ret_fname_Set;
    private javax.swing.JTextField studid;
    private javax.swing.JTextField sub_Book;
    private javax.swing.JTextField upBok_Au;
    private javax.swing.JTextField upBok_Edi;
    private javax.swing.JTextField upBok_Name;
    private javax.swing.JTextField upBok_corType;
    private javax.swing.JTextField upBok_id;
    private javax.swing.JTextField upBok_pub_date;
    private javax.swing.JTextField upBok_pub_name;
    private javax.swing.JTextField upsub_set;
    // End of variables declaration//GEN-END:variables
private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/src/lib_icon.png")));
    }
}
