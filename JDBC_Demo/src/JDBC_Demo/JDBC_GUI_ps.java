package JDBC_Demo;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class JDBC_GUI_ps extends Frame implements ActionListener{
    Label label;
    TextField textField;
    TextArea textArea;

    public JDBC_GUI_ps() {
        setLayout(new FlowLayout());

        label = new Label("Enter Name: ");
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
        try {
            String na = textField.getText();
            //int idx=Integer.parseInt(ids);
            String query= "SELECT id, name FROM studentinfo where name=?";
            JDBC_Connection_ps.setDatabaseDetails("studentdemo","postgres","postgres");
            ResultSet rs = JDBC_Connection_ps.getResult(query,na);
            while (rs.next()) {
                int idn = rs.getInt("id");
                String name = rs.getString("name");
                textArea.append("ID: " + idn + ", Name: " + name+"\n");
            }
            JDBC_Connection_ps.closeResources();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new JDBC_GUI_ps();
    }
}
