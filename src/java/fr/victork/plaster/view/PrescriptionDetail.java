package fr.victork.plaster.view;

import fr.victork.plaster.controller.Prescription;
import fr.victork.plaster.exception.ExceptionEntity;
import fr.victork.plaster.main.Main;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PrescriptionDetail extends JFrame {
    //--------------------- CONSTANTS ------------------------------------------
    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    private JPanel contentPane = (JPanel) this.getContentPane();
    private JTable table = new JTable();
    //--------------------- CONSTRUCTORS ---------------------------------------
    public PrescriptionDetail() throws UnsupportedLookAndFeelException {
        initFrame();

        JScrollPane panDropdownList = new JScrollPane(this.dropdownList);
        contentPane.add(panDropdownList, BorderLayout.CENTER);
    }
    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    public void initFrame(){
        setTitle("Prescriptions");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 200);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowWidth = this.getWidth();
        int windowHeight = this.getHeight();
        this.setLocation(screenWidth - windowWidth, screenHeight - windowHeight);

        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }catch (UnsupportedLookAndFeelException ulafe){
            System.out.println("There is an error, here it is : " + ulafe.getMessage());
        }
        setVisible(true);
    }
    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
    class MyTableModel extends AbstractTableModel {
        private Object[][] data ;
        public MyTableModel() throws ExceptionEntity {
            this.setData();
        }
        private String[] columnNames = {"Medication name", "Quantity"};
        public void setData(){
            ArrayList<Prescription> prescriptions = (ArrayList<Prescription>) Prescription.getListOfPrescription();
            this.data = new Object[prescriptions.size()][2];

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
