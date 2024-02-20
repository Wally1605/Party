import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener{
    JFrame frame;
    JPanel panel;
    JLabel intro;
    JLabel party;
    JRadioButton partyChoice1;
    JRadioButton partyChoice2;
    JLabel howMany;
    JTextField numGuests;
    JLabel dinner;
    JRadioButton dinner1;
    JRadioButton dinner2;

    JButton submit;
    JButton submit2;
    JLabel partyInfo1;
    JLabel displayInvitation;
    JLabel selectedDin;


    public GUI(){
        frame = new JFrame();
        panel = new JPanel();
        Color c = new Color(63,90,54);
        panel.setBackground(c);
        intro = new JLabel("Party Planner:");
        intro.setForeground(Color.YELLOW);
        party = new JLabel("What type of party is it?");
        party.setForeground(Color.lightGray);

        ButtonGroup p = new ButtonGroup();
        partyChoice1 = new JRadioButton("Party");
        partyChoice1.setBackground(c);
        partyChoice1.setForeground(Color.lightGray);
        p.add(partyChoice1);
        partyChoice2 = new JRadioButton("Dinner Party");
        partyChoice2.setBackground(c);
        partyChoice2.setForeground(Color.lightGray);
        p.add(partyChoice2);

        howMany = new JLabel("How many guests?");
        howMany.setForeground(Color.lightGray);
        numGuests = new JTextField();
        numGuests.setBackground(Color.lightGray);
        submit = new JButton("Submit");
        submit.setBackground(Color.lightGray);
        submit.addActionListener(this);

        dinner = new JLabel("What dinner would you like?");
        dinner.setForeground(Color.YELLOW);
        ButtonGroup d = new ButtonGroup();
        dinner1 = new JRadioButton("Steak, mashed potatoes, and asparagus");
        dinner1.setForeground(Color.lightGray);
        dinner1.setBackground(c);

        d.add(dinner1);
        dinner2 = new JRadioButton("Grilled chicken, fresh chop salad, and mushrooms");
        dinner2.setForeground(Color.lightGray);
        dinner2.setBackground(c);
        d.add(dinner2);

        partyInfo1 = new JLabel("");
        partyInfo1.setForeground(Color.lightGray);
        dinner2.setForeground(Color.lightGray);
        displayInvitation = new JLabel("");
        displayInvitation.setForeground(Color.YELLOW);



        submit2 = new JButton("Submit");
        submit2.addActionListener(this::actionPerformed2);
        submit2.setBackground(Color.lightGray);

        selectedDin = new JLabel("");
        selectedDin.setForeground(Color.lightGray);

        frame.setSize(400,350);
        panel.setBorder(BorderFactory.createEmptyBorder(10,0,10,60));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();



        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(intro,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(party,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(partyChoice1,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(partyChoice2,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(howMany,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(numGuests,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(submit,gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(partyInfo1,gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        panel.add(selectedDin,gbc);

        gbc.gridx = 0;
        gbc.gridy = 13;
        panel.add(displayInvitation,gbc);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Party");
        frame.setVisible(true);



    }
    public void actionPerformed(ActionEvent e){
        GridBagConstraints gbc = new GridBagConstraints();
        Party p = new Party();
        int guests = Integer.parseInt(numGuests.getText());
        p.setGuests(guests);
        partyInfo1.setText("Guests: " + guests);

        if(partyChoice2.isSelected()){
            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panel.add(dinner,gbc);

            gbc.gridx = 0;
            gbc.gridy = 8;
            gbc.gridwidth = 3;
            panel.add(dinner1,gbc);

            gbc.gridx = 0;
            gbc.gridy = 9;
            gbc.gridwidth = 3;
            panel.add(dinner2,gbc);

            gbc.gridx = 0;
            gbc.gridy = 10;
            gbc.gridwidth = 1;
            panel.add(submit2,gbc);
        }else if(partyChoice1.isSelected()){
            displayInvitation.setText("Please come to my party!");
        }
    }
    public void actionPerformed2(ActionEvent e){
        DinnerParty d = new DinnerParty();
        GridBagConstraints gbc = new GridBagConstraints();
        if(dinner1.isSelected()){
            d.setDinnerChoice(1);
            selectedDin.setText(d.getDinnerChoice());
        }else if(dinner2.isSelected()){
            d.setDinnerChoice(2);
            selectedDin.setText(d.getDinnerChoice());
        }
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 3;
        panel.add(selectedDin,gbc);
        displayInvitation.setText("Please come to my party!");

    }

}
