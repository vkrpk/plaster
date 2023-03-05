package fr.victork.plaster.view;

import fr.victork.plaster.controller.Medication;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MedicationFrame extends JFrame {
    //--------------------- CONSTANTS ------------------------------------------
    private JComboBox dropdownList = new JComboBox();
    private JPanel contentPane = (JPanel) this.getContentPane();
    private JButton btnCreate = new JButton("Create");
    private JButton btnEdit = new JButton("Edit");
    private JButton btnDelete = new JButton("Delete");

    //--------------------- STATIC VARIABLES -----------------------------------
    //--------------------- INSTANCE VARIABLES ---------------------------------
    //--------------------- CONSTRUCTORS ---------------------------------------
    public MedicationFrame() throws UnsupportedLookAndFeelException {
        initFrame();
        getDropdownList();
        JScrollPane panDropdownList = new JScrollPane(this.dropdownList);
        contentPane.add(panDropdownList, BorderLayout.NORTH);
        btnCreate.addActionListener(this::btnMedicationListener);
        btnEdit.addActionListener(this::btnPrescriptionHistoryListener);
        btnDelete.addActionListener(this::btnDetailsByCustomerListener);
    }


    //--------------------- STATIC METHODS -------------------------------------
    //--------------------- INSTANCE METHODS -----------------------------------
    public void initFrame(){
        setTitle("Medications");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(800, 400);
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
    public void getDropdownList(){
        for (Medication medication: Medication.getListOfMedication()
             ) {
            this.dropdownList.addItem(medication.getName());
        }
    }
    private void btnMedicationListener(ActionEvent actionEvent) {

    }

    private void btnPrescriptionHistoryListener(ActionEvent actionEvent) {
    }

    private void btnDetailsByCustomerListener(ActionEvent actionEvent) {
    }

    //--------------------- ABSTRACT METHODS -----------------------------------
    //--------------------- STATIC - GETTERS - SETTERS -------------------------
    //--------------------- GETTERS - SETTERS ----------------------------------
    //--------------------- TO STRING METHOD------------------------------------
}
