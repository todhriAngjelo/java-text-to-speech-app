package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends View {

	// our programs main. It initiates the first UI and the first UI links with the other ones
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new MainView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public MainView() {
        initialize();
        this.frame.setVisible(true);
    }

    protected void initialize() {
        frame = new JFrame();
        frame.setBounds(400, 400, 446, 330);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // text label - window top - app title
        JLabel appTitleLabel = new JLabel("Advanced text to speech App");
        appTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        appTitleLabel.setFont(new Font("Dialog", Font.BOLD, 12));
        appTitleLabel.setBounds(10, 31, 410, 44);
        frame.getContentPane().add(appTitleLabel);

        JButton openDocumentButton = new JButton("Open document editor");
        openDocumentButton.addActionListener(ignored -> {
            new TextEditorView();
            frame.setVisible(false);
        });
        openDocumentButton.setBounds(123, 188, 188, 23);
        frame.getContentPane().add(openDocumentButton);

        // exit button
        JButton exitButton = new JButton("Exit application");
        exitButton.addActionListener(e -> System.exit(0));
        exitButton.setBounds(123, 222, 188, 23);
        frame.getContentPane().add(exitButton);

        JTextArea lblCreateLoadEdit = new JTextArea("Create, load, edit and transform to audio a various set of document types. " +
                "Supported types: word, excel");
        lblCreateLoadEdit.setFont(null);
        lblCreateLoadEdit.setWrapStyleWord(true);
        lblCreateLoadEdit.setLineWrap(true);
        lblCreateLoadEdit.setOpaque(false);
        lblCreateLoadEdit.setAlignmentX(100f);
        lblCreateLoadEdit.setEditable(false);
        lblCreateLoadEdit.setFocusable(false);
        lblCreateLoadEdit.setBackground(UIManager.getColor("Label.background"));
        lblCreateLoadEdit.setBounds(10, 83, 410, 44);
        frame.getContentPane().add(lblCreateLoadEdit);

        JTextArea lblEncodingIsAlso = new JTextArea("Encoding is also supported for the document's content for privacy and security reasons. " +
                "Supported mechanisms: Atbash, Rot-13");
        lblEncodingIsAlso.setFont(null);
        lblEncodingIsAlso.setWrapStyleWord(true);
        lblEncodingIsAlso.setLineWrap(true);
        lblEncodingIsAlso.setOpaque(false);
        lblEncodingIsAlso.setEditable(false);
        lblEncodingIsAlso.setFocusable(false);
        lblEncodingIsAlso.setBackground(UIManager.getColor("Label.background"));
        lblEncodingIsAlso.setBounds(10, 122, 410, 44);
        frame.getContentPane().add(lblEncodingIsAlso);
    }
}