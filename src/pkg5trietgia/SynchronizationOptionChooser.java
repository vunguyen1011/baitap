package pkg5trietgia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class SynchronizationOptionChooser extends JFrame {
    private String selectedOption;
    private Consumer<String> callback;

   public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        Consumer<String> callback = synchronizationChoice -> {
                System.out.println("Selected synchronization choice: " + synchronizationChoice);
         
        };
        SynchronizationOptionChooser syncChooser = new SynchronizationOptionChooser(callback);
        syncChooser.setVisible(true);
    });
}


    public SynchronizationOptionChooser(Consumer<String> callback) {
        setTitle("Synchronization Option Chooser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton monitorButton = new JButton("Monitor");
        JButton semaphoreButton = new JButton("Semaphore");
        JButton mutexButton = new JButton("Mutex");

        monitorButton.addActionListener(new OptionButtonListener("Monitor"));
        semaphoreButton.addActionListener(new OptionButtonListener("Semaphore"));
        mutexButton.addActionListener(new OptionButtonListener("Mutex"));

        panel.add(monitorButton);
        panel.add(semaphoreButton);
        panel.add(mutexButton);

        add(panel);

        this.callback = callback;
    }

    private class OptionButtonListener implements ActionListener {
        private String selectedOption;

        public OptionButtonListener(String option) {
            this.selectedOption = option;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int result = JOptionPane.showConfirmDialog(
                    SynchronizationOptionChooser.this,
                    "You selected: " + selectedOption + "\nDo you want to proceed?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION
            );
            if (result == JOptionPane.YES_OPTION) {
                startSynchronization(selectedOption);
                // Only call the callback where necessary
                callback.accept(selectedOption);
            }
        }

        private void startSynchronization(String option) {
            System.out.println("Starting synchronization with: " + option);
            SynchronizationOptionChooser.this.selectedOption = option;
            SynchronizationOptionChooser.this.dispose();
        }
    }
}
