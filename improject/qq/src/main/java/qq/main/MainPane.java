package qq.main;

import com.component.ExtendPane;
import com.component.ImageUtils;
import com.resource.ConfigurationRes;

import qq.main.tree.QQContactTree;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lenovo on 2014/9/17.
 */
public class MainPane extends ExtendPane implements ActionListener{
    private MainDialogButtonFactory mainDialogButtonFactory;
    private QQContactTree friendsTree;
    private JButton closeWindowButton; //�رմ��ڵİ�ť
    private JButton minWindowButton; //��С�����ڰ�ť
    private JButton searchFriendsButton; //�������Ѱ�ť

    public MainPane() {
        super(null,ImageUtils.getInstance(ConfigurationRes.getImageResPath()+"main/").getImageIcon("mainDialogBg.png"));
        mainDialogButtonFactory = new MainDialogButtonFactory();
        this.addCloseWindowButton();
        this.addMinWindowButton();
        this.addSearchAddFriendsButton();
        this.addFriendsTree();
    }

    /**
     * ���Ӵ��ڹرհ�ť
     */
    private void addCloseWindowButton(){
        closeWindowButton = mainDialogButtonFactory.createCloseWindowButton();
        closeWindowButton.setLocation(this.getWidth()-closeWindowButton.getWidth(),0);
        addButton(closeWindowButton);
    }

    /**
     * ���Ӵ�����С����ť
     */
    private void addMinWindowButton(){
        minWindowButton = mainDialogButtonFactory.createMinWindowButton();
        minWindowButton.setLocation(this.getWidth() - closeWindowButton.getWidth() - minWindowButton.getWidth(), 0);
        add(minWindowButton);
    }

    /**
     * ���Ӳ������Ӻ��Ѱ�ť
     */
    private void addSearchAddFriendsButton(){
        searchFriendsButton =mainDialogButtonFactory.createSearchFriendsButton();  //�������ѵİ�ť
        searchFriendsButton.setLocation(400,500); //���ð�ť��λ��
        add(searchFriendsButton); //�����������Ѱ�ť
        searchFriendsButton.addActionListener(this); //�����¼�����
    }

    private void addButton(JButton jButton){
        add(jButton);
        jButton.addActionListener(this);
    }

    /**
     * ���Ӻ�����
     */
    private void addFriendsTree(){
        friendsTree = new QQContactTree();
        friendsTree.setBackground(Color.blue);
        friendsTree.setSize(452, 440);
        friendsTree.setLocation(0, 200);
        add(friendsTree);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchFriendsButton){

        }
    }


}