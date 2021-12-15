import java.awt.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class leaderboard {
    // common variables
    String image = "Images\\bg.jpg";
    String driverName = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/theif_catching_name";
    String userName = "root";
    String password = "Tarang@1234";
    String[] columnNames = {"name", "score", "Ranking"};
    JFrame fPlayer;      // f2
    ImageIcon imgIcon;   // i2
    JLabel lBg, ltitle;    // l2
    JButton bSpecific, bAll;
    JTextField tSearch;
    DefaultTableModel playerModel;       // model1
    JTable playerTabel;
    JScrollPane playerScroll;

    leaderboard()
    {
        layout();
        showAllRecords();
    }

    public void layout()
    {
        fPlayer = new JFrame("Leaderboard");

        // background image
        imgIcon = new ImageIcon(image);
        lBg = new JLabel(imgIcon, JLabel.CENTER);
        lBg.setBounds(0, 0, 520, 520);
        lBg.setBackground(Color.BLACK);
        lBg.setLayout(null);
        fPlayer.add(lBg);

        // search label, text box and button
        ltitle = new JLabel("Enter Player Name");
        ltitle.setBounds(10, 20, 400, 20);
        lBg.add(ltitle);
        tSearch = new JTextField();
        tSearch.setBounds(10, 50, 100, 20);
        lBg.add(tSearch);
        bSpecific = new JButton("Search");
        bSpecific.setBounds(120, 50, 100, 20);
        lBg.add(bSpecific);
        bSpecific.addActionListener((java.awt.event.ActionEvent evt) -> {
            showSpecificRecords();
        });

        // button to show all records
        bAll = new JButton("All Records");
        bAll.setBounds(230, 50, 100, 20);
        lBg.add(bAll);
        bAll.addActionListener((java.awt.event.ActionEvent evt) -> {
            showAllRecords();
        });

        // table
        playerModel = new DefaultTableModel();
        playerModel.setColumnIdentifiers(columnNames);
        playerTabel = new JTable(playerModel);
        playerTabel.setFillsViewportHeight(true);
        playerTabel.getColumnModel().getColumn(0).setPreferredWidth(50);
        playerTabel.getColumnModel().getColumn(1).setPreferredWidth(200);
        playerTabel.getColumnModel().getColumn(2).setPreferredWidth(100);
        playerScroll = new JScrollPane(playerTabel);
        playerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        playerScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        playerScroll.setBounds(10, 100, 500, 400);
        lBg.add(playerScroll);

        // frame specifications
        fPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fPlayer.setSize(540, 540);
        fPlayer.setLocationRelativeTo(null);
        fPlayer.setResizable(false);
        fPlayer.setVisible(true);
    }

  
    public void showAllRecords()
    {
        playerModel.setRowCount(0);
        String playerName= "";
        String playerTime= "";
        String playerRank = "";
        try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql1 = "SET @r=0";
            String sql2 = "SELECT *, @r:= (@r+1) as Ranking FROM leaderboard ORDER BY score ASC";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.executeUpdate();
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next())
            {
                playerName = rs2.getString("name");
                playerTime = rs2.getString("score");
                playerRank = rs2.getString("Ranking");
                playerModel.addRow(new Object[]{playerName, playerTime, playerRank});
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showSpecificRecords()
    {
        playerModel.setRowCount(0);
        String textvalue = tSearch.getText();
        int i = 0;
        String playerRank= "";
        String playerName;
        String playerTime= "";
        try
        {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, password);
            String sql1 = "SET @r=0";
            String sql2 = "SELECT *, @r:= (@r+1) as Ranking FROM leaderboard ORDER BY score ASC";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.executeUpdate();
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next())
            {
                playerName = rs2.getString("name");
                if(playerName.equals(textvalue))
                {
                    playerTime = rs2.getString("score");
                    playerRank = rs2.getString("Ranking");
                    playerModel.addRow(new Object[]{playerName, playerTime, playerRank});
                    i++;
                }
            }
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error", JOptionPane.ERROR_MESSAGE);
                showAllRecords();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
}

