package com.qq.friends;




import com.comunication.connection.ConnectionManager;
import com.qq.main.MainDialog;
import com.qq.main.tree.QQContactItem;
import com.san30.pub.tools.SanHttpClient;
import com.ui.chat.WrapLetterHTMLEditorKit;
import com.ui.jlabel.JLabelFactory;
import com.ui.window.NotifyWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 * Created by a on 2014/9/9.
 */
public class AcceptNewFriendDialog extends NotifyWindow {

    private JLabel linkLabel;
    private JLabel closeLabel;
    private JEditorPane content;

    private String from;
    public AcceptNewFriendDialog(String from) {
        super();
        setTitle("��������");
        this.from = from;
        setContent(from+"��������Ϊ����!",10,10);
        setSize(220, 151);
    }

    @Override
    protected JPanel initContentPane() {
        JPanel contentPane = new JPanel(null);
        String url = null;
        Font font = new Font("����",Font.PLAIN,13);
        linkLabel = JLabelFactory.createLinkLabel("ͬ��", font, "#0000FF", url);
        linkLabel.setBounds(20,70,50,23);
        linkLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    FriendsManager friendsManager = FriendsManager.getInstance();
                    HashMap<String,String> paramMap = new HashMap<String, String>();
                    paramMap.put("jid",from);
                    paramMap.put("targetAccount", "");
                    String url = "http://" + ConnectionManager.getConnection().getHost() + ":" + 9090 + "/plugins/udpserver/addcontact";
                    SanHttpClient.getDataAsString(url, paramMap);
                    dispose();
                    QQContactItem qqContactItem = friendsManager.addNewContactItem(from.split("@")[0]);
                    MainDialog.getInstance().getFriendsTree().getFriends().addContactItem(qqContactItem);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        closeLabel = JLabelFactory.createLinkLabel("�ܾ�",font,"#0000FF",null);
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        closeLabel.setBounds(80,70,50,23);
        Font font1 = new Font("����",Font.PLAIN,13);
        content = new JEditorPane();
        content.setEditable(false);
        content.setEditorKit(new WrapLetterHTMLEditorKit());
        content.setSize(new Dimension(193, 88));

        contentPane.add(linkLabel);
        contentPane.add(closeLabel);
        contentPane.add(content);
        return contentPane;
    }


    /**
     * @Title:setContent
     * @Description: ������Ϣ��ʾ����
     * @author houk
     * @date 2012-6-21 ����5:40:02
     */
    public void setContent(String contentStr, int x, int y) {
        this.content.setText(new StringBuffer().append("<html><font size=").append(5).append(">")
                .append(contentStr).append("</font></html>").toString());
        content.setLocation(x, y + 2);

        this.add(content);
    }
}