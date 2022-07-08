// Oliver De Leon Guzman

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class Main extends JFrame implements ActionListener{
  private JLabel sideA; private JFormattedTextField sideAField;
  private JLabel sideB; private JFormattedTextField sideBField;
  private JLabel sideC; private JFormattedTextField sideCField;
  private JLabel angleA; private JFormattedTextField angleAField;
  private JLabel angleB; private JFormattedTextField angleBField;
  private JLabel angleC; private JFormattedTextField angleCField;
  private JButton calcButton;
  private JButton resetButton;
  private ImageIcon triangle;
  private JLabel triangleLabel;
  private JLabel directions1;
  private JLabel directions2;
  private double numSideA;
  private double numSideB;
  private double numSideC;
  private double numAngleA;
  private double numAngleB;
  

  Main(){
    setTitle("Right Triangle Calculator");
    sideA = new JLabel("Side a:");
    sideB = new JLabel("Side b:");
    sideC = new JLabel("Side c:");
    angleA = new JLabel("Angle A:");
    angleB = new JLabel("Angle B:");
    angleC = new JLabel("Angle C:");

    sideA.setForeground(Color.red);
    sideB.setForeground(Color.red);
    sideC.setForeground(Color.red);
    angleA.setForeground(Color.blue);
    angleB.setForeground(Color.blue);
    angleC.setForeground(Color.blue);
    
    sideAField = new JFormattedTextField(NumberFormat.getNumberInstance());
    sideAField.setColumns(10);
    sideAField.setEditable(true);
    
    
    sideBField = new JFormattedTextField(NumberFormat.getNumberInstance());
    sideBField.setColumns(10);
    sideBField.setEditable(true);
    
    
    sideCField = new JFormattedTextField(NumberFormat.getNumberInstance());
    sideCField.setColumns(10);
    sideCField.setEditable(true);

    angleAField = new JFormattedTextField(NumberFormat.getNumberInstance());
    angleAField.setColumns(10);
    angleAField.setEditable(true);
    
    angleBField = new JFormattedTextField(NumberFormat.getNumberInstance());
    angleBField.setColumns(10);
    angleBField.setEditable(true);

    angleCField = new JFormattedTextField(NumberFormat.getNumberInstance());
    angleCField.setColumns(10);
    angleCField.setText("90");
    angleCField.setEditable(false);

    resetButton = new JButton("Reset");
    resetButton.addActionListener(this);

    calcButton = new JButton("Calculate");
    calcButton.addActionListener(this);

    setLayout(new GridBagLayout());
    GridBagConstraints layoutConst = new GridBagConstraints();

    Font font = new Font("Arial", Font.BOLD, 11);
    directions1 = new JLabel("Enter either one side and one angle or two sides");
    directions1.setFont(font);
    layoutConst.gridwidth = 4;
    layoutConst.gridx = 0;
    layoutConst.gridy = 0;
    layoutConst.insets = new Insets(10, 3, 10, 10);
    add(directions1, layoutConst);

    directions2 = new JLabel("Enter angles in degrees");
    directions2.setFont(font);
    layoutConst.gridx = 0;
    layoutConst.gridy = 1;
    add(directions2, layoutConst);

    
    layoutConst.gridx = 0;
    layoutConst.gridy = 2;
    layoutConst.gridwidth = 4;
    triangle = new ImageIcon("triangle.PNG");
    triangleLabel = new JLabel(triangle);
    add(triangleLabel, layoutConst);
    layoutConst.gridwidth = 1;

    layoutConst.gridx = 0;
    layoutConst.gridy = 3;
    add(sideA, layoutConst);
    
    layoutConst.gridx = 1;
    layoutConst.gridy = 3;
    
    add(sideAField, layoutConst);

    layoutConst.gridx = 2;
    layoutConst.gridy = 3;
    
    add(angleA, layoutConst);

    layoutConst.gridx = 3;
    layoutConst.gridy = 3;
    
    add(angleAField, layoutConst);

    layoutConst.gridx = 0;
    layoutConst.gridy = 4;
    add(sideB, layoutConst);

    layoutConst.gridx = 1;
    layoutConst.gridy = 4;
    add(sideBField, layoutConst);

    layoutConst.gridx = 2;
    layoutConst.gridy = 4;
    add(angleB, layoutConst);

    layoutConst.gridx = 3;
    layoutConst.gridy = 4;
    add(angleBField, layoutConst);

    layoutConst.gridx = 0;
    layoutConst.gridy = 5;
    add(sideC, layoutConst);

    layoutConst.gridx = 1;
    layoutConst.gridy = 5;
    add(sideCField, layoutConst);

    layoutConst.gridx = 2;
    layoutConst.gridy = 5;
    add(angleC, layoutConst);

    layoutConst.gridx = 3;
    layoutConst.gridy = 5;
    add(angleCField, layoutConst);

    layoutConst.gridx = 2;
    layoutConst.gridy = 6;
    add(calcButton, layoutConst);

    layoutConst.gridx = 1;
    layoutConst.gridy = 6;
    resetButton.setPreferredSize(new Dimension(100, 25));
    add(resetButton, layoutConst);



  }

  @Override
  public void actionPerformed(ActionEvent event){
    
    if (event.getSource() == calcButton){
      try{
        numSideA = ((Number) sideAField.getValue()).doubleValue();
      } catch (NullPointerException exception){
        numSideA = 0;
      }

      try{
        numSideB = ((Number) sideBField.getValue()).doubleValue();
      } catch (NullPointerException exception){
        numSideB = 0;
      }

      try{
        numSideC = ((Number) sideCField.getValue()).doubleValue();
      } catch (NullPointerException exception){
        numSideC = 0;
      }

      try{
        numAngleA = ((Number) angleAField.getValue()).doubleValue();
      } catch (NullPointerException exception){
        numAngleA = 0;
      }

      try{
        numAngleB = ((Number) angleBField.getValue()).doubleValue();
      } catch (NullPointerException exception){
        numAngleB = 0;
      }


      
      boolean sideAPresent = numSideA != 0.0;
      boolean sideBPresent = numSideB != 0.0;
      boolean sideCPresent = numSideC != 0.0;

      boolean angleAPresent = numAngleA != 0.0;
      boolean angleBPresent = numAngleB != 0.0;


      if (sideAPresent && sideBPresent){
        numAngleA = Math.toDegrees(Math.atan(numSideA/numSideB));
        numAngleB = 90.0 - numAngleA;
        numSideC = Math.sqrt(numSideA * numSideA + numSideB * numSideB);

        angleAField.setText(Double.toString(round(numAngleA)));
        angleBField.setText(Double.toString(round(numAngleB)));
        sideCField.setText(Double.toString(round(numSideC)));

      } else if (sideAPresent && sideCPresent){
        if (round(numSideA) >= round(numSideC)){
          JOptionPane.showMessageDialog(this, "Legs can't be longer than the                  hypotenuse!");
        }else{
        
          numAngleA = Math.toDegrees(Math.asin(numSideA/numSideC));
          numAngleB = 90.0 - numAngleA;
          numSideB = Math.sqrt(numSideC*numSideC - numSideA*numSideA);

          angleAField.setText(Double.toString(round(numAngleA)));
          angleBField.setText(Double.toString(round(numAngleB)));
          sideBField.setText(Double.toString(round(numSideB)));

        }
      } else if (sideBPresent && sideCPresent){
        if (round(numSideB) >= round(numSideC)){
          JOptionPane.showMessageDialog(this, "Legs can't be longer than the                  hypotenuse!");
        } else{

          numAngleA = Math.toDegrees(Math.acos(numSideB/numSideC));
          numAngleB = 90.0 - numAngleA;
          numSideA = Math.sqrt(numSideC*numSideC - numSideB*numSideB);

          angleAField.setText(Double.toString(round(numAngleA)));
          angleBField.setText(Double.toString(round(numAngleB)));
          sideAField.setText(Double.toString(round(numSideA)));
        }

      } else if (sideAPresent && angleAPresent){
        numSideB = numSideA/Math.tan(Math.toRadians(numAngleA));
        numSideC = Math.sqrt(numSideA*numSideA + numSideB*numSideB);
        numAngleB = 90.0 - numAngleA;

        sideBField.setText(Double.toString(round(numSideB)));
        sideCField.setText(Double.toString(round(numSideC)));
        angleBField.setText(Double.toString(round(numAngleB)));
        
      } else if (sideAPresent && angleBPresent){
        numSideB = numSideA * Math.tan(Math.toRadians(numAngleB));
        numSideC = Math.sqrt(numSideA*numSideA + numSideB*numSideB);
        numAngleA = 90.0 - numAngleB;

        sideBField.setText(Double.toString(round(numSideB)));
        sideCField.setText(Double.toString(round(numSideC)));
        angleAField.setText(Double.toString(round(numAngleA)));

      } else if (sideBPresent && angleAPresent){
        numSideA = numSideB * Math.tan(Math.toRadians(numAngleA));
        numSideC = Math.sqrt(numSideA*numSideA + numSideB*numSideB);
        numAngleB = 90.0 - numAngleA;

        sideAField.setText(Double.toString(round(numSideA)));
        sideCField.setText(Double.toString(round(numSideC)));
        angleBField.setText(Double.toString(round(numAngleB)));

      } else if(sideBPresent && angleBPresent){
        numSideA = numSideB/Math.tan(Math.toRadians(numAngleB));
        numSideC = Math.sqrt(numSideA*numSideA + numSideB*numSideB);
        numAngleA = 90.0 - numAngleB;

        sideAField.setText(Double.toString(round(numSideA)));
        sideCField.setText(Double.toString(round(numSideC)));
        angleAField.setText(Double.toString(round(numAngleA)));


      } else if (sideCPresent && angleAPresent){
        numSideB = numSideC * Math.cos(Math.toRadians(numAngleA));
        numSideA = Math.sqrt(numSideC*numSideC - numSideB*numSideB);
        numAngleB = 90.0 - numAngleA;

        sideBField.setText(Double.toString(round(numSideB)));
        sideAField.setText(Double.toString(round(numSideA)));
        angleBField.setText(Double.toString(round(numAngleB)));


      } else if (sideCPresent && angleBPresent){
        numSideA = numSideC * Math.cos(Math.toRadians(numAngleB));
        numSideB = Math.sqrt(numSideC*numSideC - numSideA*numSideA);
        numAngleA = 90.0 - numAngleB;

        sideAField.setText(Double.toString(round(numSideA)));
        sideBField.setText(Double.toString(round(numSideB)));
        angleAField.setText(Double.toString(round(numAngleA)));
      } else{
        JOptionPane.showMessageDialog(this, "Must enter either one side and one             angle or two sides!");
      }
  

    } else if (event.getSource() == resetButton){
      sideAField.setText("");
      sideBField.setText("");
      sideCField.setText("");


      angleAField.setText("");
      angleBField.setText("");

      // resetting the text inside a JTextField to an empty string doesn't reset
      // its original value
      sideAField.setValue(null);
      sideBField.setValue(null);
      sideCField.setValue(null);
      angleAField.setValue(null);
      angleBField.setValue(null);


    }
    
    
  }

  public double round(double num){
    return Math.round(num*100.0)/100.0;
  }

  public static void main(String[] args) {

    Main topFrame = new Main();
    topFrame.pack();

    topFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    topFrame.setVisible(true);
  }
}