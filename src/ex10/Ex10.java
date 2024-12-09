package ex10;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.TextArea;
import javax.swing.JLabel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ScrollPaneConstants;

public class Ex10 {
  private JFrame frame;
  private JTextField textField;
  private JButton loadButton;
  private JScrollPane scrollPane;
  private JScrollPane scrollPane2;
  private ImagePanel imagePanel; 
  
  private JTextArea textArea;
  

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ex10 window = new Ex10();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ex10() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, BorderLayout.WEST);
    panel.setLayout(new GridLayout(10, 1, 10, 10));
    
    JLabel lblNewLabel = new JLabel("Write URL...");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblNewLabel);
    
    textField = new JTextField();
    panel.add(textField);
    textField.setColumns(10);
    
    
    loadButton = new JButton("Load");
    loadButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String fName = textField.getText();
        try {
          BufferedImage img = ImageIO.read(new File(fName));
          if(img == null) {
            textArea.append("Unknown file : \""+ fName+"\"\n");
          } else {
            textArea.append("Load : \""+ fName+"\"\n");
            // グレイスケールに変換
            GrayImage gImage = new GrayImage(img);
            imagePanel.setImage(gImage);
          }
        } catch (IOException e1) {
          textArea.append("Cannot open : \""+ fName+"\"\n");
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        scrollPane.setViewportView(imagePanel);
      }
    });
    panel.add(loadButton);
    
    
    JPanel panel_1 = new JPanel();
    panel.add(panel_1);
    
    JButton btnBinary = new JButton("Binary");
    panel.add(btnBinary);
    
    JButton btnNegative = new JButton("Negative");
    panel.add(btnNegative);
    
    scrollPane = new JScrollPane();
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    
    imagePanel = new ImagePanel();
    scrollPane.setViewportView(imagePanel);
    
    scrollPane2 = new JScrollPane();
    frame.getContentPane().add(scrollPane2, BorderLayout.SOUTH);
    
    textArea = new JTextArea();
    scrollPane2.setViewportView(textArea);
  }
}
