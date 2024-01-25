    package pkg5trietgia;

    import java.awt.EventQueue;

    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.border.EmptyBorder;
    import javax.swing.SwingUtilities;
    import javax.swing.JLabel;
    import java.awt.Font;
    import java.util.ArrayList;
    import java.util.Timer;
    import java.util.TimerTask;

    import javax.swing.SwingConstants;
    import java.awt.Color;
    import javax.swing.ImageIcon;
    import javax.swing.JProgressBar;
    import javax.swing.JTextArea;

    public class DiningAppGui extends JFrame {

            /**
             * 
             */
                private static final long serialVersionUID = -9102921349267475005L;
                private JPanel contentPane;
                private DiningTable diningTable;
                private ArrayList<JLabel> forkLabelList = new ArrayList<>();
                private ArrayList<JLabel> philosopherLabelList = new ArrayList<>();
                private ArrayList<JProgressBar> progressBars = new ArrayList<>();
                private ArrayList<JLabel> zzzList = new ArrayList<>();
                private ArrayList<JLabel> finishedList = new ArrayList<>();
                private DiningApp diningApp;
               private SynchronizationMechanism synchronizationMechanism;
                /**
                 * Launch the application.
                    */
 public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        SynchronizationOptionChooser syncChooser = new SynchronizationOptionChooser(synchronizationChoice -> {
            if (synchronizationChoice != null) {
                DiningAppGui frame = new DiningAppGui(synchronizationChoice);
                frame.setVisible(true);
            } else {
                System.out.println("No synchronization option selected.");
            }
        });

        syncChooser.setVisible(true);
    });
}




             public DiningAppGui(String synchronizationChoice) {
                        SynchronizationMechanism syncMechanism;

                        syncMechanism = switch (synchronizationChoice) {
                        case "Semaphore" -> new SemaphoreMechanism();
                        case "Monitor" -> new MonitorMechanism();
                        case "Mutex" -> new MutexMechanism();
                        default -> throw new IllegalArgumentException("Invalid synchronization choice: " + synchronizationChoice);
                    };
                        
                diningApp = new DiningApp(syncMechanism);

                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setBounds(100, 100, 969, 660);
                        contentPane = new JPanel();
                        contentPane.setBackground(Color.WHITE);
                        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                        contentPane.setLayout(null);
                        setContentPane(contentPane);


                        JLabel lblPhilosopher_1 = new JLabel();
                        lblPhilosopher_1.setOpaque(true);
                        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/anh1.jpg"));
                        lblPhilosopher_1.setIcon(icon);
                        lblPhilosopher_1.setText("Philosopher 1");
                        lblPhilosopher_1.setVerticalTextPosition(SwingConstants.TOP);
                        lblPhilosopher_1.setHorizontalAlignment(SwingConstants.CENTER);
                        lblPhilosopher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
                        lblPhilosopher_1.setBounds(543, 206, 120, 100);
                        philosopherLabelList.add(lblPhilosopher_1);
                        contentPane.add(lblPhilosopher_1);

                        JLabel lblPhilosopher_2 = new JLabel();
                        lblPhilosopher_2.setOpaque(true);
                        ImageIcon icon1 = new ImageIcon(getClass().getResource("/resources/anh2.jpg"));
                        lblPhilosopher_2.setIcon(icon1);
                        lblPhilosopher_2.setHorizontalAlignment(SwingConstants.CENTER);
                        lblPhilosopher_2.setFont(new Font("Tahoma", Font.BOLD, 12));
                        lblPhilosopher_2.setBounds(590, 402, 125, 110);
                        philosopherLabelList.add(lblPhilosopher_2);
                        contentPane.add(lblPhilosopher_2);

                        JLabel lblPhilosopher_3 = new JLabel();
                        lblPhilosopher_3.setOpaque(true);
                       ImageIcon icon3 = new ImageIcon(getClass().getResource("/resources/anh3.jpg"));
                        lblPhilosopher_3.setIcon(icon3);
                        lblPhilosopher_3.setHorizontalAlignment(SwingConstants.CENTER);
                        lblPhilosopher_3.setFont(new Font("Tahoma", Font.BOLD, 12));
                        lblPhilosopher_3.setBounds(410, 480, 115, 100);
                        philosopherLabelList.add(lblPhilosopher_3);
                        contentPane.add(lblPhilosopher_3);

                        JLabel lblPhilosopher_4 = new JLabel("Philosopher 4");
                        ImageIcon icon4 = new ImageIcon(getClass().getResource("/resources/anh4.jpg"));
                        lblPhilosopher_4.setIcon(icon4);
                        lblPhilosopher_4.setHorizontalAlignment(SwingConstants.CENTER);
                        lblPhilosopher_4.setFont(new Font("Tahoma", Font.BOLD, 12));
                        lblPhilosopher_4.setBounds(213, 402, 115, 100);
                        philosopherLabelList.add(lblPhilosopher_4);
                        contentPane.add(lblPhilosopher_4);

                        JLabel lblPhilosopher_5 = new JLabel();
                        lblPhilosopher_5.setOpaque(true);
                        ImageIcon icon5 = new ImageIcon(getClass().getResource("/resources/anh5.jpg"));
                        lblPhilosopher_5.setIcon(icon5);
                        lblPhilosopher_5.setHorizontalAlignment(SwingConstants.CENTER);
                        lblPhilosopher_5.setFont(new Font("Tahoma", Font.BOLD, 12));
                        lblPhilosopher_5.setBounds(257, 206, 130, 110);
                        philosopherLabelList.add(lblPhilosopher_5);
                        contentPane.add(lblPhilosopher_5);

                        JLabel lblFork_1 = new JLabel("fork 1");
                        lblFork_1.setBackground(new Color(205, 92, 92));
                        lblFork_1.setOpaque(true);
                        lblFork_1.setHorizontalAlignment(SwingConstants.CENTER);
                        lblFork_1.setBounds(571, 310, 66, 27);
                        forkLabelList.add(lblFork_1);
                        contentPane.add(lblFork_1);

                        JLabel lblFork_2 = new JLabel("fork 2");
                        lblFork_2.setBackground(new Color(205, 92, 92));
                        lblFork_2.setOpaque(true);
                        lblFork_2.setHorizontalAlignment(SwingConstants.CENTER);
                        lblFork_2.setBounds(504, 450, 66, 27);
                        forkLabelList.add(lblFork_2);
                        contentPane.add(lblFork_2);

                        JLabel lblFork_3 = new JLabel("fork 3");
                        lblFork_3.setBackground(new Color(205, 92, 92));
                        lblFork_3.setOpaque(true);
                        lblFork_3.setHorizontalAlignment(SwingConstants.CENTER);
                        lblFork_3.setBounds(346, 450, 66, 27);
                        forkLabelList.add(lblFork_3);
                        contentPane.add(lblFork_3);

                        JLabel lblFork_4 = new JLabel("fork 4");
                        lblFork_4.setBackground(new Color(205, 92, 92));
                        lblFork_4.setOpaque(true);
                        lblFork_4.setHorizontalAlignment(SwingConstants.CENTER);
                        lblFork_4.setBounds(306, 330, 66, 27);
                        forkLabelList.add(lblFork_4);
                        contentPane.add(lblFork_4);

                        JLabel lblFork_5 = new JLabel("fork 5");
                        lblFork_5.setBackground(new Color(205, 92, 92));
                        lblFork_5.setOpaque(true);
                        lblFork_5.setHorizontalAlignment(SwingConstants.CENTER);
                        lblFork_5.setBounds(425, 228, 66, 27);
                        forkLabelList.add(lblFork_5);
                        contentPane.add(lblFork_5);

                        JProgressBar progressBar_1 = new JProgressBar();
                        progressBar_1.setMaximum(50);
                        progressBar_1.setBounds(630, 173, 146, 22);
                        progressBars.add(progressBar_1);
                        contentPane.add(progressBar_1);

                        JProgressBar progressBar_2 = new JProgressBar();
                        progressBar_2.setMaximum(50);
                        progressBar_2.setBounds(630, 369, 146, 22);
                        progressBars.add(progressBar_2);
                        contentPane.add(progressBar_2);

                        JProgressBar progressBar_3 = new JProgressBar();
                        progressBar_3.setMaximum(50);
                        progressBar_3.setBounds(397, 583, 146, 27);
                        progressBars.add(progressBar_3);
                        contentPane.add(progressBar_3);

                        JProgressBar progressBar_4 = new JProgressBar();
                        progressBar_4.setMaximum(50);
                        progressBar_4.setBounds(102, 369, 146, 22);
                        progressBars.add(progressBar_4);
                        contentPane.add(progressBar_4);

                        JProgressBar progressBar_5 = new JProgressBar();
                        progressBar_5.setMaximum(50);
                        progressBar_5.setBounds(158, 173, 146, 22);
                        progressBars.add(progressBar_5);
                        contentPane.add(progressBar_5);

                        JLabel lblZzz1 = new JLabel("zzz...");
                        lblZzz1.setVisible(false);
                        lblZzz1.setBounds(668, 206, 46, 14);
                        zzzList.add(lblZzz1);
                        contentPane.add(lblZzz1);

                        JLabel lblZzz2 = new JLabel("zzz...");
                        lblZzz2.setVisible(false);
                        lblZzz2.setBounds(715, 402, 46, 14);
                        zzzList.add(lblZzz2);
                        contentPane.add(lblZzz2);

                        JLabel lblZzz3 = new JLabel("zzz...");
                        lblZzz3.setVisible(false);
                        lblZzz3.setBounds(535, 501, 46, 14);
                        zzzList.add(lblZzz3);
                        contentPane.add(lblZzz3);

                        JLabel lblZzz4 = new JLabel("zzz...");
                        lblZzz4.setVisible(false);
                        lblZzz4.setBounds(337, 402, 46, 14);
                        zzzList.add(lblZzz4);
                        contentPane.add(lblZzz4);

                        JLabel lblZzz5 = new JLabel("zzz...");
                        lblZzz5.setVisible(false);
                        lblZzz5.setBounds(382, 206, 46, 14);
                        zzzList.add(lblZzz5);
                        contentPane.add(lblZzz5);

                        JLabel lblFinishedEating1 = new JLabel("Finished eating");
                        lblFinishedEating1.setOpaque(true);
                        lblFinishedEating1.setVisible(false);
                        lblFinishedEating1.setBackground(new Color(255, 20, 147));
                        lblFinishedEating1.setBounds(668, 235, 108, 20);
                        finishedList.add(lblFinishedEating1);
                        contentPane.add(lblFinishedEating1);

                        JLabel lblFinishedEating2 = new JLabel("Finished eating");
                        lblFinishedEating2.setOpaque(true);
                        lblFinishedEating2.setVisible(false);
                        lblFinishedEating2.setBackground(new Color(255, 20, 147));
                        lblFinishedEating2.setBounds(712, 431, 108, 20);
                        finishedList.add(lblFinishedEating2);
                        contentPane.add(lblFinishedEating2);

                        JLabel lblFinishedEating3 = new JLabel("Finished eating");
                        lblFinishedEating3.setOpaque(true);
                        lblFinishedEating3.setVisible(false);
                        lblFinishedEating3.setBackground(new Color(255, 20, 147));
                        lblFinishedEating3.setBounds(529, 530, 108, 20);
                        finishedList.add(lblFinishedEating3);
                        contentPane.add(lblFinishedEating3);

                        JLabel lblFinishedEating4 = new JLabel("Finished eating");
                        lblFinishedEating4.setOpaque(true);
                        lblFinishedEating4.setVisible(false);
                        lblFinishedEating4.setBackground(new Color(255, 20, 147));
                        lblFinishedEating4.setBounds(102, 431, 108, 20);
                        finishedList.add(lblFinishedEating4);
                        contentPane.add(lblFinishedEating4);

                        JLabel lblFinishedEating5 = new JLabel("Finished eating");
                        lblFinishedEating5.setOpaque(true);
                        lblFinishedEating5.setVisible(false);
                        lblFinishedEating5.setBackground(new Color(255, 20, 147));
                        lblFinishedEating5.setBounds(139, 235, 108, 20);
                        finishedList.add(lblFinishedEating5);
                        contentPane.add(lblFinishedEating5);

                        startDining();
                }

                private void startDining() {
                        diningApp.start();
                        Timer timer = new Timer();
                        timer.scheduleAtFixedRate(new TimerTask() {
                                @Override
                                public void run() {
                                        for(Philosopher philosopher : diningApp.getPhilosophers()){
                                                if(!philosopher.isFinished()){
                                                        updateGui();
                                                }
                                                else {
                                                        timeForBed(philosopher);
                                                }
                                        }
                                }
                        }, 2000, 1000);
                }
                protected void timeForBed(Philosopher philosopher) {
                        switch (philosopher.getName()) {
                        case "Philosopher: 1":
                                finishedList.get(0).setVisible(true);
                                break;
                        case "Philosopher: 2":
                                finishedList.get(1).setVisible(true);
                                break;
                        case "Philosopher: 3":
                                finishedList.get(2).setVisible(true);
                                break;
                        case "Philosopher: 4":
                                finishedList.get(3).setVisible(true);
                                break;
                        case "Philosopher: 5":
                                finishedList.get(4).setVisible(true);
                                break;
                        default:
                                break;
                        }
                }
           private void updateGui() {
        SwingUtilities.invokeLater(() -> {
        for (int i = 0; i < diningApp.getPhilosophers().size(); i++) {
            Philosopher philosopher = diningApp.getPhilosophers().get(i);
            if (i < progressBars.size()) {
                progressBars.get(i).setValue(philosopher.getAmountEaten());
                updateSnoozingState(i, philosopher.isSnoozing());
            }
        }
    });
}


        private void updateSnoozingState(int philosopherIndex, boolean isSnoozing) {
            zzzList.get(philosopherIndex).setVisible(isSnoozing);
        }

                private void wakeUp(Philosopher philosopher) {
                        switch (philosopher.getName()) {
                        case "Philosopher: 1":
                                zzzList.get(0).setVisible(false);
                                break;
                        case "Philosopher: 2":
                                zzzList.get(1).setVisible(false);
                                break;
                        case "Philosopher: 3":
                                zzzList.get(2).setVisible(false);
                                break;
                        case "Philosopher: 4":
                                zzzList.get(3).setVisible(false);
                                break;
                        case "Philosopher: 5":
                                zzzList.get(4).setVisible(false);
                                break;
                        default:
                                break;
                        }
                }
                private void putToSleep(Philosopher philosopher) {
                        switch (philosopher.getName()) {
                        case "Philosopher: 1":
                                zzzList.get(0).setVisible(true);
                                break;
                        case "Philosopher: 2":
                                zzzList.get(1).setVisible(true);
                                break;
                        case "Philosopher: 3":
                                zzzList.get(2).setVisible(true);
                                break;
                        case "Philosopher: 4":
                                zzzList.get(3).setVisible(true);
                                break;
                        case "Philosopher: 5":
                                zzzList.get(4).setVisible(true);
                                break;
                        default:
                                break;
                        }
                }
    }

 