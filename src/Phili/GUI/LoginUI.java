package Phili.GUI;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import Phili.MainEngine.Controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import Phili.MainEngine.Logic;

/**
 * @author phili
 *
 */
public class LoginUI extends javax.swing.JFrame implements KeyListener{
    
    public static Controller controller;
    public static Logic uiLogic;
    
    private javax.swing.JButton LoginButtonLogin;
    private javax.swing.JButton LoginButtonReset;
    private javax.swing.JLabel LoginLabelControllerAnswer;
    private javax.swing.JLabel LoginLabelPassword;
    private javax.swing.JLabel LoginLabelUser;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPasswordField LoginPasswordFieldPassword;
    private javax.swing.JTextField LoginTextFieldUser;

    public LoginUI() {
        
        initComponents();
        
        LoginTextFieldUser.addKeyListener(this);
        LoginPasswordFieldPassword.addKeyListener(this);
        
        controller = new Controller();
        
        uiLogic = new Logic();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        LoginPanel = new javax.swing.JPanel();
        LoginLabelUser = new javax.swing.JLabel();
        LoginLabelPassword = new javax.swing.JLabel();
        LoginTextFieldUser = new javax.swing.JTextField();
        LoginButtonLogin = new javax.swing.JButton();
        LoginButtonReset = new javax.swing.JButton();
        LoginLabelControllerAnswer = new javax.swing.JLabel();
        LoginPasswordFieldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        LoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter your details"));

        LoginLabelUser.setText("User:");

        LoginLabelPassword.setText("Password:");

        LoginButtonLogin.setBackground(java.awt.SystemColor.controlHighlight);
        LoginButtonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Phili/GUI/Images/key2.png"))); 
        LoginButtonLogin.setText("Log In");
        LoginButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonLoginMouseClicked(evt);
            }
        });

        LoginButtonReset.setBackground(java.awt.SystemColor.controlHighlight);
        LoginButtonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Phili/GUI/Images/reset copy.png"))); 
        LoginButtonReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonResetMouseClicked(evt);
            }
        });

        LoginLabelControllerAnswer.setText(" ");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoginLabelUser)
                            .addComponent(LoginLabelPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LoginTextFieldUser, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(LoginPasswordFieldPassword)))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addComponent(LoginLabelControllerAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LoginButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LoginButtonLogin)))
                .addContainerGap())
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginLabelUser)
                    .addComponent(LoginTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginLabelPassword)
                    .addComponent(LoginPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(LoginLabelControllerAnswer))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoginButtonReset)
                            .addComponent(LoginButtonLogin))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LoginPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LoginButtonLogin, LoginButtonReset});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void LoginButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {
                
        String username = LoginTextFieldUser.getText();
        String password = LoginPasswordFieldPassword.getText();
        
        String cntrAnswer = controller.CheckLogin(username, password);
        
        EvaluateLogin(cntrAnswer); 
    }

    private void LoginButtonResetMouseClicked(java.awt.event.MouseEvent evt) {
        
        LoginTextFieldUser.setText(null);
        LoginPasswordFieldPassword.setText(null);  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    }

        java.awt.EventQueue.invokeLater(() -> {
            new LoginUI().setVisible(true);
        });
    }



    public void EvaluateLogin(String answer)
    {
        if(null != answer)
        switch (answer) {
            case "Invalid":
                LoginLabelControllerAnswer.setText("Login has failed!");
                break;
            case "admin":{
                MainUI mainFrame = InitializeMainFrame();
                mainFrame.RenderAsAdmin();
                    break;
                }
            case "user":{
                MainUI mainFrame = InitializeMainFrame();
                mainFrame.RenderAsUser();
                    break;
                }
            case "operator":{
                MainUI mainFrame = InitializeMainFrame();
                mainFrame.RenderAsOperator();
                    break;
                }
            case "curier":
                InitializeOrdersFrame();
                break;
            case "i am god":{
                MainUI mainFrame = new MainUI();
                this.dispose();
                mainFrame.setVisible(true);
                    break;
                }
            default:
                break;
        }
    }
    
    public MainUI InitializeMainFrame ()
    {
        MainUI mainFrame = new MainUI();
        this.dispose();
        mainFrame.setVisible(true);
        
        return mainFrame;
    }
    
    public void InitializeOrdersFrame ()
    {
        OrdersUI ordersFrame = new OrdersUI();
        this.dispose();
        ordersFrame.setVisible(true);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            MouseEvent evt = null;
            
            LoginButtonLoginMouseClicked(evt);
        }
    }

}
