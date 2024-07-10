package JDBC_Demo;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class JDBC_GUI extends Frame implements ActionListener {
    Label label;
    TextField textField;
    TextArea textArea;

    public JDBC_GUI() {
        setLayout(new FlowLayout());

        label = new Label("Enter ID No.: ");
        add(label);

        textField = new TextField(20);
        add(textField);

        textArea = new TextArea(5, 30);
        add(textArea);

        textField.addActionListener(this);

        setTitle("Student Details");
        setSize(400, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String ids = textField.getText();
        try {
            String query= "SELECT id, name FROM studentinfo where id="+ids;
            JDBC_Connection.setDatabaseDetails("studentdemo","postgres","postgres");
            ResultSet rs = JDBC_Connection.getResult(query);
            while (rs.next()) {
                int idn = rs.getInt("id");
                String name = rs.getString("name");
                textArea.setText("ID: " + idn + ", Name: " + name);
            }
            JDBC_Connection.closeResources();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBC_GUI();
    }
}

