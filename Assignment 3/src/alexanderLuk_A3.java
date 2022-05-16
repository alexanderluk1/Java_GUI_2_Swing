import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class alexanderLuk_A3 extends JFrame implements ActionListener {

    
    public static void main(String[] args) {
        alexanderLuk_A3 myApp = new alexanderLuk_A3();
    }

    public alexanderLuk_A3()
    {
        OlympicFrame();
    }

    JFrame frame;
    JPanel panel;

    // --------------------- Label to hold Rank ---------------------
    ArrayList<JLabel> rLabelArray = new ArrayList<JLabel>();

    // --------------------- Create Buttons with Image ---------------------
    ArrayList<JButton> jbArray = new ArrayList<JButton>(); // To hold all the Buttons

    ImageIcon icon1 = new ImageIcon(new ImageIcon("src/Images/1.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b1 = new JButton("USA", icon1);

    ImageIcon icon2 = new ImageIcon(new ImageIcon("src/Images/2.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b2 = new JButton("Spain", icon2);

    ImageIcon icon3 = new ImageIcon(new ImageIcon("src/Images/3.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b3 = new JButton("China", icon3);

    ImageIcon icon4 = new ImageIcon(new ImageIcon("src/Images/4.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b4 = new JButton("Japan", icon4);

    ImageIcon icon5 = new ImageIcon(new ImageIcon("src/Images/5.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b5 = new JButton("Italy", icon5);

    ImageIcon icon6 = new ImageIcon(new ImageIcon("src/Images/6.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b6 = new JButton("Germany", icon6);

    ImageIcon icon7 = new ImageIcon(new ImageIcon("src/Images/7.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b7 = new JButton("France", icon7);

    ImageIcon icon8 = new ImageIcon(new ImageIcon("src/Images/8.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b8 = new JButton("Brazil", icon8);

    ImageIcon icon9 = new ImageIcon(new ImageIcon("src/Images/9.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b9 = new JButton("Netherland", icon9);

    ImageIcon icon10 = new ImageIcon(new ImageIcon("src/Images/10.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b10 = new JButton("Poland", icon10);

    ImageIcon icon11 = new ImageIcon(new ImageIcon("src/Images/11.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b11 = new JButton("Russia", icon11);

    ImageIcon icon12 = new ImageIcon(new ImageIcon("src/Images/12.jpg").getImage().getScaledInstance(80, 55, Image.SCALE_DEFAULT));
    JButton b12 = new JButton("Ukraine", icon12);

    ImageIcon trophy = new ImageIcon(new ImageIcon("src/Images/trophy.jpg").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT));

    // --------------------- To hold all the Countries Names ---------------------
    final String[] countryArray = new String[]{"USA", "Spain", "China", "Japan", "Italy", "Germany", 
        "France", "Brazil", "Netherlands", "Poland", "Russia", "Ukraine"};

    ArrayList<Olympic> alist = new ArrayList<Olympic>(); // To hold all the Olympic Obj

    // --------------------- FRAME COMPONENT ---------------------
    public void OlympicFrame()
    {
        // --------------------- GUI COMPONENTS ---------------------
        // --------------------- FRAME SETTINGS ---------------------
        frame = new JFrame();
        frame.setTitle("Olympic 2020");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);

        // --------------------- MAIN PANEL ---------------------
        panel = new JPanel(new GridLayout(4, 3, 5, 5));
        frame.add(panel);

        // --------------------- Add each Button to ArrayList ---------------------
        jbArray.add(b1);
        jbArray.add(b2);
        jbArray.add(b3);
        jbArray.add(b4);
        jbArray.add(b5);
        jbArray.add(b6);
        jbArray.add(b7);
        jbArray.add(b8);
        jbArray.add(b9);
        jbArray.add(b10);
        jbArray.add(b11);
        jbArray.add(b12);

        // --------------------- Button Settings ---------------------
        for (JButton eachButton : jbArray)
        {
            eachButton.setHorizontalTextPosition(JButton.CENTER);
            eachButton.setVerticalTextPosition(JButton.BOTTOM);
            eachButton.addActionListener(this); 
        }

        // --------------------- Add Button to Panel ---------------------
        for (JButton eachButton : jbArray)
        {
            panel.add(eachButton);
        }

        // --------------------- Creating 12 Labels to hold Rank ---------------------
        for (int i = 0; i < jbArray.size(); i++)
        {
            rLabelArray.add(new JLabel());
        }

        constructAList(alist);
        setRank(alist);
        frame.setVisible(true);
    }

    // --------------------- EVENT HANDLER ---------------------
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < jbArray.size(); i++)
        {
            if (e.getSource() == jbArray.get(i))
            {
                jbArray.get(i).add(rLabelArray.get(i));
                jbArray.get(i).setHorizontalAlignment(JLabel.RIGHT);
                rLabelArray.get(i).setText(String.valueOf("Rank: " + alist.get(i).getRank()));
                break;
            }
        }

        JOptionPane.showMessageDialog(null, getFinalRanking(), "Miss World 2020", JOptionPane.PLAIN_MESSAGE, trophy);
    }

    // --------------------- CODE COMPONENT ---------------------
    public String getFinalRanking()
    {
        StringBuilder finalString = new StringBuilder(); // To combine into 1 String
        int counter = 1; // To ensure we have 12 countries added
        ArrayList<Olympic> blist = new ArrayList<Olympic>(); // Copy of alist to manipulate data
        blist.addAll(alist);

        while (counter <= 12)
        {
            for (int i = 0; i < blist.size(); i++)
            {
                if (blist.get(i).getRank() == counter)
                {
                    finalString.append(String.format("Rank %d: %s (%.2f)%n", blist.get(i).getRank(), 
                    blist.get(i).getCountry(), blist.get(i).getTotalScore()));
                    
                    counter++;
                    blist.remove(i); // Remove the entry found, to reduce Time complexity
                    i--;
                }
            }
        }
        return finalString.toString();
    }

    // To create an ArrayList of Country Objects
    public void constructAList(ArrayList<Olympic> alist)
    {
        for (int i = 0; i < countryArray.length; i++)
        {
            alist.add(new Olympic(countryArray[i]));
        }
    }

    public void setRank(ArrayList<Olympic> alist)
    {
        // Using Bubble Sort
        
        int numOfIter = 0; // Special condition to end sort
        List<Olympic> listOfCountry = new LinkedList<Olympic>();

        listOfCountry.addAll(alist);
        int rank = 1;

        for (int i = 0; i < listOfCountry.size(); i++)
        {
            for (int j = 0; j < listOfCountry.size() - 1; j++)
            {
                if (listOfCountry.get(j).getTotalScore() < listOfCountry.get(j + 1).getTotalScore())
                {
                    Collections.swap(listOfCountry, j, j + 1);
                    numOfIter++;
                }
            }

            if (numOfIter == 0)
            {
                break;
            }
        }

        for (Olympic eachCountry : listOfCountry)
        {
            eachCountry.setRank(rank);
            rank++;
        }
    }
}

class Olympic {

    private final int NO = 10; // Number of Judges
    private String country;
    private double[] score;
    private double totalScore;
    private int rank;

    public Olympic(String country)
    {
        score = getScoreArray(); // 10 Judges
        totalScore = setTotalScore();
        this.country = country;
    }

    public double setTotalScore()
    {
        double total = 0;
        for (int i = 0; i < score.length; i++)
        {
            total += score[i];
        }

        return total;
    }

    public double[] getScoreArray()
    {
        double[] score = new double[NO];
        for (int i = 0; i < NO; i++)
        {
            score[i] = generateScore();
        }

        return score;
    }

    public double generateScore()
    {
        double score = (Math.random() * 100);
        score = Math.round(score * 100.0) / 100.0;
        return score;
    }

    // Getters and Setters
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double[] getScore() {
        return score;
    }

    public void setScore(double[] score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }
}
