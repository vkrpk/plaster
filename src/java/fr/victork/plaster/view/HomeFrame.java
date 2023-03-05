package fr.victork.plaster.view;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.AbstractTableModel;

import fr.victork.plaster.controller.Medication;
import fr.victork.plaster.controller.Prescription;
import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.main.Main;
import fr.victork.plaster.tools.Tools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class HomeFrame extends JFrame implements Tools {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private JDesktopPane desktopPane = new JDesktopPane();
    private JButton btnMedication = new JButton("Medication");
    private JButton btnPrescriptionHistory = new JButton("Prescription history");
    private JButton btnDetailsByCustomer = new JButton("Details by customer");
    private JPanel contentPane = (JPanel) this.getContentPane();
    private JTable table = new JTable();

    private JComboBox dropdownList = new JComboBox();


    //--------------------- CONSTRUCTORS ---------------------------------------
    public HomeFrame() throws ExceptionEntity {
        super("Plaster");
        btnMedication.addActionListener(this::btnMedicationListener);
        btnPrescriptionHistory.addActionListener(this::btnPrescriptionHistoryListener);
        btnDetailsByCustomer.addActionListener(this::btnDetailsByCustomerListener);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 400);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
        this.setLocation(screenWidth - windowWidth, screenHeight - windowHeight);
        //this.setLocationRelativeTo(null);

        //this.desktopPane.setBackground(Color.RED);
        this.createStatusBarAndSideMenu();

        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        this.contentPane.add(scrollPane, BorderLayout.LINE_END);
        getDropdownList();
        this.contentPane.add(dropdownList, BorderLayout.NORTH);
        dropdownList.addActionListener(this::dropdownListener);
        /*JInternalFrame firstWindow = new JInternalFrame("Première fenêtre");
        firstWindow.setSize(300,200);
        firstWindow.setVisible(true);
        firstWindow.setResizable(true);
        desktopPane.add( firstWindow );

        JInternalFrame secondWindow = new JInternalFrame("Seconde fenêtre");
        secondWindow.setSize(300,200);
        secondWindow.setVisible(true);
        secondWindow.setResizable(true);
        secondWindow.setClosable( true );
        secondWindow.setIconifiable( true );
        secondWindow.setMaximizable( true );
        secondWindow.setLocation(20,20);
        desktopPane.add( secondWindow );

        // Pass the second view to front
        try {
            secondWindow.moveToFront();
            secondWindow.setSelected( true );
        } catch ( PropertyVetoException exception ) {
            exception.printStackTrace();
        }
        contentPane.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        */
    }


    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    private void dropdownListener(ActionEvent actionEvent) {
        System.out.println("test");
    }
    private void btnMedicationListener(ActionEvent event)  {
        try {
            new MedicationFrame();
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
    private void btnPrescriptionHistoryListener(ActionEvent event){

    }
    private void btnDetailsByCustomerListener(ActionEvent event){
    }
    private void createStatusBarAndSideMenu() {
        JPanel sideMenu = new JPanel();
        sideMenu.setLayout(new BoxLayout(sideMenu, BoxLayout.Y_AXIS));
        //Border borderRight = BorderFactory.createMatteBorder(0, 0, 0, 1, Color.black);
        //.setBorder(borderRight);
        sideMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sideMenu.setBackground(Color.lightGray);
        sideMenu.add(this.btnMedication);
        sideMenu.add(this.btnPrescriptionHistory);
        sideMenu.add(this.btnDetailsByCustomer);
        this.contentPane.add(sideMenu, BorderLayout.LINE_START);

        JLabel statusBar = new JLabel(new ImageIcon("src/images/image.jpg"));
        statusBar.setPreferredSize(new Dimension(0, 40));
        this.contentPane.add(statusBar, BorderLayout.PAGE_END);
    }

    public void getDropdownList(){
        for (Prescription prescription: Prescription.getListOfPrescription()
        ) {
            this.dropdownList.addItem(prescription.getIdPrescription() + " - " + prescription.getCustomer().getName() +
                    " - " +
                    prescription.getDatePrescription());
        }
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    public static void main(String[] args) throws Exception {
        JFrame.setDefaultLookAndFeelDecorated(true);
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        HomeFrame homeFrame = new HomeFrame();
        homeFrame.setVisible(true);
    }
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
    class MyTableModel extends AbstractTableModel {
        private Object[][] data ;
        public MyTableModel() throws ExceptionEntity {
            Main.initData();
            this.setData();
        }
        private String[] columnNames = {"Prescription date", "Prescript", "Customer"};
        public void setData(){
            ArrayList<Prescription> prescriptions = (ArrayList<Prescription>) Prescription.getListOfPrescription();
            this.data = new Object[prescriptions.size()][3];

            for (int i = 0; i < prescriptions.size(); i++) {
                Prescription prescription = prescriptions.get(i);
                this.data[i][0] = prescription.getDatePrescription();
                this.data[i][1] = prescription.getPrescriber().getName();
                this.data[i][2] = prescription.getCustomer().getName();
            }
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/ editor for
         * each cell. If we didn't implement this method, then the last column
         * would contain text ("true"/"false"), rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i = 0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j = 0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
}
