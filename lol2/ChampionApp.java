package lol2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ChampionApp extends JFrame {
    private JTextArea output;

    public ChampionApp() {
        setTitle("Gestor de Campions LoL");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        output = new JTextArea();
        output.setEditable(false);
        add(new JScrollPane(output), BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton btnList = new JButton("Llistar Campions");
        JButton btnSearch = new JButton("Veure Campió");
        JButton btnAdd = new JButton("Afegir Campió");

        buttons.add(btnList);
        buttons.add(btnSearch);
        buttons.add(btnAdd);
        add(buttons, BorderLayout.SOUTH);

        btnList.addActionListener(e -> listChampions());
        btnSearch.addActionListener(e -> searchChampion());
        btnAdd.addActionListener(e -> addChampion());
    }

    private void listChampions() {
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, title, tags FROM champions")) {

            StringBuilder sb = new StringBuilder("Campions:\n");
            while (rs.next()) {
                sb.append(rs.getInt("id")).append(" - ")
                        .append(rs.getString("name")).append(" - ")
                        .append(rs.getString("title")).append(" - ")
                        .append(rs.getString("tags")).append("\n");
            }
            output.setText(sb.toString());
        } catch (Exception ex) {
            output.setText("Error: " + ex.getMessage());
        }
    }

    private void searchChampion() {
        String input = JOptionPane.showInputDialog(this, "ID o Nom del campió:");
        if (input == null || input.isBlank()) return;

        String sql = input.matches("\\d+") ?
                "SELECT * FROM champions WHERE id = ?" :
                "SELECT * FROM champions WHERE name LIKE ?";

        try (Connection conn = Database.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (input.matches("\\d+")) ps.setInt(1, Integer.parseInt(input));
            else ps.setString(1, "%" + input + "%");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                output.setText("Nom: " + rs.getString("name") + "\n"
                        + "Títol: " + rs.getString("title") + "\n"
                        + "Tags: " + rs.getString("tags") + "\n"
                        + "Lore: " + rs.getString("lore"));
            } else {
                output.setText("No s'ha trobat cap campió.");
            }
        } catch (Exception ex) {
            output.setText("Error: " + ex.getMessage());
        }
    }

    private void addChampion() {
        JTextField name = new JTextField();
        JTextField title = new JTextField();
        JTextField tags = new JTextField();
        JTextField lore = new JTextField();
        Object[] fields = {
                "Nom:", name,
                "Títol:", title,
                "Tags:", tags,
                "Lore:", lore
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Nou Campió", JOptionPane.OK_CANCEL_OPTION);
        if (option != JOptionPane.OK_OPTION) return;

        try (Connection conn = Database.connect()) {
            // Check if name already exists
            PreparedStatement check = conn.prepareStatement("SELECT COUNT(*) FROM champions WHERE name = ?");
            check.setString(1, name.getText());
            ResultSet rs = check.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                output.setText("Ja existeix un campió amb aquest nom.");
                return;
            }

            PreparedStatement insert = conn.prepareStatement("INSERT INTO champions(name, title, tags, lore) VALUES (?, ?, ?, ?)");
            insert.setString(1, name.getText());
            insert.setString(2, title.getText());
            insert.setString(3, tags.getText());
            insert.setString(4, lore.getText());

            int rows = insert.executeUpdate();
            output.setText(rows > 0 ? "Campió afegit correctament." : "No s'ha pogut afegir.");
        } catch (Exception ex) {
            output.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChampionApp().setVisible(true));
    }
}

