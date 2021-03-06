package gui;

import io.CSVReader;
import io.JSONReader;
import optimizer.Optimizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartGUI extends JFrame {

    /// Attributes

    private JTextField fastMA_min = new JTextField("", 5);
    private JTextField fastMA_max = new JTextField("", 5);

    private JTextField midMA_min = new JTextField("", 5);
    private JTextField midMA_max = new JTextField("", 5);

    private JTextField slowMA_min = new JTextField("", 5);
    private JTextField slowMA_max = new JTextField("", 5);

    private JButton button = new JButton("Optimize!");

    private transient Object[] type_MA = {"Simple", "Exponential"};
    private JComboBox<Object> cbox_TypeMA = new JComboBox(type_MA);

    private transient Object[] optimCond = {"Net profit", "Winning ratio"};
    private JComboBox<Object> cbox_optimCond = new JComboBox(optimCond);


    class OkButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {


            int i1 = Integer.parseInt(fastMA_min.getText());
            int i2 = Integer.parseInt(fastMA_max.getText());

            int i3 = Integer.parseInt(midMA_min.getText());
            int i4 = Integer.parseInt(midMA_max.getText());

            int i5 = Integer.parseInt(slowMA_min.getText());
            int i6 = Integer.parseInt(slowMA_max.getText());

            Optimizer myOptimizer = new Optimizer(i1, i2, i3, i4, i5, i6, (String) cbox_TypeMA.getSelectedItem(), new CSVReader("data/EURUSD_15m_2010-2016_v2.csv"));
            //Optimizer myOptimizer = new Optimizer(i1, i2, i3, i4, i5, i6, (String) cbox_TypeMA.getSelectedItem(), new JSONReader("data/jsonInput_M15.json"));

            //myOptimizer.importData();
            myOptimizer.importData();

            myOptimizer.initTraders();

            String optimCondition = (String) cbox_optimCond.getSelectedItem();

            if (optimCondition.equals("Net profit"))
                myOptimizer.maxProfit();

            else if (optimCondition.equals("Winning ratio"))
                myOptimizer.maxWR();

            myOptimizer.getResults();

        }

    }



    /// Methods

    public StartGUI() {

        super();

        this.setTitle("SwingLab");
        this.setSize(400, 200);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        button.addActionListener(new OkButtonActionListener());


        // JPanel -- GridBagLayout
        JPanel pane = new JPanel();
        pane.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();


        // 1. sor
        JLabel row1Lab = new JLabel("Gyors MA peri??dus: ", SwingConstants.RIGHT);
        c.weightx = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_END;
        pane.add(row1Lab, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(this.fastMA_min, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(fastMA_max, c);


        // 2. sor
        JLabel row2Lab = new JLabel("K??zepes MA peri??dus: ", SwingConstants.RIGHT);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.PAGE_END;
        pane.add(row2Lab, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(this.midMA_min, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(this.midMA_max, c);


        // 3. sor
        JLabel row3Lab = new JLabel("Lass?? MA peri??dus: ", SwingConstants.RIGHT);
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        pane.add(row3Lab, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(this.slowMA_min, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(this.slowMA_max, c);


        // 4. sor
        JLabel row4Lab = new JLabel("MA t??pusa: ", SwingConstants.RIGHT);
        c.weightx = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(row4Lab, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 3;
        pane.add(this.cbox_TypeMA, c);


        // 5. sor
        JLabel row5Lab = new JLabel("Optimaliz??l??si krit??rium: ", SwingConstants.RIGHT);
        c.weightx = 0.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 4;
        pane.add(row5Lab, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 4;
        pane.add(this.cbox_optimCond, c);


        // 6. sor
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 5;
        pane.add(this.button, c);


        this.add(pane);

    }

}
