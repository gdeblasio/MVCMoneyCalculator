package mvcmoneycalculator.view;

import java.awt.event.ActionListener;
import javax.swing.*;

public class MoneyCalculatorView extends JFrame {
    private final JTextField amount = new JTextField(10);
    private final JComboBox from = new JComboBox();
    private final JComboBox to = new JComboBox();
    JButton exchangeButton = new JButton("Cambio");
    JTextField exchange = new JTextField(10);    

    public MoneyCalculatorView() {
        this.setTitle("MoneyCalculator");
        JPanel mcPanel = new JPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setSize(600, 200);
        
        mcPanel.add(amount);
        mcPanel.add(from);
        rellenaCombo(from);
        mcPanel.add(to);
        rellenaCombo(to);
        mcPanel.add(exchangeButton);
        mcPanel.add(exchange);
        exchange.setEditable(false);
        
        this.add(mcPanel);
        pack();
    }

    public double getAmount() {
        return Double.parseDouble(amount.getText());
    }
    
    public String getFrom() {
        return from.getSelectedItem().toString();
    }
    
    public String getTo() {
        return to.getSelectedItem().toString();
    }
    
    public void setExchange(double r) {
        exchange.setText(Double.toString(r));
    }
    
    public void addRateListener(ActionListener listenForRateButton) {
        exchangeButton.addActionListener(listenForRateButton);
    }
    
    public void DisplayErrorMessage(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    private void rellenaCombo(JComboBox comboBox) {
        comboBox.addItem("USD");
        comboBox.addItem("EUR");
        comboBox.addItem("GBP");
    }
}
